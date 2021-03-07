package ru.geekbrains.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
    @GetMapping("/json")
    public Json getJson(){
        Json json = new Json();
        json.setName("Vitaly");
        json.setSecondName("Petukhov");
        json.setAge(35);
        ObjectMapper objectMapper = new ObjectMapper();
        json = objectMapper.convertValue(json, Json.class);
        return json;
    }

    public static class Json{
        private String name;
        private String secondName;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
