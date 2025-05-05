package org.example.lesson1.task3;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Locale;

@Getter
@ToString
public class Phone {
    @ToString.Exclude
    private final Faker faker = new Faker(Locale.FRANCE);
    private String number;
    private PhoneType phoneType;

    public Phone(){
        setNum();
        randomizer();
    }

    private void setNum(){
        this.number = faker.numerify("89#########");
    }
    private void randomizer(){
        int temp = (Math.random() <= 0.5) ? 1 : 2;
        this.phoneType = (temp == 2) ? PhoneType.MOBILE : PhoneType.STATIONARY;
    }
}
