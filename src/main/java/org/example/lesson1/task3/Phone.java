package org.example.lesson1.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Phone {
    private String number;
    private PhoneType phoneType;
}
