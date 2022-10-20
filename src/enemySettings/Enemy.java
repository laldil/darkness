package enemySettings;

import characterSettings.Observer;
import characterSettings.Roles.Role;

import java.util.LinkedList;

public class Enemy implements Observed{
    private String name;
    private Role role;
    private int HP;
    private LinkedList<Observer> observers = new LinkedList<>();

    public Enemy(String name, Role role, int HP) {
        setName(name);
        setHP(HP);
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
        if(getHP() >= 0) notifyObserver();
    }

    public Role getRole() {
        return role;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.handleEvent(getHP(), getName()));
    }
}
