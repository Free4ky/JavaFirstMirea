package ru.mirea.task31;

import org.junit.Assert;
import org.junit.Before;

class CityTest {

    @org.junit.jupiter.api.Test
    void averagePeople() {
            City city1 = new City(1000);
            City city2 = new City(1500);
            double expected = city1.averagePeople();
            double actual = 2500d/2;
            Assert.assertEquals(expected,actual,0.1d);
    }

    @org.junit.jupiter.api.Test
    void new_City_minus_people(){
        City city1 = new City(1000);
        City city2 = new City(1500);

        City city3 = new City(-1);
        for(City city: City.getAllCities().values()){
            if (city.getPeople() < 0){
                Assert.fail("Попытка создания города с отрицательным количеством жителей");
            }
        }
    }
}