package scenes;

import characterSettings.MainCharacter;
import characterSettings.Save;

import java.util.Scanner;

public class MainScene {
    private static MainScene mainScene;
    public static MainScene getMainScene(){
        if(mainScene == null) mainScene = new MainScene();
        return mainScene;
    }
    private MainScene(){}

    Scanner sc = new Scanner(System.in);
    MainCharacter character;

    public void playScene() {
        System.out.println("1. Go towards the city");
        System.out.println("2. Go to the forest");
        System.out.println("3. Inventory");
        System.out.println("4. Save");
        String choice = sc.next();

        if(choice.equals("1")){
            System.out.println("1. Go to the shop");
            sc.next();

        }
        else if(choice.equals("2")){

        }
        else if(choice.equals("3")){

        }
        else if(choice.equals("4")){
            Save.save(character);
        }
    }

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }

}
