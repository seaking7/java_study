package tk.refactoring._06_mutable_data._18_split_variable;

public class Rectangle {

    private double perimeter;
    private double area;

    public void updateGeometry(double height, double width) {
        double temp_perimeter = 2 * (height + width);
        System.out.println("Perimeter: " + temp_perimeter);
        perimeter = temp_perimeter;

        double temp_area = height * width;
        System.out.println("Area: " + temp_area);
        area = temp_area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
