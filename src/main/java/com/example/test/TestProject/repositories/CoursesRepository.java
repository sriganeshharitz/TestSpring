package com.example.test.TestProject.repositories;

import com.example.test.TestProject.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository extends CrudRepository<Course,Long> {
}
