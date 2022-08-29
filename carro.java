import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class carro extends Actor
{
    private int speed;
    
    public carro(int v){
        speed = v;
    }
    /**
     * Act - do whatever the carro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("right")){
            if (getX() < 385 )
                setLocation(getX()+speed,getY()); 
        }
        if (Greenfoot.isKeyDown("left")){
            if (getX() > 65 )
                setLocation(getX()-speed,getY());
        }
        if (Greenfoot.isKeyDown("up")){
            if (getY() > 100 )
                setLocation(getX(),getY()-speed);
        }
        if (Greenfoot.isKeyDown("down")){
            if (getY() < 700 )
                setLocation(getX(),getY()+speed);
        }
    }
    public void checkColission(){
        Actor collided = getOneIntersectingObject(carro2.class);
        if (collided != null){
            getWorld().removeObject(collided);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
    
    public void aumenta_velocidad(){
        speed++;
    }
}
