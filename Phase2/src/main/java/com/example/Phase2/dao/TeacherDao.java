package com.example.Phase2.dao;

import com.example.Phase2.dbConfig.SimplilearnConfig;
import com.example.Phase2.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TeacherDao {
    private SessionFactory sessionFactory;

    public TeacherDao() {
        sessionFactory = SimplilearnConfig.getSessionFactory();
    }

    public boolean isExist(Teacher teacher){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();


            Teacher existTeacher = session.find(Teacher.class, teacher);
            return Objects.nonNull(existTeacher);

        }catch (Exception e){
            return false;
        }
    }


    public boolean insert(Teacher teacher){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();


            session.save(teacher);

            transaction.commit();
            return true;
        }catch (ConstraintViolationException e){
            return false;
        }
    }

    public List<Teacher> getAll(){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Query<Teacher> query = session.createQuery("from Teacher", Teacher.class);
            List<Teacher> queries = query.getResultList();

            session.close();

            return queries;

        }catch (Exception e){
            return Collections.EMPTY_LIST;
        }
    }
}
