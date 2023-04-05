package com.example.demo.course;

import com.example.demo.topic.Topic;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

}
