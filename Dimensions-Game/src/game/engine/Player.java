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
	
	/*// Moves the player in the given direction
	public void move(int xdir, int ydir, int zdir, int wdir) {
		
		if(canMove()) { // If the timer is zeroed
			
			// Assigns temporary variables to check if the movement is allowed
			int tempx = position[0] + xdir;
			int tempy = position[1] + ydir;
			
			// Checks if the movement would be within bounds
			if(tempx >= 0 && tempx <= Game.LEVEL_SIZE - 1) position[0] = tempx;
			if(tempy >= 0 && tempy <= Game.LEVEL_SIZE - 1) position[1] = tempy;
			
			// Debug code
			System.out.println(position[0] + ", " + position[1]);
			System.out.println(getX() + " : " + getY());
			
			resetTimer(); // Resets the timer
		}
	}//*/
	
	public void move(int xpos, int ypos) {
		
		position[0] = xpos;
		position[1] = ypos;
	}
	
	public void resetTimer() {
		
		timer = moveTime;
	}
	
	// Checks if a player can move in regards to the timer
	public boolean canMove() {
		
		return timer <= 0;
	}
}
