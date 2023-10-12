package org.example;

import lombok.Getter;

@Getter 
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {
        this.flower = new Flower(flower);
        this.quantity = quantity;
    }

    double getPrice() {
        return this.flower.getPrice() * this.quantity;
    }

    private void setQuantity(int value) {
        if (value < 1) {
            this.quantity = 1;
        } else {
            this.quantity = value;
        }
    }
}
