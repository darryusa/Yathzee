/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Neal
 */
public class PlayerUi extends JPanel 
{
    private JPanel panel  = new JPanel(); 
    private JLabel playerName;
    private JLabel playerScore;
    private BorderLayout layout = new BorderLayout();
    
    public  PlayerUi()
    {
        initComponents();
    }
    private void initComponents()
    {
        //add name label to UI
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();        
        playerName = new JLabel();
        playerName.setText("Name");
        playerScore = new JLabel();
        panel.setLayout(layout);
        this.setMinimumSize(new Dimension((int)width/2,(int)(height/10)));
        this.setPreferredSize(new Dimension((int)width/2,(int)(height/10)));
        this.setMaximumSize(new Dimension((int)width/2,(int)(height/10)));
        panel.add(playerName,BorderLayout.WEST);
        add(panel,BorderLayout.WEST);
        //this.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String name) {
        playerName.setText("Player:" + name);
    }    
}
