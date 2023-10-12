package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setFlowerType(FlowerType.ROSE);
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.addFlowerPack(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testPriceWithMultipleFlowerPacks() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setFlowerType(FlowerType.ROSE);
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.addFlowerPack(flowerPack);
        flowerBucket.addFlowerPack(flowerPack);
        Assertions.assertEquals(price * quantity * 2, flowerBucket.getPrice());
    }

    @Test
    public void testPriceWithMultipleFlowerPacksAndDifferentPrices() {
        int price_first = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int price_second = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower_first = new Flower();
        flower_first.setFlowerType(FlowerType.ROSE);
        flower_first.setPrice(price_first);
        Flower flower_second = new Flower();
        flower_second.setFlowerType(FlowerType.ROSE);
        flower_second.setPrice(price_second);
        FlowerPack flowerPackFirst = new FlowerPack(flower_first, quantity);
        FlowerPack flowerPackSecond = new FlowerPack(flower_second, quantity);
        flowerBucket.addFlowerPack(flowerPackFirst);
        flowerBucket.addFlowerPack(flowerPackSecond);
        // Calculate the total price for the first and second flowers
        double totalPriceFirst = price_first * quantity;
        double totalPriceSecond = price_second * quantity;

        // Use meaningful variable names to calculate the expected total price
        double expectedTotalPrice = totalPriceFirst + totalPriceSecond;

        // Assert that the expected total price matches the actual price
        Assertions.assertEquals(expectedTotalPrice, flowerBucket.getPrice());

    }

    @Test
    public void testEmptyBucket() {
        Assertions.assertEquals(0, flowerBucket.getPrice());
    }

}
