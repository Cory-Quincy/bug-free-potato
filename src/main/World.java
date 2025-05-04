
package main;
import interfaces.LifeForm;
import java.io.*;
import java.util.*;
import model.Omnivore;


//note I have refactored creature to implement the LifeForm interface


public class World {
    // List of all creatures currently in the world
    //-Dev TF- I think you hadnt gotten a chance to use your interface yet so refactoring some of this will help
    private List<LifeForm> creatures;

    // List of possible names to assign to new creatures
    private List<String> namePool;

    private int foodCount;

    // Constructor initializes the world with an empty list of creatures
    public World() {
        creatures = new ArrayList<>();
        namePool = new ArrayList<>();
        foodCount = 25;
        loadNames("src/data/names.txt");
    }


    //dev TF - I had to stackoverflow this, otherwise vs will freak out about data being in its own package
    private void loadNames(String filename) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("data/names.txt")) {
            if (input == null) {
                System.out.println("Could not find names.txt in classpath.");
                return;
            }
            Scanner fileScanner = new Scanner(input);
            while (fileScanner.hasNextLine()) {
                namePool.add(fileScanner.nextLine());
            }
            fileScanner.close();
            System.out.println("Loaded " + namePool.size() + " names.");
        } catch (Exception e) {
            System.out.println("Error loading names: " + e.getMessage());
        }
    }
    

    // Create a new creature with a random name from the name pool
    public void createCreature() {
        if (!namePool.isEmpty()) {
            String name = namePool.get((int)(Math.random() * namePool.size()));
            double chanceToDie = 0.1;
            double chanceToReproduce = 0.3;
            int hunger = 10;
            LifeForm newCreature = new Omnivore(name, chanceToDie, chanceToReproduce, hunger);

            creatures.add(newCreature);
            System.out.println("Created creature: " + name);
        }
    }

    // Placeholder for spawning food in the world
    public long spawnFood() {
        long foodToSpawn = Math.round(Math.random() * 5 * (creatures.size())); //Food is spawned in proportion to the number of creatures
        foodCount += foodToSpawn;
        System.out.println(Long.toString(foodToSpawn) + " food has spawned in the world. Total food: " + Integer.toString(foodCount));
        return foodToSpawn;
    }

    // Runs the simulation for a specified number of steps
    public void runSimulation(int steps) {
        for (int step = 1; step <= steps; step++) {
            System.out.println("\n--- Step " + step + " ---");
            

            // Track new creatures born
            List<LifeForm> newCreatures = new ArrayList<>();
            Iterator<LifeForm> it = creatures.iterator();

            spawnFood();

            // Iterate through each creature's survival and reproduction
            while (it.hasNext()) {
                LifeForm c = it.next();
                if (c.isAlive()) {
                    c.changeHunger(-3);
                    c.maybeDie("natural causes");

                    if(c.getHunger() < 1)
                        c.maybeDie("starvation");
                    

                    if (Math.random() < 0.7){ // Deciding whether the creature eats or not
                        int foodToEat = (int) Math.round(Math.random() * 10); //Creature eats 1-10 food and gains 1-10 hunger.
                        if (foodToEat <= foodCount){
                            c.changeHunger(foodToEat);
                            foodCount -= foodToEat;
                            System.out.println(c.getName() + " ate " + Integer.toString(foodToEat) + " food.");
                        } else { 
                            System.out.println(c.getName() + " doesn't find food.");
                        }
                    }

                    if (c.isAlive()) {
                        LifeForm offspring = c.reproduce();
                        if (offspring != null) {
                            c.changeHunger(-5);
                            newCreatures.add(offspring);
                        }
                    }
                    
                }
            }

            // Add any new creatures to the population
            creatures.addAll(newCreatures);

            // Display current population size
            System.out.println("Current population: " + creatures.size());
        }
    }
}