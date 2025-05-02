package org.example.lesson1.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class User {
    private String uniqueID;
    private String name;
    private int age;
    private ArrayList<Phone> phones;
}
