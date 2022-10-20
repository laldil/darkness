package characterSettings.Roles.Attack;

public class AttackWithStick implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("Hit with stick");
    }

    @Override
    public void specialAttack1() {
        System.out.println("Fireball");
    }

    @Override
    public void specialAttack2() {
        System.out.println("Ice ball");
    }

    @Override
    public void ultimate() {
        System.out.println("Lullaby");
    }
}
