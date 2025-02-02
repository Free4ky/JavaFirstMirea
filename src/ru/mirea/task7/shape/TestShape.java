package ru.mirea.task7.shape;

public class TestShape {
    public static void main(String[]args) {
        Shape s1 = new Circle(5.5, "RED", false); // Upcast Circle to Shape
        System.out.println(s1); // which version?
        System.out.println(s1.getArea()); // which version?
        System.out.println(s1.getPerimetr()); // which version?
        System.out.println(s1.getColour());
        System.out.println(s1.isFilled());
        // System.out.println(s1.getRadius()); // нужно сделать downcast to Circle, правильный вариант ниже
        System.out.println(((Circle) s1).getRadius());
        Circle c1 = (Circle)s1; // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimetr());
        System.out.println(c1.getColour());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());
        // Shape s2 = new Shape(); нельзя создать экземпляр абстрактного класса
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimetr());
        System.out.println(s3.getColour());
        // System.out.println(s3.getLength()); нужно сделать downcast to Rectangle, правильный вариант ниже
        System.out.println(((Rectangle) s3).getLength());
        Rectangle r1 = (Rectangle)s3; // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColour());
        System.out.println(r1.getLength());
        Shape s4 = new Square(6.6); // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColour());
        // System.out.println(s4.getSide()); нужно сделать downcast to Square, правильный вариант ниже
        System.out.println(((Square) s4).getSide());
        // Take note that we downcast Shape s4 to Rectangle,
        // which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColour());
        // System.out.println(r2.getSide()); нужнос сделать downcast to Square, правильный вариант ниже
        System.out.println(((Square)r2).getSide());
        System.out.println(r2.getLength());
        // Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColour());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }
}
