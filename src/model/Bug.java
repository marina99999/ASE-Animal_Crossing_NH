package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Bug implements AnimalInterface{
    private int bugId;
    private String name;
    private String location;
    private int price;
    private int[] timeArray;
    private int[] monthArrayNorthern;
    private int[] monthArraySouthern;

    public Bug(int bugId, String name, String location, int price, int[] timeArray, int[] monthArrayNorthern, int[] monthArraySouthern) {
        this.bugId = bugId;
        this.name = name;
        this.location = location;
        this.price = price;
        this.timeArray = timeArray;
        this.monthArrayNorthern = monthArrayNorthern;
        this.monthArraySouthern = monthArraySouthern;
    }

    public List getCatchableBug(int[] userInput, Animal animalList){
        List<Bug> catchableBug = new ArrayList<>();
        List<Bug> checkTime = new ArrayList<>();
        tableheader();
        for (Bug bug: animalList.getAnimalBug()) {
            boolean contains = IntStream.of(bug.getTimeArray()).anyMatch(x -> x == userInput[2]);
            if(contains){
                checkTime.add(bug);
            }
        }

        if(userInput[0] == 1) {
            for (Bug bug: checkTime) {
                boolean contains = IntStream.of(bug.getMonthArrayNorthern()).anyMatch(x -> x == userInput[1]);
                if(contains){
                    catchableBug.add(bug);
                }
            }
        } else if(userInput[0] == 2) {
            for (Bug bug: checkTime) {
                boolean contains = IntStream.of(bug.getMonthArraySouthern()).anyMatch(x -> x == userInput[1]);
                if(contains){
                    catchableBug.add(bug);
                }
            }
        }
        for (Bug bug: catchableBug) {
            System.out.println(bug.toString());
        }
        return catchableBug;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("|%5s|%15s|%10s|%5s|", bugId, name, location, price);
    }

    public void tableheader() {
        System.out.println(String.format("\nFangbare Insekten:\n|%5s|%15s|%10s|%5s|", "Id", "Name", "Ort", "Preis") + "\n----------------------------------------");
    }

    @Override
    public int getId() {
        return bugId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int[] getTimeArray() {
        return timeArray;
    }

    @Override
    public int[] getMonthArrayNorthern() {
        return monthArrayNorthern;
    }

    @Override
    public int[] getMonthArraySouthern() {
        return monthArraySouthern;
    }
}
