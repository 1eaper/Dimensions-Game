package game.engine;

import game.Game;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

public class Level {
	
	private int dimension; // The dimension the level is in
	private Player player; // The player
	private Goal goal; // The goal
	private ArrayList<GameObject> objects; // A list of objects in the level
	//private int[][][][] layout; // The array to initialize the level
	public int[][][][] level; // All of the objects in the level by coordinate
	private float x, y; // The level's coordinates on the screen (for rendering)
	
	// Default constructor for a 2d level
	public Level(int dimension) {
		
		this.objects = new ArrayList<GameObject>(); // Initialize the objects list
		this.dimension = dimension; // Assign the dimension to the given dimension
		
		tempSetup();
		
		this.level = new int[Game.LEVEL_SIZE][Game.LEVEL_SIZE][Game.LEVEL_SIZE][Game.LEVEL_SIZE]; // Initialize the level array
		
		this.x = Display.getWidth() / 2 - Game.LEVEL_SIZE * Game.TILE_SIZE / 2; // Set the x position of the level
		this.y = Display.getHeight() / 2; // Set the y position of the level

		updateObjects(); // Initialize the objects in the level array
	}
	
	// Update everything in the level
	public void update() {

		this.x = Display.getWidth() / 2 - Game.LEVEL_SIZE * Game.TILE_SIZE / 2; // Set the x position of the level
		if(dimension == Game.ONE_TWO_ID)
			this.y = Display.getHeight() / 2; // Set the y position of the level
		else if(dimension == Game.TWO_THREE_ID)
			this.y = Display.getHeight() / 2 - Game.LEVEL_SIZE * Game.TILE_SIZE / 2; // Set the y position of the level
		
		for(GameObject go : objects) { // For all of the objects in the level
			
			go.update(); // Update the object
		}
	}
	
	// Render all of the objects in the level
	public void render() {

		for(GameObject go : objects) { // For all of the objects in the level
			
			if(dimension == Game.ONE_TWO_ID && go.getY() == player.getY())
				go.render(x, y, dimension); // Render the object
			if(dimension == Game.TWO_THREE_ID && go.getZ() == player.getZ())
				go.render(x, y, dimension);
		}
	}
	
	// Move the player
	public void move(int xdir, int ydir, int zdir, int wdir) {
		if(player.move(xdir, ydir, zdir, wdir, this)) {
			
			updateObjects();
		}
		
	}
	
	// Le inefficient level setup
	public void tempSetup() {
		
		if(dimension == Game.ONE_TWO_ID) {
			objects.add(new Block(3, 0));
				objects.add(new Block(3, 1));
				objects.add(new Block(3, 2));
				objects.add(new Block(3, 5));
				objects.add(new Block(3, 6));
				objects.add(new Block(3, 7));
			objects.add(new Moveable(3,3));
				objects.add(new Moveable(3,4));
			this.goal = new Goal(); // Initialize the goal
			objects.add(goal); // Add the goal to the objects list
			this.player = new Player(); // Initialize the player
			objects.add(player); // Add the player to the objects list
			
		} else if (dimension == Game.TWO_THREE_ID) {
			for(int i = 0; i < Game.LEVEL_SIZE; i++) {
				objects.add(new Block(3, i, 0));
			}
			for(int i = 0; i < Game.LEVEL_SIZE; i++) {
				objects.add(new Block(3, i, 1));
			}
			for(int i = 0; i < Game.LEVEL_SIZE; i++) {
				objects.add(new Block(3, i, 2));
			}
			for(int i = 0; i < Game.LEVEL_SIZE; i++) {
				objects.add(new Block(3, i, 5));
			}
			for(int i = 0; i < Game.LEVEL_SIZE; i++) {
				objects.add(new Block(3, i, 6));
			}
			for(int i = 0; i < Game.LEVEL_SIZE; i++) {
				objects.add(new Block(3, i, 7));
			}
			this.goal = new Goal(7, 7); // Initialize the goal
			objects.add(goal); // Add the goal to the objects list
			this.player = new Player(); // Initialize the player
			objects.add(player); // Add the player to the objects list
		}
	}
	
	// Sets up the positions of all of the objects in the level array
	public void updateObjects() {
		
		// Sets all of the blocks to empty by default
		for(int x = 0; x < Game.LEVEL_SIZE; x++) {
			for(int y = 0; y < Game.LEVEL_SIZE; y++) {
				for(int z = 0; z < Game.LEVEL_SIZE; z++) {
					for(int w = 0; w < Game.LEVEL_SIZE; w++) {
							this.level[x][y][z][w] = Game.EMPTY_ID;
					}
				}
			}
		}
		
		// Sets all of the occupied spaces in the level to their respective occupant
		for (GameObject go : objects) {
			
			if (go.getID() != Game.PLAYER_ID) {
				
				level[go.getX()][go.getY()][go.getZ()][go.getW()] = go.getID();
			}
		}
	}
	
	// Returns the gameObject at a given coordinate
	/*
	 * getObject()
	 */
	public GameObject getObject(int x, int y) {
		
		return getObject(x, y, 0, 0);
	}
	public GameObject getObject(int x, int y, int z) {
		
		return getObject(x, y, z, 0);
	}
	public GameObject getObject(int x, int y, int z, int w) {

		for(GameObject go : objects) {
			
			if(go.getX() == x && go.getY() == y && go.getZ() == z && go.getW() == 0) {
				
				return go;
			}
		}

		return null;
	}
}
