package uz.pdp.project_management_front_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.project_management_front_end.domain.request.UserRequest;
import uz.pdp.project_management_front_end.service.CompanyService;
import uz.pdp.project_management_front_end.service.UserService;

import java.util.UUID;

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

    @PostMapping("/save-hr-admin")
    public String addHRAdmin(UserRequest userRequest) {
        userService.saveHRAdmin(userRequest);
        return "redirect:/users/get-hr-admin";
    }

    @GetMapping("/get-hr-admin")
    public String getHRAdmin(Model model) {
        model.addAttribute("hr_admins", userService.getAllHRAdmin());
        return "ceo/hr-admin-crud";
    }

    @GetMapping("/delete-hr-admin/{id}")
    public String deleteHRAdmin(@PathVariable UUID id) {
        userService.deleteHRAdmin(id);
        return "redirect:/users/get-hr-admin";
    }

}
