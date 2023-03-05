package com.example.Phase2.dao;

import com.example.Phase2.dbConfig.SimplilearnConfig;
import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
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

    public boolean assignTeacherToClass(Teacher teacher, SchoolClass schoolClass){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Teacher existTeacher = session.find(Teacher.class, teacher.getTeacherId());
            SchoolClass existClass = session.find(SchoolClass.class, schoolClass.getClassId());

            existTeacher.setSchoolClass(existClass);
            session.saveOrUpdate(existTeacher);

            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Teacher getTeacherById(int id){
        try{

            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Teacher teacher = session.get(Teacher.class, id);
            return teacher;
        }catch (Exception e){
            return null;
        }

    }

    public List<Teacher> getTeacherByClassId(int id){
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            String teacherSql = "SELECT t FROM Teacher t WHERE  t.schoolClass.classId = :id";
            Query<Teacher> teacherQuery = session.createQuery(teacherSql, Teacher.class);
            teacherQuery.setParameter("id", id);
            List<Teacher> teachers = teacherQuery.getResultList();

            session.close();

            return teachers;
        }catch (Exception e){
            return null;
        }

    }
}
