package gameSettings.items;

public abstract class ItemDecorator implements Item{
    private Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public void useItem() {
        item.useItem();
    }

    @Override
    public String getName() {
        return item.getName();
    }
}
