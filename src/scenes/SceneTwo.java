package scenes;

import java.util.Scanner;

public class SceneTwo {
    public void startScene(){
        Scanner sc = new Scanner(System.in);
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

            }
            else if(choice.equals("3")){
                System.out.println("There are racks of weapons in the room. Above them is an inscription with classes:\n" +
                        "1. Warrior\n" +
                        "2. Pyromancer\n" +
                        "3. Wizard\n" +
                        "4. Hunter");
                String innerChoice = sc.next();
                if(innerChoice.equals("1")){

                }
                else if(innerChoice.equals("2")){

                }
                else if(innerChoice.equals("3")){

                }
                else if(innerChoice.equals("4")){

                }
            }
        }
    }
}
