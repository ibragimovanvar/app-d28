package com.example.homework;

public class Programmer extends Person{

    public Programmer(int age, String name) {
        super(age, name);
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return getAge() + " | " + getName();
    }
}
