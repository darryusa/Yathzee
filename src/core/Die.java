package core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;


/**
 *
 * @author Neal
 */
public class Die {
    public int faceValue;
    
    public void rollDie()
        {
        Random random = new Random(); // instantiate instace random
        faceValue = 1 + random.nextInt(6); // assign random value 1 - 6  to face value
        }
        @Override
        public String toString() // override method toString in class String
        {       
            return String.valueOf(getFaceValue()); // return faceValue as a String
        }

    /**
     * @return the faceValue
     */
    public int getFaceValue() 
        {
            return faceValue;
        }

    /**
     * @param faceValue the faceValue to set
     */
    public void setFaceValue(int faceValue) 
        {
            this.faceValue = faceValue;
        }

}
