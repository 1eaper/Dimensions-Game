package game.engine;


import game.Game;

public class Player extends GameObject{

	private float moveTime; // The delay in between movements in seconds
	private float timer; // Keeps track of the position in the delay
	
	// Default constructor for 1/2d player
	public Player() {
		
		// Runs the 1/2d GameObject constructor
		super(0, 0);
		
		// Initializes the timer
		moveTime = .125f;
		timer = 0;
		
		this.id = Game.PLAYER_ID; // Sets the player's id to the player id
	}
	
	// Update function
	public void update() {
		
		// Counts down the timer
		if(timer > 0) {
			timer -= Time.Delta();
		}
	}
	
	// Moves the player to the given coordinates in 1/2d
	public void move(int xpos, int ypos) {
		
		position[0] = xpos;
		position[1] = ypos;
	}
	
	// Moves the player to the given coordinates in 2/3d
	public void move(int xpos, int ypos, int zpos) {
		
		position[0] = xpos;
		position[1] = ypos;
		position[2] = zpos;
	}
	
	// Resets the move timer
	public void resetTimer() {
		
		timer = moveTime;
	}
	
	// Checks if a player can move in regards to the timer
	public boolean canMove() {
		
		return timer <= 0;
	}
}
