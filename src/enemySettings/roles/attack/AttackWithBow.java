package enemySettings.roles.attack;

import characterSettings.Roles.Attack.AttackBehavior;

public class AttackWithBow implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("A shot from a bow.");
    }
}
