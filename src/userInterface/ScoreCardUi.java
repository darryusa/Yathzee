/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Player;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Neal
 */
public class ScoreCardUi extends JPanel
{
private JPanel panel;
private JLabel grandTotal;
private LowerSectionUi lowerUi;
private UpperSectionUi upperUi;
private BoxLayout box;
private Player player;
public ScoreCardUi()
{
    initComponents();
}
private void initComponents()
{
    
    panel = new JPanel();
    grandTotal = new JLabel("Grand Total:");
    lowerUi = new LowerSectionUi();
    upperUi = new UpperSectionUi();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    panel.add(upperUi);
    panel.add(lowerUi);
    panel.add(grandTotal);
    grandTotal.setAlignmentX(LEFT_ALIGNMENT);
    lowerUi.setAlignmentX(LEFT_ALIGNMENT);
    upperUi.setAlignmentX(LEFT_ALIGNMENT);
    add(panel);
    
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
        lowerUi.setPlayer(player);
        upperUi.setPlayer(player);
        updateUi();
    }
    
    public void updateUi()
    {        
        lowerUi.updateUi();
        upperUi.updateUi();
        grandTotal.setText("GrandTotal: " + String.valueOf(getPlayer().getScore().getGrandTotal()));     
    }
}
