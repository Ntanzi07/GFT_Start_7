package EX3;

public record Triangle(double height, double base) implements GeometricForm {

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

}
