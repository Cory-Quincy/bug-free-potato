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

	// Tracks the creature's hunger
	protected int hunger;
	
	// Returns the chance of dying
	public void die(String deathMessage) {
		alive = false;
		System.out.println(name + " has died of " + deathMessage + ".");
	}

	// Returns true if the creature is alive
	public boolean isAlive() {
		return alive;
	}

	// Simulates the chance of dying
	public void maybeDie(String deathMessage) {
		if (Math.random() < chanceToDie) {
			die(deathMessage);
		}
	}

	// Constructor to initialize a creature with a name, chance to die, and chance to reproduce
	public Creature(String name, double chanceToDie, double chanceToReproduce, int hunger) {
		this.name = name;
		this.chanceToDie = chanceToDie;
		this.chanceToReproduce = chanceToReproduce;
		this.alive = true;
		this.hunger = hunger;
	}

	// Returns the name of the creature
	public String getName() {
		return name;
	}

	// Returns the chance of reproducing
	public abstract LifeForm reproduce();

	// Returns the value of hunger
	public int getHunger(){
		return hunger;
	}

	// Changes the value of hunger
	public void changeHunger(int change){
		hunger += change;
	}
	
}
