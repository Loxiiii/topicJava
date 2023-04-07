package com.example.demo.hackerNewsItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/items/{id}")
    public Item addItemById(@PathVariable("id") int id) {
        System.out.println("Received the post, with ID: " + id);
        return itemService.addItem(id);
    }

    @GetMapping(value = "/items", params = "by")
    public List<Item> findByBy(@RequestParam("by") String by) {
        return itemService.findByBy(by);
    }

    @GetMapping(value = "/items", params = "type")
    public List<Item> findByType(@RequestParam("type") String type) {
        return itemService.findByType(type);
    }

    @GetMapping(value = "/items", params = {"by", "type"})
    public List<Item> findByByAndType(@RequestParam("by")
            String by, @RequestParam("type") String type) {
        return itemService.findByByAndType(by, type);
    }

    @GetMapping(value = "/items", params = "findParentOfId")
    public Item findParentOfId(@RequestParam("findParentOfId") int id) {
        Item it = itemService.findById(id);
        int parentId = it.getParent().getId();
        return itemService.findById(parentId);
    }

    @GetMapping("/items/children")
    public List<String> findChildrenTexts(@RequestParam("id") int id) {
        return itemService.findChildrenTexts(id);
    }

    @GetMapping("/items/{id}")
    public Item findById(@PathVariable("id") int id) {
        return itemService.findById(id);
    }
}
