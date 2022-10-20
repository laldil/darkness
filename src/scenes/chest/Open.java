package scenes.chest;

public class Open implements State{
    @Override
    public void openClose() {
        System.out.println("The chest is open");
    }
}
