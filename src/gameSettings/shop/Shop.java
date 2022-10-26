package gameSettings.shop;

import gameSettings.items.Item;

import java.util.List;

public interface Shop {
    Item buyItem(int point);
    List<Item> getItems();
}
