package uz.pdp.project_management_front_end.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/team-lead")
    public String teamLead() {
        return "team_lead/task-page";
    }



}
