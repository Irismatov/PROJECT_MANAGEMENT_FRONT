package uz.pdp.project_management_front_end.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.project_management_front_end.domain.request.LoginRequest;
import uz.pdp.project_management_front_end.domain.request.RegisterRequest;
import uz.pdp.project_management_front_end.domain.response.LoginResponse;
import uz.pdp.project_management_front_end.service.AuthService;
import uz.pdp.project_management_front_end.service.CompanyService;
import uz.pdp.project_management_front_end.service.UserService;


@Controller
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register-pa")
    public String register() {
        authService.registerPA();
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest, Model model, HttpSession session) {
        LoginResponse login = authService.login(loginRequest);

        session.setAttribute("token", login.getToken());

        switch (login.getRole()) {
            case HR_ADMIN -> {
                return "hr_admin/hr-admin-dashboard";
            }
            case CEO ->  {
                return "ceo/ceo-dashboard";
            }
            case PROJECT_ADMINISTRATOR -> {
                model.addAttribute("ceos", userService.getAllCEO());
                model.addAttribute("companies", companyService.getAllCompanies());
                return "pa-dashboard";
            }

            case TEAM_LEAD -> {
                return "team_lead/teamLead-dashboard";
            }
        }


        return "hr_admin/hr-admin-dashboard";
    }
}