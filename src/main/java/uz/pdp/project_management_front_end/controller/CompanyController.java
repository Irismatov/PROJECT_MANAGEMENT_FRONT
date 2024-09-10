package uz.pdp.project_management_front_end.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.project_management_front_end.domain.request.CompanyCreateDTO;
import uz.pdp.project_management_front_end.service.CompanyService;

import java.util.UUID;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public String save(CompanyCreateDTO createDTO, Model model) {
        companyService.save(createDTO);
        model.addAttribute("company", companyService.getAllCompanies());
        return "project-admin/pa-dashboard";
    }

    @GetMapping
    public String getAll(Model model) {
        companyService.getAllCompanies();
        model.addAttribute("company", companyService.getAllCompanies());
        return "project-admin/pa-dashboard";
    }

    @PutMapping("/{id}")
    public String freeze(@PathVariable("id")UUID id, Model model) {
        companyService.freezeCompany(id);
        model.addAttribute("company", companyService.getAllCompanies());
        return "project-admin/pa-dashboard";
    }

    @PutMapping("/{id}")
    public String unfreeze(@PathVariable("id")UUID id, Model model) {
        companyService.unfreezeCompany(id);
        model.addAttribute("company", companyService.getAllCompanies());
        return "project-admin/pa-dashboard";
    }



}
