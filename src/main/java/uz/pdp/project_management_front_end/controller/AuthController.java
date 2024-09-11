package uz.pdp.project_management_front_end.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.project_management_front_end.domain.request.LoginRequest;
import uz.pdp.project_management_front_end.domain.request.RegisterRequest;
import uz.pdp.project_management_front_end.domain.response.LoginResponse;
import uz.pdp.project_management_front_end.service.AuthService;


@Controller
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private HttpSession httpSession;

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
    public String login(LoginRequest loginRequest) {
        LoginResponse login = authService.login(loginRequest);

        httpSession.setAttribute("token", login.getToken());

        switch (login.getRole()) {
            case HR_ADMIN -> {
                return "hr_admin/hr-admin-dashboard";
            }
            case CEO ->  {
                return "ceo/ceo-dashboard";
            }
            case PROJECT_ADMINISTRATOR -> {
                return "pa-dashboard";
            }
        }


        return "hr_admin/hr-admin-dashboard";
    }
}