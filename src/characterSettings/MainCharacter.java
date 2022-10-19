package characterSettings;

import characterSettings.Roles.Role;

public class MainCharacter implements Observer{
    private String name;
    private int money;
    private int lvl;
    private int HP;
    private Role role;

    public MainCharacter(String name) {
        setName(name);
        setMoney(0);
        setLvl(1);
        setHP(100);
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

    public int getLvl() {
        return lvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public void handleEvent(int enemyHP, String enemyName) {
        System.out.println(enemyName + "'s HP: " + enemyHP);
    }
}
