package com.example.Phase2.dao;

import com.example.Phase2.dbConfig.SimplilearnConfig;
import com.example.Phase2.entity.SchoolClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SchoolClassDao {
    private SessionFactory sessionFactory;

    public SchoolClassDao() {
        sessionFactory = SimplilearnConfig.getSessionFactory();
    }

    public boolean isExist(SchoolClass schoolClass){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();


            SchoolClass existSchoolClass = session.find(SchoolClass.class, schoolClass);
            return Objects.nonNull(existSchoolClass);

        }catch (Exception e){
            return false;
        }
    }


    public boolean insert(SchoolClass schoolClass){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();


            session.save(schoolClass);

            transaction.commit();
            return true;
        }catch (ConstraintViolationException e){
            return false;
        }
    }

    public List<SchoolClass> getAll(){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Query<SchoolClass> query = session.createQuery("from SchoolClass", SchoolClass.class);
            List<SchoolClass> queries = query.getResultList();

            session.close();

            return queries;

        }catch (Exception e){
            return Collections.EMPTY_LIST;
        }
    }
}
