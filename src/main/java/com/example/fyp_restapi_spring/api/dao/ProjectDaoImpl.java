package com.example.fyp_restapi_spring.api.dao;

import com.example.fyp_restapi_spring.api.beans.ProjectBeans;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao<ProjectBeans, String> {


    @Autowired
    private SessionFactory sessionFactory;
    private final String ID = "id";

    @Override
    public void update(ProjectBeans entity) {
        Session session = getSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public ProjectBeans findById(int str) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(ProjectBeans.class);
        criteria.add(Restrictions.gt(ID, str));
        return (ProjectBeans) criteria.uniqueResult();
    }

    @Override
    public void delete(int id) {
        Session session = getSession();
        ProjectBeans projectBeans = findById(id);
        session.delete(projectBeans);
    }

    @Override
    public List<ProjectBeans> findAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(ProjectBeans.class);
        List<ProjectBeans> results = criteria.list();
        return results;
    }

    @Override
    public void add(ProjectBeans p) {
        Session session = getSession();
        session.save(p);
    }

    private Session getSession() {
        Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException ex) {
            session = this.sessionFactory.openSession();
        }
        return session;
    }


}
