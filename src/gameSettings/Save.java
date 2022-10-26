package gameSettings;

import characterSettings.MainCharacter;

import java.io.*;

public class Save {
    public static void save(MainCharacter character){
        try {
            File file = new File("save.bin");
            if(!file.exists()) file.createNewFile();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(character);

            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MainCharacter loadSave(){
        File file = new File("save.bin");
        MainCharacter character = null;
        if(file.exists()){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

                character = (MainCharacter) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return character;
    }
}
