package ru.mirea.task12.qsort;

public class Student {
    private int studentId;
    private String name;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student() {
        this.studentId = (int)(Math.random()*123);
        this.setName();
    }

    public void setName() {
        int x = (int)(Math.random()*15);
        switch (x)
        {
            case 0:
                this.name = "Sergey";
                break;
            case 1:
                this.name = "Ivan";
                break;
            case 2:
                this.name = "Anna";
                break;
            case 3:
                this.name = "Diana";
                break;
            case 4:
                this.name = "Leha";
                break;
            case 5:
                this.name = "Alex";
                break;
            case 6:
                this.name = "Oucho";
                break;
            case 7:
                this.name = "Dmitry";
                break;
            case 8:
                this.name = "Danil";
                break;
            case 9:
                this.name = "Sasha";
                break;
            case 10:
                this.name = "Sveta";
                break;
            case 11:
                this.name = "Misha";
                break;
            case 12:
                this.name = "Alina";
                break;
            case 13:
                this.name = "Nick";
                break;
            case 14:
                this.name = "Nickolay";
                break;
            case 15:
                this.name = "Monica";
                break;
        }
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString()
    {
        return "Id: "+this.getStudentId()+" name: "+this.getName();
    }
}
