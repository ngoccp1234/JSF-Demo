package com.demo.bean;

import com.demo.entity.Student;
import com.demo.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StudentBean {
    @ManagedProperty(value = "#{studentService}")
    private StudentService studentService;

    @ManagedProperty(value = "#{student}")
    private Student student;

    private String[] favourites;
    private String[] sports;

    public String saveStudent() {
        student.setFavourites(String.join(", ", favourites));
        student.setSports(String.join(", ", sports));
        studentService.createStudent(student);
        student = new Student();
        favourites = new String[0];
        sports = new String[0];
        return "list-student?faces-redirect=true";
    }

    public String deleteStudent(long id)
    {
        studentService.deleteStudent(id);
        return "list-student?faces-redirect=true";

    }

    public String editStudent()
    {
        student.setFavourites(String.join(", ", favourites));
        student.setSports(String.join(", ", sports));
        studentService.updateStudent(student);
        student = new Student();
        favourites = new String[0];
        sports = new String[0];
        return "list-student?faces-redirect=true";
    }
    public String getStudentById(long id) {
        student = studentService.findById(id);
        if (student == null) {
            return "not found!";
        }
        this.favourites = student.getFavourites().split(", ");
        this.sports = student.getSports().split(", ");
        return "update-student?faces-redirect=true";

    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String[] getFavourites() {
        return favourites;
    }

    public void setFavourites(String[] favourites) {
        this.favourites = favourites;
    }

    public String[] getSports() {
        return sports;
    }

    public void setSports(String[] sports) {
        this.sports = sports;
    }
}
