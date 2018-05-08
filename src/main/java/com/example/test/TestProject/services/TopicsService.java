package com.example.test.TestProject.services;

import com.example.test.TestProject.models.Topic;
import com.example.test.TestProject.repositories.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {
    @Autowired
    private TopicsRepository topicsRepository;

    public TopicsService() {
    }

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<Topic>();
        Iterator<Topic> iterator = this.topicsRepository.findAll().iterator();
        while (iterator.hasNext()) {
            Topic topic = iterator.next();
            topics.add(topic);
        }
        return topics;
    }

    public Optional<Topic> getTopic(long id) {
        return this.topicsRepository.findById(id);
    }

    public Topic createTopic(Topic topic) {
       return this.topicsRepository.save(topic);
    }

    public Topic updateTopic(Topic topic) {
       return this.topicsRepository.save(topic);
    }

    public void deleteTopic(long id) {
        this.topicsRepository.deleteById(id);
    }
}
