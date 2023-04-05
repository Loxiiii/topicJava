package com.example.demo.course;

import com.example.demo.topic.Topic;
import com.example.demo.topic.TopicRepository;
import com.example.demo.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TopicService topicService;

    public Course addCourse(Course course, Long topicId) {
        Topic topic = topicService.findById(topicId);
        course.setTopic(topic);
        return courseRepository.save(course);
    }
}
