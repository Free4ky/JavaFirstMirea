package ru.mirea.task3.circle;

import java.util.Scanner;
public class Circle {
    private float radious;
    public Circle(float radious){
        this.radious = radious;
    }
    public float getRadious(){
        return radious;
    }
    public void setRadious(float radious){
        this.radious = radious;
    }
    public float P(){
        return(2*3.14f*radious);
    }
    public float S() {
        return (3.14f * radious * radious);
    }
}

