package ru.mirea.task12.mergeSort;

import ru.mirea.task12.qsort.Comporator;
import ru.mirea.task12.qsort.SortingStudentsByGPA;

import java.util.Scanner;

public class MergeSort {
    public Student[] mergeArrays(Student[] a, Student[] b)
    {
        Student [] c = new Student[a.length + b.length];
        for (int i = 0; i < c.length; i++)
        {
            c[i] = new Student();
        }
        int positionA = 0;
        int positionB = 0;

        for (int i = 0; i < c.length; i++) {
            if (positionA == a.length){
                c[i].setStudentId(b[positionB].getStudentId());
                c[i].setName(b[positionB].getName());
                positionB++;
            } else if (positionB == b.length) {
                c[i].setStudentId(a[positionA].getStudentId());
                c[i].setName(a[positionA].getName());
                positionA++;
            } else if (a[positionA].getStudentId() < b[positionB].getStudentId()) {
                c[i].setStudentId(a[positionA].getStudentId());
                c[i].setName(a[positionA].getName());
                positionA++;
            } else {
                c[i].setStudentId(b[positionB].getStudentId());
                c[i].setName(b[positionB].getName());
                positionB++;
            }
        }
        return c;
    }
    public Student[] mergeSort(Student[] c)
    {
        if (c == null) {
            return null;
        }
        if (c.length < 2) {
            return c;
        }
        Student [] b = new Student[c.length / 2];
        System.arraycopy(c, 0, b, 0, c.length / 2);

        Student [] a = new Student[c.length - c.length / 2];
        System.arraycopy(c, c.length / 2, a, 0, c.length - c.length / 2);

        b = mergeSort(b);
        a = mergeSort(a);

        return mergeArrays(b, a);
    }
    public MergeSort()
    {
        Scanner sc = new Scanner(System.in);
        int a_size = sc.nextInt();
        int b_size = sc.nextInt();
        Student[] a = new Student[a_size];
        Student[] b = new Student[b_size];
        for (int i = 0; i < a_size; i++) {
            a[i] = new Student();
        }
        for (int i = 0; i < b_size; i++) {
            b[i] = new Student();
        }
        System.out.println("First array:");
        OutPut(a);
        System.out.println("Second array:");
        OutPut(b);
        System.out.println("Merged array:");
        OutPut(mergeArrays(a,b));
        System.out.println("Merged and sorted array:");
        OutPut(mergeSort(mergeArrays(a,b)));
    }
    public void OutPut(Student[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i].toString());
        }
        System.out.println();
    }
    public static void main(String[]args) {

        new MergeSort();

    }
}
