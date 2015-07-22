package game;

import org.lwjgl.input.Keyboard;

public class Game {

	private Player player;
	
	public Game() {
		
		player = new Player();
	}
	
	public void getInput() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			
			player.move(1, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			
			player.move(-1, 0);
		}
	}
	
	public void update() {
		
		player.update();
	}
	
	public void render() {
		
		player.render();
	}
}
