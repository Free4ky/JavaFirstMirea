package ru.mirea.task13.myArayList;

public class TestMyArrayList {
    public  static void main(String[] args){
        MyArrayList<String> example = new MyArrayList<String>();
        example.add("Mazda");
        example.add("Toyota");
        example.add("Lincoln");
        example.add("Honda");
        System.out.println(example.get(0));
        example.remove("Lincoln");
        example.remove(1);
        for (int i = 0; i < example.size(); i++){
            System.out.println(example.get(i));
        }
    }
}
