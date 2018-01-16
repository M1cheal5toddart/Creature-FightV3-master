import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Charmander here.
 * CS20S
 * Micheal Stoddart
 * Oct.2
 */
public class Charmander extends Creature
{
    
    public Charmander( World w )
    {
        //Indentation issues
        super (700, true, "Fire"); 
       
        getImage().scale( 150, 100 ); 
        
        w.addObject( getHealthBar(), 300, w.getHeight() - 50);
    }
    
    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        if ( getHealthBar().getCurrent() <= 0)
        {
            getWorld().showText("Charmander has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            
            Greenfoot.delay(30);
            if( playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.changePlayerOneTurn(true);
                getWorld().showText( "", getWorld().getWidth() / 2, getWorld().getHeight() / 2 - 26 );
                getWorld().removeObject(this);
            }
            else if( playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(2);
                playerWorld.changePlayerOneTurn(true);
                getWorld().showText( "", getWorld().getWidth() / 2, getWorld().getHeight() / 2 - 26 );
                getWorld().removeObject(this);
            }
            else
            {
                switchCreature(1);
                playerWorld.changePlayerOneTurn(true);
                getWorld().showText( "", getWorld().getWidth() / 2, getWorld().getHeight() / 2 - 26 );
                getWorld().removeObject(this);
            }
        }  
    }
    
    /**
     * attack deals damage to other creatures
     * 
     * @param idx number of attack
     * @return nothing is returned
     */ 
    public void attack( int idx ) 
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature enemy = world.getPlayerTwo();
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx == 0 )
        {
            //Indentation issues
            enemy.getHealthBar().add(-25);
        }
        else
        {
            if( enemyType.equalsIgnoreCase( "Water") )
            {
                enemy.getHealthBar().add(-70/2);
                getWorld().showText( "It's Not Very Effective..." , getWorld().getWidth() / 2 , getWorld().getHeight() /2 + 26 );
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add(-70);
            }
        }
        world.changePlayerOneTurn (false);
    }
    
    /**
     * attackAnimation animates the attack
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for( int i = 0; i < 15; i++ ) 
        {
            setLocation( getX() + 1, getY() - 2 ); 
            
            Greenfoot.delay(1);
        }
        setLocation( originalX, originalY );
    }
    
    /**
     * switchCreature switches the current creature
     * 
     * @param idx gives a number
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature switchCreature;
        if( idx == 0 )
        {
            switchCreature = world.getNewOneCreature(1);
        }
        else
        {
            switchCreature = world.getNewOneCreature(2);
        }
        
        if( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
           JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
           
        }
        else
        {
            while( getX() > 0 )
            {
                setLocation( getX() - 5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            
        }
        
        if( idx == 0 )
        {
            world.changePlayerOne( "Golem" );
        }
        else
        {
            world.changePlayerOne( "Ivysaur" );
            
        }
        switchCreature.switchedIn();
        world.changePlayerOneTurn(false);
    }

    /**
     * switchedIn reaveals Image and health bar of the creature switched in
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while ( getX() < 75 )
        {
            setLocation( getX() + 5, getY() );
            
            Greenfoot.delay(2);
        }
    }
}
