package exercise;

public class Circle {
    Point point;

    public int getRadius() {
        return radius;
    }

    int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public double getSquare() throws NegativeRadiusException  {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return this.radius * this.radius * Math.PI;
    }
}

