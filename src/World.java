import java.io.*;
import java.util.*;

public class World {
    // List of all creatures currently in the world
    private List<Creature> creatures;

    // List of possible names to assign to new creatures
    private List<String> namePool;

    // Constructor initializes the world with an empty list of creatures
    public World() {
        creatures = new ArrayList<>();
        namePool = new ArrayList<>();
        loadNames("names.txt");
    }

    // Load names from a file into the name pool
    private void loadNames(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                namePool.add(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error loading names: " + e.getMessage());
        }
    }

    // Create a new creature with a random name from the name pool
    public void createCreature() {
        if (!namePool.isEmpty()) {
            String name = namePool.get((int)(Math.random() * namePool.size()));
            double chanceToDie = 0.1;
            double chanceToReproduce = 0.3;
            Creature newCreature = new Creature(name, chanceToDie, chanceToReproduce);
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
            List<Creature> newCreatures = new ArrayList<>();
            Iterator<Creature> it = creatures.iterator();

            // Iterate through each creature's survival and reproduction
            while (it.hasNext()) {
                Creature c = it.next();
                if (c.isAlive()) {
                    c.maybeDie();
                    if (c.isAlive()) {
                        Creature offspring = c.reproduce();
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