package com.example.demo.hackerNewsItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    WebClient.Builder builder = WebClient.builder();
    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(int id) {
        String generatedUri = "https://hacker-news.firebaseio.com/v0/item/"
        + id + ".json?print=pretty";
        System.out.println("This is the Id currently being added" + id);
        Item loadItem = builder.build().get().uri(generatedUri)
                .retrieve().bodyToMono(Item.class).block();
        loadItem.getKids().clear();
        System.out.println("This is the Item currently being added" + loadItem.toString());
        return itemRepository.save(loadItem);
    }

    public List<Item> findByBy(String by) {
        return itemRepository.findByBy(by);
    }

    public List<Item> findByType(String type) {
        return itemRepository.findByType(type);
    }

    public List<Item> findByByAndType(String by, String type) {
        return itemRepository.findByByAndType(by, type);
    }

    public Item findById(int id) {
        return itemRepository.findById(id).get();
    }

    public List<String> findChildrenTexts(int parentId) {
        // create result array
        ArrayList<String> result = new ArrayList<>();
        // find parent
        Item parent = itemRepository.findById(parentId).get();
        System.out.println("This is the parent found" + parent.toString());
        // isolate the list of kids
        List<Item> kids = parent.getKids();
        kids.forEach(kid -> {
            Item kidItem = itemRepository.findById(kid.getId()).get();
            if(kidItem.getText() != null) {
                result.add(kidItem.getText());
            }

        });
        return result;
    }
}
