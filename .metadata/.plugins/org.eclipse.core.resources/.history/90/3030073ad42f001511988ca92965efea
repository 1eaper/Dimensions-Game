package game.engine;

public class Time {

	private static long currTime = getTime();
	private static long lastTime = getTime();
	
	public static long getTime() {
		
		return System.nanoTime();
	}
	
	public static float Delta() {
		
		return (currTime - lastTime);
	}
	
	public static void update() {
		
		lastTime = currTime;
		currTime = getTime();
	}
}
