package characterSettings.Roles;

import characterSettings.Roles.Attack.AttackWithStick;
import characterSettings.Roles.Defend.DefendWithStick;

public class Wizard extends Role{
    public Wizard() {
        setRoleName("Wizard");
        setDamage(15);
        setDefence(3);
        setAttack(new AttackWithStick());
        setDefendBehavior(new DefendWithStick());
    }
}
