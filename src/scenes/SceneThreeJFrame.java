package scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneThreeJFrame {
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    static int playerHP;
    static int monsterHP;
    static String weapon;
    static String position;
    static int lvl=0;
    static int coins=0;
    static JButton c1;
    static JButton c2;
    static JButton c3;
    static JButton c4;
    JPanel mainTextPanelS3, choiceButtonPanelS3, playerPanel;
    JLabel hpLabel;
    static JLabel hpLabelNumber;
    JLabel weaponLabel;
    static JLabel weaponLabelName;

    static JTextArea mainTextArea;
    SceneHandler sceneHandler = new SceneHandler();
    Container conS3;
    static SceneTwoJFrame sceneTwoJFrame=new SceneTwoJFrame();

    public void sceneThree(Container con, JPanel mainTextPanel, JPanel choiceButtonPanel,JPanel pPanel) {
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        pPanel.setVisible(false);
        con.remove(mainTextPanel);
        con.remove(choiceButtonPanel);
        con.remove(pPanel);
        conS3 = con;

        mainTextPanelS3 = new JPanel();
        mainTextPanelS3.setBounds(100, 100, 600, 250);
        mainTextPanelS3.setBackground(Color.black);
        conS3.add(mainTextPanelS3);

        mainTextArea = new JTextArea(".");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanelS3.add(mainTextArea);

        choiceButtonPanelS3 = new JPanel();
        choiceButtonPanelS3.setBounds(250, 350, 300, 150);
        choiceButtonPanelS3.setBackground(Color.black);
        choiceButtonPanelS3.setLayout(new GridLayout(5, 1));
        conS3.add(choiceButtonPanelS3);

        c1 = new JButton("Choice 1");
        c1.setBackground(Color.black);
        c1.setForeground(Color.white);
        c1.setFont(normalFont);
        c1.setFocusPainted(false);
        c1.addActionListener(sceneHandler);
        c1.setActionCommand("c1");
        choiceButtonPanelS3.add(c1);

        c2 = new JButton("Choice 2");
        c2.setBackground(Color.black);
        c2.setForeground(Color.white);
        c2.setFont(normalFont);
        c2.setFocusPainted(false);
        c2.addActionListener(sceneHandler);
        c2.setActionCommand("c2");
        choiceButtonPanelS3.add(c2);

        c3 = new JButton("Choice 3");
        c3.setBackground(Color.black);
        c3.setForeground(Color.white);
        c3.setFont(normalFont);
        c3.setFocusPainted(false);
        c3.addActionListener(sceneHandler);
        c3.setActionCommand("c3");
        choiceButtonPanelS3.add(c3);

        c4 = new JButton("Choice 4");
        c4.setBackground(Color.black);
        c4.setForeground(Color.white);
        c4.setFont(normalFont);
        c4.setFocusPainted(false);
        c4.addActionListener(sceneHandler);
        c4.setActionCommand("c4");
        choiceButtonPanelS3.add(c4);


//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        conS3.add(playerPanel);

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

    public static void playerSetup() {

        playerHP = 100;
        monsterHP = 50;
        weaponLabelName.setText(SceneTwoJFrame.weapon);
        hpLabelNumber.setText("" + playerHP);

        sceneThree();
    }

    public static void sceneThree() {
        position = "sceneThree";
        if(monsterHP<=0){
            mainTextArea.setText("""
                    You have successfully killed the skeleton archer.
                    Reward:
                    LVL UP
                    50 coins.""");
            lvl=lvl+1;
            coins+=50;
            c1.setText("Next");
            c2.setText("");
            c3.setText("");
            c4.setText("");
        }
        else {
            mainTextArea.setText("""
                    There's a corridor in front of you.

                    Suddenly, a skeleton archer came around the corner.""");
            c1.setText("");
            c2.setText("Attack");
            c3.setText("Defend");
            c4.setText("Escape");
        }
    }
    public void attack(){
        position = "attack";
        mainTextArea.setText("Monster HP: "+ monsterHP);
        c1.setText("simple attack");
        c2.setText("special attack");
        c3.setText("special attack 2");
        c4.setText("Ultimate");
    }
    public void simpleAttack(){
        position = "simpleAttack";
        monsterHP = monsterHP-10;
        playerHP=playerHP-10;
        hpLabelNumber.setText("" + playerHP);
            if (monsterHP <= 0) {
                mainTextArea.setText("Monster DIED");
                c1.setText("");
                c2.setText("Next");
            } else {
                mainTextArea.setText("You attacked monster using simple attack!" + "\n" + "Monster HP: " + monsterHP);
                c1.setText("back");
                c2.setText("");
            }
            c3.setText("");
            c4.setText("");

    }
    public void specialAttack(){
        position = "specialAttack";
        if(lvl>=1){
            playerHP=playerHP-10;
            hpLabelNumber.setText("" + playerHP);
            monsterHP = monsterHP-20;
        if(monsterHP<=0){
            mainTextArea.setText("Monster DIED");
            c1.setText("");
            c2.setText("Next");
        }
        else {
            mainTextArea.setText("You attacked monster using special attack!" + "\n" + "Monster HP: " + monsterHP);
            c1.setText("back");
            c2.setText("");
        }
        c3.setText("");
        c4.setText("");
        }
        else {
            mainTextArea.setText("Your lvl is too low");
            c1.setText("");
            c2.setText("");
            c3.setText("Back");
            c4.setText("");
        }
    }
    public void specialAttack2(){
        position = "specialAttack2";
        if(lvl>=2){
            monsterHP = monsterHP-30;
            playerHP=playerHP-10;
            hpLabelNumber.setText("" + playerHP);
        if(monsterHP<=0){
            mainTextArea.setText("Monster DIED");
            c1.setText("");
            c2.setText("Next");
        }
        else {
            mainTextArea.setText("You attacked monster using special attack №2!" + "\n" + "Monster HP: " + monsterHP);
            c1.setText("back");
            c2.setText("");
        }
        c3.setText("");
        c4.setText("");
        }
        else {
            mainTextArea.setText("Your lvl is too low");
            c1.setText("");
            c2.setText("");
            c3.setText("Back");
            c4.setText("");
        }
    }
    public void ultimate(){
        position = "ultimate";
        if(lvl>=3){
            monsterHP = monsterHP-40;
            playerHP=playerHP-10;
            hpLabelNumber.setText("" + playerHP);
        if(monsterHP<=0){
            mainTextArea.setText("Monster DIED");
            c1.setText("");
            c2.setText("Next");
        }
        else {
            mainTextArea.setText("You attacked monster using ULTIMATE!" + "\n" + "Monster HP: " + monsterHP);
            c1.setText("back");
            c2.setText("");
        }
        c3.setText("");
        c4.setText("");
        }
        else {
            mainTextArea.setText("Your lvl is too low");
            c1.setText("");
            c2.setText("");
            c3.setText("Back");
            c4.setText("");
        }
    }
    public void defend(){
        playerHP=playerHP-5;
        hpLabelNumber.setText("" + playerHP);
        position = "defend";
        if (playerHP <= 0) {
            mainTextArea.setText("""
                             You are so weak that you were killed by the most ordinary archer. You're dead!""");
            c1.setText("");
            c2.setText("RESTART");
        }
        else{
            mainTextArea.setText("""
                             Skeleton attacked you!""");
            c1.setText("Back");
            c2.setText("");
        }
        c3.setText("");
        c4.setText("");
    }
    public void escape(){
        playerHP=100;
        monsterHP=50;
        hpLabelNumber.setText("" + playerHP);
        position = "escape";
        mainTextArea.setText("""
                There was an ambush of 15 monster guards waiting for you from behind. You're dead.""");
        c1.setText("Restart");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }


    public class SceneHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (position) {
                case"sceneThree":
                    switch (yourChoice){
                        case "c1"-> {
                            MainSceneJFrame mainSceneJFrame = new MainSceneJFrame();
                            mainSceneJFrame.mainScene(conS3, mainTextPanelS3, choiceButtonPanelS3, playerPanel);
                        }
                        case "c2"->attack();
                        case "c3"->defend();
                        case "c4"->escape();
                    }
                    break;
                case"attack":
                    switch (yourChoice){
                        case "c1"->simpleAttack();
                        case "c2"->specialAttack();
                        case "c3"->specialAttack2();
                        case"c4"->ultimate();
                    }
                    break;
                case"defend":
                    switch (yourChoice){
                        case "c1"->sceneThree();
                        case"c2"-> {
                            playerHP = 100;
                            hpLabelNumber.setText("" + playerHP);
                            sceneThree();
                        }
                    }
                    break;
                case"escape":
                    if ("c1".equals(yourChoice)) {
                        sceneThree();
                    }
                    break;
                case"simpleAttack":
                case"specialAttack":
                case"specialAttack2":
                case"ultimate":
                    switch (yourChoice){
                        case "c1", "c3" ->attack();
                        case "c2"->sceneThree();
                    }
                    break;
            }
        }
    }
}
