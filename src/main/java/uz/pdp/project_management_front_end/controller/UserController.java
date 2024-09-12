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

    @GetMapping("/update-hr-admin/{id}")
    public String updateHRAdmin(@PathVariable("id") UUID id, @RequestBody UserRequest userRequest, Model model) {
        model.addAttribute("hr_admins", userService.updateHRAdmin(id, userRequest));
        return "ceo/hr-admin-crud";
    }

    @GetMapping("/delete-hr-admin/{id}")
    public String deleteHRAdmin(@PathVariable UUID id) {
        userService.deleteHRAdmin(id);
        return "redirect:/users/get-hr-admin";
    }

    @PostMapping("/save-employee")
    public String addEmployee(UserRequest userRequest, Model model) {
        userService.saveEmployee(userRequest);
        return "redirect:/users/get-employee";
    }

    @GetMapping("/get-employee")
    public String getEmployee(Model model) {
        model.addAttribute("employees", userService.getAllEmployee());
        return "hr_admin/employee-crud";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable("id") UUID id) {
        userService.deleteEmployee(id);
        return "redirect:/users/get-employee";
    }


    @GetMapping("/get-product-owner")
    public String getProductOwner(Model model) {
        model.addAttribute("hr_admins", userService.getAllProductOwner());
        return "ceo/po-crud";
    }

}
