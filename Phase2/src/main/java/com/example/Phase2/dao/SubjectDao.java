package com.example.Phase2.dao;

import com.example.Phase2.dbConfig.SimplilearnConfig;
import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Subject;
import com.example.Phase2.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SubjectDao {

    private SessionFactory sessionFactory;

    public SubjectDao() {
        sessionFactory = SimplilearnConfig.getSessionFactory();
    }

    public boolean isExist(Subject subject){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();


            Subject existSubject = session.find(Subject.class, subject);
            return Objects.nonNull(existSubject);

        } catch (Exception e) {
            return false;
        }
    }


    public boolean insert(Subject subject){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            session.save(subject);

            transaction.commit();
            return true;
        } catch (ConstraintViolationException e) {
            return false;
        }
    }

    public List<Subject> getAll(){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Query<Subject> query = session.createQuery("from Subject", Subject.class);
            List<Subject> queries = query.getResultList();

            session.close();

            return queries;

        }catch (Exception e){
            return Collections.EMPTY_LIST;
        }
    }

    public boolean assignSubjectToClass(Subject subject, SchoolClass schoolClass){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Subject existSubject = session.find(Subject.class, subject.getSubjectId());
            SchoolClass existClass = session.find(SchoolClass.class, schoolClass.getClassId());

            existSubject.setSchoolClass(existClass);
            session.saveOrUpdate(existSubject);

            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean assignSubjectToTeacher(Subject subject, Teacher teacher){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Subject existSubject = session.find(Subject.class, subject.getSubjectId());
            Teacher existTeacher = session.find(Teacher.class, teacher.getTeacherId());

            existSubject.setTeacher(existTeacher);
            session.saveOrUpdate(existSubject);

            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Subject getSubjectById(int id){
        try{

            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Subject subject = session.get(Subject.class, id);
            return subject;
        }catch (Exception e){
            return null;
        }

    }
}
