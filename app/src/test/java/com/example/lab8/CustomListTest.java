package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity(){
        list = MockCityList();
        City city = new City("Charlottetown", "PEI");
        list.addCity(city);
        assertTrue(list.hasCity(city));

    }

    @Test
    void testDelete(){
        list = MockCityList();
        int list_size = list.getCount();
        City city = new City("Charlottetown", "PEI");
        list.addCity(city);
        list.delete(city);
        assertEquals(list_size, list.getCount());
    }

    @Test
    void testDeleteException(){
        list = MockCityList();
        City city = new City("Charlottetown", "PEI");
        assertThrows( IllegalArgumentException.class, () ->{
            list.delete(city);});

    }

    @Test
    void testCountCities(){
        list = MockCityList();
        int list_size = list.getCount();
        City city = new City("Charlottetown", "PEI");
        list.add(city);
        assertEquals(list_size+1, list.countCities());
    }


}
