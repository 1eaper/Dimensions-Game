package game.engine;


import game.Game;

public class Player extends GameObject{

	private float moveTime; // The delay in between movements in seconds
	private float timer; // Keeps track of the position in the delay
	
	// Default constructor for 1/2d player
	public Player() {
		
		// Runs the 1/2d GameObject constructor
		super(0, 0, 0, 0);
		
		this.canMove = true;
		
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
	
	// Player specific move wrapper
	public boolean move(int xdir, int ydir, int zdir, int wdir, Level level) {

		if (this.canMove()) {
			if(super.move(xdir, ydir, zdir, wdir, level)) {
			
				this.resetTimer();
				return true;
			} else {
				
			}
		}
		return false;
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
