package scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSceneJFrame {
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    static int playerHP;
    static int monsterHP;
    static String position;
    static JButton c1;
    static JButton c2;
    static JButton c3;
    static JButton c4;
    JPanel mainTextPanelMain, choiceButtonPanelMain, playerPanel;
    JLabel hpLabel;
    static JLabel hpLabelNumber;
    JLabel weaponLabel;
    static JLabel weaponLabelName;

    static JTextArea mainTextArea;
    SceneHandler sceneHandler = new SceneHandler();
    Container conMain;
    static int lvl=SceneThreeJFrame.lvl;
    static int coins=SceneThreeJFrame.coins;
    static String items="";
    static String potion="";
    static String role;
    public static String getRole(){
        if(SceneTwoJFrame.weapon=="Sword"){
            role="Warrior";
        } else if (SceneTwoJFrame.weapon=="Axe") {
            role="Pyromancer";
        } else if (SceneTwoJFrame.weapon=="Stick") {
            role="Wizard";
        } else if (SceneTwoJFrame.weapon=="Knife") {
            role="Hunter";
        }
        return role;
    }
    public void mainScene(Container con, JPanel mainTextPanel, JPanel choiceButtonPanel, JPanel pPanel) {
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        pPanel.setVisible(false);
        con.remove(mainTextPanel);
        con.remove(choiceButtonPanel);
        con.remove(pPanel);
        conMain = con;

        mainTextPanelMain = new JPanel();
        mainTextPanelMain.setBounds(100, 100, 600, 250);
        mainTextPanelMain.setBackground(Color.black);
        conMain.add(mainTextPanelMain);

        mainTextArea = new JTextArea(".");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanelMain.add(mainTextArea);

        choiceButtonPanelMain = new JPanel();
        choiceButtonPanelMain.setBounds(250, 350, 300, 150);
        choiceButtonPanelMain.setBackground(Color.black);
        choiceButtonPanelMain.setLayout(new GridLayout(5, 1));
        conMain.add(choiceButtonPanelMain);

        c1 = new JButton("Choice 1");
        c1.setBackground(Color.black);
        c1.setForeground(Color.white);
        c1.setFont(normalFont);
        c1.setFocusPainted(false);
        c1.addActionListener(sceneHandler);
        c1.setActionCommand("c1");
        choiceButtonPanelMain.add(c1);

        c2 = new JButton("Choice 2");
        c2.setBackground(Color.black);
        c2.setForeground(Color.white);
        c2.setFont(normalFont);
        c2.setFocusPainted(false);
        c2.addActionListener(sceneHandler);
        c2.setActionCommand("c2");
        choiceButtonPanelMain.add(c2);

        c3 = new JButton("Choice 3");
        c3.setBackground(Color.black);
        c3.setForeground(Color.white);
        c3.setFont(normalFont);
        c3.setFocusPainted(false);
        c3.addActionListener(sceneHandler);
        c3.setActionCommand("c3");
        choiceButtonPanelMain.add(c3);

        c4 = new JButton("Choice 4");
        c4.setBackground(Color.black);
        c4.setForeground(Color.white);
        c4.setFont(normalFont);
        c4.setFocusPainted(false);
        c4.addActionListener(sceneHandler);
        c4.setActionCommand("c4");
        choiceButtonPanelMain.add(c4);


//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        conMain.add(playerPanel);

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

        playerHP = 110;
        monsterHP = 65;
        weaponLabelName.setText(SceneTwoJFrame.weapon);
        hpLabelNumber.setText("" + playerHP);

        mainScene();
    }
    public static void mainScene(){
        position="main";
        if(monsterHP<=0) {
            lvl=lvl+1;
            coins+=15;
            mainTextArea.setText("""
                    You killed the troll
                    Your reward:
                    LVL UP!
                    15 coins""");
        }else{
            mainTextArea.setText("You are in main location!");
        }
        c1.setText("Go towards the city");
        c2.setText("Go to the forest");
        c3.setText("Inventory/Status");
        c4.setText("Go home (save)");
    }
    public static void city(){
        position="city";
        mainTextArea.setText("You are in the city");
        c1.setText("Go to the shop");
        c2.setText("Go to the bar");
        c3.setText("Back");
        c4.setText("status");
    }

    public void shop(){
        position="shop";
        mainTextArea.setText("Choose a potion: ");
        c1.setText("simple potion");
        c2.setText("big potion");
        c3.setText("");
        c4.setText("");
    }
    public void potion(){
        position="potion";
        mainTextArea.setText("You bought: "+potion);
        c1.setText("back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public void bar(){
        position="bar";
        mainTextArea.setText("You walked into a bar. You've spent 10$ and got 50 hp");
        coins-=10;
        playerHP+=50;
        hpLabelNumber.setText("" + playerHP);

        c1.setText("back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public static void forest(){
        position="forest";
        mainTextArea.setText("In the forest you met the troll"+"\n"+"Monster HP: "+ monsterHP);
        c1.setText("simple attack");
        c2.setText("special attack");
        c3.setText("special attack 2");
        c4.setText("Ultimate");
    }
    public void simpleAttack(){
        position = "simpleAttack";
        monsterHP = monsterHP-10;
        playerHP=playerHP-15;
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
        if(lvl==1){
            playerHP=playerHP-15;
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
        if(lvl==2){
            monsterHP = monsterHP-30;
            playerHP=playerHP-15;
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
        if(lvl==3){
            monsterHP = monsterHP-40;
            playerHP=playerHP-15;
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

    public static void status(){
        position="status";
        mainTextArea.setText("HP:" +playerHP+"\n"+
                "LVL:" +lvl+"\n"+
                "Money:" +coins+"\n"+
                "Role:"+getRole()+"\n"+
                "Items:"+items);
        c1.setText("Back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
    public static void home(){
        position="home";
        if(lvl<=10){
            mainTextArea.setText("You got some sleep at Tent house");
        }
        else{
            playerHP =120;
            hpLabelNumber.setText("" + playerHP);
            mainTextArea.setText("You got some sleep at Wooden house");
        }
        c1.setText("back");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }


    public class SceneHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (position) {
                case"main":
                    switch (yourChoice){
                        case "c1"-> city();
                        case "c2"->forest();
                        case "c3"->status();
                        case "c4"->home();
                    }
                    break;
                case"city":
                    switch (yourChoice){
                        case "c1"-> shop();
                        case "c2"->bar();
                        case "c3"->mainScene();
                        case "c4"->status();
                    }
                    break;
                case"shop":
                    switch (yourChoice){
                        case "c1" -> {
                            potion="simple potion";
                            coins-=10;
                            items=items+" "+potion;
                            potion();
                        }
                        case "c2" -> {
                            potion="big potion";
                            coins-=20;
                            items=items+" "+potion;
                            potion();
                        }
                    }
                    break;
                case"potion":
                case"bar":
                    if ("c1".equals(yourChoice)) {
                        city();
                    }
                    break;
                case"forest":
                    switch (yourChoice){
                        case "c1"-> simpleAttack();
                        case "c2"->specialAttack();
                        case "c3"->specialAttack2();
                        case "c4"->ultimate();
                    }
                    break;
                case"simpleAttack":
                case"specialAttack":
                case"specialAttack2":
                case"ultimate":
                    switch (yourChoice){
                        case "c1", "c3" ->forest();
                        case "c2"->mainScene();
                    }
                    break;
                case"status":
                case"home":
                    if ("c1".equals(yourChoice)) {
                        mainScene();
                    }
                    break;
            }
        }
    }
}
