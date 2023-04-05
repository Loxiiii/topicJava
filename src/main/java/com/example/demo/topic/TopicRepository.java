package com.example.demo.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    public List<Topic> findByNameIgnoreCase(String name);
}
