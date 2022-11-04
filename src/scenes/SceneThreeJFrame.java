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
    static JButton c1;
    static JButton c2;
    static JButton c3;
    static JButton c4;
    JPanel mainTextPanelS3,choiceButtonPanelS3,playerPanel;
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
    Container conS3;

    public void sceneThree(Container con, JPanel mainTextPanel, JPanel choiceButtonPanel){
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        con.remove(mainTextPanel);
        con.remove(choiceButtonPanel);

        conS3=con;

        mainTextPanelS3= new JPanel();
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
        choiceButtonPanelS3.setLayout(new GridLayout(5,1));
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
        playerPanel.setLayout(new GridLayout(1,4));
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
    public static void playerSetup(){

        playerHP = 100;
        monsterHP = 20;
        weapon = "None";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        sceneThree();
    }
    public static void sceneThree(){
        position="sceneThree";
        mainTextArea.setText("""
                There's a corridor in front of you.

                Suddenly, a skeleton archer came around the corner.""");
        c1.setText("Open the book");
        c2.setText("Run out the door.");
        c3.setText("Go to the armory room.");
        c4.setText("");
    }



    public class SceneHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(position){

            }

        }
    }
}
