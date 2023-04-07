package com.example.demo.hackerNewsItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    public List<Item> findByBy(String by);
    public List<Item> findByType(String type);

    public List<Item> findByByAndType(String by, String type);
}
