package com.example.Phase2.dao;

import com.example.Phase2.dbConfig.SimplilearnConfig;
import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StudentDao {

    private SessionFactory sessionFactory;

    public StudentDao() {
        sessionFactory = SimplilearnConfig.getSessionFactory();
    }

    public boolean isExist(Student student){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();


            Student existStudent = session.find(Student.class, student);
            return Objects.nonNull(existStudent);

        }catch (Exception e){
            return false;
        }
    }


    public boolean insert(Student student){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();


            session.save(student);

            transaction.commit();
            return true;
        }catch (ConstraintViolationException e){
            return false;
        }
    }

    public List<Student> getAll(){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Query<Student> query = session.createQuery("from Student", Student.class);
            List<Student> queries = query.getResultList();

            session.close();

            return queries;

        }catch (Exception e){
            return Collections.EMPTY_LIST;
        }
    }

    public boolean assignStudentToClass(Student student, SchoolClass schoolClass){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Student existStudent = session.find(Student.class, student.getStudentId());
            SchoolClass existClass = session.find(SchoolClass.class, schoolClass.getClassId());

            existStudent.setSchoolClass(existClass);
            session.saveOrUpdate(existStudent);

            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Student getStudentById(int id){
        try{

            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Student student = session.get(Student.class, id);
            return student;
        }catch (Exception e){
            return null;
        }

    }
}
