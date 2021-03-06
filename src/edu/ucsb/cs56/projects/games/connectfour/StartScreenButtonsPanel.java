package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// A JPanel to Layout the Buttons in Start Menu

public class StartScreenButtonsPanel extends JPanel{
    
    private JButton MPButton; // Multi Player Button
    private JButton SPButton; // Single Player Button
    private JButton ExitButton; // Exit Button
    private JButton RuleButton; // Button to show rules
    
    public StartScreenButtonsPanel(startScreen2 ss){
        super();
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        
        MPButton = new JButton ("Multiplayer!");
        MPButton.addActionListener(new MPButtonListener(ss));
        MPButton.setFont(BFont);
        
        SPButton = new JButton ("Single Player");
        SPButton.addActionListener(new SPButtonListener(ss));
        SPButton.setFont(BFont);
        
        RuleButton = new JButton ("Rules");
        RuleButton.addActionListener(new RuleButtonListener());
        RuleButton.setFont(BFont);
        
        ExitButton = new JButton ("Exit");
        ExitButton.addActionListener(new ExitButtonListener(ss));
        ExitButton.setFont(BFont);
        
        
        
        this.add(SPButton);
        this.add(MPButton);
        this.add(RuleButton);
        this.add(ExitButton);
        
    }
    

    public void displayRules() {
        // Create pop-up window for rules
        JFrame ruleFrame = new JFrame();
        ruleFrame.setTitle("Rules");
        // Use HTML tags for multiline JLabel
        JLabel l1 = new JLabel("<html><FONT SIZE = 18><u>Rules:</u><br><br></FONT>" +
                               "1. Choose a Column to Place a Circle in.<br>" +
                               "2. Try to get Four identical circles in a row.<br><br><br>");
        ruleFrame.getContentPane().add(l1, BorderLayout.CENTER);
        ruleFrame.pack();
        ruleFrame.setVisible(true);
    }
    
    class MPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        MPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event) {
            ss1.setGameMode(1);
            ss1.launchGame();
        }
    }
    
    class SPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        SPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event) {
            System.out.println("Single Player Mode!");
            ss1.loadSinglePlayerMenu();
            
        }
    }
    
    class RuleButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            displayRules();
        }
    }
    
    class ExitButtonListener implements ActionListener {
        private startScreen2 ss1;
        ExitButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event) {
            
            ss1.setVisible(false);
            ss1.dispose();
        }
        
    }
}
