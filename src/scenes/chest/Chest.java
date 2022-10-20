package scenes.chest;

public class Chest {
    private State state;

    public Chest(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void openChest(){
        state.openClose();
    }
}
