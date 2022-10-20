package scenes;

import characterSettings.MainCharacter;
import enemySettings.Enemy;
import enemySettings.roles.Archer;
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
                if(innerChoice.equals("1")) {
                    character.getRole().performAttack();
                    enemy.setHP(enemy.getHP() - character.getRole().getDamage());
                }
                else if(innerChoice.equals("2")){
                    if(character.getRole().getLvl() > 5){
                        character.getRole().performSpecialAttack1();
                        enemy.setHP(enemy.getHP() - (character.getRole().getDamage() + 3));
                    }
                    else {
                        System.out.println("Your lvl is low. You did simple attack");
                        character.getRole().performAttack();
                        enemy.setHP(enemy.getHP() - character.getRole().getDamage());
                    }
                }
                else if(innerChoice.equals("3")){
                    if(character.getRole().getLvl() > 10){
                        character.getRole().performSpecialAttack2();
                        enemy.setHP(enemy.getHP() - (character.getRole().getDamage() + 5));
                    }
                    else {
                        System.out.println("Your lvl is low. You did simple attack");
                        character.getRole().performAttack();
                        enemy.setHP(enemy.getHP() - character.getRole().getDamage());
                    }
                }
                else if(innerChoice.equals("4")){
                    if(character.getRole().getLvl() > 15){
                        character.getRole().performUltimate();
                        enemy.setHP(enemy.getHP() - (character.getRole().getDamage() + 7));
                    }
                    else {
                        System.out.println("Your lvl is low. You did simple attack");
                        character.getRole().performAttack();
                        enemy.setHP(enemy.getHP() - character.getRole().getDamage());
                    }
                }
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
            if(enemy.getHP() > 0) enemyAttackPart(defendForRound);
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

    public boolean isEnemyDefeated() {
        return isEnemyDefeated;
    }
}
