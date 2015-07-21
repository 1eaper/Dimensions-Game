package game;

import game.engine.Draw;
import game.engine.GameObject;

import org.lwjgl.opengl.Display;

public class Player extends GameObject{

	public static final float VEL = 0.000001f;
	public static final float SIZE = 50f;
	
	public Player() {
		
		super(SIZE / 2, Display.getHeight() / 2 - SIZE / 2, SIZE);
	}
	
	public Player(float x, float y, float z, float w, float size) {
		
		super(x, y, z, w, size);
	}
	
	public void update() {
		
		
	}
	
	public void render() {
		
		Draw.drawSq(x, y, sx);
	}
	
	public void move(float velx, float vely) {
		
		x += velx;
		y += vely;
	}
	
	public void move(float velx, float vely, float velz) {
		
		x += velx;
		y += vely;
		z += velz;
	}
	
	public void move(float velx, float vely, float velz, float velw) {
		
		x += velx;
		y += vely;
		z += velz;
		w += velw;
	}
}
