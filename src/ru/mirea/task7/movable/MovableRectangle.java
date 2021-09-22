package ru.mirea.task7.movable;

public class MovableRectangle implements Movable{
    private MovablePoint UpLeft_point;
    private MovablePoint DownRight_point;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        UpLeft_point = new MovablePoint(x1,y1,xSpeed,ySpeed);
        DownRight_point = new MovablePoint(x2,y2,xSpeed,ySpeed);
    }
    @Override
    public void moveUp() {
        UpLeft_point.moveUp();
        DownRight_point.moveUp();
    }

    @Override
    public void moveDown() {
        UpLeft_point.moveDown();
        DownRight_point.moveDown();
    }

    @Override
    public void moveLeft() {
        UpLeft_point.moveLeft();
        DownRight_point.moveLeft();
    }

    @Override
    public void moveRight() {
        UpLeft_point.moveRight();
        DownRight_point.moveRight();

    }
    @Override
    public String toString()
    {
        return "RECTANGLE\n" + "Top-left point:\n" + this.UpLeft_point.toString() + "\nBottom-right point:\n" + this.DownRight_point.toString() + "\n";
    }
}
