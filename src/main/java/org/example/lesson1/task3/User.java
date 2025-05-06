package org.example.lesson1.task3;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.Locale;

@Getter
@ToString
public class User {
    @ToString.Exclude
    private final Faker faker = new Faker(Locale.FRANCE);
    private int uniqueID;
    private String name;
    private int age;
    private ArrayList<Phone> phones;

    public User (int id) {
        this.name = faker.name().firstName();
        //this.name = "John"; // для первого таска
        this.age = faker.number().numberBetween(15, 18);
        this.uniqueID = id;
        this.phones = new ArrayList<>();
        for (int i = 0; i < randomSize(); i++){
            phones.add(new Phone());
        }
    }

    private int randomSize(){
        return (int)(Math.random() * 3) + 1;
    }
}
