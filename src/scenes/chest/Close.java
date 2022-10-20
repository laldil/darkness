package scenes.chest;

public class Close implements State{
    @Override
    public void openClose() {
        System.out.println("The chest is closed");
    }
}
