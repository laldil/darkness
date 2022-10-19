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
    private boolean isEnemyDefeated = false;

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
                character.getRole().performAttack();
                enemy.setHP(enemy.getHP() - character.getRole().getDamage());
            }
            else if(choice.equals("2")){
                defendForRound = true;
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
            if(enemy.getHP() > 0) enemyAttackPart(defendForRound);
            else if(enemy.getHP() <= 0){
                isEnemyDefeated = true;
                System.out.println("You have successfully killed the skeleton archer.\n" +
                        "Reward:\n" +
                        "LVL UP\n" +
                        "50 coins.");
                character.setLvl(character.getLvl() + 1);
                character.setMoney(character.getMoney() + 50);
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

    private void enemyAttackPart(boolean defendForRound){
        int enemyTurn = (int)(0 + Math.random() * 100);
        int enemyDamageForRound;
        if(enemyTurn < 10){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() - 3 - character.getRole().getDefence() : enemy.getRole().getDamage() - 3;
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                getInfoAboutStatus(enemyDamageForRound);
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
        else if(enemyTurn < 50){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() - 1 - character.getRole().getDefence() : enemy.getRole().getDamage() - 1;
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                getInfoAboutStatus(enemyDamageForRound);
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
        else if(enemyTurn < 80){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() - character.getRole().getDefence() : enemy.getRole().getDamage();
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                getInfoAboutStatus(enemyDamageForRound);
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
        else if(enemyTurn < 100){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() + 1 - character.getRole().getDefence() : enemy.getRole().getDamage() + 1;
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                getInfoAboutStatus(enemyDamageForRound);
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
    }

    private void getInfoAboutStatus(int enemyDamageForRound){
        System.out.println(enemy.getName() + " hit you for " + enemyDamageForRound + " damage");
        System.out.println("Your HP: " + character.getHP());
    }

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }
}
