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


public class ScoreCard 
{
    private UpperSection upper;
    private LowerSection lower;
    
    private int grandTotal = 0;

    public ScoreCard()
    {
        lower = new LowerSection();
        upper = new UpperSection();
    }
    
    public UpperSection getUpper() 
    {
        return upper;
    }

    public void setUpper(UpperSection upper) 
    {
        this.upper = upper;
    }

    public LowerSection getLower() 
    {
        return lower;
    }

    public void setLower(LowerSection lower) 
    {
        this.lower = lower;
    }

    /**
     * @return the grandTotal
     */
    public int getGrandTotal() {
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(int grandTotal) {
        this.grandTotal = getLower().getTotalScore() + getUpper().getTotalScore();
    }
}