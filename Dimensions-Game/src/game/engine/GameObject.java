package game.engine;

public abstract class GameObject {

	protected float x, y, z, w;
	protected float sx, sy, sz, sw;
	
	/*
	 *  Constructors
	 */
	
	public GameObject(float x, float y, float sizex, float sizey) {
		
		this.x = x;
		this.y = y;
		this.z = 0;
		this.w = 0;
		this.sx = sizex;
		this.sy = sizey;
		this.sz = 1;
		this.sw = 1;
	}
	
	public GameObject(float x, float y, float size) {
		
		this.x = x;
		this.y = y;
		this.z = 0;
		this.w = 0;
		this.sx = size;
		this.sy = size;
		this.sz = 1;
		this.sw = 1;
	}
	
	public GameObject(float x, float y, float z, 
					  float sizex, float sizey, float sizez) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 0;
		this.sx = sizex;
		this.sy = sizey;
		this.sz = sizez;
		this.sw = 1;
	}
	
	public GameObject(float x, float y, float z, float size, int meh) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 0;
		this.sx = size;
		this.sy = size;
		this.sz = size;
		this.sw = 1;
	}
	
	public GameObject(float x, float y, float z, float w, 
					  float sizex, float sizey, float sizez, float sizew) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.sx = sizex;
		this.sy = sizey;
		this.sz = sizez;
		this.sw = sizew;
	}
	
	public GameObject(float x, float y, float z, float w, float size) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.sx = size;
		this.sy = size;
		this.sz = size;
		this.sw = size;
	}
	
	/*
	 *  Abstract functions
	 */
	
	public abstract void update();
	public abstract void render();
	
	/*
	 *  Getters
	 */
	
	public float getX() { return x; }
	public float getY() { return y; }
	public float getZ() { return z; }
	public float getW() { return w; }
	public float getSX() { return sx; }
	public float getSY() { return sy; }
	public float getSZ() { return sz; }
	public float getSW() { return sw; }
}
