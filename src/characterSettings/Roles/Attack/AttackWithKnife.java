package characterSettings.Roles.Attack;

public class AttackWithKnife implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("Hit with knife");
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
