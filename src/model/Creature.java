// Represents a basic creature that can die or reproduce
package model;

import interfaces.LifeForm;

//refactoring to an abstract class because we would hit a wall with scalability when adding more creature types
public abstract class Creature implements LifeForm {
    // Creature's name
    protected  String name;

    // Probability of dying each simulation step
    protected double chanceToDie;

    // Probability of reproducing each simulation step
    protected double chanceToReproduce;

    // Tracks whether the creature is alive
    protected boolean alive;


    
    // Returns the chance of dying
    public void die() {
        alive = false;
        System.out.println(name + " has died.");
    }

    // Returns true if the creature is alive
    public boolean isAlive() {
        return alive;
    }

    // Simulates the chance of dying
    public void maybeDie() {
        if (Math.random() < chanceToDie) {
            die();
        }
    }


    // Constructor to initialize a creature with a name, chance to die, and chance to reproduce
    public Creature(String name, double chanceToDie, double chanceToReproduce) {
        this.name = name;
        this.chanceToDie = chanceToDie;
        this.chanceToReproduce = chanceToReproduce;
        this.alive = true;
    }


    // Returns the name of the creature
    public String getName() {
        return name;
    }


    // Returns the chance of reproducing
    public abstract LifeForm reproduce();
        


    
}