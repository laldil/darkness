package scenes;

import characterSettings.MainCharacter;
import characterSettings.Roles.Hunter;
import characterSettings.Roles.Pyromancer;
import characterSettings.Roles.Warrior;
import characterSettings.Roles.Wizard;

import java.util.Scanner;

public class SceneTwo {

    private static SceneTwo sceneTwo;
    public static SceneTwo getSceneTwo(){
        if(sceneTwo == null) sceneTwo = new SceneTwo();
        return sceneTwo;
    }
    private SceneTwo(){

    }

    Scanner sc = new Scanner(System.in);
    MainCharacter character;

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }

    public void startScene(){
//        Тут история какая-то(мб напали на эту тюрьму или что-то такое,
//        чтобы была возможность открыть дверь и страже не было у дверей)
        System.out.println("1. Open the door");
        sc.next();
        System.out.println("The door opened. There is a security desk in front of you. " +
                "On the left side, the door is wide open. " +
                "On the right is a closed door with the inscription \"Armory\".");
        while(true){
            System.out.println("""
                    1. Inspect the desk
                    2. Run out the door.
                    3. Go to the armory room.""");
            String choice = sc.next();
            if(choice.equals("1")){

            }
            else if(choice.equals("2")){
                if(character.getRole() == null){
                    System.out.println("You're not ready, take the equipment from the armory.");
                    System.out.println("1. Go back");
                    sc.next();
                }

            }
            else if(choice.equals("3")){
                System.out.println("There are racks of weapons in the room. Above them is an inscription with classes:\n" +
                        "1. Warrior\n" +
                        "2. Pyromancer\n" +
                        "3. Wizard\n" +
                        "4. Hunter");
                String innerChoice = sc.next();
                if(innerChoice.equals("1")){
                    character.setRole(new Warrior());
                    getRoleInfoAfterChoice();
                }
                else if(innerChoice.equals("2")){
                    character.setRole(new Pyromancer());
                    getRoleInfoAfterChoice();
                }
                else if(innerChoice.equals("3")){
                    character.setRole(new Wizard());
                    getRoleInfoAfterChoice();
                }
                else if(innerChoice.equals("4")){
                    character.setRole(new Hunter());
                    getRoleInfoAfterChoice();
                }
            }
        }
    }
    private void getRoleInfoAfterChoice(){
        System.out.println("You took the " + character.getRole().getRoleName() + "'s equipment. \nYour damage: " + character.getRole().getDamage());
        System.out.println("Your defence: " + character.getRole().getDefence());
    }
}
