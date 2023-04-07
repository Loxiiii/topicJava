package com.example.demo.hackerNewsItem;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Kid {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "item_id")
    private int itemId;
}
