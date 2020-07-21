package com.demo.dao;

import com.demo.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();


    public void insertStudent(Student student) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public List<Student> getAllStudent() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Student> list = em.createQuery("select c from Student c", Student.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public Student getStudent(long id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.getTransaction().commit();
        em.close();
        return student;
    }

    public void updateStudent(Student student) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Student entity = em.find(Student.class, student.getId());
        entity.setRollNumber(student.getRollNumber());
        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        entity.setGender(student.getGender());
        entity.setFavourites(student.getFavourites());
        entity.setSports(student.getSports());
        entity.setAddress(student.getAddress());
        entity.setCity(student.getCity());
        entity.setCreatedAt(student.getCreatedAt());
        entity.setUpdatedAt(student.getUpdatedAt());
        entity.setStatus(student.getStatus());
        em.getTransaction().commit();
        em.close();
    }

    public void deleteStudent(long id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Student entity = em.find(Student.class, id);
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

}
