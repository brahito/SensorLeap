package LeapMotion;

import java.util.ArrayList;

import LeapMotion.LeapMotionS.Gestos;
import processing.core.PApplet;

public class Logica implements Gestos {

	private PApplet app;
	private LeapMotionS leap;
	private int color;
	private int tam = 20;
	private boolean c;
	private Personaje pj;
	private ArrayList<Carne> carnes;
	private int contadorAgarre;

	public Logica(PApplet app) {
		this.app = app;
		carnes = new ArrayList<Carne>();
		leap = new LeapMotionS(app);
		leap.setClassGestos(this);
		pj = new Personaje(app);
	}

	public void pintar() {
		leap.procesosEnEjecucion(10);

		if (leap.getAgarro()) {
			app.noFill();
			contadorAgarre++;
		} else {
			contadorAgarre = 0;
			app.fill(color);
		}
		pj.pintar(leap.getHandX(), leap.getHandY());
		if (app.frameCount % 120 == 0) {
			carnes.add(new Carne(app));
		}
		for (int i = 0; i < carnes.size(); i++) {
			carnes.get(i).pintar();
		}
		for (int i = 0; i < carnes.size(); i++) {

			if (PApplet.dist(pj.getX(), pj.getY(), carnes.get(i).getX(), carnes.get(i).getY()) < pj.getTam() / 2
					&& leap.getAgarro() == true && contadorAgarre <= 2) {
				carnes.remove(i);
			}
		}

	}

	@Override
	public void swipe() {
		// TODO Auto-generated method stub
		int r = (int) app.random(255);
		int g = (int) app.random(255);
		int b = (int) app.random(255);
		color = app.color(r, g, b);

	}

	@Override
	public void circleGeneral() {
		// TODO Auto-generated method stub

	}

	@Override
	public void circleDerecha() {
		// TODO Auto-generated method stub
		tam += 5;
	}

	@Override
	public void circleIzquierda() {
		// TODO Auto-generated method stub
		tam -= 5;
	}

	@Override
	public void screenTap() {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTap() {
		// TODO Auto-generated method stub

	}

	public LeapMotionS getLeap() {
		return leap;
	}

}
