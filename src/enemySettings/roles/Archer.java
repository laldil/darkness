package enemySettings.roles;

import characterSettings.Roles.Role;
import enemySettings.roles.attack.AttackWithBow;

public class Archer extends Role {
    public Archer() {
        setRoleName("Archer");
        setDamage(7);
        setAttack(new AttackWithBow());
    }
}
