// Capability for adding different types of life forms.

package interfaces;

public interface LifeForm {
	// TODO: doc
	String getName();

	// Marks the life form as dead
	void die(String deathMessage);

	// Atemps to create a new life form
	LifeForm reproduce();

	// Checks if the life form is alive
	boolean isAlive();

	// TODO: doc
	void eating(LifeForm lifeForm);

	//stub for fighting - not yet implemented
	void fighting(LifeForm lifeForm);

	// TODO: doc
	void maybeDie(String deathMessage);

	// TODO: doc
	int getHunger();

	// TODO: doc
	void changeHunger(int change);
}
