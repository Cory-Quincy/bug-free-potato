
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

    // Constructor initializes the world with an empty list of creatures
    public World() {
        creatures = new ArrayList<>();
        namePool = new ArrayList<>();
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

            LifeForm newCreature = new Omnivore(name, chanceToDie, chanceToReproduce);

            creatures.add(newCreature);
            System.out.println("Created creature: " + name);
        }
    }

    // Placeholder for spawning food in the world
    public void spawnFood() {
        System.out.println("Food has spawned in the world.");
    }

    // Runs the simulation for a specified number of steps
    public void runSimulation(int steps) {
        for (int step = 1; step <= steps; step++) {
            System.out.println("\n--- Step " + step + " ---");
            spawnFood();

            // Track new creatures born
            List<LifeForm> newCreatures = new ArrayList<>();
            Iterator<LifeForm> it = creatures.iterator();

            // Iterate through each creature's survival and reproduction
            while (it.hasNext()) {
                LifeForm c = it.next();
                if (c.isAlive()) {
                    c.maybeDie();
                    if (c.isAlive()) {
                        LifeForm offspring = c.reproduce();
                        if (offspring != null) {
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