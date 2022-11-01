package characterSettings;

import gameSettings.items.Item;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Inventory implements Serializable {
    private List<Item> items = new LinkedList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }
}
