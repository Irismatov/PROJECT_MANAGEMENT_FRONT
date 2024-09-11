package uz.pdp.project_management_front_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.project_management_front_end.domain.request.TeamRequest;
import uz.pdp.project_management_front_end.service.ProductService;
import uz.pdp.project_management_front_end.service.TeamService;
import uz.pdp.project_management_front_end.service.UserService;

import java.util.UUID;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAll (Model model) {
        model.addAttribute("teams",teamService.getAllTeams());
        model.addAttribute("leads" , userService.getAllTeamLeads());
        return "hr_admin/team-crud";
    }

    @PostMapping
    public String addTeam(TeamRequest teamRequest, Model model) {
        teamService.saveTeam(teamRequest);
        model.addAttribute("teams", teamService.getAllTeams());
        model.addAttribute("leads", userService.getAllTeamLeads());
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("scrums", userService.getAllScrumMasters());
        return "hr_admin/team-crud";
    }

    @GetMapping("delete/{id}")
    public String deleteTeam(@PathVariable("id") UUID id, Model model) {
        teamService.deleteTeam(id);
        return "hr_admin/team-crud";
    }



    @GetMapping("/update/{id}")
    public String updateTeam(@PathVariable("id") UUID id, TeamRequest teamRequest, Model model) {
        teamService.updateTeam(id, teamRequest);
        return "hr_admin/team-crud";
    }
}
