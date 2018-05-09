package com.example.test.TestProject.com.example.test.TestProject.controllers;

import com.example.test.TestProject.exceptions.Error;
import com.example.test.TestProject.exceptions.ResourceNotFoundException;
import com.example.test.TestProject.jsonresponse.JSONResponse;
import com.example.test.TestProject.models.Topic;
import com.example.test.TestProject.services.TopicsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicsService topicsService;

    @GetMapping("/")
    public JSONResponse<List<Topic>> index() {
        return new JSONResponse<List<Topic>>(this.topicsService.getTopics());
    }

    @GetMapping("/{id}")
    public JSONResponse<Topic> show(@PathVariable long id) {
        Optional<Topic> topic = this.topicsService.getTopic(id);
        if (topic.isPresent()) {
            return new JSONResponse<Topic>(topic.get());
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    @PostMapping("/")
    public JSONResponse<Topic> create(@RequestBody Topic topic) {
        return new JSONResponse<Topic>(this.topicsService.createTopic(topic));
    }

    @PutMapping("/{id}")
    public JSONResponse<Topic> update(@RequestBody Topic topic, @PathVariable int id) {
        Optional<Topic> optionalTopic = this.topicsService.getTopic(id);
        if (optionalTopic.isPresent()) {
            return new JSONResponse<Topic>(topicsService.updateTopic(topic));
        } else {
            throw new ResourceNotFoundException(topic.getId());
        }
    }

    @DeleteMapping("/{id}")
    public String destroy(@PathVariable long id) {
        Optional<Topic> optionalTopic = this.topicsService.getTopic(id);
        if (optionalTopic.isPresent()) {
             this.topicsService.deleteTopic(id);
             return "Deleted";
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Error resourceNotFound(ResourceNotFoundException e) {
//        long id = e.getId();
//        return new Error(4,"Resource with id " + id + " not found");
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Error defaultErrorHandler(Exception e) {
//        return new Error(5,e.getMessage());
//    }
}
