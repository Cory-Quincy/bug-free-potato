package model;

import interfaces.LifeForm;

//stub for omnivore class - not yet implemented
public class Omnivore extends Creature {

    public Omnivore(String name, double chanceToDie, double chanceToReproduce, int hunger) {
        super(name, chanceToDie, chanceToReproduce, hunger);
    }

    @Override
    // Returns the chance of reproducing
    public LifeForm reproduce() {
        if (Math.random() < chanceToReproduce) {
            String childName = name + " Jr.";
            System.out.println(name + " reproduce and created " + childName);
            return new Omnivore(childName, chanceToDie, chanceToReproduce, hunger);
        }
        return null;
    }


    @Override
    // in progress - trying to establish health loss/gain - simulates eating
    public void eating(LifeForm lifeForm) {
        if (lifeForm.isAlive()) {
            System.out.println(name + " eats " + lifeForm.getName() + ".");
            maybeDie("being eaten.");
        } else {
            System.out.println(name + " cannot eat, " + name + " is dead. ");
        }
    }
    
    @Override
    public void fighting(LifeForm lifeForm) {
        System.out.println(name + " is fighting " + lifeForm.getName() + ".");
        //health -= 10; // -stub- Decrease health by 10 for fighting
    }
}
