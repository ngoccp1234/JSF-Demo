package com.demo.service;


import com.demo.dao.StudentDAO;
import com.demo.entity.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Calendar;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudentService {

    StudentDAO dao = new StudentDAO();

    public void createStudent(Student student) {
        student.setId(Calendar.getInstance().getTimeInMillis());
        student.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        dao.insertStudent(student);
    }

    public void updateStudent(Student student) {
        student.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        dao.updateStudent(student);
    }

    public void deleteStudent(long id)
    {
        dao.deleteStudent(id);
    }

    public Student findById(long id) {
        return dao.getStudent(id);
    }

    public List<Student> getAllStudent() {
        return dao.getAllStudent();
    }
}
