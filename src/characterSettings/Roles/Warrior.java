package characterSettings.Roles;

import characterSettings.Roles.Attack.AttackWithSword;
import characterSettings.Roles.Defend.DefendWithShield;

public class Warrior extends Role {
    public Warrior() {
        setRoleName("Warrior");
        setDamage(10);
        setDefence(7);
        setDefendBehavior(new DefendWithShield());
        setAttack(new AttackWithSword());
    }
}
