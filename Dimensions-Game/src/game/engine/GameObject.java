package game.engine;

import game.Game;


public abstract class GameObject {

	protected int id; // Determines what type of gameobject something is
	protected int[] position; // The coordinates of the object
	protected boolean canMove; // If the object can move
	
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
	
	// Initialize the object for a 2/3d level
	public GameObject(int x, int y, int z) {
		
		position = new int[4];
		
		position[0] = x;
		position[1] = y;
		position[2] = z;
		position[3] = 0;
	}
	
	// Initialize the object for a 3/4d level
	public GameObject(int x, int y, int z, int w) {
		
		position = new int[4];
		
		position[0] = x;
		position[1] = y;
		position[2] = z;
		position[3] = w;
	}
	
	/*
	 *  Abstract functions
	 */
	
	public abstract void update();
	//public boolean move() { return canMove; }
	
	public boolean move(int xdir, int ydir, int zdir, int wdir, Level level) {
		int tempx = xdir + this.getX();
		int tempy = ydir + this.getY();
		int tempz = zdir + this.getZ();
		int tempw = wdir + this.getW();
		
		//System.out.println("Temp Coordinates : (" + tempx + ", " + tempy + ", " + tempz + ", " + tempw + ")");
		
		// Checks if the movement would be within bounds
		if(tempx >= 0 && tempx <= Game.LEVEL_SIZE - 1) {
			if(tempy >= 0 && tempy <= Game.LEVEL_SIZE - 1) {
				if(tempz >= 0 && tempz <= Game.LEVEL_SIZE - 1) {
					
					int temp = level.level[tempx][tempy][tempz][tempw];
					System.out.println("Temp : " + temp);
					
					if(!canMove)
						return false;
					
					if(temp != Game.EMPTY_ID) {
						
						if(level.getObject(tempx, tempy).move(xdir, ydir, zdir, wdir, level)) {
							
							moveto(tempx, tempy, tempz, tempw);
							return true;
						}
					} else {
						
						moveto(tempx, tempy, tempz, tempw);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private void moveto(int x, int y, int z, int w) {
		position[0] = x;
		position[1] = y;
		position[2] = z;
		position[3] = w;
	}

	public boolean move(int xdir, int ydir, Level level) { return move(xdir, ydir, 0, 0, level); }
	public boolean move(int xdir, int ydir, int zdir, Level level) { return move(xdir, ydir, zdir, level); }

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
