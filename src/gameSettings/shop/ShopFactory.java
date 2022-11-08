package gameSettings.shop;

public class ShopFactory {
    public Shop create(String typeOfShop){
        if(typeOfShop.equals("Potion")) return new PotionShop();
        else if(typeOfShop.equals("Armory")) return new ArmoryShop();
        else return null;
    }

    PotionShop potionShop;
    public Shop clonePotionShop(){
        return (Shop) potionShop.copy();
    }
}
