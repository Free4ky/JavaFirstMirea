package ru.mirea.task30;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class City {
    private static HashMap<Integer,City> allCities;
    private int people;
    private int id;
    private static int counter = 0;

    public City(int people){

        this.people = people;

        if (allCities == null)
        {
            allCities = new HashMap<>();
        }

        if (!hashCity()){
            counter++;
            this.id = counter;
            allCities.put(id,this);
        }
    }
    private boolean hashCity(){
        for (City city: allCities.values()){
            if (city.equals(this) && city.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }
    public double averagePeople()
    {
        double pep = 0;
        for (City city: allCities.values()){
            pep += city.people;
        }
        return pep/allCities.size();
    }

}
