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

public class UpperSection 
{
    private int aces;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int totalScore;
    private int bonus;
    private int total;

     public UpperSection()
    {
        initializeData();
    }
    
    private void initializeData()
    {
        setAces(Constants.ZERO);
        setTwos(Constants.ZERO);
        setThrees(Constants.ZERO);
        setFours(Constants.ZERO);
        setFives(Constants.ZERO);
        setSixes(Constants.ZERO);
        setTotal(Constants.ZERO);
        setBonus(Constants.ZERO);        
        setTotalScore(Constants.ZERO);
        
    }

    /**
     * @return the aces
     */
    public int getAces() {
        return aces;
    }

    /**
     * @param aces the aces to set
     */
        public void setAces(int aces) {
        this.aces = aces;
//        setTotal(this.aces);
        //setTotalScore(this.aces);
        checkBonus();
    }

    /**
     * @return the twos
     */
    public int getTwos() {
        return twos;
    }

    /**
     * @param twos the twos to set
     */
    public void setTwos(int twos) {
        this.twos = twos;
//        setTotal(this.twos);
        //setTotalScore(this.twos);
        checkBonus();
    }

    /**
     * @return the threes
     */
    public int getThrees() {
        return threes;
    }

    /**
     * @param threes the threes to set
     */
    public void setThrees(int threes) {
        this.threes = threes;
//        setTotal(this.threes);
       // setTotalScore(this.threes);
        checkBonus();
    }

    /**
     * @return the fours
     */
    public int getFours() {
        return fours;
    }

    /**
     * @param fours the fours to set
     */
    public void setFours(int fours) {
        this.fours = fours;
//        setTotal(this.fours);
        //setTotalScore(this.fours);
        checkBonus();
    }

    /**
     * @return the fives
     */
    public int getFives() {
        return fives;
    }

    /**
     * @param fives the fives to set
     */
    public void setFives(int fives) {
        this.fives = fives;
//        setTotal(this.fives);
        //setTotalScore(this.fives);
        checkBonus();
    }

    /**
     * @return the sixes
     */
    public int getSixes() {
        return sixes;
    }

    /**
     * @param sixes the sixes to set
     */
    public void setSixes(int sixes) {
        this.sixes = sixes;
        //setTotal(this.sixes);
        //setTotalScore(this.sixes);
        checkBonus();
    }

    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore += totalScore;
        checkBonus();
    }

    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    
    public void checkBonus()
    {
        if(totalScore >= Constants.IS_BONUS)
            setBonus(Constants.UPPER_BONUS);
        else
            setBonus(Constants.ZERO);
        
        setTotal((getTotalScore() + bonus));
    }
}