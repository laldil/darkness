package scenes;

import java.util.Scanner;

public class SceneOne {

    private static SceneOne sceneOne;
    public static SceneOne getSceneOne(){
        if(sceneOne == null) sceneOne = new SceneOne();
        return sceneOne;
    }
    private SceneOne(){

    }

    Scanner sc = new Scanner(System.in);
    private boolean isWireFound = false;
    private boolean isNoteFound = false;
    private boolean isMasterKeyDone = false;

    private void mainText(){
        System.out.println("___________________________");
        System.out.println("You need to find the key: ");
        System.out.println("1. Examine the corpse");
        System.out.println("2. Call the guard");
        System.out.println("3. Inspect the lying place");
        System.out.println("4. Go to bed");
        if(isWireFound && isNoteFound){
            System.out.println("5. Make a master key");
            isMasterKeyDone = true;
        }
        System.out.println("___________________________");
    }

    public void startScene(){
        while(!isMasterKeyDone){
            mainText();

            String choice = sc.next();
            if(choice.equals("1")){
                System.out.println("There is nothing in the pocket except the usual iron wire.");
                isWireFound = true;
                if(isNoteFound) System.out.println("Just what I was looking for! Now I can make a master key.");
                else System.out.println("\"The wire? Probably useful.\"");
                System.out.println("\n1. Go back");
                sc.next();
            }
            else if(choice.equals("2")){
                System.out.println("\"Guard! It's bad for a person here.\"");
                System.out.println("\"...\"");
                System.out.println("\n1. Go back");
                sc.next();
            }
            else if(choice.equals("3")){
                System.out.println("It's very dusty and dark under lying place, but you could see the note.");
//                Что-то добавить с будущим сюжетом можно
                System.out.println("\n1. Go back");
                System.out.println("2. Read the note");
                String innerChoice = sc.next();
                if(innerChoice.equals("2")){
//                    Тут какой-то текст в записке,
//                    типо как сделать отмычку или историю трупа, как он пытался сделать отмычку
                    isNoteFound = true;
                    if(isWireFound) System.out.println("\"I see, so I can make a master key from this door.\"");
                    else System.out.println("\"I know how to make a master key, now I need to find something to make it.\"");
                    System.out.println("\n1. Go back");
                    sc.next();
                }
            }
            else if(choice.equals("4")){
                System.out.println("Early morning of the next day. " +
                        "Two guards came in and took you away for execution.");
                System.out.println("You are dead!");
                System.out.println(
                                "██▀▀▀▀██\n" +
                                "█┌─┐┌─┐█\n" +
                                "█└─┘└─┘█\n" +
                                "██▌└┘▐██\n" +
                                "██┼┼┼┼██\n" +
                                "██▄▄▄▄██");
                break;
            }
            else if(choice.equals("5") && isWireFound && isNoteFound){
                isMasterKeyDone = true;
                System.out.println("\"Done. Now I can escape as soon as I have the opportunity.\"");
                break;
            }
            else {
                System.out.println("You've chose a non-existent option, try again");
            }
        }
    }

    public boolean isMasterKeyDone() {
        return isMasterKeyDone;
    }
}
