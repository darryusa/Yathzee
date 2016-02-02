/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


/**
 *
 * @author Neal
 */
import static core.Constants.*;
import java.util.ArrayList;
import userInterface.ScoreCardUi;
public class Player 
{
    private String name;
    private ScoreCard scoreCard;
    private ScoreCardUi scoreCardUi;
    private Roll roll;
    private int rollCount = 0;   
    private boolean finished = false;
    private ArrayList buttonStatus;
    private boolean status;

    public Player()
    {
        // initialize the Roll object for the player
        // use this single reference for the game
        roll = new Roll();
        scoreCard = new ScoreCard();
        scoreCardUi = new ScoreCardUi();
        buttonStatus = new ArrayList();
        for( int i = 0; i <14;i++)
        {
            status = true;
            buttonStatus.add(status);
        }
    }
    
    public Roll getRoll() 
    {
        return roll;
    }

    public void setRoll(Roll roll) 
    {
        this.roll = roll;
    }

    public ScoreCard getScore() 
    {
        return scoreCard;
    }

    public void setScore(ScoreCard score) 
    {
        this.scoreCard = score;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public void incrementRoll()
    {
        // call Roll's rollDice() method
        if(rollCount < 3)
        {
            finished = false;
            rollCount++;
        }
        else
        {
            rollCount = 0;
            finished = true;
        }           
    }
    
    public void rollDice()
    {
        // call Roll's rollDice() method
        if(rollCount < 3)
        {
            finished = false;
            roll.rollDice();
            rollCount++;
        }
        else
        {
            rollCount = 0;
            finished = true;
        }   
    }
    
// Player evaluates the dice
    public  boolean checkCategory(int[] dice, int category) {
		boolean categoryMatch = false;
		if(category >= ONES && category <= SIXES || category == CHANCE) {
			categoryMatch = true;
		}
		else {
			
			//creates an array for each possible dice value (1-6)
			ArrayList <Integer> ones = new ArrayList<>();  
			ArrayList <Integer> twos = new ArrayList<>(); 
			ArrayList <Integer> threes = new ArrayList<>(); 
			ArrayList <Integer> fours = new ArrayList<>(); 
			ArrayList <Integer> fives = new ArrayList<>(); 
			ArrayList <Integer> sixes = new ArrayList<>();
			
			/*goes through each rolled die and puts 1 as a place-holder into the appropriate ArrayList
			* e.g. if the first die value is 1, then 1 is added to the ones ArrayList or
			* if the second die value is 5, then 1 is added to the fives ArrayList*/
			for(int i = 0; i < NUM_DICE; i++) {
				if(dice[i] == 1) {
					ones.add(1);
				}
				else if(dice[i] == 2) {
					twos.add(1);
				}
				else if(dice[i] == 3) {
					threes.add(1);
				}
				else if(dice[i] == 4) {
					fours.add(1);
				}
				else if(dice[i] == 5) {
					fives.add(1);
				}
				else if(dice[i] == 6) {
					sixes.add(1);
				}
			}
			if(category == THREE_KIND) {
				if(ones.size() >= 3 || twos.size() >= 3 || threes.size() >= 3 || fours.size() >= 3 || fives.size() >= 3 || sixes.size() >= 3) {
					categoryMatch = true;
				}
			}	
			else if(category == FOUR_KIND) { 
				if(ones.size() >= 4 || twos.size() >= 4 || threes.size() >= 4 || fours.size() >= 4 || fives.size() >= 4 || sixes.size() >= 4) {
					categoryMatch = true;
				}
			}
			else if(category == YAHTZEE) {
				if(ones.size() == 5 || twos.size() == 5 || threes.size() == 5 || fours.size() == 5 || fives.size() == 5 || sixes.size() == 5) {
					categoryMatch = true;
				}
			}
			else if(category == FULL_HOUSE) {
				if(ones.size() == 3 || twos.size() == 3 || threes.size() == 3 || fours.size() == 3 || fives.size() == 3 || sixes.size() == 3) {
					if(ones.size() == 2 || twos.size() == 2 || threes.size() == 2 || fours.size() == 2 || fives.size() == 2 || sixes.size() == 2) {
						categoryMatch = true;
					}
				}
			}	
			else if(category == LRGSTR) { 
				if(ones.size() == 1 && twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1){
					categoryMatch = true;
				}
				else if(twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1 && sixes.size() == 1) {
					categoryMatch = true;
				}
			}
			else if(category == FULL ) { 
				if(ones.size() >= 1 && twos.size() >= 1 && threes.size() >= 1 && fours.size() >= 1) {
					categoryMatch = true;
				}
				else if(twos.size() >= 1 && threes.size() >= 1 && fours.size() >= 1 && fives.size() >= 1) {
					categoryMatch = true;
				}
				else if(threes.size() >= 1 && fours.size() >= 1 && fives.size() >= 1 && sixes.size() >= 1) {
					categoryMatch = true;
				}
			}
		}
		return categoryMatch;
	}

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * @return the buttonStatus
     */
    public ArrayList getButtonStatus() {
        return buttonStatus;
    }

    /**
     * @param status
     * @param index
     */
    public void setButtonStatus(boolean status,int index) {
        this.buttonStatus.set(index, status);
    }

    /**
     * @return the scoreCardUi
     */
    public ScoreCardUi getScoreCardUi() {
        return scoreCardUi;
    }

    /**
     * @param scoreCardUi the scoreCardUi to set
     */
    public void setScoreCardUi(ScoreCardUi scoreCardUi) {
        this.scoreCardUi = scoreCardUi;
    }
    
}
