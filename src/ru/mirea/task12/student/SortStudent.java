package ru.mirea.task12.student;

import java.util.Scanner;

public class SortStudent {
    public static void InsertionSort(Student[] a)
    {
        for (int left = 0; left < a.length; left++)
        {
            int val = a[left].getStudentId();
            int i = left - 1;
            for(; i>=0; i--)
            {
                if (val < a[i].getStudentId()) {
                    a[i + 1].setStudentId(a[i].getStudentId());
                }
                else
                {
                    break;
                }
            }
            a[i+1].setStudentId(val);
        }
    }
    public static void OutPut(Student[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i].getStudentId());
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Student[] arr = new Student[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = new Student();
        }
        OutPut(arr);
        InsertionSort(arr);
        OutPut(arr);
    }
}
