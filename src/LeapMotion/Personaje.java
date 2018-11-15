package LeapMotion;

import processing.core.PApplet;

public class Personaje {
	private int tam;
	private PApplet app;
	private float x;
	private float y;

	public Personaje(PApplet app) {
		this.app = app;
		tam = 50;
	}

	public void pintar(float x, float y) {
		this.x = x;
		this.y = y;
		app.ellipse(this.x, this.y, tam, tam);
	}

	public int getTam() {
		return tam;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
