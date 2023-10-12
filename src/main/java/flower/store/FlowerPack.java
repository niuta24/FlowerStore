package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlowerPack {
    private Flower flower;
    private int myquantity;

    public FlowerPack(Flower flower) {
        this.flower = new Flower(flower);
        this.myquantity = 1;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            this.myquantity = 1;
        } else {
            this.myquantity = quantity;
        }
    }

    public double getPrice() {
        return myquantity * flower.getPrice();
    }
}
