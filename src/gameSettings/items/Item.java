package gameSettings.items;

import java.io.Serializable;

public interface Item extends Serializable {
    void useItem();
    String getName();
}
