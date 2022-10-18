package characterSettings.Roles.Attack;

public class AttackWithKnife implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("Hit with knife");
    }
}
