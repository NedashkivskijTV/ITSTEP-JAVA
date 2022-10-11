package edu.itstep.cw20221006;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Db.createPlacesTable();

        Place p1 = new Place("2", "1111111");
        Place p2 = new Place("1", "5555555");
//        Db.insertPlace(p1);
//        Db.insertPlace(p2);
//        Db.deletePlaceById(2);

        List<Place> places = Db.getAllPlaces();
        places.forEach(System.out::println);

        MyFrame myFrame = new MyFrame();

    }

    public static void dbTest(){

    }
}

