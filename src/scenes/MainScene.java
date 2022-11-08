package scenes;

import characterSettings.MainCharacter;
import enemySettings.Enemy;
import enemySettings.roles.Archer;
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
    private Save save;

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
                    for(int i = 0; i < shop.getItems().size(); i++)
                        System.out.println(i + ": " + shop.getItems().get(i).getName());
                    System.out.println("Choose a potion");
                    String shopChoice = sc.next();
                    if(character.getMoney() >= 10 && Integer.parseInt(shopChoice) >= 0 && Integer.parseInt(shopChoice) <= shop.getItems().size() - 1){
                        character.getInventory().addItem(shop.getItems().get(Integer.parseInt(shopChoice)));
                        character.setMoney(character.getMoney() - 10);
                        System.out.println("You bought a " + shop.getItems().get(Integer.parseInt(shopChoice)).getName() + " for $10");
                    }
                    else{
                        System.out.println("You entered it wrong");
                    }
                }
                else if(innerChoice.equals("2")){
                    Shop shop = shopFactory.create("Armory");
                    System.out.println("The armory shop is undergoing repairs.");
                }
                else if(innerChoice.equals("3")){
                    System.out.println("You walked into a bar. You've spent 10$ and got 50 hp");
                    character.setHP(character.getHP() + 50);
                    character.setMoney(character.getMoney() - 10);
                }
            } else if (choice.equals("2")) {
                Enemy enemy = new Enemy("Skeleton", new Archer(), (character.getHP()/2) + 10);
                enemy.addObserver(character);
                boolean isEnemyDefeated = false;
                boolean defendForRound = false;
                System.out.println("In the forest you met the enemy " + enemy.getName());
                while(!isEnemyDefeated){
                    System.out.println("1. Attack\n2. Defend");
                    String fightOrDefend = sc.next();
                    if(fightOrDefend.equals("1")) {
                        System.out.println("1. Simple attack\n2. Special attack 1\n3. Special attack 2\n4. Ultimate");
                        String innerChoice = sc.next();
                        FightScene.getFightScene().characterAttackPart(innerChoice, character, enemy);
                    }
                    else {
                        defendForRound = true;
                        character.getRole().performDefend();
                    }

                    if(enemy.getHP() > 0){
                        FightScene.getFightScene().enemyAttackPart(defendForRound, character, enemy);
                        defendForRound = false;
                    }
                    else if (enemy.getHP() <= 0){
                        isEnemyDefeated = true;
                        System.out.println("You killed the " + enemy.getName() + ". Your reward:\nLVL UP!\n15 coins.");
                        character.getRole().setLvl(character.getRole().getLvl() + 1);
                        character.setMoney(character.getMoney() + 15);
                    }

                    if(character.getHP() <= 0){
                        System.out.println("You have lost!");
                        character.setHP(1);
                        break;
                    }
                }

            } else if (choice.equals("3")) {
                if(character.getInventory().getItems() == null) System.out.println("Inventory is empty");
                else {
                    System.out.println("Inventory: ");
                    for (int i = 0; i < character.getInventory().getItems().size(); i++)
                        System.out.println(i + ". " + character.getInventory().getItems().get(i).getName());
                }
                System.out.println("HP: " + character.getHP());
                System.out.println("LVL: " + character.getRole().getLvl());
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
