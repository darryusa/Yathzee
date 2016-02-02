/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import core.Die;
import core.LowerSection;
import core.Player;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
        
public class LowerSectionUi extends JPanel
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints constraints;
    private JLabel totalLower;
    private JLabel totalUpper;
    private LowerSection lowerSection;
    private LowerSectionUi.SelectionListener selectionListener;
    private Player player;

    public LowerSectionUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        // layout manager
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        gridBagLayout = new GridBagLayout();
        constraints = new GridBagConstraints();
        
        // setting up JPanel
        this.setLayout(gridBagLayout);        
        this.setMinimumSize(new Dimension((int)width/2,(int)height*4/10));
        this.setPreferredSize(new Dimension((int)width/2,(int)height*4/10));
        this.setMaximumSize(new Dimension((int)width/2,(int)height*4/10));
        //this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList<JButton>();
        scores = new ArrayList<JLabel>();
        
        selectionListener = new LowerSectionUi.SelectionListener();

        for(int i = 0; i < Constants.LOWER_CATERGORY; i++)
        {
            // JButton for the category
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(new Dimension((int)width/4,(int)height*4/90)));
            category.setPreferredSize(new Dimension(new Dimension((int)width/4,(int)height*4/90)));
            category.setMaximumSize(new Dimension(new Dimension((int)width/4,(int)height*4/90)));
            category.addActionListener(selectionListener);
            
            switch(i)
            {
                case 0:
                    category.setText(Constants.TRIPLE);
                    category.putClientProperty("category", Constants.THREE_KIND);
                    break;
                case 1:
                    category.setText(Constants.QUAD);
                    category.putClientProperty("category", Constants.FOUR_KIND);
                    break;
                case 2:
                    category.setText(Constants.FULLHOUSE);
                    category.putClientProperty("category", Constants.FULL_HOUSE);
                    break;
                case 3:
                    category.setText(Constants.SMALL);
                    category.putClientProperty("category", Constants.SM_STRAIGHT);
                    break;
                case 4:
                    category.setText(Constants.LARGE);
                    category.putClientProperty("category", Constants.LG_STRAIGHT);
                    break;
                case 5:
                    category.setText(Constants.YAHTZ);
                    category.putClientProperty("category", Constants.YAHTZEE);
                    break;
                case 6:
                    category.setText(Constants.LASTCHANCE);
                    category.putClientProperty("category", Constants.CHANCE);
                    break;
                case 7:
                    category.setText(Constants.YAHTZ_BONUS);
                    category.putClientProperty("category", Constants.YAHTZEE_BONUSC);
                    break;
                default:
                    category.setText("No valid value");
                    break;
            }
            categories.add(category);
            
            JLabel score = new JLabel(String.valueOf(Constants.ZERO));
            score.setMinimumSize(new Dimension(new Dimension((int)width/4,(int)height*4/90)));
            score.setMaximumSize(new Dimension(new Dimension((int)width/4,(int)height*4/90)));
            score.setPreferredSize(new Dimension(new Dimension((int)width/4,(int)height*4/90)));
            score.setHorizontalTextPosition(JLabel.CENTER);
            scores.add(score);
        }
              
        setTotalLower(new JLabel());
        getTotalLower().setMinimumSize(new Dimension((int)width/4,(int)height*4/90));
        getTotalLower().setPreferredSize(new Dimension((int)width/4,(int)height*4/90));
        getTotalLower().setMaximumSize(new Dimension((int)width/4,(int)height*4/90));

        int row = 0;
        for(JButton category : categories)
        {
            addComponent(0, row, 1, 1, this, category);
            row++;
        }
        row = 0;
        for(JLabel score : scores)
        {
            addComponent(1, row, 1, 1, this, score);
            row++;
        }
        addComponent(0,row,1,1,this, totalLower);
    }

    private void addComponent( int x, int y, int w, int h, 
                               Container aContainer, Component aComponent )  
    {  
        constraints.gridx = x;  
        constraints.gridy = y;  
        constraints.gridwidth = w;  
        constraints.gridheight = h;
    
        gridBagLayout.setConstraints( aComponent, constraints );  
        
        aContainer.add( aComponent );  
    } 

    /**
     * @return the lowerSection
     */
    public LowerSection getLowerSection() {
        return lowerSection;
    }

    /**
     * @param lowerSection the lowerSection to set
     */
    public void setLowerSection(LowerSection lowerSection) {
        this.lowerSection = lowerSection;
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
    public void setPlayer(Player player) 
    {
        this.player = player;
    }
    
    public void updateUi()
    {
        int counter = 0;
        for(JLabel score : scores)
        {
            switch(counter)
            {
                case 0:
                    score.setText(String.valueOf(player.getScore().getLower().getThreeKind()));
                    break;
                case 1:
                    score.setText(String.valueOf(player.getScore().getLower().getFourKind()));
                    break;
                case 2:
                    score.setText(String.valueOf(player.getScore().getLower().getFullHouse()));
                    break;
                case 3:
                    score.setText(String.valueOf(player.getScore().getLower().getSmallStraight()));
                    break;
                case 4:
                    score.setText(String.valueOf(player.getScore().getLower().getLargeStraight()));
                    break;
                case 5:
                    score.setText(String.valueOf(player.getScore().getLower().getYahtzee()));
                    break;
                case 6:
                    score.setText(String.valueOf(player.getScore().getLower().getChance()));
                    break;
                case 7:
                    score.setText(String.valueOf(player.getScore().getLower().getYahtzeeBonus()));
                    break;
            }
            counter++;
        }
        
        getTotalLower().setText("Lower Total: "  +String.valueOf(player.getScore().getLower().getTotalScore()));
        for( int i = 0; i < 8;i++)
        {
            categories.get(i).setEnabled((boolean) player.getButtonStatus().get(i+6));
        }
        //totalUpper.setText(String.valueOf(player.getScore().getUpper().getTotal()));
    }

    /**
     * @return the totalLower
     */
    public JLabel getTotalLower() {
        return totalLower;
    }

    /**
     * @param totalLower the totalLower to set
     */
    public void setTotalLower(JLabel totalLower) {
        this.totalLower = totalLower;
    }
    
    private class SelectionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            int category = 0;

            if(ae.getSource() instanceof JButton)
            {
                JButton button = (JButton)ae.getSource();
//                String data = button.getActionCommand();
//                String dataToo = button.getText();
                category = (int)button.getClientProperty("category");                                

                // get the player's dice
                ArrayList<Die> dice = getPlayer().getRoll().getDice();
                
                // check the category and add the dice together
                int score = 0;
                int totalScore = 0;
                int diceValue[] = new int[5];
               
                for( int i = 0;i <dice.size();i++)
                {
                    diceValue[i]=dice.get(i).getFaceValue();
                }
                switch(category)
                {
                    case Constants.THREE_KIND:                        
                        if(getPlayer().checkCategory(diceValue, category))
                        {
                            for(int i = 0; i < dice.size(); i++)
                            {
                                score += dice.get(i).getFaceValue();
                            }

                            player.getScore().getLower().setThreeKind(score);
                            categories.get(0).setEnabled(false);
                            scores.get(0).setText(String.valueOf(getPlayer().getScore().getLower().getThreeKind()));
                            player.getScore().getLower().setTotalScore(score);
                            player.getScore().setGrandTotal(score);
                            player.setFinished(true);
                            player.setButtonStatus(false,6);
                            
                        }
                        break;
                        
                   case Constants.FOUR_KIND:                        
                        if(getPlayer().checkCategory(diceValue, category) == true)
                        {
                            for(int i = 0; i < dice.size(); i++)
                            {
                                score += dice.get(i).getFaceValue();
                            }

                            player.getScore().getLower().setFourKind(score);
                            categories.get(1).setEnabled(false);
                            scores.get(1).setText(String.valueOf(getPlayer().getScore().getLower().getFourKind()));
                            player.getScore().getLower().setTotalScore(score);
                            player.getScore().setGrandTotal(score);
                            player.setFinished(true);
                            player.setButtonStatus(false,7);
                        }
                        break;
                      case Constants.FULL_HOUSE:                        
                        if(getPlayer().checkCategory(diceValue, category))
                        {
                            

                            player.getScore().getLower().setFullHouse(25);
                            categories.get(2).setEnabled(false);
                            scores.get(2).setText(String.valueOf(getPlayer().getScore().getLower().getFullHouse()));
                            player.getScore().getLower().setTotalScore(25);
                            player.getScore().setGrandTotal(25);
                            player.setFinished(true);
                            player.setButtonStatus(false,8);
                        }
                        break;
                                 
                      case Constants.SM_STRAIGHT:                        
                        if(getPlayer().checkCategory(diceValue, category))
                        {
                            
                            player.getScore().getLower().setSmallStraight(30);
                            categories.get(3).setEnabled(false);
                            scores.get(3).setText(String.valueOf(getPlayer().getScore().getLower().getSmallStraight()));
                            player.getScore().getLower().setTotalScore(30);
                            player.getScore().setGrandTotal(30);
                            player.setFinished(true);
                            player.setButtonStatus(false,9);
                        }
                        break;
                    case Constants.LG_STRAIGHT:  
                        if(getPlayer().checkCategory(diceValue, category)){
                        getPlayer().getScore().getLower().setLargeStraight(Constants.LG_STRAIGHT);
                        categories.get(4).setEnabled(false);
                        scores.get(4).setText(String.valueOf(getPlayer().getScore().getLower().getLargeStraight()));
                        player.getScore().getLower().setTotalScore(Constants.LG_STRAIGHT);
                        player.getScore().setGrandTotal(Constants.LG_STRAIGHT);
                        player.setFinished(true);
                        player.setButtonStatus(false,10);
                        }
                        break;
                        
                    case Constants.YAHTZEE:  
                        if(getPlayer().checkCategory(diceValue, category)== true){
                        getPlayer().getScore().getLower().setYahtzee(50);
                        categories.get(5).setEnabled(false);
                        scores.get(5).setText(String.valueOf(getPlayer().getScore().getLower().getYahtzee()));
                        player.getScore().getLower().setTotalScore(50);
                        player.getScore().setGrandTotal(50);
                        player.setFinished(true);
                        player.setButtonStatus(false,11);
                        }
                        break;
                        
                    
                    case Constants.CHANCE:  
                        if(getPlayer().checkCategory(diceValue, category) == true){
                        for(int i = 0; i < dice.size(); i++)
                            {
                                score += dice.get(i).getFaceValue();
                            }
                        getPlayer().getScore().getLower().setChance(score);
                        categories.get(6).setEnabled(false);
                        scores.get(6).setText(String.valueOf(getPlayer().getScore().getLower().getChance()));
                        player.getScore().getLower().setTotalScore(score);
                        player.getScore().setGrandTotal(score);
                        player.setFinished(true);
                        player.setButtonStatus(false,12);
                        break;
                        }
                    case Constants.YAHTZEE_BONUSC:  
                        if(getPlayer().checkCategory(diceValue, category) == true){
                        getPlayer().getScore().getLower().setLargeStraight(50);
                        scores.get(7).setEnabled(false);
                        scores.get(7).setText(String.valueOf(getPlayer().getScore().getLower().getYahtzeeBonus()));
                        player.getScore().getLower().setTotalScore(100);
                        player.getScore().setGrandTotal(100);
                        player.setFinished(true);
                        player.setButtonStatus(false,13);
                        break;
                        }
                }
            }
        }
    }  
}
