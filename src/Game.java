import characterSettings.MainCharacter;
import scenes.SceneOneJFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font font = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4,choice5;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");

    boolean isWireFound = false;
    boolean isNoteFound = false;
    boolean isMasterKeyDone = false;
    MainCharacter character=new MainCharacter("Aldik");
    public Game(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("DARKNESS");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        //start music
        window.setVisible(true);
    }
    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            SceneOneJFrame sceneOneJFrame = new SceneOneJFrame();
            sceneOneJFrame.createGameScreen(con,titleNamePanel,startButtonPanel);
        }
    }
}