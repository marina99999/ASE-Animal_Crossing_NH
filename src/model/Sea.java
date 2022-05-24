package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Sea implements AnimalInterface{
    private int seaId;
    private String name;
    private String shadow;
    private int price;
    private String speed;
    private int[] timeArray;
    private int[] monthArrayNorthern;
    private int[] monthArraySouthern;

    public Sea(int seaId, String name, String shadow, int price, String speed, int[] timeArray, int[] monthArrayNorthern, int[] monthArraySouthern) {
        this.seaId = seaId;
        this.name = name;
        this.shadow = shadow;
        this.price = price;
        this.speed = speed;
        this.timeArray = timeArray;
        this.monthArrayNorthern = monthArrayNorthern;
        this.monthArraySouthern = monthArraySouthern;
    }

    public List getCatchableSea(int[] userInput, Animal animalList){
        tableheader();
        List<Sea> catchableSea = new ArrayList<>();
        List<Sea> checkTime = new ArrayList<>();
        for (Sea sea: animalList.getAnimalSea()) {
            boolean contains = IntStream.of(sea.getTimeArray()).anyMatch(x -> x == userInput[2]);
            if(contains){
                checkTime.add(sea);
            }
        }

        if(userInput[0] == 1) {
            for (Sea sea: checkTime) {
                boolean contains = IntStream.of(sea.getMonthArrayNorthern()).anyMatch(x -> x == userInput[1]);
                if(contains){
                    catchableSea.add(sea);
                }
            }
        } else if(userInput[0] == 2) {
            for (Sea sea: checkTime) {
                boolean contains = IntStream.of(sea.getMonthArraySouthern()).anyMatch(x -> x == userInput[1]);
                if(contains){
                    catchableSea.add(sea);
                }
            }
        }
        for (Sea sea: catchableSea) {
            System.out.println(sea.toString());
        }
        return catchableSea;
    }

    public String getShadow() {
        return shadow;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return String.format("|%5s|%20s|%10s|%15s|%5s|", seaId, name, shadow, speed, price);
    }

    public void tableheader() {
        System.out.println(String.format("\nFangbare Meerestiere:\n|%5s|%20s|%10s|%15s|%5s|", "Id", "Name", "Größe", "Geschwindigkeit", "Preis") + "\n-------------------------------------------------------------");
    }

    @Override
    public int getId() {
        return seaId;
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
