package ru.mirea.task25;

public class ShapeDecorator implements Shape{
    public Shape shape;
    public ShapeDecorator(Shape shape){this.shape = shape;}
    @Override
    public void draw(){}
}
