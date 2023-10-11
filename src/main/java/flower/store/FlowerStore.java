package flower.store;

import java.util.ArrayList;
import java.util.List;
import flower.filters.SearchFilter;

public class FlowerStore {
    public List<FlowerItem> items;

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
