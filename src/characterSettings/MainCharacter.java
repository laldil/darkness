package characterSettings;

import characterSettings.Roles.Role;

public class MainCharacter {
    private String name;
    private int money;
    private int lvl;
    private Role role;

    public MainCharacter(String name) {
        this.name = name;
        this.money = 0;
        this.lvl = 1;
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
}
