package userInterface;

import core.Constants;
import core.Die;
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

public class UpperSectionUi extends JPanel
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private JLabel total;
    private JLabel bonus;
    private JLabel totalScore;
    private SelectionListener selectionListener;
    private Player player;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints constraints;

    public UpperSectionUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        // layout manager
        gridBagLayout = new GridBagLayout();
        constraints = new GridBagConstraints();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        // setting up JPanel
        this.setLayout(gridBagLayout);        
        this.setMinimumSize(new Dimension((int)width/2,(int)height*4/10));
        this.setPreferredSize(new Dimension((int)width/2,(int)height*4/10));
        this.setMaximumSize(new Dimension((int)width/2,(int)height*4/10));
        //this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList<JButton>();
        scores = new ArrayList<JLabel>();
        
        selectionListener = new SelectionListener();
        
        for(int i = 0; i < Constants.MAX_DIE_VALUE; i++)
        {
            JButton category = new JButton();
            category.setMinimumSize(new Dimension((int)width/4,(int)height*4/90));
            category.setPreferredSize(new Dimension((int)width/4,(int)height*4/90));
            category.setMaximumSize(new Dimension((int)width/4,(int)height*4/90));
            category.addActionListener(selectionListener);
            
            switch(i)
            {
                case 0:
                    category.setText(Constants.ACE);
                    category.putClientProperty("category", Constants.ONES);
                    break;
                case 1:
                    category.setText(Constants.TWO);
                    category.putClientProperty("category", Constants.TWOS);
                    break;
                case 2:
                    category.setText(Constants.THREE);
                    category.putClientProperty("category", Constants.THREES);
                    break;
                case 3:
                    category.setText(Constants.FOUR);
                    category.putClientProperty("category", Constants.FOURS);
                    break;
                case 4:
                    category.setText(Constants.FIVE);
                    category.putClientProperty("category", Constants.FIVES);
                    break;
                case 5:
                    category.setText(Constants.SIX);
                    category.putClientProperty("category", Constants.SIXES);
                    break;
                default:
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
              
        totalScore = new JLabel("TOTAL SCORE");
        totalScore.setMinimumSize(new Dimension((int)width/4,(int)height*4/90));
        totalScore.setPreferredSize(new Dimension((int)width/4,(int)height*4/90));
        totalScore.setMaximumSize(new Dimension((int)width/4,(int)height*4/90));

        bonus = new JLabel();
        bonus.setText(Constants.BONUS);
        bonus.setMinimumSize(new Dimension((int)width/4,(int)height*4/90));
        bonus.setPreferredSize(new Dimension((int)width/4,(int)height*4/90));
        bonus.setMaximumSize(new Dimension((int)width/4,(int)height*4/90));
        
        total = new JLabel("TOTAL of Upper Section     0");
        total.setMinimumSize(new Dimension((int)width/4,(int)height*4/90));
        total.setPreferredSize(new Dimension((int)width/4,(int)height*4/90));
        total.setMaximumSize(new Dimension((int)width/4,(int)height*4/90));

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
        
        addComponent(0, row++, 1, 1, this, totalScore);
        addComponent(0, row++, 1, 1, this, bonus);
        addComponent(0, row++, 1, 1, this, total);
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
        
        for(JLabel category : scores)
        {
            switch(counter)
            {
                case 0:
                    category.setText(String.valueOf(player.getScore().getUpper().getAces()));
                    break;
                case 1:
                    category.setText(String.valueOf(player.getScore().getUpper().getTwos()));
                    break;
                case 2:
                    category.setText(String.valueOf(player.getScore().getUpper().getThrees()));
                    break;
                case 3:
                    category.setText(String.valueOf(player.getScore().getUpper().getFours()));
                    break;
                case 4:
                    category.setText(String.valueOf(player.getScore().getUpper().getFives()));
                    break;
                case 5:
                    category.setText(String.valueOf(player.getScore().getUpper().getSixes()));
                    break;
                
            }
            counter++;
            totalScore.setText("Total Score:" + String.valueOf(player.getScore().getUpper().getTotalScore()));
            bonus.setText("Bonus:" + String.valueOf(player.getScore().getUpper().getBonus()));
            total.setText("Total Upper:" + String.valueOf(player.getScore().getUpper().getTotal()));
            for( int i = 0; i < 6;i++)
            {
                categories.get(i).setEnabled((boolean) player.getButtonStatus().get(i));
            }
        }        
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

                category = (int)button.getClientProperty("category");                                

                // get the player's dice
                ArrayList<Die> dice = player.getRoll().getDice();
                
                // check the category and add the dice together
                int score = 0;
                        
                switch(category)
                {
                    case Constants.ONES:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                            
                    
                            if(dice.get(i).getFaceValue() == 1)
                            {
                               score += dice.get(i).getFaceValue();
                            }
                        
                            
                        }
                        player.getScore().getUpper().setAces(score);
                        categories.get(0).setEnabled(false);
                        player.getScore().setGrandTotal(score);
                        scores.get(0).setText(String.valueOf(player.getScore().getUpper().getAces()));
                        player.getScore().getUpper().setTotalScore(score);
                        player.setFinished(true);
                        player.setButtonStatus(false,0);
                        break;
                        
                        
                        case Constants.TWOS:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                            if(dice.get(i).getFaceValue() == 2)
                            {
                               score += dice.get(i).getFaceValue();
                            }
                        }
                        
                        player.getScore().getUpper().setTwos(score);
                        categories.get(1).setEnabled(false);
                        player.getScore().setGrandTotal(score);

                        scores.get(1).setText(String.valueOf(player.getScore().getUpper().getTwos()));
                        player.getScore().getUpper().setTotalScore(score);
                        player.setFinished(true);
                        player.setButtonStatus(false,1);
                        break;
                        
                        
                        
                        case Constants.THREES:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                             if(dice.get(i).getFaceValue() == 3)
                            {
                               score += dice.get(i).getFaceValue();
                            }
                        }
                        
                        player.getScore().getUpper().setThrees(score);
                        categories.get(2).setEnabled(false);
                        player.getScore().setGrandTotal(score);
                        player.getScore().getUpper().setTotalScore(score);
                        scores.get(2).setText(String.valueOf(player.getScore().getUpper().getThrees()));
                        player.setFinished(true);
                        player.setButtonStatus(false,2);
                        break;
                        
                        
                        case Constants.FOURS:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                             if(dice.get(i).getFaceValue() == 4)
                            {
                               score += dice.get(i).getFaceValue();
                            }
                        }
                        
                        player.getScore().getUpper().setFours(score);
                        categories.get(3).setEnabled(false);
                        player.getScore().getUpper().setTotalScore(score);
                        player.getScore().setGrandTotal(score);
                        scores.get(3).setText(String.valueOf(player.getScore().getUpper().getFours()));
                        player.setFinished(true);
                        player.setButtonStatus(false,3);
                        break;
                        
                        
                        
                        case Constants.FIVES:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                            if(dice.get(i).getFaceValue() == 5)
                            {
                               score += dice.get(i).getFaceValue();
                            }
                        }
                        
                        player.getScore().getUpper().setFives(score);
                        categories.get(4).setEnabled(false);
                        player.getScore().getUpper().setTotalScore(score);
                        player.getScore().setGrandTotal(score);
                        scores.get(4).setText(String.valueOf(player.getScore().getUpper().getFives()));
                        player.setFinished(true);
                        player.setButtonStatus(false,4);
                        
                        break;
                        
                        case Constants.SIXES:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                             if(dice.get(i).getFaceValue() == 6)
                            {
                               score += dice.get(i).getFaceValue();
                            }
                        }                        
                        player.getScore().getUpper().setSixes(score);
                        categories.get(5).setEnabled(false);
                        player.getScore().getUpper().setTotalScore(score);
                        player.getScore().setGrandTotal(score);
                        scores.get(5).setText(String.valueOf(player.getScore().getUpper().getSixes()));
                        player.setFinished(true);
                        player.setButtonStatus(false,5);
                        break;                                                                 
                }
                        
               
            }
        }
    }    
}
