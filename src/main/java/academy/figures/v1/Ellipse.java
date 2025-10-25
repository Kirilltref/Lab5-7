package main.java.academy.figures.v1;

import java.util.Objects;

public class Ellipse
{
    // Поля: центр эллипса и размеры осей (полная длина горизонтальной и вертикальной осей)
    private Point center;
    private int xAxis;
    private int yAxis;

    // 1. Создает Ellipse по координатам центра и размерам осей.
    public Ellipse(Point center, int xAxis, int yAxis) {
        if (xAxis <= 0 || yAxis <= 0) {
            throw new IllegalArgumentException("Размеры осей должны быть положительными.");
        }
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    // 2. Создает Ellipse по координатам центра и размерам осей.
    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    // 3. Создает Ellipse с центром в точке (0,0) и указанными размерами осей.
    public Ellipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis);
    }

    // 4. Создает Ellipse с центром в точке (0,0) и единичными размерами осей.
    public Ellipse() {
        this(new Point(0, 0), 1, 1);
    }

    // 5. Возвращает центр Ellipse.
    public Point getCenter() {
        return center;
    }

    // 6. Возвращает размер оси Ellipse по X.
    public int getXAxis() {
        return xAxis;
    }

    // 7. Возвращает размер оси Ellipse по Y.
    public int getYAxis() {
        return yAxis;
    }

    // 8. Устанавливает размер оси Ellipse по X.
    public void setXAxis(int xAxis) {
        if (xAxis <= 0) {
            throw new IllegalArgumentException("Размер оси по X должен быть положительным.");
        }
        this.xAxis = xAxis;
    }

    // 9. Устанавливает размер оси Ellipse по Y.
    public void setYAxis(int yAxis) {
        if (yAxis <= 0) {
            throw new IllegalArgumentException("Размер оси по Y должен быть положительным.");
        }
        this.yAxis = yAxis;
    }

    // 10. Устанавливает центр Ellipse.
    public void setCenter(Point center) {
        this.center = center;
    }

    // 11. Передвигает Ellipse в точку (x, y).
    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    // 12. Передвигает Ellipse в точку point.
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // 13. Передвигает Ellipse на (dx, dy).
    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    // 14. Увеличивает оси Ellipse в ratio раз, не изменяя центра.
    //     Дробная часть вычисленных размеров отбрасывается.
    public void resize(double ratio) {
        int newXAxis = (int) (xAxis * ratio);
        int newYAxis = (int) (yAxis * ratio);
        if (newXAxis <= 0 || newYAxis <= 0) {
            throw new IllegalArgumentException("Новые размеры осей должны быть положительными.");
        }
        this.xAxis = newXAxis;
        this.yAxis = newYAxis;
    }

    // 15. Увеличивает ось X Ellipse в xRatio раз и ось Y Ellipse в yRatio раз, не изменяя центра.
    //     Дробная часть вычисленных размеров отбрасывается.
    public void stretch(double xRatio, double yRatio) {
        int newXAxis = (int) (xAxis * xRatio);
        int newYAxis = (int) (yAxis * yRatio);
        if (newXAxis <= 0 || newYAxis <= 0) {
            throw new IllegalArgumentException("Новые размеры осей должны быть положительными.");
        }
        this.xAxis = newXAxis;
        this.yAxis = newYAxis;
    }

    // 16. Возвращает площадь Ellipse.
    //     Площадь эллипса: π * a * b, где a = xAxis/2 и b = yAxis/2.
    public double getArea() {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        return Math.PI * a * b;
    }

    // 17. Возвращает периметр Ellipse по формуле: P = 2π * sqrt((xAxis² + yAxis²) / 8).
    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / 8.0);
    }

    // 18. Определяет, лежит ли точка (x, y) внутри Ellipse.
    //     Если точка лежит на линии эллипса, считается, что она лежит внутри.
    //     Стандартное уравнение эллипса с центром (h, k): ((x - h)² / a²) + ((y - k)² / b²) <= 1.
    public boolean isInside(int x, int y) {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        double dx = x - center.getX();
        double dy = y - center.getY();
        double value = (dx * dx) / (a * a) + (dy * dy) / (b * b);
        return value <= 1.0;
    }

    // 19. Определяет, лежит ли точка point внутри Ellipse.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // 20. Методы equals и hashCode генерируются средствами IDEA.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}
