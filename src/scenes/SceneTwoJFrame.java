package scenes;

import characterSettings.MainCharacter;
import characterSettings.Roles.Hunter;
import characterSettings.Roles.Pyromancer;
import characterSettings.Roles.Warrior;
import characterSettings.Roles.Wizard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneTwoJFrame {
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    static int playerHP;
    static int monsterHP;
    static String weapon;
    static String position;
    static JButton c1;
    static JButton c2;
    static JButton c3;
    static JButton c4;
    JPanel mainTextPanelS2,choiceButtonPanelS2,playerPanel;
    JLabel hpLabel;
    static JLabel hpLabelNumber;
    JLabel weaponLabel;
    static JLabel weaponLabelName;

    static JTextArea mainTextArea;
    SceneHandler sceneHandler = new SceneHandler();
    static boolean getRole=false;
    boolean isSecondSceneDone = false;

    boolean isBookRead=false;
    boolean isClassTaken=false;
    boolean isInspectDone=false;
    Container conS2;
    public void sceneTwo(Container con, JPanel mainTextPanel, JPanel choiceButtonPanel){
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        con.remove(mainTextPanel);
        con.remove(choiceButtonPanel);

        conS2=con;

        mainTextPanelS2= new JPanel();
        mainTextPanelS2.setBounds(100, 100, 600, 250);
        mainTextPanelS2.setBackground(Color.black);
        con.add(mainTextPanelS2);

        mainTextArea = new JTextArea(".");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanelS2.add(mainTextArea);

        choiceButtonPanelS2 = new JPanel();
        choiceButtonPanelS2.setBounds(250, 350, 300, 150);
        choiceButtonPanelS2.setBackground(Color.black);
        choiceButtonPanelS2.setLayout(new GridLayout(5,1));
        con.add(choiceButtonPanelS2);

        c1 = new JButton("Choice 1");
        c1.setBackground(Color.black);
        c1.setForeground(Color.white);
        c1.setFont(normalFont);
        c1.setFocusPainted(false);
        c1.addActionListener(sceneHandler);
        c1.setActionCommand("c1");
        choiceButtonPanelS2.add(c1);

        c2 = new JButton("Choice 2");
        c2.setBackground(Color.black);
        c2.setForeground(Color.white);
        c2.setFont(normalFont);
        c2.setFocusPainted(false);
        c2.addActionListener(sceneHandler);
        c2.setActionCommand("c2");
        choiceButtonPanelS2.add(c2);

        c3 = new JButton("Choice 3");
        c3.setBackground(Color.black);
        c3.setForeground(Color.white);
        c3.setFont(normalFont);
        c3.setFocusPainted(false);
        c3.addActionListener(sceneHandler);
        c3.setActionCommand("c3");
        choiceButtonPanelS2.add(c3);

        c4 = new JButton("Choice 4");
        c4.setBackground(Color.black);
        c4.setForeground(Color.white);
        c4.setFont(normalFont);
        c4.setFocusPainted(false);
        c4.addActionListener(sceneHandler);
        c4.setActionCommand("c4");
        choiceButtonPanelS2.add(c4);



//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponLabel.setBackground(Color.red);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }
    public static void playerSetup(){

        playerHP = 100;
        monsterHP = 20;
        weapon = "None";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        sceneTwo();
    }
    public static void sceneTwo(){
        position="sceneTwo";
        mainTextArea.setText("""
                The door opened. There is a book in front of you.

                On the left side, the door is wide open.

                On the right is a closed door with the inscription "Armory".""");
        c1.setText("Open the book");
        c2.setText("Run out the door.");
        c3.setText("Go to the armory room.");
        c4.setText("");
    }
    public void openBook(){
        position="openBook";
        mainTextArea.setText("""
                You opened the book, there's nothing special in the book.
                         
                Just as you were about to close the book, you saw the code: 1042.
                """);
        c1.setText("Go Back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public void armory(){
        position="armory";
        mainTextArea.setText("There are racks of weapons in the room. Above them is an inscription with classes:");
        c1.setText("Warrior");
        c2.setText("Pyromancer");
        c3.setText("Wizard");
        c4.setText("Hunter");
    }
    public void warrior(){
        position="warrior";
        weapon = "Sword";
        getRole=true;
        isClassTaken=false;
        weaponLabelName.setText(weapon);
        mainTextArea.setText("You took the warrior's equipment."+"\\n"+ " Your weapon: Straight sword" +"\\n"+ " Your defence: 7");
        c1.setText("Go Back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public void pyromancer(){
        position="pyromancer";
        weapon = "Axe";
        getRole=true;
        isClassTaken=false;
        weaponLabelName.setText(weapon);
        mainTextArea.setText("You took the pyromancer's equipment."+"\\n"+ " Your weapon: Axe" +"\\n"+ " Your defence: 4");
        c1.setText("Go Back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public void wizard(){
        position="wizard";
        weapon = "Stick";
        getRole=true;
        isClassTaken=false;
        weaponLabelName.setText(weapon);
        mainTextArea.setText("You took the wizard's equipment."+"\\n"+ " Your weapon: magic stick" +"\\n"+ " Your defence: 3");
        c1.setText("Go Back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public void hunter(){
        position="hunter";
        weapon = "Knife";
        getRole=true;
        isClassTaken=false;
        weaponLabelName.setText(weapon);
        mainTextArea.setText("You took the hunter's equipment."+"\\n"+ " Your weapon: knife" +"\\n"+ " Your defence: 2");
        c1.setText("Go Back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public void run(){
        position="run";
            mainTextArea.setText("Next");
            c1.setText("Next");
            c2.setText("");
            c3.setText("");
            c4.setText("");
    }

    public class SceneHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(position){
                case "sceneTwo":
                    switch (yourChoice) {
                        case "c1" -> openBook();
                        case "c2" -> {
                            if(getRole){
                                run();
                            }
                        }
                        case "c3" -> {
                            if(isInspectDone){
                                armory();
                            }
                        }
                    }
                case"openBook":
                    if ("c1".equals(yourChoice)) {
                        isInspectDone = true;
                        isClassTaken=true;
                        sceneTwo();
                    }
                case"armory":
                    switch (yourChoice) {
                        case "c1" -> {
                            if(isClassTaken) {
                                warrior();
                            }
                        }
                        case "c2" -> {
                            if(isClassTaken) {
                                pyromancer();
                            }
                        }
                        case "c3" -> {
                            if(isClassTaken) {
                                wizard();
                            }
                        }
                        case "c4" -> {
                            if(isClassTaken) {
                                hunter();
                            }
                        }
                    }
                case"run":
                    switch (yourChoice) {
                        case "c1" -> {
                            SceneThreeJFrame sceneThreeJFrame = new SceneThreeJFrame();
                            sceneThreeJFrame.sceneThree(conS2,mainTextPanelS2,choiceButtonPanelS2);
                        }
                    }
                case"warrior":
                    switch (yourChoice) {
                        case "c1"->sceneTwo();
                    }
                case"pyromancer":
                    switch (yourChoice) {
                        case "c1"->sceneTwo();
                    }
                case"wizard":
                    switch (yourChoice) {
                        case "c1"->sceneTwo();
                    }
                case"hunter":
                    switch (yourChoice) {
                        case "c1"->sceneTwo();
                    }
            }

        }
    }
}
