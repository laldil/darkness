package characterSettings.Roles;

import characterSettings.Roles.Attack.AttackBehavior;
import characterSettings.Roles.Defend.DefendBehavior;

public class Role {
    AttackBehavior attack;
    DefendBehavior defendBehavior;

    private String roleName;
    private int damage;
    private int defence;

    public String getRoleName() {
        return roleName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setAttack(AttackBehavior attack) {
        this.attack = attack;
    }

    public void setDefendBehavior(DefendBehavior defendBehavior) {
        this.defendBehavior = defendBehavior;
    }
}
