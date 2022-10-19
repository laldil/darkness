package scenes;

import characterSettings.MainCharacter;
import enemySettings.Enemy;
import enemySettings.roles.Archer;

import java.util.Scanner;

public class SceneThree {
    private static SceneThree sceneThree;
    public static SceneThree getSceneThree(){
        if(sceneThree == null) sceneThree = new SceneThree();
        return sceneThree;
    }
    private SceneThree(){}

    Scanner sc = new Scanner(System.in);
    MainCharacter character;
    Enemy enemy;

    public void startScene(){
        System.out.println("There's a corridor in front of you.\n1. Go through the corridor.");
        sc.next();
        System.out.println("Suddenly, a skeleton archer came around the corner.");
        enemy = new Enemy("Skeleton", new Archer(), 50);
        enemy.addObserver(character);
        while(true){
            System.out.println("1. Attack\n2. Defend\n3. Escape.");
            String choice = sc.next();
            if(choice.equals("1")){
                character.getRole().performAttack();
                enemy.setHP(enemy.getHP() - character.getRole().getDamage());
            }
            else if(choice.equals("2")){

            }
            else if(choice.equals("3")){

            }
        }
    }

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }
}
