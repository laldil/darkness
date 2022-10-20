package scenes;

import characterSettings.MainCharacter;

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
        System.out.println("2. Inventory");
        System.out.println("3. Save");
        String choice = sc.next();

        if(choice.equals("1")){

        }
        else if(choice.equals("2")){

        }
        else if(choice.equals("3")){

        }
    }

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }
}
