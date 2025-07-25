package EX3;

public record Circle(double radius) implements GeometricForm{
    private static final double PI = 3.14;

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }


}
