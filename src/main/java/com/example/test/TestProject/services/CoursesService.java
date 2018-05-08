package com.example.test.TestProject.services;

import com.example.test.TestProject.models.Course;
import com.example.test.TestProject.models.Topic;
import com.example.test.TestProject.repositories.CoursesRepository;
import com.example.test.TestProject.repositories.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;
    @Autowired
    private TopicsRepository topicsRepository;

    public List<Course> getAllCourses(long id) {
       return this.topicsRepository.findById(id).get().getCourses();
    }

    public Optional<Course> getCourse(long id) {
        return this.coursesRepository.findById(id);
    }

    public Course createCourse(Course course, long id) {
        Topic topic = topicsRepository.findById(id).get();
        course.setTopic(topic);
        topic.getCourses().add(course);
        topicsRepository.save(topic);
        return course;
    }

    public Course updateCourse(Course course, long courseId) {
        return this.coursesRepository.save(course);
    }

    public void deleteCourse(long id) {
        this.coursesRepository.deleteById(id);
    }
}
