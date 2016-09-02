package Drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import State.State;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public ArrayList<Polygon> polygonCollection;
	public ArrayList<State> statesCollection;
	
	public MyFrame(ArrayList<State> statesCollection) {
		polygonCollection =  new ArrayList<Polygon>();
		this.statesCollection = statesCollection;
	}
	
	public static void drawMap(ArrayList<State> statesCollection) {
		MyFrame fr = new MyFrame(statesCollection);
		fr.setBackground(Color.lightGray);
		fr.setSize(1280, 720);//1280, 720);
		fr.setTitle("Map");
		fr.setVisible(true);
		fr.repaint();
	}
	
	public void paint(Graphics g) {
		Dimension size = this.getSize();

        for(State state : statesCollection) {
        	MyPolygon mp = new MyPolygon();
        	Polygon polygon = mp.buildDrawablePolygon(state);
        	g.setColor(new Color((int)(state.mood * 10)));
        	g.fillPolygon(polygon);
        }
	}
}
