package flower.store;

import java.util.ArrayList;
import java.util.List;
import flower.filters.SearchFilter;

public class FlowerStore {
    private List<FlowerItem> items;

    public FlowerStore() {
        this.items = new ArrayList<>();
    }

    public List<FlowerItem> getItems() {
        return items;
    }

    public void setItems(List<FlowerItem> newItems) {
        items = newItems; // No need for 'this' keyword
    }

    public List<FlowerItem> search(SearchFilter searchFilter) {
        List<FlowerItem> foundItems = new ArrayList<>();
        for (FlowerItem item : items) {
            if (searchFilter.match(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
}
