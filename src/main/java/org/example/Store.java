package org.example;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> items;

    public Store(List<Item> items) {
        this.items = items;
    }

    public List<Item> search(SearchFilter filter) {
        List<Item> foundedItems = new ArrayList<>();

        for (Item item: items) {
            if (filter.match(item)) {
                foundedItems.add(item);
            }
        }
        return null;
    }
}
