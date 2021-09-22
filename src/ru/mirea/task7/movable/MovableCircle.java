package ru.mirea.task7.movable;

public class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.radius = radius;
        center = new MovablePoint(x,y,xSpeed,ySpeed);
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }
    @Override
    public String toString()
    {
        return "CIRCLE\nradius: " + this.radius + "\ncenter is a point:\n" + this.center.toString() + "\n";
    }
}
