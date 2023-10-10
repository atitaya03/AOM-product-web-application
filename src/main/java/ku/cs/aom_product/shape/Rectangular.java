package ku.cs.aom_product.shape;

import lombok.Data;

@Data
public class Rectangular implements Shape{
    private double length;
    private  double width;
    private double height;
    @Override
    public double calculateVolume() {
        return length*width*height;
    }
}
