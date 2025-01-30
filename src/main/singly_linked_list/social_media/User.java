package main.singly_linked_list.social_media;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List of Friend IDs
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}
