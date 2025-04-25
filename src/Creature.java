// Represents a basic creature that can die or reproduce

public class Creature {
    // Creature's name
    private String name;

    // Probability of dying each simulation step
    private double chanceToDie;

    // Probability of reproducing each simulation step
    private double chanceToReproduce;

    // Tracks whether the creature is alive
    private boolean alive;

    // Constructor to initialize a creature with a name, chance to die, and chance to reproduce
    public Creature(String name, double chanceToDie, double chanceToReproduce) {
        this.name = name;
        this.chanceToDie = chanceToDie;
        this.chanceToReproduce = chanceToReproduce;
        this.alive = true;
    }

    // Returns true if the creature is alive
    public boolean isAlive() {
        return alive;
    }

    // Returns the name of the creature
    public String getName() {
        return name;
    }

    // Returns the chance of dying
    public void die() {
        alive = false;
        System.out.println(name + " has died.");
    }

    // Returns the chance of reproducing
    public Creature reproduce() {
        if (Math.random() < chanceToReproduce) {
            String childName = name + " Jr.";
            System.out.println(name + " reproduce and created " + childName);
            return new Creature(childName, chanceToDie, chanceToReproduce);
        }
        return null;
    }

    // Simulates the chance of dying
    public void maybeDie() {
        if (Math.random() < chanceToDie) {
            die();
        }
    }
}