package com.example.test.TestProject.com.example.test.TestProject.controllers;

import com.example.test.TestProject.models.Course;
import com.example.test.TestProject.models.Topic;
import com.example.test.TestProject.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> index(@PathVariable long id) {
        return this.coursesService.getAllCourses(id);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course show(@PathVariable long topicId, @PathVariable long id) {
        return this.coursesService.getCourse(id).get();
    }

    @PostMapping("/topics/{id}/courses")
    public Course create(@RequestBody Course course, @PathVariable long id) {
        return this.coursesService.createCourse(course, id);
    }

    @PutMapping("/topics/{topicId}/courses/{courseId}")
    public Course update(@RequestBody Course course, @PathVariable long courseId) {
        return this.coursesService.updateCourse(course, courseId);
    }

    @DeleteMapping("/topics/{topicId}/courses/{courseId}")
    public void delete(@PathVariable long courseId) {
        this.coursesService.deleteCourse(courseId);
    }
}
