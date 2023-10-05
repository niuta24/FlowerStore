package flower.store;

import lombok.Getter;
import lombok.Setter;



@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }

    public Flower(Flower flower) {
        this.sepalLength = flower.getSepalLength();
        this.color = flower.color;
        this.price = flower.getPrice();
        this.flowerType = flower.getFlowerType();
    }
}
