import characterSettings.MainCharacter;
import enemySettings.Enemy;
import scenes.SceneOne;
import scenes.SceneThree;
import scenes.SceneTwo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Тут меню и предысторию нужно добавить
        System.out.println("Enter your name: ");
        MainCharacter character = new MainCharacter(sc.nextLine());

        SceneOne.getSceneOne().startScene();

        SceneTwo.getSceneTwo().setCharacter(character);
        if(SceneOne.getSceneOne().isMasterKeyDone()) SceneTwo.getSceneTwo().startScene();

        SceneThree.getSceneThree().setCharacter(character);
        if(SceneTwo.getSceneTwo().isSecondSceneDone()) SceneThree.getSceneThree().startScene();

    }
}
