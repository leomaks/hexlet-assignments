package exercise;

// BEGIN
public class Cottage implements Home {

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    private double area;
    int floorCount;

    public double getArea() {
        return this.area;
    }


    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }

    public int compareTo(Home another) {

        int result = (this.getArea() > another.getArea()) ? 1
                : (this.getArea() < another.getArea()) ? -1 : 0;

        return result;
    }

}

// END
