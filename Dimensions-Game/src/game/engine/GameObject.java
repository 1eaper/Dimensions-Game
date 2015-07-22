package game.engine;

public abstract class GameObject {

	protected int id;
	protected int[] position;
	public static final int PLAYER_ID = 0;
	public static final int GOAL_ID = 1;
	public static final int BLOCK_ID = 2;
	
	/*
	 *  Constructors
	 */
	
	public GameObject(int x, int y) {
		
		position = new int[4];
		
		position[0] = x;
		position[1] = y;
	}
	
	/*
	 *  Abstract functions
	 */
	
	public abstract void update();
	public abstract void render();
	
	/*
	 *  Getters
	 */
	
	public int getX() { return position[0]; }
	public int getY() { return position[1]; }
}
