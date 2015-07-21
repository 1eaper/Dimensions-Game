package game.engine;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.opengl.GL11;

public class Draw {

	public static void drawSq(float x, float y, float size) {
		
		size /= 2;
		
		glPushMatrix();
		{
			
			glTranslatef(x, y, 0f);
			
			glBegin(GL_QUADS);
			{
				glVertex2f(-size, -size);
				glVertex2f(-size, size);
				glVertex2f(size, size);
				glVertex2f(size, -size);
			}
			glEnd();
			
		}
		glPopMatrix();
	}
	
	public static void drawCir(float x, float y, float size) {
		
		size /= 2;
		double acc = 20.0;
		
		glPushMatrix();
		{
			glTranslatef(x, y, 0);
			
			glBegin(GL11.GL_POLYGON);
			{
				for(int i = 0; i < acc; i++) {
					float xcor = (float)(Math.cos(i/acc*(2*Math.PI)))* size;
					float ycor = (float)(Math.sin(i/acc*(2*Math.PI)))* size; 
					glVertex2f(xcor, ycor);
				}
			}
			glEnd();
		}
	}
}