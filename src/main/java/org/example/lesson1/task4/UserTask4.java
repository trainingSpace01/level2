package org.example.lesson1.task4;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Random;

@Getter
public class UserTask4 {
    private Long id;
    private String name;
    private List<UserTask4> friends;

    public UserTask4(String name) {
        this.name = name;
        this.id = new Random().nextLong();
    }

    public void setFriends(List<UserTask4> friends) {
        this.friends = friends;
    }
}
