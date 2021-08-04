package com.bogdan.jpa.hibernate.demo.repository;

import com.bogdan.jpa.hibernate.demo.DemoApplication;
import com.bogdan.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;


    @Test
    public void contextLoads() {

    }

    @Test
    void findById_basic() {
        Course course = repository.findById(10001L);
        assertEquals("JPA Learning", course.getName());
    }

    @Test
    @DirtiesContext
    void deleteById_basic(){
         repository.deleteById(10001L);
         assertNull(repository.findById(10001L));
    }

    @Test
    @DirtiesContext
    void save_basic(){
        //get a course
        Course course = repository.findById(1L);
        assertEquals("Java 101", course.getName());

        //update the course
        course.setName("Java Core");

        repository.save(course);

        //check the values
        Course course1 = repository.findById(1L);
        assertEquals("Java Core", course1.getName());
    }

    @Test
    @DirtiesContext
    void save_test() {

        //get the course
        Course course = repository.findById(10001L);
        assertEquals("JPA Learning", course.getName());

        //update the course
        course.setName("Spring boot Training");

        //save the course
        repository.save(course);

        //check the values
        Course course1 = repository.findById(10001L);
        assertEquals("Spring boot Training", course1.getName());

    }




}

