
package interfaces;



public interface LifeForm {

    String getName();

    // Marks the life form as dead
    void die(String deathMessage);

    // Atemps to create a new life form
    LifeForm reproduce();

    // Checks if the life form is alive
    boolean isAlive();

    void eating(LifeForm lifeForm);

    //stub for fighting - not yet implemented
    void fighting(LifeForm lifeForm);

    //
    void maybeDie(String deathMessage);

    //
    int getHunger();

    //
    void changeHunger(int change);
}