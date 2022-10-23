import characterSettings.MainCharacter;
import characterSettings.Save;
import scenes.MainScene;
import scenes.SceneOne;
import scenes.SceneThree;
import scenes.SceneTwo;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainCharacter character;

        if(Save.loadSave() == null){
            System.out.println("Enter your name: ");
            character = new MainCharacter(sc.nextLine());

            SceneOne.getSceneOne().startScene();

            SceneTwo.getSceneTwo().setCharacter(character);
            if(SceneOne.getSceneOne().isMasterKeyDone()) SceneTwo.getSceneTwo().startScene();

            SceneThree.getSceneThree().setCharacter(character);
            if(SceneTwo.getSceneTwo().isSecondSceneDone()) SceneThree.getSceneThree().startScene();
        }
        else character = Save.loadSave();

        MainScene.getMainScene().setCharacter(character);
        MainScene.getMainScene().playScene();
    }


}
