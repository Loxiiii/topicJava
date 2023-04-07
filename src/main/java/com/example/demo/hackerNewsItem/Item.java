package com.example.demo.hackerNewsItem;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.springframework.context.annotation.Primary;
import org.w3c.dom.Text;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean deleted;
    @Column(length = 10000)
    private String text;
    private boolean dead;

    @ManyToOne
    private Item parent;
    private String by;
    private int descendants;

    @OneToMany(mappedBy = "parent")
    private List<Item> kids = new ArrayList<>();
    private int score;
    private long time;
    private String title;
    private String type;
    private String url;
}
