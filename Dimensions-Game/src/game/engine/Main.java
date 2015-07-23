package game.engine;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import game.Game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {
	
	private static int height = 720;
	private static int width = height * 16 / 9;
	
	private static Game game;
	
	// Main Function
	public static void main(String[] args) {
		
		// Initialize Program
		
		initDisplay(); // Initialize the display
		initGL(); // Initialize OpenGL
		initGame(); // Initialize the Game
		
		// Game Loop
		
		gameLoop(); // Run the main game loop
		
		// Clean up
		
		cleanUp(); // Clean up the program
	}
	
	/*
	 *  Init Functions
	 */
	
	// Initializes the display
	private static void initDisplay() {
		
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
			Display.setResizable(true);
			Display.setVSyncEnabled(true);
			Keyboard.create();
		} catch(LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	// Initializes OpenGL
	private static void initGL() {
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
		glClearColor(1, 1, 1, 1);
		
		glDisable(GL_DEPTH_TEST);
	}

	// Initializes the game
	private static void initGame() {
		
		game = new Game();
	}
	
	/*
	 *  Game Functions
	 */
	
	// The game loop
	private static void gameLoop() {
		
		while(!Display.isCloseRequested()) {
			
			Time.update();
			getInput();
			update();
			
			render(); // Render Screen
		}
	}
	
	// Collect user input
	private static void getInput() {
		
		game.getInput();
	}
	
	// Update objects
	private static void update() {
		
		game.update();
	}
	
	// Renders the screen
	private static void render() {
		
		width = Display.getWidth();
		height = Display.getHeight();
		
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		game.render();
		
		Display.update();
		Display.sync(60);
	}
	
	/*
	 *  Clean Up Functions
	 */
	
	// Cleans up the program
	private static void cleanUp() {

		Display.destroy();
		Keyboard.destroy();
	}
}