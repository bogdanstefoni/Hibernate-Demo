package com.bogdan.jpa.hibernate.demo.repository;

import com.bogdan.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            em.persist(course);
        }else {
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }
}
