package game.engine;

import game.Game;


public abstract class GameObject {

	protected int id; // Determines what type of gameobject something is
	protected int[] position; // The coordinates of the object
	
	/*
	 *  Constructors
	 */
	
	public GameObject() {
		position = new int[4];
	}
	
	// Initialize the object for a 1/2d level
	public GameObject(int x, int y) {
		
		position = new int[4];
		
		position[0] = x;
		position[1] = y;
		position[2] = 0;
		position[3] = 0;
	}
	
	/*
	 *  Abstract functions
	 */
	
	public abstract void update();

	public void render(float levelX, float levelY, int dimension) {
		
		if(dimension == Game.ONE_TWO_ID) 
			Draw.drawSq((float)getX() * Game.TILE_SIZE + Game.TILE_SIZE / 2 + levelX, 0 + levelY, id);
		if(dimension == Game.TWO_THREE_ID)
			Draw.drawSq((float)getX() * Game.TILE_SIZE + Game.TILE_SIZE / 2 + levelX, (float)getY() * Game.TILE_SIZE + Game.TILE_SIZE / 2 + levelY, id);
	}
	
	/*
	 *  Getters
	 */
	
	public int getID() { return id; }
	public int getX() { return position[0]; }
	public int getY() { return position[1]; }
	public int getZ() { return position[2]; }
	public int getW() { return position[3]; }
}
