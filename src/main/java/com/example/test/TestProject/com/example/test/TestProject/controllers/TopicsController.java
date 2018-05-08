package com.example.test.TestProject.com.example.test.TestProject.controllers;

import com.example.test.TestProject.models.Topic;
import com.example.test.TestProject.services.TopicsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class TopicsController {

    @Autowired
    private TopicsService topicsService;

    @GetMapping("/topics")
    public List<Topic> index() {
        return this.topicsService.getTopics();
    }

    @GetMapping("/topics/{id}")
    public Optional<Topic> show(@PathVariable int id) {
        return this.topicsService.getTopic(id);
    }

    @PostMapping("/topics")
    public Topic create(@RequestBody Topic topic) {
        return this.topicsService.createTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public Topic update(@RequestBody Topic topic, @PathVariable int id) {
        return this.topicsService.updateTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void destroy(@PathVariable int id) {
         this.topicsService.deleteTopic(id);
    }
}
