package gameSettings.items;

public class HPPotion implements Item{
    private final String name = "Health potion";

    public String getName() {
        return name;
    }

    @Override
    public void useItem() {
        System.out.println("Using health potion");
    }
}
