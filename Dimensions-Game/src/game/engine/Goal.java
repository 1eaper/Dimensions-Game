package game.engine;

import game.Game;

public class Goal extends GameObject{

	// Default constructor for a 1/2d goal
	public Goal() {
		
		super(Game.LEVEL_SIZE - 1, 0);
		this.id = Game.GOAL_ID;
	}
	
	// Update function
	public void update() {
		
	}
}
