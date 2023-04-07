package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

//    @PostMapping("/courses/{topicId}")
//    public Course addCourse(@RequestBody Course course, @PathVariable("topicId") Long topicId){
//        return courseService.addCourse(course, topicId);
//    }

    @PostMapping("/courses/{topicName}")
    public Course addCourseByTopicName(@RequestBody Course course, @PathVariable("topicName") String topicName){
        return courseService.addCourseByTopicName(course, topicName);
    }

}
