package gameSettings.items;

public class LargeHPPotion extends ItemDecorator{
    public LargeHPPotion(Item item) {
        super(item);
    }

    @Override
    public String getName() {
        return super.getName() + ": large";
    }
}
