package game;

import game.engine.Level;

import org.lwjgl.input.Keyboard;

public class Game {

	public static final int ONE_TWO_ID = 12;
	public static final int TWO_THREE_ID = 23;
	public static final int THREE_FOUR_ID = 34;
	public final static int LEVEL_SIZE = 8;

	public final static float TILE_SIZE = 64f;
	
	private Level level;
	
	public Game() {
		
		level = new Level();
	}
	
	public void getInput() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			
			level.move(1, 0, 0, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			
			level.move(-1, 0, 0, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			
			level.move(0, 1, 0, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			
			level.move(0, -1, 0, 0);
		}
	}
	
	public void update() {
		
		level.update();
	}
	
	public void render() {
		
		level.render();
	}
}
