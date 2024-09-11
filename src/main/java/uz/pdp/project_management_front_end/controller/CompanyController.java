package uz.pdp.project_management_front_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.project_management_front_end.domain.request.CompanyCreateDTO;
import uz.pdp.project_management_front_end.service.CompanyService;
import uz.pdp.project_management_front_end.service.UserService;

import java.util.UUID;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;

    @PostMapping
    public String save(CompanyCreateDTO createDTO, Model model) {
        companyService.save(createDTO);
        model.addAttribute("company", companyService.getAllCompanies());
        return "redirect:/company";
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("company", companyService.getAllCompanies());
        model.addAttribute("ceos", userService.getAllCEO());
        return "pa-dashboard";
    }


    @GetMapping("freeze/{id}")
    public String freeze(@PathVariable("id") UUID id, Model model) {
        companyService.freezeCompany(id);
        model.addAttribute("company", companyService.getAllCompanies());
        return "pa-dashboard";
    }

    @GetMapping("unfreeze/{id}")
    public String unfreeze(@PathVariable("id") UUID id, Model model) {
        companyService.unfreezeCompany(id);
        model.addAttribute("company", companyService.getAllCompanies());
        return "pa-dashboard";
    }

//    @GetMapping("/freeze/{id}/block")
//    public String freeze(@PathVariable("id")UUID id, Model model) {
//        companyService.freezeCompany(id);
//      //  model.addAttribute("company", companyService.getAllCompanies());
//        return "pa-dashboard";
//    }
//
//
//    @GetMapping("/unfreeze/{id}/unblock")
//    public String unfreeze(@PathVariable("id")UUID id, Model model) {
//        companyService.unfreezeCompany(id);
//    //    model.addAttribute("company", companyService.getAllCompanies());
//
//        return "pa-dashboard";
//    }



}

