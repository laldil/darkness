package characterSettings.Roles;

import characterSettings.Roles.Attack.AttackWithAxe;
import characterSettings.Roles.Defend.DefendWithFire;

public class Pyromancer extends Role{
    public Pyromancer() {
        setRoleName("Pyromancer");
        setDamage(12);
        setDefence(4);
        setDefendBehavior(new DefendWithFire());
        setAttack(new AttackWithAxe());
    }
}
