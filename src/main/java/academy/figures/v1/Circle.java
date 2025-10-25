package main.java.academy.figures.v1;

import java.util.Objects;

public class Circle
{
    // Поля класса: центр круга и его радиус (целые значения).
    private Point center;
    private int radius;

    // 1. Конструктор: создает Circle по точке центра и значению радиуса.
    public Circle(Point center, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным.");
        }
        this.center = center;
        this.radius = radius;
    }

    // 2. Конструктор: создает Circle по координатам центра и значению радиуса.
    public Circle(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius);
    }

    // 3. Конструктор: создает Circle с центром в точке (0,0) указанного радиуса.
    public Circle(int radius) {
        this(new Point(0, 0), radius);
    }

    // 4. Конструктор: создает Circle с центром в точке (0,0) с радиусом 1.
    public Circle() {
        this(new Point(0, 0), 1);
    }

    // 5. Возвращает центр Circle.
    public Point getCenter() {
        return center;
    }

    // 6. Возвращает радиус Circle.
    public int getRadius() {
        return radius;
    }

    // 7. Устанавливает центр Circle.
    public void setCenter(Point center) {
        this.center = center;
    }

    // 8. Устанавливает радиус Circle.
    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным.");
        }
        this.radius = radius;
    }

    // 9. Передвигает Circle так, чтобы его центр оказался в точке (x, y).
    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    // 10. Передвигает Circle так, чтобы его центр оказался в точке point.
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // 11. Передвигает Circle на (dx, dy).
    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    // 12. Увеличивает радиус Circle в ratio раз при сохранении центра.
    //     Дробная часть результата отбрасывается.
    public void resize(double ratio) {
        int newRadius = (int) (radius * ratio);
        if (newRadius <= 0) {
            throw new IllegalArgumentException("Новый радиус должен быть положительным.");
        }
        radius = newRadius;
    }

    // 13. Возвращает площадь круга.
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // 14. Возвращает периметр окружности (длину окружности).
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // 15. Определяет, лежит ли точка (x, y) внутри Circle.
    //     Если точка лежит на окружности, считается, что она внутри.
    public boolean isInside(int x, int y) {
        int dx = x - center.getX();
        int dy = y - center.getY();
        // Точка считается внутри, если квадрат расстояния <= (radius)^2.
        return dx * dx + dy * dy <= radius * radius;
    }

    // 16. Определяет, лежит ли точка point внутри Circle.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // 17. Методы equals и hashCode генерируются средствами IDEA.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
