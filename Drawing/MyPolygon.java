package Drawing;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import State.State;
import lab1.Coords;

public class MyPolygon {
	public Polygon buildDrawablePolygon(State state) {
        Polygon polygon = new Polygon();
        int multiplier = 100000;
        for (Coords point : state.coords) {
            int x = 8 * (int)(point.x * multiplier) / 100000 + 1400;
            int y = -8 * (int)(point.y * multiplier) / 100000 + 700;
            polygon.addPoint(x, y);
        }
        return polygon;
    }
	public Polygon buildPolygon(State state) {
		Polygon polygon = new Polygon();
        int multiplier = 1000000;
        for (Coords point : state.coords) {
            int x = (int)(point.x * multiplier);
            int y = (int)(point.y * multiplier);
            polygon.addPoint(y, x);
        }
        return polygon;
	}
}
