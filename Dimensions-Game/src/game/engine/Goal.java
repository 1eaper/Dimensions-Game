package game.engine;

import game.Game;

public class Goal extends GameObject{

	// Default constructor for a 1/2d goal
	public Goal() {
		
		super(Game.LEVEL_SIZE - 1, 0);
		this.canMove = false;
		this.id = Game.GOAL_ID;
	}
	
	// Constructor for a 1/2d goal
	public Goal(int x, int y) {
		
		super(x, y);
		this.canMove = false;
		this.id = Game.GOAL_ID;
	}
	
	// Constructor for a 2/3d goal
	public Goal(int x, int y, int z) {
		
		super(x, y, z);
		this.canMove = false;
		this.id = Game.GOAL_ID;
	}
	
	// Update function
	public void update() {
		
	}
}
