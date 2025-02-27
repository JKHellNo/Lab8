package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
        // given a city, return whether or not it belongs in the list
    void testHasCity() {
        CustomList cityList = MockCityList();
        City city = new City("Shenzhen", "Guangdong");
        City city1 = new City("Calgary", "Alberta");
        cityList.addCity(city);

        assertEquals(true, cityList.hasCity(city));
        assertEquals(false, cityList.hasCity(city1));
    }

    @Test
        //Check if a city is present in the list. If it does then remove it from the list, if not then throw an exception
    void testDeleteCity() {
        CustomList cityList = MockCityList();
        City city = new City("Calgary", "Alberta");

        cityList.addCity(city);
        assertEquals(true, cityList.hasCity(city));
        cityList.delete(city);
        assertEquals(false, cityList.hasCity(city));
        //assertThrows(IllegalArgumentException.class, ()-> {cityList.delete(city);} );
    }

    @Test
        //Return how many cities are in the list
    void testCountCities(){
        CustomList cityList = MockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.addCity(city);

        assertEquals(1, cityList.countCities());
    }

}
