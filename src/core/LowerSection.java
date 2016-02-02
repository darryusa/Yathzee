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


public class LowerSection 
{
    private int threeKind;
    private int fourKind;
    private int fullHouse;
    private int smStraight;
    private int lgStraight;
    private int yahtzee;
    private int chance;
    private int yahtzeeBonus;
    private int totalScore = 0;

    /**
     * overriding default no-argument constructor
     */
    public LowerSection()
    {
        initializeData();
    }
    
    
    private void initializeData()
    {
        setThreeKind(Constants.ZERO);
        setFourKind(Constants.ZERO);
        setChance(Constants.ZERO);
        setFullHouse(Constants.ZERO);
        setSmallStraight(Constants.ZERO);
        setLargeStraight(Constants.ZERO);
        setYahtzee(Constants.ZERO);
        setYahtzeeBonus(Constants.ZERO);        
        setTotalScore(Constants.ZERO);
    }
    /**
     * @return the threeKind
     */
    public int getThreeKind() {
        return threeKind;
    }

    /**
     * @param threeKind the threeKind to set
     */
    public void setThreeKind(int threeKind) {
        this.threeKind = threeKind;
        //totalScore += this.threeKind;
    }

    /**
     * @return the fourKind
     */
    public int getFourKind() {
        return fourKind;
    }

    /**
     * @param fourKind the fourKind to set
     */
    public void setFourKind(int fourKind) {
        this.fourKind = fourKind;
        //totalScore += this.fourKind;
    }

    /**
     * @return the fullHouse
     */
    public int getFullHouse() {
        return fullHouse;
    }

    /**
     * @param fullHouse the fullHouse to set
     */
    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
        //totalScore += Constants.FULL_HOUSE;
    }

    /**
     * @return the smallStraight
     */
    public int getSmallStraight() {
        return smStraight;
    }

    /**
     * @param smallStraight the smallStraight to set
     */
    public void setSmallStraight(int smallStraight) {
        this.smStraight = smallStraight;
        //totalScore += Constants.SM_STRAIGHT;
    }

    /**
     * @return the largeStraight
     */
    public int getLargeStraight() {
        return lgStraight;
    }

    /**
     * @param largeStraight the largeStraight to set
     */
    public void setLargeStraight(int largeStraight) {
        this.lgStraight = largeStraight;
        //totalScore += Constants.LG_STRAIGHT;
    }

    /**
     * @return the yahtzee
     */
    public int getYahtzee() {
        return yahtzee;
    }

    /**
     * @param yahtzee the yahtzee to set
     */
    public void setYahtzee(int yahtzee) {
        this.yahtzee = yahtzee;
        //totalScore += Constants.YAHTZEE;
    }

    /**
     * @return the chance
     */
    public int getChance() {
        return chance;
    }

    /**
     * @param chance the chance to set
     */
    public void setChance(int chance) {
        this.chance = chance;
    }

    /**
     * @return the yahtzeeBonus
     */
    public int getYahtzeeBonus() {
        return yahtzeeBonus;
    }

    /**
     * @param yahtzeeBonus the yahtzeeBonus to set
     */
    public void setYahtzeeBonus(int yahtzeeBonus) {
        this.yahtzeeBonus = yahtzeeBonus;
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
        //totalScore;
        this.totalScore += totalScore;
    }
}
