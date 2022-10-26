package scenes;

import characterSettings.MainCharacter;
import gameSettings.Save;
import gameSettings.shop.Shop;
import gameSettings.shop.ShopFactory;

import java.util.Scanner;

public class MainScene {
    private static MainScene mainScene;
    public static MainScene getMainScene(){
        if(mainScene == null) mainScene = new MainScene();
        return mainScene;
    }
    private MainScene(){}

    Scanner sc = new Scanner(System.in);
    ShopFactory shopFactory = new ShopFactory();
    MainCharacter character;

    public void startScene() {
        while (true) {
            System.out.println("1. Go towards the city");
            System.out.println("2. Go to the forest");
            System.out.println("3. Inventory");
            System.out.println("4. Save");
            String choice = sc.next();

            if (choice.equals("1")) {
                System.out.println("1. Go to the shop\n2. Go to the armory shop\n3. Go to the bar");
                String innerChoice = sc.next();
                if(innerChoice.equals("1.")){
                    Shop shop = shopFactory.create("Potion");
                    System.out.println(shop.getItems());
                }
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {

            } else if (choice.equals("4")) {
                Save.save(character);
            }
        }
    }

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }

}
