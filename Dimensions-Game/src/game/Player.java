package game;

import game.engine.Draw;
import game.engine.GameObject;
import game.engine.Time;

import org.lwjgl.opengl.Display;

public class Player extends GameObject{

	public final static float SIZE = 64f;

	private float moveTime;
	private float timer;
	
	public Player() {
		
		super(SIZE * 3 / 2, Display.getHeight() / 2, SIZE);
		moveTime = .125f;
		timer = 0;
	}
	
	public Player(float x, float y, float z, float w, float size) {
		
		super(x, y, z, w, size);
	}
	
	public void update() {
		
		if(timer > 0) {
			timer -= Time.Delta();
		}
	}
	
	public void render() {
		
		Draw.drawSq(x, y, sx);
	}
	
	public void move(int xdir, int ydir) {
		if(canMove()) {
			x += SIZE * xdir;
			y += SIZE * ydir;
			timer = moveTime;
		}
	}
	
	public boolean canMove() {
		
		return timer <= 0;
	}
}
