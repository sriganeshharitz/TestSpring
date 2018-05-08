package com.example.test.TestProject.repositories;

import com.example.test.TestProject.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface TopicsRepository extends CrudRepository<Topic,Long> {
}
