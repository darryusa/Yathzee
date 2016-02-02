/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author Neal
 */
public class Roll 
{
    private ArrayList<Die> dice = new ArrayList<>();

    public ArrayList<Die> getDice() {
        return dice;
    }

    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }
    //end getter and setter
    public Roll()
    {
        initializeDice();
    }
   
    public void initializeDice()
    {
        for (int i = 0; i < 5; i++)  //generate 5 new dice
        {
            Die die = new Die();
            dice.add(die);
        }
    }//end initializeDice method
    
    public void rollDice()
    {
        int i = 0;
        for (Die die : dice)  // loop through array list die to call method rollDie in class die and print out the value of the die rolled
        {           
           i++;
           die.rollDie();
           
        }
    }
    
}//end of Roll Class
