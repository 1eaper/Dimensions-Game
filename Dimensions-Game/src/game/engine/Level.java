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
	private int[][][][] level; // All of the objects in the level by coordinate
	private float x, y; // The level's coordinates on the screen (for rendering)
	
	// Default constructor for a 2d level
	public Level() {
		
		this.objects = new ArrayList<GameObject>(); // Initialize the objects list
		this.dimension = Game.ONE_TWO_ID; // Assign the dimension to 1/2d
		initLevel(); // Initialize the objects in the level
		
		objects.add(new Block());
		this.goal = new Goal(); // Initialize the goal
		objects.add(goal); // Add the goal to the objects list
		this.player = new Player(); // Initialize the player
		objects.add(player); // Add the player to the objects list
		
		this.level = new int[Game.LEVEL_SIZE][Game.LEVEL_SIZE][Game.LEVEL_SIZE][Game.LEVEL_SIZE]; // Initialize the level array
		
		this.x = Game.TILE_SIZE * 5 / 2; // Set the x position of the level
		this.y = Display.getHeight() / 2; // Set the y position of the level
		
		//TODO: Replace this system
		for(int x = 0; x < Game.LEVEL_SIZE; x++) {
			for(int y = 0; y < Game.LEVEL_SIZE; y++) {
				for(int z = 0; z < Game.LEVEL_SIZE; z++) {
					for(int w = 0; w < Game.LEVEL_SIZE; w++) {
						if(x == 7 && y == 0) {
							this.level[x][y][z][w] = Game.GOAL_ID;
						} else if (x == 3 && y == 0) {
							this.level[x][y][z][w] = Game.BLOCK_ID;
						} else {
							this.level[x][y][z][w] = 9;
						}
					}
				}
			}
		}
	}
	
	// Update everything in the level
	public void update() {
		
		for(GameObject go : objects) { // For all of the objects in the level
			
			go.update(); // Update the object
		}
	}
	
	// Render all of the objects in the level
	public void render() {

		for(GameObject go : objects) { // For all of the objects in the level
			
			if(dimension == Game.ONE_TWO_ID && go.getY() == player.getY())
				go.render(x, y, dimension); // Render the object
		}
	}
	
	// Move the player
	public void move(int xdir, int ydir, int zdir, int wdir) {

		if(player.canMove()) {
			System.out.println("Start of Move");
			System.out.println("Current X : " + player.getX());
			System.out.println("X direction : " + xdir);
			System.out.println("Current Y : " + player.getY());
			System.out.println("Y direction : " + ydir);
			
			int tempx = xdir + player.getX();
			int tempy = ydir + player.getY();
			int tempz = zdir + player.getZ();
			int tempw = wdir + player.getW();
			
			System.out.println("Temp Coordinates : (" + tempx + ", " + tempy + ", " + tempz + ", " + tempw + ")");
			
			// Checks if the movement would be within bounds
			if(tempx >= 0 && tempx <= Game.LEVEL_SIZE - 1) {
				if(tempy >= 0 && tempy <= Game.LEVEL_SIZE - 1) {
					
					int temp = level[tempx][tempy][tempz][tempw];
					System.out.println("Temp : " + temp);
					if (temp == Game.BLOCK_ID)
						System.out.println("None shall pass");
					else if (temp == Game.GOAL_ID)
						System.out.println("You win!");
					else
						player.move(tempx, tempy);
					
					player.resetTimer();
				}
			}
		}
	}
	
	public void initLevel() {
		
		
	}
}
