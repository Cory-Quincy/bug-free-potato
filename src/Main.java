public class Main {
    public static void main(String[] args) {
        // Create a new simulation world
        World world = new World();

        // Populate the world with 5 creatures
        for (int i = 0; i < 5; i++) {
            world.createCreature();
        }
    
        // Run the simulation for 10 steps
        world.runSimulation(10);
    }
}