package EX3;

public record Square(double side) implements GeometricForm {

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

}
