package com.example.Phase2.service;

import com.example.Phase2.domain.ClassReport;
import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Subject;
import com.example.Phase2.entity.Teacher;

import java.util.List;

public class SchoolClassService extends BaseService {

    public boolean addNewSchoolClass(int id, String name) {
        try {
            SchoolClass schoolClass = SchoolClass.builder().classId(id).className(name).build();
            if (!schoolClassDao.isExist(schoolClass)) {
                boolean isInserted = schoolClassDao.insert(schoolClass);
                return isInserted;
            }
            return false;
        } catch (Exception e) {
            //todo: change log status
            logger.info("Exception occurred! " + e);
            return false;
        }
    }

    public List<SchoolClass> getAllClass() {
        return schoolClassDao.getAll();
    }

    public ClassReport getClassReportById(int id) {

        SchoolClass schoolClass = schoolClassDao.getSchoolClassById(id);
        List<Student> students = studentDao.getStudentByClassId(id);
        List<Teacher> teachers = teacherDao.getTeacherByClassId(id);
        List<Subject> subjects = subjectDao.getSubjectByClassId(id);

        return ClassReport.builder().schoolClass(schoolClass).subjects(subjects).teachers(teachers).students(students).build();
    }
}
