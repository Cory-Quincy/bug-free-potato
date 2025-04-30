package main;

//Dev TF- note: this could be refactored to be an entry exit point for running the sim



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

/*
REFRACTOR NOTE — by TF

This commit focuses on structural cleanup and minimal refactoring to improve functionality 
without altering the original design intent.

Key Changes:
------------
- Converted Creature.java to an abstract class to allow subtype extension (e.g., Omnivore).
- Created Omnivore.java as a working subclass to maintain existing simulation behavior.
- Updated LifeForm.java interface to include getName(), required for clearer output in interactions.
- Replaced direct Creature instantiation in World.java with Omnivore (concrete subclass).
- Fixed file path handling for names.txt — changed from hardcoded relative path to classpath-based InputStream.
- Verified namePool loads correctly (4945 entries), and creature creation now populates the world as expected.

Preserved:
----------
- All simulation output format remains untouched — only underlying logic was connected to actual data.
- No changes made to reproduction, death, or step logic outside of necessary fixes for class structure.

Intended as a structural baseline. Ready for pull request if team agrees this aligns with our original plan.
*/

/*
git commit -m "Refactored Creature into abstract class; added Omnivore subclass" `
-m "- Updated LifeForm interface with getName()" `
-m "- World now instantiates Omnivore instead of abstract Creature" `
-m "- Fixed names.txt loading via classpath InputStream" `
-m "- Verified reproduction/death logic and name pool load (4945 entries)" `
-m "- Simulation output format preserved"
     
*/

