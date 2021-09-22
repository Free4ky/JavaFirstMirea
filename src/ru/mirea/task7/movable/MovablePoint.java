package ru.mirea.task7.movable;

public class MovablePoint implements Movable{
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public void moveUp() {
        this.y = this.y + 1;
    }
    @Override
    public void moveDown() {
        this.y = this.y - 1;
    }

    @Override
    public void moveLeft() {
        this.x = this.x - 1;
    }

    @Override
    public void moveRight() {
        this.x = this.x + 1;
    }
    @Override
    public String toString()
    {
        return "POINT\nx: " + this.x + " y: " + this.y + "\nxSpeed: " + this.xSpeed + " ySpeed: " + this.ySpeed + "\n";
    }
}
