package characterSettings.Roles.Attack;

public class AttackWithSword implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("Hit with sword");
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
