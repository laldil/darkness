import characterSettings.MainCharacter;
import scenes.SceneOne;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Тут меню и предысторию нужно добавить
        System.out.println("Enter your name: ");
        MainCharacter character = new MainCharacter(sc.nextLine());

        SceneOne sceneOne = new SceneOne();
        sceneOne.scene();
    }
}
