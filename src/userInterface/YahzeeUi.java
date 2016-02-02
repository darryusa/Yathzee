/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.*;
import java.awt.BorderLayout;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class YahzeeUi
{

    private GameUi gameUi;
    private PlayerUi playerUi;
    private RollUi rollUi;
    private ScoreCardUi scoreCardUi;
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu game;
    private JMenuItem exit;
    private JMenuItem newGame;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private Game coreGame;
    private BorderLayout borderLayout = new BorderLayout(1,1);

    

    
 


 
        //Set up the content pane.


    public YahzeeUi()
    {
        initComponents();
    }

    private void initComponents()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setCoreGame(new Game(this));
        setGameUi(new GameUi());
        setPlayerUi(new PlayerUi());
        setRollUi(new RollUi());
        setScoreCardUi(new ScoreCardUi());
        frame = new JFrame("Yahzee!!! by Neal Nguyen"); //done
        frame.setLayout(borderLayout);
        //set Menu bar
        menuBar = new JMenuBar();  //done
        game = new JMenu("File"); //done
        game.setMnemonic('F');
        exit = new JMenuItem("Exit"); //done
        exit.addActionListener(new FileMenuAction());
        exit.setMnemonic('e');
        newGame = new JMenuItem("New Game"); //done
        newGame.addActionListener(new FileMenuAction());
        newGame.setMnemonic('n');
        menuBar.add(game);
        game.add(newGame);
        game.add(exit);
        rightPanel = new JPanel(); 
        leftPanel = new JPanel();
        //initialize the panels to box layout
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));

        //add component to right panels
        
        getRollUi().setAlignmentX(LEFT_ALIGNMENT);
        getGameUi().setAlignmentX(LEFT_ALIGNMENT);
        getPlayerUi().setAlignmentX(LEFT_ALIGNMENT);
        leftPanel.add(getScoreCardUi());
        rightPanel.add(getGameUi());
        rightPanel.add(getPlayerUi());
        rightPanel.add(getRollUi());
        rightPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        //adding component to frame
        frame.setJMenuBar(menuBar);
        frame.add(rightPanel,BorderLayout.EAST); //working
        frame.add(leftPanel,BorderLayout.WEST);
        frame.setMinimumSize(new Dimension((int)width,(int)height));
        frame.setMaximumSize(new Dimension((int)width,(int)height));
        frame.setPreferredSize(new Dimension((int)width,(int)height));       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.validate();
        frame.repaint();
        startGame();
        
    }
    public void startGame()
    {
        getCoreGame().playGame();
    }
    public void resetUi()
    {
        initComponents();
        startGame();
    }

    /**
     * @return the gameUi
     */
    public GameUi getGameUi() {
        return gameUi;
    }

    /**
     * @param gameUi the gameUi to set
     */
    public void setGameUi(GameUi gameUi) {
        this.gameUi = gameUi;
    }

    /**
     * @return the playerUi
     */
    public PlayerUi getPlayerUi() {
        return playerUi;
    }

    /**
     * @param playerUi the playerUi to set
     */
    public void setPlayerUi(PlayerUi playerUi) {
        this.playerUi = playerUi;
    }

    /**
     * @return the rollUi
     */
    public RollUi getRollUi() {
        return rollUi;
    }

    /**
     * @param rollUi the rollUi to set
     */
    public void setRollUi(RollUi rollUi) {
        this.rollUi = rollUi;
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

    /**
     * @return the coreGame
     */
    public Game getCoreGame() {
        return coreGame;
    }

    /**
     * @param coreGame the coreGame to set
     */
    public void setCoreGame(Game coreGame) {
        this.coreGame = coreGame;
    }
            
        private class FileMenuAction implements ActionListener
    {
        // Process the object events
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int choices;
            // Remove any previous content
            // gets the text of the JMenuItem
            switch (e.getActionCommand()) {
                case "Exit":
                    choices = JOptionPane.showConfirmDialog(null,"Would you like to exit?","EXIT?",
                            JOptionPane.YES_NO_OPTION);
                    if(choices == JOptionPane.YES_OPTION)
                    {
                        System.exit(0);
                    }
                    break;
                case "New Game":
                    choices = JOptionPane.showConfirmDialog(null,"Would you like to play a new game", "New Game", JOptionPane.YES_NO_OPTION);
                    if(choices == JOptionPane.YES_OPTION)
                    {
                        resetUi();
                    }   
                    break;
            }
        }    
    }      

}

