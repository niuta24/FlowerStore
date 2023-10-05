package flower.filters;

import flower.store.FlowerItem;

public interface SearchFilter {
    boolean match(FlowerItem flowerItem);  
}
