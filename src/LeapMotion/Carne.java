package LeapMotion;

import processing.core.PApplet;

public class Carne {
	private PApplet app;
	private int tam, x, y;

	public Carne(PApplet app) {
		this.app = app;
		tam = 20;
		x = (int) app.random(20, app.width - 20);
		y = -20;
	}

	public void pintar() {
		app.fill(255, 0, 0);
		app.ellipse(x, y, tam, tam);
		y++;
		if (y > app.height + 20)
			y = -20;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTam() {
		return tam;
	}

}
