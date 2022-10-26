package gameSettings.shop;

import gameSettings.items.Item;

import java.util.LinkedList;
import java.util.List;

public class ArmoryShop implements Shop{
    private String name = "Armory Shop";
    private List<Item> items = new LinkedList<>();

    @Override
    public Item buyItem(int point) {
        return items.get(point);
    }

    @Override
    public List<Item> getItems() {
        return items;
    }
}
