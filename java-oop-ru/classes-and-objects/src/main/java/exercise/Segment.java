package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {

        int midX = (this.getEndPoint().getX() + this.getBeginPoint().getX())/2;
        int midY = (this.getEndPoint().getY() + this.getBeginPoint().getY())/2;

        return new Point(midX, midY);
    }

}
// END
/* Создайте класс `Segment`. Внутри класса реализуйте конструктор, который принимает две точки — начало и конец отрезка.
Точка — это объект класса `Point`. В классе определите следующие методы:

        * `getBeginPoint()` — возвращает начальную точку отрезка.
        * `getEndPoint()` — возвращает конечную точку отрезка.
        * `getMidPoint()` — возвращает новую точку — середину отрезка.

        ```java
Point point1 = new Point(4, 3);
Point point2 = new Point(6, 1);
Segment segment = new Segment(point1, point2);
Point midPoint = segment.getMidPoint();
  midPoint.getX(); // 5
  midPoint.getY(); // 2
  ```

 */