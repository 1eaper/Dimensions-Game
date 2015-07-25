package game;

import game.engine.Level;

import org.lwjgl.input.Keyboard;

public class Game {

	public static final int ONE_TWO_ID = 12; // The id for a 1/2d level
	public static final int TWO_THREE_ID = 23; // The id for a 2/3d level
	public static final int THREE_FOUR_ID = 34; // The id for a 3/4d level
	public static final int EMPTY_ID = 0; // The id of an empty space
	public static final int PLAYER_ID = 1; // The player id
	public static final int GOAL_ID = 2; // The goal id
	public static final int BLOCK_ID = 3; // The block id
	public final static int LEVEL_SIZE = 8; // The size of a level for each dimension
	public final static float TILE_SIZE = 64f; // The tile size for every object
	
	private Level level; // The level handler
	
	// Default constructor
	public Game() {
		
		level = new Level(TWO_THREE_ID); // initialize the level
	}
	
	public void getInput() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) // If the right is hit
				|| Keyboard.isKeyDown(Keyboard.KEY_D)) { // Or if the D key is hit
			
			level.move(1, 0, 0, 0); // Move the player one unit right
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) // If the left key is hit
				|| Keyboard.isKeyDown(Keyboard.KEY_A)) { // Or if the A Key is hit
			
			level.move(-1, 0, 0, 0); // Move the player one unit left
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP) // If the up key is hit
				|| Keyboard.isKeyDown(Keyboard.KEY_W)) { // Or if the W key is hit
			
			level.move(0, 1, 0, 0); // Move the player one unit up
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) // If the down key is hit
				|| Keyboard.isKeyDown(Keyboard.KEY_D)) { // Or if the D key is hit
			
			level.move(0, -1, 0, 0); // Move the player one unit down
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R)) { // If the R key is hit
			
			level.move(0, 0, 1, 0); // Move the player one unit forward
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_F)){ // If the F key is hit
			
			level.move(0, 0, -1, 0); // Move the player one unit back
		}
	}
	
	// Update function
	public void update() {
		
		level.update(); // Update the level
	}
	
	// Render function
	public void render() {
		
		level.render(); // Render everything in the level
	}
}
