package characterSettings.Roles.Attack;

public class AttackWithSword implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("Hit with sword");
    }
}
