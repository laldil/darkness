package scenes;

import characterSettings.MainCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneOneJFrame {
    static JPanel mainTextPanel;
    static JPanel choiceButtonPanel;
    static JPanel playerPanel;
    static JLabel hpLabel;
    static JLabel hpLabelNumber;
    static JLabel weaponLabel;
    static JLabel weaponLabelName;
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    static JButton choice1;
    static JButton choice2;
    static JButton choice3;
    static JButton choice4;
    static JButton choice5;
    static JTextArea mainTextArea;
    static int playerHP;
    static int monsterHP;
    static String weapon;
    static String position;
    static boolean isWireFound = false;
    static boolean isNoteFound = false;
    static boolean isMasterKeyDone = false;
    SceneHandler sceneHandler = new SceneHandler();
    SceneTwoJFrame sceneTwoJFrame = new SceneTwoJFrame();
    static Container container;
    static MainCharacter character;
    public void setCharacter(MainCharacter character) {
        this.character = character;
    }

    public void createGameScreen(Container con, JPanel titleNamePanel, JPanel startButtonPanel){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        container=con;
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        container.add(mainTextPanel);
        mainTextArea = new JTextArea(".");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(5,1));
        container.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(sceneHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(sceneHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(sceneHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(sceneHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        choice5 = new JButton("Choice 5");
        choice5.setBackground(Color.black);
        choice5.setForeground(Color.white);
        choice5.setFont(normalFont);
        choice5.setFocusPainted(false);
        choice5.addActionListener(sceneHandler);
        choice5.setActionCommand("c5");
        choiceButtonPanel.add(choice5);

//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        container.add(playerPanel);
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
        weapon = "";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        sceneOne();
    }
    public static void sceneOne(){
        position="sceneOne";
        mainTextArea.setText("You are in prison in the location of the Northern Refuge of the Undead.\n\nYou need to find the key:");
        choice1.setText("Examine the corpse");
        choice2.setText("Call the guard");
        choice3.setText("Inspect the lying place");
        choice4.setText("Go to bed");
        if(isWireFound&&isNoteFound){
            choice5.setText("Make a master key");
        }
        else choice5.setText("");
    }
    public static class SceneHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(position){
                case "sceneOne":
                    switch(yourChoice){
                        case "c1": isWireFound = true;examine_corpse();
                            break;
                        case "c2": call_guard();break;
                        case "c3": inspect_place();break;
                        case "c4": isNoteFound=false;isWireFound=false;go_bed();break;
                        case "c5": masterKey();break;
                    }
                    break;
                case "examine_corpse":
                    switch (yourChoice){
                        case "c1":sceneOne();break;
                    }
                case "call_guard":
                    switch (yourChoice){
                        case "c1":sceneOne();break;
                    }
                case "inspect_place":
                    switch (yourChoice){
                        case "c1":sceneOne();break;
                        case "c2":isNoteFound = true;read_note();break;
                    }
                case "bed":
                    switch (yourChoice){
                        case "c1":sceneOne();break;
                    }
                case "read_note":
                    switch (yourChoice){
                        case "c1":sceneOne();break;
                    }
                case "masterKey":
                    if ("c1".equals(yourChoice) && isMasterKeyDone) {
                        SceneTwoJFrame sceneTwoJFrame = new SceneTwoJFrame();
                        sceneTwoJFrame.sceneTwo(container,mainTextPanel,choiceButtonPanel,playerPanel);
                    }
            }

        }
    }

    public static void examine_corpse(){
        position="examine_corpse";
        if(isNoteFound) mainTextArea.setText("Iron wire! Just what I was looking for, now I can make a master key.");
        else mainTextArea.setText("The wire? Probably useful.");
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");
    }
    public static void call_guard(){
        position="call_guard";
        mainTextArea.setText("Guard! It's bad for a person here.");
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");
    }
    public static void inspect_place(){
        position="inspect_place";
        mainTextArea.setText("It's very dusty and dark under lying place, but you could see the note.");
        choice1.setText("Go Back");
        choice2.setText("Read the note");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");
    }
    public static void read_note(){
        position="read_note";
        if(isWireFound) mainTextArea.setText("I see, so I can make a master key from this door.");
        else mainTextArea.setText("I know how to make a master key, now I need to find something to make it.");
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");
    }
    public static void go_bed(){
        position="bed";
        mainTextArea.setText("Early morning of the next day. " +
                "Two guards came in and took you away for execution.\nYou are dead!\n\nGAME OVER!");
        choice1.setText("Restart");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");

    }
    public static void masterKey(){
        isMasterKeyDone = true;
        position="masterKey";
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        choiceButtonPanel.remove(choice5);
        mainTextArea.setText("Done. Now I can escape as soon as I have the opportunity.");
        choice1.setText("Escape");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");
    }
}


