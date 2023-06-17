package com.example.fyp_restapi_spring.service;


import com.example.fyp_restapi_spring.api.beans.ProjectBeans;

import java.util.List;

public interface ProjectService {

    public void addProject(ProjectBeans p);
    public void updateProject(ProjectBeans p);
    public List<ProjectBeans> listProjects();
    public ProjectBeans getProjectById(int id);
    public void removeProject(int id);
}
