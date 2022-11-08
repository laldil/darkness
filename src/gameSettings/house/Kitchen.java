package gameSettings.house;

import characterSettings.MainCharacter;

public class Kitchen implements Room{

    @Override
    public void boostCharacteristic(MainCharacter character) {
        System.out.println("You ate a little and raised HP");
        character.setHP(character.getHP() + 5);
    }
}
