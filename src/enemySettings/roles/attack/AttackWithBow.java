package enemySettings.roles.attack;

import characterSettings.Roles.Attack.AttackBehavior;

public class AttackWithBow implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("A shot from a bow.");
    }

    @Override
    public void specialAttack1() {
        System.out.println("Special attack 1");
    }

    @Override
    public void specialAttack2() {
        System.out.println("Special attack 2");
    }

    @Override
    public void ultimate() {
        System.out.println("Ultimate");
    }
}
