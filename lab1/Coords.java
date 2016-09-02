package lab1;


public class Coords {
	public double x;
	public double y;
	
	public Coords() {
		x = 0.00;
		y = 0.00;
	}
	
	public Coords(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
    public String toString() {
        return this.x + " " + this.y;
    }
}
