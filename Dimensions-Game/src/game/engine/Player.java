package game.engine;


import game.Game;

import org.lwjgl.opengl.Display;

public class Player extends GameObject{

	private float moveTime;
	private float timer;
	
	public int[] position;
	
	public Player() {
		
		super(0, 0);
		position = new int[4];
		for(int i = 0; i < position.length; i++) {
			position[i] = 0;
		}
		moveTime = .125f;
		timer = 0;
		this.id = PLAYER_ID;
	}
	
	public void update() {
		
		if(timer > 0) {
			timer -= Time.Delta();
		}
	}
	
	public void render() {
		
		Draw.drawSq(0f, 0f, Game.TILE_SIZE, id);
	}
	
	public void render(float levelX, float levelY, int dimension) {
		
		if(dimension == Game.ONE_TWO_ID) 
			Draw.drawSq((float)position[0] * Game.TILE_SIZE + Game.TILE_SIZE / 2 + levelX, 0 + levelY, Game.TILE_SIZE, id);
		if(dimension == Game.TWO_THREE_ID)
			Draw.drawSq((float)position[0] * Game.TILE_SIZE + Game.TILE_SIZE / 2 + levelX, (float)position[1] * Game.TILE_SIZE + Game.TILE_SIZE / 2 + levelY, Game.TILE_SIZE, id);
	}
	
	public void move(int xdir, int ydir, int zdir, int wdir) {
		if(canMove()) {
			int tempx = position[0] + xdir;
			int tempy = position[1] + ydir;
			if(tempx >= 0 && tempx < Game.LEVEL_SIZE) position[0] = tempx;
			if(tempy >= 0 && tempy < Game.LEVEL_SIZE) position[1] = tempy;
			System.out.println(position[0] + ", " + position[1]);
			timer = moveTime;
		}
	}
	
	public boolean canMove() {
		
		return timer <= 0;
	}
}