package ru.mirea.task30;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @org.junit.jupiter.api.Test
    void averagePeople() {
            City city1 = new City(1000);
            City city2 = new City(1500);
            double expected = city1.averagePeople();
            double actual = 2500d/2;
            Assert.assertEquals(expected,actual,0.1d);
    }
}