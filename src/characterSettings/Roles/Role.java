package characterSettings.Roles;

import characterSettings.Roles.Attack.AttackBehavior;
import characterSettings.Roles.Defend.DefendBehavior;

import java.io.Serializable;

public class Role implements Serializable {
    AttackBehavior attack;
    DefendBehavior defendBehavior;

    private String roleName;
    private int damage;
    private int defence;
    private int lvl;

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

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

    public void performSpecialAttack1(){
        attack.specialAttack1();
    }

    public void performSpecialAttack2(){
        attack.specialAttack2();
    }

    public void performUltimate(){
        attack.ultimate();
    }

    public void performAttack(){
        attack.attack();
    }

    public void performDefend(){
        defendBehavior.defend();
    }
}
