package ru.mirea.task12.student;

public class Student {
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student() {
        this.studentId = (int)(Math.random()*123);
    }
}
