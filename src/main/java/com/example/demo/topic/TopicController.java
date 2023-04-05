package com.example.demo.topic;

import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @PostMapping("/topics")
    public Topic addTopic (@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{name}")
    public List<Topic> findByName(@PathVariable String name) {
        return topicService.findByName(name);
    }
}
