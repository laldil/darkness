package scenes;

import characterSettings.MainCharacter;
import enemySettings.Enemy;
import enemySettings.roles.Archer;
import gameSettings.Save;
import scenes.chest.Chest;
import scenes.chest.Close;
import scenes.chest.Open;

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
    private boolean isEnemyDefeated = false;
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }

    public void startScene(){
        System.out.println("There's a corridor in front of you.\n1. Go through the corridor.");
        sc.next();
        System.out.println("Suddenly, a skeleton archer came around the corner.");

        enemy = new Enemy("Skeleton", new Archer(), 50);
        enemy.addObserver(character);

        while(!isEnemyDefeated){
            System.out.println("1. Attack\n2. Defend\n3. Escape.");
            String choice = sc.next();
            boolean defendForRound = false;

            if(choice.equals("1")){
                System.out.println("1. Simple attack\n2. Special attack 1\n3. Special attack 2\n4. Ultimate");
                String innerChoice = sc.next();
                FightScene.getFightScene().characterAttackPart(innerChoice, character, enemy);
            }
            else if(choice.equals("2")){
                defendForRound = true;
                character.getRole().performDefend();
            }
            else if(choice.equals("3")){
                System.out.println("There was an ambush of 15 monster guards waiting for you from behind. You're dead.");
                System.out.println(
                                "██▀▀▀▀██\n" +
                                "█┌─┐┌─┐█\n" +
                                "█└─┘└─┘█\n" +
                                "██▌└┘▐██\n" +
                                "██┼┼┼┼██\n" +
                                "██▄▄▄▄██");
                break;
            }
            if(enemy.getHP() > 0) {
                FightScene.getFightScene().enemyAttackPart(defendForRound, character, enemy);
                save = character.saveForFight();
                defendForRound = false;
            }
            else if(enemy.getHP() <= 0){
                isEnemyDefeated = true;
                System.out.println("You have successfully killed the skeleton archer.\n" +
                        "Reward:\n" +
                        "LVL UP\n" +
                        "50 coins.");
                character.getRole().setLvl(character.getRole().getLvl() + 1);
                character.setMoney(character.getMoney() + 50);
            }

            if(isEnemyDefeated){
                System.out.println("A little further from the battlefield was a chest with a lock.");
                Chest chest = new Chest(new Close());
                chest.getState().openClose();
                int counter = 0;
                System.out.println("You have 3 attempts to open the chest, otherwise the chest will explode.");
                while(!(chest.getState() instanceof Open) && counter < 3){
                    System.out.println("Enter the code: ");
                    String inputCode = sc.next();
                    if (inputCode.equals("1042")) chest.setState(new Open());
                    else System.out.println("Wrong");
                    counter++;
                }
                if(chest.getState() instanceof Open){
                    chest.openChest();
                    System.out.println("There were 100 coins inside the chest.");
                }
                else {
                    System.out.println("The chest exploded, you took 3 damage.\nYour HP: " + character.getHP());
                }
            }

            if(character.getHP() <= 0) {
                System.out.println("You are so weak that you were killed by the most ordinary archer. You're dead!");
                System.out.println(
                                "██▀▀▀▀██\n" +
                                "█┌─┐┌─┐█\n" +
                                "█└─┘└─┘█\n" +
                                "██▌└┘▐██\n" +
                                "██┼┼┼┼██\n" +
                                "██▄▄▄▄██");
                break;
            }
        }
    }

    public boolean isEnemyDefeated() {
        return isEnemyDefeated;
    }

    public void setEnemyDefeated(boolean enemyDefeated) {
        isEnemyDefeated = enemyDefeated;
    }

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }
}
