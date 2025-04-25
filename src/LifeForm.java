public interface LifeForm {

    // Marks the life form as dead
    void die();

    // Atemps to create a new life form
    Creature reproduce();

    // Checks if the life form is alive
    boolean isAlive();
}