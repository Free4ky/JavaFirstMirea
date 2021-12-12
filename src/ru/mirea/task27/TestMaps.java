package ru.mirea.task27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestMaps {
    public static void main(String[] args){
        //задание 1
        HashMap<String,String> SN = new HashMap<String,String>();
        SN.put("Karpov","Daniil");
        SN.put("Lavrov","Daniil");
        SN.put("Geller","Monica");
        SN.put("Geller","Ross");
        SN.put("Buffay","Phoebe");
        HashMap<String,String> SN_reverse = new HashMap<String,String>();
        for (Map.Entry<String,String> pair: SN.entrySet()) {
            SN_reverse.put(pair.getValue(), pair.getKey());
        }
        SN.clear();
        for (Map.Entry<String,String> pair: SN_reverse.entrySet()) {
            SN.put(pair.getValue(), pair.getKey());
        }
        SN_reverse.clear();
        System.out.print(SN);
        // Задание 2
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(new City("Moscow","Russia"));
        cities.add(new City("Kaluga","Russia"));
        cities.add(new City("Vladimir","Russia"));
        cities.add(new City("New-York","USA"));
        cities.add(new City("Berlin","Germany"));
        cities.add(new City("Kiev","Ukraine"));
        cities.add(new City("Beijing","China"));
        HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();

        ArrayList<String> buf = new ArrayList<String>();
        for(City city: cities){
            buf = hm.get(city.getCountry());
            if (buf == null){
                buf = new ArrayList<>();
            }
            buf.add(city.getCity());
            hm.put(city.getCountry(),buf);
        }
        System.out.println(hm);
    }
}
