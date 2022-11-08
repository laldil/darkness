package scenes;

import characterSettings.MainCharacter;
import enemySettings.Enemy;

public class FightScene {
    private static FightScene fightScene;
    public static FightScene getFightScene(){
        if(fightScene == null) fightScene = new FightScene();
        return fightScene;
    }
    private FightScene(){}

    public void characterAttackPart(String choice, MainCharacter character, Enemy enemy){
        if(choice.equals("1")) {
            character.getRole().performAttack();
            enemy.setHP(enemy.getHP() - character.getRole().getDamage());
        }
        else if(choice.equals("2")){
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
        else if(choice.equals("3")){
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
        else if(choice.equals("4")){
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

    public void enemyAttackPart(boolean defendForRound, MainCharacter character, Enemy enemy){
        int enemyTurn = (int)(0 + Math.random() * 100);
        int enemyDamageForRound;
        if(enemyTurn < 10){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() - 3 - character.getRole().getDefence() : enemy.getRole().getDamage() - 3;
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                System.out.println(enemy.getName() + " hit you for " + enemyDamageForRound + " damage");
                System.out.println("Your HP: " + character.getHP());
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
        else if(enemyTurn < 50){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() - 1 - character.getRole().getDefence() : enemy.getRole().getDamage() - 1;
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                System.out.println(enemy.getName() + " hit you for " + enemyDamageForRound + " damage");
                System.out.println("Your HP: " + character.getHP());
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
        else if(enemyTurn < 80){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() - character.getRole().getDefence() : enemy.getRole().getDamage();
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                System.out.println(enemy.getName() + " hit you for " + enemyDamageForRound + " damage");
                System.out.println("Your HP: " + character.getHP());
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
        else if(enemyTurn < 100){
            enemyDamageForRound = defendForRound ? enemy.getRole().getDamage() + 1 - character.getRole().getDefence() : enemy.getRole().getDamage() + 1;
            if(enemyDamageForRound > 0) {
                character.setHP(character.getHP() - enemyDamageForRound);
                System.out.println(enemy.getName() + " hit you for " + enemyDamageForRound + " damage");
                System.out.println("Your HP: " + character.getHP());
            }
            else
                System.out.println("Your defense is too strong. The enemy can't break through you.");
        }
    }

}
