package game;

import game.engine.Time;

import org.lwjgl.input.Keyboard;

public class Game {

	private Player player;
	
	public Game() {
		
		player = new Player();
	}
	
	public void getInput() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			
			player.move(player.VEL * Time.Delta(), 0f);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			
			player.move(-player.VEL * Time.Delta(), 0f);
		}
	}
	
	public void update() {
		
		player.update();
	}
	
	public void render() {
		
		player.render();
	}
}