package characterSettings.Roles;

import characterSettings.Roles.Attack.AttackWithKnife;
import characterSettings.Roles.Attack.AttackWithSword;
import characterSettings.Roles.Defend.DefendWithShield;

public class Hunter extends Role{
    public Hunter() {
        setRoleName("Hunter");
        setDamage(15);
        setDefence(2);
//        setDefendBehavior();
        setAttack(new AttackWithKnife());
    }
}
