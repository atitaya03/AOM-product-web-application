package ku.cs.aom_product.shape;

import lombok.Data;

@Data
public class Cube implements Shape {
    private double length;
    @Override
    public double calculateVolume() {
        return Math.pow(length,3);
    }
}
