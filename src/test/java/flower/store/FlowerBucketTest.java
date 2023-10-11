package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import flower.store.Flower;
import flower.store.FlowerBucket;
import flower.store.FlowerPack;
import flower.store.FlowerType;

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
        int price1 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int price2 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower1 = new Flower();
        flower1.setFlowerType(FlowerType.ROSE);
        flower1.setPrice(price1);
        Flower flower2 = new Flower();
        flower2.setFlowerType(FlowerType.ROSE);
        flower2.setPrice(price2);
        FlowerPack flowerPack1 = new FlowerPack(flower1, quantity);
        FlowerPack flowerPack2 = new FlowerPack(flower2, quantity);
        flowerBucket.addFlowerPack(flowerPack1);
        flowerBucket.addFlowerPack(flowerPack2);
        Assertions.assertEquals(price1 * quantity + price2 * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testEmptyBucket() {
        Assertions.assertEquals(0, flowerBucket.getPrice());
    }

}
