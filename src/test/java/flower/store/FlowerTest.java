package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testSepalLength() {
        double sepalLength = RANDOM_GENERATOR.nextDouble();
        flower.setSepalLength(sepalLength);
        Assertions.assertEquals(sepalLength, flower.getSepalLength());
    }

    @Test
    public void testFlower() {
        Flower newFlower = new Flower(); // Use a different variable name
        Assertions.assertNotNull(newFlower);
    }

    @Test
    public void testFlowerWithParameters() {
        double sepalLength = RANDOM_GENERATOR.nextDouble();
        FlowerColor color = FlowerColor.RED;
        double price = RANDOM_GENERATOR.nextDouble();
        FlowerType flowerType = FlowerType.ROSE;
        Flower newFlower = new Flower(sepalLength, color, price, flowerType); // Use a different variable name
        Assertions.assertNotNull(newFlower);
    }

    @Test
    public void testFlowerWithFlower() {
        double sepalLength = RANDOM_GENERATOR.nextDouble();
        FlowerColor color = FlowerColor.RED;
        double price = RANDOM_GENERATOR.nextDouble();
        FlowerType flowerType = FlowerType.ROSE;
        Flower newFlower = new Flower(sepalLength, color, price, flowerType); // Use a different variable name
        Flower newflowerSecond = new Flower(newFlower); // Use a different variable name
        Assertions.assertNotNull(newflowerSecond);
    }
}
