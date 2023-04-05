package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic addTopic (Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        ArrayList<Topic> t = new ArrayList<>();
        topicRepository.findAll().forEach(t::add);
        return t;
    }

    public List<Topic> findByName(String name) {
        return topicRepository.findByNameIgnoreCase(name);
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).get();
    }
}
