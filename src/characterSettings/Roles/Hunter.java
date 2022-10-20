package characterSettings.Roles;

import characterSettings.Roles.Attack.AttackWithKnife;

public class Hunter extends Role{
    public Hunter() {
        setRoleName("Hunter");
        setDamage(15);
        setLvl(1);
        setDefence(2);
        setAttack(new AttackWithKnife());
    }
}
