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
        int priceFirst = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int priceSecond = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flowerFirst = new Flower();
        flowerFirst.setFlowerType(FlowerType.ROSE);
        flowerFirst.setPrice(priceFirst);
        Flower flowerSecond = new Flower();
        flowerSecond.setFlowerType(FlowerType.ROSE);
        flowerSecond.setPrice(priceSecond);
        FlowerPack flowerPackFirst = new FlowerPack(flowerFirst, quantity);
        FlowerPack flowerPackSecond = new FlowerPack(flowerSecond, quantity);
        flowerBucket.addFlowerPack(flowerPackFirst);
        flowerBucket.addFlowerPack(flowerPackSecond);
        // Calculate the total price for the first and second flowers
        double totalPriceFirst = priceFirst * quantity;
        double totalPriceSecond = priceSecond * quantity;

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
