package characterSettings;

import characterSettings.Roles.Role;
import gameSettings.Save;

import java.io.Serializable;

public class MainCharacter implements Observer, Serializable {
    private String name;
    private int money;
    private int HP;
    private Role role;
    Inventory inventory = new Inventory();

    public MainCharacter(String name) {
        setName(name);
        setMoney(0);
        setHP(100);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void handleEvent(int enemyHP, String enemyName) {
        System.out.println(enemyName + "'s HP: " + enemyHP);
    }

    public Save saveForFight(){
        return new Save(getHP());
    }
    public void loadSaveForFight(Save save){
        setHP(save.getHP());
    }
}
