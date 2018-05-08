package com.example.test.TestProject.dataloaders;

import com.example.test.TestProject.models.Topic;
import com.example.test.TestProject.repositories.TopicsRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private TopicsRepository topicsRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            Topic topic = new Topic();
//            Faker faker = new Faker();
//            topic.setName(faker.company().name());
//            topic.setDescription(faker.company().profession());
//            topicsRepository.save(topic);
//        }
    }
}
