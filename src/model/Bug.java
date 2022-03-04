package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Bug {
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

    public List getCachableBug(int[] userInput, Animal animalList){
        List<Bug> catchableBug = new ArrayList<>();
        List<Bug> checkTime = new ArrayList<>();
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

    public int getBugId() {
        return bugId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public int[] getTimeArray() {
        return timeArray;
    }

    public int[] getMonthArrayNorthern() {
        return monthArrayNorthern;
    }

    public int[] getMonthArraySouthern() {
        return monthArraySouthern;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "bugId=" + bugId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", timeArray=" + Arrays.toString(timeArray) +
                ", monthArrayNorthern=" + Arrays.toString(monthArrayNorthern) +
                ", monthArraySouthern=" + Arrays.toString(monthArraySouthern) +
                '}';
    }
}
