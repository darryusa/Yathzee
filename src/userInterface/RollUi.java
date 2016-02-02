/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Neal
 */



public class RollUi extends JPanel {
    private ArrayList<JToggleButton> dice;
    private JButton roll;
    private BoxLayout box;
    private JPanel rollPanel = new JPanel();
    private ImageIcon dieImage;
    private Player player;
    DieListener dieListener;
    public RollUi()
    {
        initComponents();
    }
    private void initComponents()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        dice = new ArrayList<>();
        roll = new JButton("ROLL DICE");
        roll.setAlignmentX(Component.LEFT_ALIGNMENT); 
        roll.addActionListener(new RollListener());
        rollPanel.add(roll);
        rollPanel.setLayout(new BoxLayout(rollPanel, BoxLayout.Y_AXIS));
        this.setMinimumSize(new Dimension((int)width/2,(int)(height*6/10)));
        this.setPreferredSize(new Dimension((int)width/2,(int)(height*6/10)));
        this.setMaximumSize(new Dimension((int)width/2,(int)(height*6/10)));
        dieListener = new DieListener();

        
        for(int i = 0; i< 5 ;i++)
        {
            JToggleButton die = new JToggleButton();
            die.setMinimumSize(new Dimension((int)height/11,(int)height/11));
            die.setPreferredSize(new Dimension((int)height/11,(int)height/11));
            die.setMaximumSize(new Dimension((int)height/11,(int)height/11));
            die.setAlignmentX(Component.LEFT_ALIGNMENT);            
            die.putClientProperty("die", (i + 1));
            die.putClientProperty("value", (i + 1));
            die.putClientProperty("selected", false);
            die.addActionListener(dieListener);
            addImage(die);
            dice.add(die);
            rollPanel.add(die);
            //addImage(button);
           
        }
        
        add(rollPanel);

        
    }
    public void setDice(ArrayList<Die> diceData)
    {
        int index = 0;
        for(JToggleButton die : dice)
        {
            //if(button.selected())
            die.putClientProperty("value", diceData.get(index).getFaceValue());
            addImage(die);
            index++;
        }
    }

        private void addImage(JToggleButton die)
    {
        int value = (int)die.getClientProperty("value");

        switch(value)
        {
            case 1:
                dieImage = new ImageIcon( getClass().getResource("../images/one.png"));
                break;
            case 2:
                dieImage = new ImageIcon( getClass().getResource("../images/two.png"));
                break;
            case 3:
                dieImage = new ImageIcon( getClass().getResource("../images/three.png"));
                break;
            case 4:
                dieImage = new ImageIcon( getClass().getResource("../images/four.png"));
                break;
            case 5:
                dieImage = new ImageIcon( getClass().getResource("../images/five.png"));
                break;
            case 6:
                dieImage = new ImageIcon( getClass().getResource("../images/six.png"));
                break;
        }
        
        dieImage = imageResize(dieImage);
        die.setIcon(dieImage);
    }
        
    private ImageIcon imageResize(ImageIcon icon)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance((int)height/11,(int) height/11, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
    
        private class DieListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            int die = 0;
            int value = 0;
            boolean selected = false;

            if(ae.getSource() instanceof JToggleButton)
            {
                JToggleButton button = (JToggleButton)ae.getSource();
                die = (int)button.getClientProperty("die");
                value = (int)button.getClientProperty("value"); 
                                
                selected = button.isSelected();
                
                if(selected)
                {
                    button.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                    button.putClientProperty("selected", true);
                }
                else
                {
                    button.setBorder(BorderFactory.createLineBorder(null));                
                    button.putClientProperty("selected", false);
                }
            }            
        }        
    }

    private class RollListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            // this rolls all dice regardless of which are selected
            ArrayList<Die> diceData = player.getRoll().getDice();

            int counter = 0;

            player.incrementRoll();
            
            for(JToggleButton die: dice)
            {
                boolean selected = (boolean)die.getClientProperty("selected");
                if(!selected)
                {
                    diceData.get(counter).rollDie();
                }
                counter++;
            }
            setDice(player.getRoll().getDice());
        }    
    }
    
        
    
}
