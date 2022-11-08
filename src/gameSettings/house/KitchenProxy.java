package gameSettings.house;

import characterSettings.MainCharacter;

public class KitchenProxy implements Room{
    Kitchen kitchen = new Kitchen();

    @Override
    public void boostCharacteristic(MainCharacter character) {
        System.out.println("You went into the kitchen.");
        kitchen.boostCharacteristic(character);
    }
}
