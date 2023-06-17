package com.example.fyp_restapi_spring.api.controller;

import com.example.fyp_restapi_spring.api.beans.ProjectBeans;
import com.example.fyp_restapi_spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class ProjectController {



    private ProjectService projectService;

    @Autowired(required = true)
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public List<ProjectBeans> getAllProject() {
        return projectService.listProjects();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProject(@RequestBody ProjectBeans projectBeans) {
        projectService.addProject(projectBeans);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable("id") int id) {
        projectService.removeProject(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateProject(@RequestBody ProjectBeans projectBeans) {
        projectService.updateProject(projectBeans);
    }

}
