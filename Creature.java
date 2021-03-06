import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    //Indentation issues
    private HealthBar creatureBar;
    private int healthNumber;
    private boolean playerOneCreature;
    private String type;
  
    /**
     * Default constructor for objects of the Creature class
     * @return an object of the Creature class  
     * @param There are no parameters
     */
    public Creature()
    {
        healthNumber = 2500;
        playerOneCreature = true;
        creatureBar = new HealthBar( healthNumber, healthNumber, 10 ); 
        
    }

    /**
     * Constructor that allows customization of objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @return an object of the Creature class
     */
    
    public Creature( int health, boolean isPlayerOne, String creatureType )
    {
        healthNumber = health;
        playerOneCreature = isPlayerOne;
        type = creatureType;
        creatureBar = new HealthBar( healthNumber, healthNumber, 10 );
    }
    
    /**
     * HealthBar changes health bar into creature bar
     * 
     * @param There are no parameters
     * @Return reaturns creatureBar
     */
    protected HealthBar getHealthBar()
    {
        return creatureBar;  
    }
    
    /**
     * getWhetherPlayerOne sees if it's player one
     * 
     * @param There are no parameters
     * @Return returns playerOneCreature
     */
    public boolean getWhetherPlayerOne()
    {
        return playerOneCreature;  
    }
    
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        
    }

    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        
    }
    
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack( int idx )
    {
        
    }
    
    /**
     * act will complete actions that the Creature object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        //empty method that will get overriden in subclasses
    }
    
    /**
     * getType gets the type of Creature
     * 
     * @param no parameters
     * @return returns type
     */
    public String getType()
    {
        return type;
    }

}
