package flower.store;

import java.util.ArrayList;
import java.util.List;
import flower.filters.SearchFilter;

public class FlowerStore {

    private List<FlowerItem> items; // Made this private for encapsulation

    // Adding a constructor to initialize the items list
    public FlowerStore() {
        items = new ArrayList<>();
    }

    public void addItem(FlowerItem item) {
        items.add(item);
    }

    // Note: Renamed the parameter to avoid hiding the field
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
