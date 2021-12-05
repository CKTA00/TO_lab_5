package util;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 Multiply(double m)
    {
        return new Vector2(x*m,y*m);
    }

    public static double Distance(Vector2 from, Vector2 to)
    {
        return Math.sqrt(Math.pow(from.x-to.x,2) + Math.pow(from.y-to.y,2));
    }

    @Override
    public String toString() {
        return "[" +
                "x=" + x +
                ", y=" + y +
                ']';
    }
}
