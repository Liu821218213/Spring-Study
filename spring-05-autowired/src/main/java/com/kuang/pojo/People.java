package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class People {

    @Autowired
    private Cat Cat;
    @Autowired
    @Qualifier(value = "dog22")
    private Dog dog;
    private String name;

    public com.kuang.pojo.Cat getCat() {
        return Cat;
    }

    public void setCat(Cat Cat) {
        this.Cat = Cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + Cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
