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

    public void setItems(List<FlowerItem> items) {
        this.items = items;
    }

    public List<FlowerItem> search(SearchFilter filter) {
        List<FlowerItem> foundItems = new ArrayList<>();
        for (FlowerItem item : items) {
            if (filter.match(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
}
