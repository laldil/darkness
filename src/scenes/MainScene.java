package scenes;

import characterSettings.MainCharacter;
import gameSettings.Save;
import gameSettings.items.Item;
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
            System.out.println("3. Inventory/Status");
            System.out.println("4. Save");
            String choice = sc.next();

            if (choice.equals("1")) {
                System.out.println("1. Go to the shop\n2. Go to the armory shop\n3. Go to the bar");
                String innerChoice = sc.next();
                if(innerChoice.equals("1")){
                    Shop shop = shopFactory.create("Potion");
                    shop.getItems().forEach((item) -> {
                        int counter = 1;
                        System.out.println(counter + ". " + item.getName());
                        counter++;
                    });
                    sc.next();
                }
                else if(innerChoice.equals("2")){
                    Shop shop = shopFactory.create("Armory");
                    System.out.println(shop.getItems());
                }
                else if(innerChoice.equals("3")){
                    System.out.println("You walked into a bar. You've spent 10$ and got 50 hp");
                    character.setHP(character.getHP() + 50);
                    character.setMoney(character.getMoney() - 10);
                }
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                if(character.getInventory().getItems() == null) System.out.println("Inventory is empty");
                else {
                    System.out.println("Inventory: ");
                    character.getInventory().getItems().forEach((Item::getName));
                }
                System.out.println("HP: " + character.getHP());
                System.out.println("Money: " + character.getMoney());
                System.out.println("Role: " + character.getRole().getRoleName());
            } else if (choice.equals("4")) {
                Save.save(character);
            }
        }
    }

    public void setCharacter(MainCharacter character) {
        this.character = character;
    }

}
