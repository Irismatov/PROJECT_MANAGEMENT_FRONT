package uz.pdp.project_management_front_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.project_management_front_end.domain.request.UserRequest;
import uz.pdp.project_management_front_end.service.CompanyService;
import uz.pdp.project_management_front_end.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public String addUser(UserRequest userRequest) {
        userService.saveCEO(userRequest);
        return "redirect:/company";
    }

//    @GetMapping
//    public String getUsers(Model model) {
//        model.addAttribute("companies", companyService.getAllCompanies());
//        model.addAttribute("ceos", userService.getAllCEO());
//        return "redirect:/company";
//    }

}
