package com.hdstudios.mydoggo;

public class Doggo {
    private final Integer MAX = 10;
    private String name;
    private String breed;
    private Integer hunger = MAX;
    private Integer happiness = MAX;
    private Integer thirst = MAX;
    private Integer energy = MAX;
    private Integer cleanness = MAX;

    public Doggo() {

    }

    public Doggo(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getHunger() {
        return hunger;
    }

    public void setHunger(Integer hunger) {
        this.hunger = hunger;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public Integer getThirst() {
        return thirst;
    }

    public void setThirst(Integer thirst) {
        this.thirst = thirst;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getCleanness() {
        return cleanness;
    }

    public void setCleanness(Integer cleanness) {
        this.cleanness = cleanness;
    }
}
