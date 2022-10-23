package characterSettings.Roles.Attack;

import java.io.Serializable;

public interface AttackBehavior extends Serializable {
    void attack();
    void specialAttack1();
    void specialAttack2();
    void ultimate();
}
