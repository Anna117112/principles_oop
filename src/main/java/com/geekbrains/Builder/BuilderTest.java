package com.geekbrains.Builder;

public class BuilderTest {
    public static void main(String[] args) {
        Person person = Person.builder()
                        .withFirstName("Иван")
                                .withLastName("Иванов")
                                        .withMiddleName("Иван")
                                                .withCountry("Россия")
                                                        .withAddress("ул.Мира")
                                                                .withPhone("1215644")
                                                                        .withAge(30)
                                                                                .withGender("м")
                .build();
    }



}
