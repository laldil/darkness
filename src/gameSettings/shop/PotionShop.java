package gameSettings.shop;

import gameSettings.items.Item;

import java.util.LinkedList;
import java.util.List;

public class PotionShop implements Shop, Copyable{
    private final String name = "Potion shop";
    private List<Item> items = new LinkedList<>();

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public Item buyItem(int point) {
        return items.get(point);
    }

    @Override
    public Object copy() {
        Shop copy = new PotionShop();
        return copy;
    }
}
