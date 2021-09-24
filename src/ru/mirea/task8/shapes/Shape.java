package ru.mirea.task8.shapes;

public abstract class Shape {
    private int x;
    private int y;
    private int RColor;
    private int GColor;
    private int BColor;

    public Shape() {
        this.x = (int)(Math.random()*600);
        this.y = (int)(Math.random()*600);
        this.RColor = (int)(Math.random()*255);
        this.GColor = (int)(Math.random()*255);
        this.BColor = (int)(Math.random()*255);
    }

    public int getRColor() {
        return RColor;
    }

    public int getGColor() {
        return GColor;
    }

    public int getBColor() {
        return BColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x, int width) {
        if (this.x > width/2)
        {
            if (width - this.x < x)
            {
                this.x = this.x - (x - (width - this.x));
            }
        }
        else
        {
            if (this.x < x)
            {
                this.x = this.x + (x - this.x);
            }
        }
    }
    public void setY(int y, int length) {
        if (this.y > length/2)
        {
            if (length - this.y < y)
            {
                this.y = this.y - (y - (length - this.y));
            }
        }
        else
        {
            if (this.y < y)
            {
                this.y = this.y + (y - this.y);
            }
        }
    }
}
