package ru.mirea.task12.qsort;

import java.util.Scanner;

public class SortingStudentsByGPA implements Comporator{


    public void OutPut(Student[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i].toString());
        }
        System.out.println();
    }

    public SortingStudentsByGPA()
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Student[] arr = new Student[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Student();
        }
        OutPut(arr);
        QSort(arr,0, arr.length - 1);
        OutPut(arr);
    }

    @Override
    public void QSort(ru.mirea.task12.qsort.Student[] a, int leftBorder, int rightBorder)
    {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = a[(leftMarker + rightMarker) / 2].getStudentId();
        do {

            while (a[leftMarker].getStudentId() < pivot) {
                leftMarker++;
            }

            while (a[rightMarker].getStudentId() > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {

                if (leftMarker < rightMarker) {
                    int tmp = a[leftMarker].getStudentId();
                    String n = a[leftMarker].getName();
                    a[leftMarker].setStudentId(a[rightMarker].getStudentId());
                    a[leftMarker].setName(a[rightMarker].getName());
                    a[rightMarker].setStudentId(tmp);
                    a[rightMarker].setName(n);
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            QSort(a, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            QSort(a, leftBorder, rightMarker);
        }
    }
    public static void main(String[]args) {

        Comporator example = new SortingStudentsByGPA();

    }
}

