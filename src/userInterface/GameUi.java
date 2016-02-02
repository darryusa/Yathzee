/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Neal
 */
public class GameUi extends JPanel
{
    private BoxLayout boxLayout;
    private ImageIcon logoImage;
    private JLabel maxTurn;
    private JLabel gameTurn;
    private JLabel logo;
    
    public GameUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension((int)width/2,(int)(height/10)));
        this.setPreferredSize(new Dimension((int)width/2,(int)(height/10)));
        this.setMaximumSize(new Dimension((int)width/2,(int)(height/10)));
        //this.setBorder(BorderFactory.createRaisedBevelBorder());
       
        logo = new JLabel();
        logo.setMinimumSize(new Dimension((int)(height*3/10), (int)(height/10)));
        logo.setPreferredSize(new Dimension((int)(height*3/10), (int)(height/10)));
        logo.setMaximumSize(new Dimension((int)(height*3/10), (int)(height/10)));
        logoImage = new ImageIcon( getClass().getResource("../images/yahtzee.jpg"));
        logoImage = imageResize(logoImage);
        logo.setIcon(logoImage);

        gameTurn = new JLabel();
        gameTurn.setMinimumSize(new Dimension((int)width/4,(int)height/10));
        gameTurn.setPreferredSize(new Dimension((int)width/4,(int)height/10));
        gameTurn.setMaximumSize(new Dimension((int)width/4,(int)height/10));
        gameTurn.setFont(new Font("Serif", Font.BOLD, 16));
        

        this.add(logo);
        this.add(gameTurn);
    }
   
    public void setGameTurnValue(int value)
    {
        gameTurn.setText("Turn: "+String.valueOf(value) + " / " + String.valueOf(Constants.NUM_CATERGORY));
    }
    
        // method to resize the image to fit on the jbutton
    private ImageIcon imageResize(ImageIcon icon)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance((int)(height/10), (int)(height/10), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

}