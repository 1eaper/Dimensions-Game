package game.engine;

import game.Game;

import org.lwjgl.opengl.Display;

public class Level {
	
	private int dimension;
	private Player player;
	private Goal goal;
	private int[][][][] layout;
	private float x, y, z, w;
	
	public Level() {
		
		this.dimension = Game.ONE_TWO_ID;
		this.player = new Player();
		this.goal = new Goal();
		this.layout = new int[Game.LEVEL_SIZE][Game.LEVEL_SIZE][Game.LEVEL_SIZE][Game.LEVEL_SIZE];
		this.x = 64;
		this.y = Display.getHeight() / 2;
		this.z = 0;
		this.w = 0;
	}
	
	public void update() {
		
		player.update();
	}
	
	public void render() {
		
		player.render(x, y, dimension);
	}
	
	public void move(int xdir, int ydir, int zdir, int wdir) {
		
		
		player.move(xdir, ydir, zdir, wdir);
	}
}
