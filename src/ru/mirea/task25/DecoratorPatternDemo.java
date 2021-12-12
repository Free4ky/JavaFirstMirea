package ru.mirea.task25;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape rect = new Rectangle();
        RedShapeDecorator rsDecorator = new RedShapeDecorator(rect);
        rsDecorator.setRedBorder();
        rsDecorator.draw();
    }
}
