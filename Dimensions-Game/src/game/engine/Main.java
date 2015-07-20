package game.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class Main {
	
	private static int height = 576;
	private static int width = height * 16 / 9;
	
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
	
	
	// Initializes the display
	private static void initDisplay() {
		
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
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
		
		glClearColor(0, 0, 0, 1);
		
		glDisable(GL_DEPTH_TEST);
	}

	// Initializes the game
	private static void initGame() {
		
		//TODO: make game class
	}
	
	// The game loop
	private static void gameLoop() {
		
		while(!Display.isCloseRequested()) {
			
			//TODO: Time.update();
			//TODO: getInput();
			//TODO: update();
			
			render(); // Render Screen
		}
	}
	
	// Renders the screen
	private static void render() {
		
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		//TODO: game.render()
		
		Display.update();
		Display.sync(60);
	}
	
	// Cleans up the program
	private static void cleanUp() {

		Display.destroy();
		Keyboard.destroy();
	}
}