package com.example.fyp_restapi_spring.service;

import com.example.fyp_restapi_spring.api.beans.ProjectBeans;
import com.example.fyp_restapi_spring.api.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectDao projectDao;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    @Transactional
    public void addProject(ProjectBeans p) {
        if (p.getCreationDate() == null) {
            p.setCreationDate(new Date());
        }
        p.setToken(generateRandomString(15));
        projectDao.add(p);
    }

    private static String generateRandomString(int length) {
        return new Random().ints(length, 0, 62)
                .mapToObj("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    @Override
    @Transactional
    public void updateProject(ProjectBeans p) {
        projectDao.update(p);
    }

    @Override
    @Transactional
    public List<ProjectBeans> listProjects() {
        return projectDao.findAll();
    }

    @Override
    @Transactional
    public ProjectBeans getProjectById(int id) {
        return (ProjectBeans) projectDao.findById(id);
    }

    @Override
    @Transactional
    public void removeProject(int id) {
        projectDao.delete(id);
    }
}
