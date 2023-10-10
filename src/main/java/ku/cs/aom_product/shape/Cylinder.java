package ku.cs.aom_product.shape;

import lombok.Data;

@Data
public class Cylinder implements Shape{
    private double radius;
    private  double height;
    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius,2)*height;
    }
}
