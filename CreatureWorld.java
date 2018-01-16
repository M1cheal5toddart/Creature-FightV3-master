import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Micheal Stoddart
 * CS20S
 *  Mr. Hardman
 * Lab #5, Program #1
 * last updated Jan.12
 * 
 * Mark: 2.5/5
 * -0.5 Mark: Comment block not updated for assignment 3
 * -2 Marks: Lots of indentation issues
 */
public class CreatureWorld extends World
{
    private String playerOneCreature; 
    private String playerTwoCreature;
    private String playerOneName;
    private String playerTwoName;
    private Creature[] playerOneCreatures;
    private Creature[] playerTwoCreatures;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    private boolean playerOneTurn;
    private boolean start;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
  
    
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super( 400, 400, 1); 
        
        playerOneCreatures = new Creature[] { new Charmander(this), new Golem(this), new Ivysaur(this) };
        playerTwoCreatures = new Creature[] { new Pikachu(this), new Lapras(this), new Pidgeot(this) };   

        start = true;
        playerOneCreature = "Charmander";
        playerTwoCreature = "Pikachu";
        prepareCreatures();
        Greenfoot.start();
    }
    
    public boolean playerOneTurn()
    {
       return playerOneTurn; 
    }

    /**
     * getPlayerOne gets the current creature
     * 
     * @param There are no parameters
     * @return returns currentPlayerOne
     */
    public Creature getPlayerOne()
    {
        Creature currentPlayerOne;
        if( playerOneCreature.equalsIgnoreCase( "Golem" ) )
        {
           currentPlayerOne = playerOneCreatures[1];
        }
        else if( playerOneCreature.equalsIgnoreCase( "Ivysaur" ) )
        {
            currentPlayerOne = playerOneCreatures[2];
        }
        else
        {
            currentPlayerOne = playerOneCreatures[0];
        }
        return currentPlayerOne;
    }
    
    /**
     * getPlayerTwo gets the current creature
     * 
     * @param There are no parameters
     * @return returns currentPlayerTwo
     */
    public Creature getPlayerTwo()
    {
        Creature currentPlayerTwo;
        if( playerTwoCreature.equalsIgnoreCase( "Lapras" ) )
        {
            currentPlayerTwo = playerTwoCreatures[1];
        }
        else if( playerTwoCreature.equalsIgnoreCase( "Pidgeot" ) )
        {
            currentPlayerTwo = playerTwoCreatures[2];
        }
        else
        {
            currentPlayerTwo = playerTwoCreatures[0];
        }
        return currentPlayerTwo;
    }
    
    /**
     * changePlayerOne removes fight and switch menus for player one
     * 
     * @param creature there must be a current creature
     * @return Nothing is returned
     */
    public void changePlayerOne( String creature )
    {
        playerOneCreature = creature;
        removeObject( oneFightMenu );
        removeObject( oneSwitchMenu );
        playerOneMenusAdded = false;
    }
    
    /**
     * changePlayerTwo removes fight and switch menus for player two
     * 
     * @param creature there must be a current creature 
     * @return Nothing is returned
     */
     public void changePlayerTwo( String creature )
    {
        playerTwoCreature = creature;
        removeObject( twoFightMenu );
        removeObject( twoSwitchMenu );
        playerTwoMenusAdded = false;
    }
    
    /**
     * getNewOneCreature gets a new creature
     * 
     * @param index gets a number for the playerOneCreatures array
     * @return returns the playerOneCreatures array
     */
    public Creature getNewOneCreature( int index )
    {
        return playerOneCreatures[index];
    }
    
    /**
     * getNewTwoCreature gets a new creature
     * 
     * @param index gets a number for the playerTwoCreatures array
     * @return returns the playerTwoCreatures array
     */
    public Creature getNewTwoCreature( int index )
    {
        return playerTwoCreatures[index];
    }
    
    public boolean isPlayerOneTurn()
    {
        return playerOneTurn;
    }
    
    public void changePlayerOneTurn( boolean turn )
    {
        //Indentation issues
        playerOneTurn = turn; 
    }

    /**
     * prepareCreatures sets transparency of non active creatures to 0
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    private void prepareCreatures()
    {   
        for( int i = 0; i < playerOneCreatures.length; i++ )
        {
            if( i == 0 )
            {
                addObject( playerOneCreatures[i], playerOneCreatures[i].getImage().getWidth() / 2, getHeight() - playerOneCreatures[i].getImage().getHeight() / 2);
            }
            else
            {
                playerOneCreatures[i].getImage().setTransparency(0);
                
                addObject( playerOneCreatures[i], 0, getHeight() - playerOneCreatures[i].getImage().getHeight()/2 );
            }
        }
            
        for( int j = 0; j < playerTwoCreatures.length; j++ )
        {
            if( j == 0 )
            {
                addObject( playerTwoCreatures[j], getWidth()-playerTwoCreatures[j].getImage().getWidth() / 2, playerTwoCreatures[j].getImage().getHeight() / 2);
            }
            else
            {
                playerTwoCreatures[j].getImage().setTransparency(0);
                
                addObject( playerTwoCreatures[j], getWidth() , playerTwoCreatures[j].getImage().getHeight()/2 );
            }
        }
    }
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
    
    public void act()
    {
        List allObjects = getObjects(null);
        boolean playerOneLose = true;
        boolean playerTwoLose = true;
        if ( start == true )
        {
            //Indentation issues
            playerOneName = JOptionPane.showInputDialog( " Player One, please enter your name: ", null );
            playerTwoName = JOptionPane.showInputDialog( " Player Two, please enter your name: ", null );
            start = false;
            playerOneTurn = true;
        }
        else if( playerOneTurn == true )
        {
            showText( playerOneName+ ", Your Turn", getWidth() / 2, getHeight()/ 2);
            showText("", getWidth() /2, getHeight()/2 + 26 );     
        }
        else 
        {
            showText( playerTwoName+ ", Your Turn", getWidth() / 2, getHeight()/ 2);
            showText("", getWidth() /2, getHeight()/2 + 26 );     
        }
       
        if( playerOneMenusAdded == false )
        {
            if( playerOneCreature.equalsIgnoreCase( "Charmander" ) )
            {
                 oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                 oneSwitchMenu = new Menu( " Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if( playerOneCreature.equalsIgnoreCase( "Golem" ) )
            {
                 oneFightMenu = new Menu( " Fight ", " Tackle \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                 oneSwitchMenu = new Menu( " Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                 oneFightMenu = new Menu( " Fight ", " Tackle \n Razor Leaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
    
                 oneSwitchMenu = new Menu( " Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
                
            }
            addObject( oneFightMenu, 177, getHeight() - 100 );
            addObject( oneSwitchMenu, 241, getHeight() - 100 );
            playerOneMenusAdded = true;
        }
        
        if( playerTwoMenusAdded == false )
        {
            if( playerTwoCreature.equalsIgnoreCase( "Pikachu" ) )
            {
               twoFightMenu = new Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               
               twoSwitchMenu = new Menu( " Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if( playerTwoCreature.equalsIgnoreCase( "Lapras" ) )
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n Hydro Pump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu( " Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu( " Switch ", " Pikachu \n Lapras ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
                
            }
            
            addObject( twoFightMenu, 135, 75 );
            addObject( twoSwitchMenu, 199, 75 );
            playerTwoMenusAdded = true;
        }
        
        for( int i = 0; playerOneLose == true && i < playerOneCreatures.length; i++ )
        {
            if( playerOneCreatures[i].getHealthBar().getCurrent() > 0)
            {
                playerOneLose = false;
            }
        }
        
          for( int j = 0; playerTwoLose == true && j < playerTwoCreatures.length; j++ )
        {
            if( playerTwoCreatures[j].getHealthBar().getCurrent() > 0)
            {
                playerTwoLose = false;
            }
        }
        
        if ( playerOneLose == true )
        {
            removeObjects(allObjects);
            showText( " Player Two Wins! " , getWidth() / 2, getHeight()/ 2);
            showText( "" , getWidth() /2, getHeight()/2 + 26 );
            Greenfoot.stop();
        }
       
        if ( playerTwoLose == true )
        {
            removeObjects(allObjects);
            showText( " Player One Wins! " , getWidth() / 2, getHeight()/ 2);
            showText( "" , getWidth() / 2, getHeight()/ 2 + 26 );
            Greenfoot.stop();
        }
    }   
    
}
