package model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Fish implements AnimalInterface, AnimalShadowInterface, AnimalLocationInterface{

    private int fishId;
    private String name;
    private String shadow;
    private String location;
    private int price;
    private int[] timeArray;
    private int[] monthArrayNorthern;
    private int[] monthArraySouthern;

    public Fish(int fishId, String name, String shadow, String location, int price, int[] timeArray, int[] monthArrayNorthern, int[] monthArraySouthern) {
        this.fishId = fishId;
        this.name = name;
        this.shadow = shadow;
        this.location = location;
        this.price = price;
        this.timeArray = timeArray;
        this.monthArrayNorthern = monthArrayNorthern;
        this.monthArraySouthern = monthArraySouthern;
    }

    public List getCatchableFish(int[] userInput, Animal animalList) {
        tableheader();
        List<Fish> catchableFish = new ArrayList<>();
        List<Fish> checkTime = new ArrayList<>();
        for (Fish fish : animalList.getAnimalFish()) {
            boolean contains = IntStream.of(fish.getTimeArray()).anyMatch(x -> x == userInput[2]);
            if (contains) {
                checkTime.add(fish);
            }
        }

        if (userInput[0] == 1) {
            for (Fish fish : checkTime) {
                boolean contains = IntStream.of(fish.getMonthArrayNorthern()).anyMatch(x -> x == userInput[1]);
                if (contains) {
                    catchableFish.add(fish);
                }
            }
        } else if (userInput[0] == 2) {
            for (Fish fish : checkTime) {
                boolean contains = IntStream.of(fish.getMonthArraySouthern()).anyMatch(x -> x == userInput[1]);
                if (contains) {
                    catchableFish.add(fish);
                }
            }
        }
        for (Fish fish : catchableFish) {
            System.out.println(fish.toString());
        }
        return catchableFish;
    }

    @Override
    public String toString() {
        return String.format("|%5s|%15s|%10s|%10s|%5s|", fishId, name, shadow, location, price);
    }

    public void tableheader() {
        System.out.println(String.format("\nFangbare Fische:\n|%5s|%15s|%10s|%10s|%5s|", "Id", "Name", "Größe", "Ort", "Preis") + "\n---------------------------------------------------");
    }

    @Override
    public String getShadow() {
        return shadow;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public int getId() {
        return fishId;
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
