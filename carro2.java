import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class carro2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class carro2 extends Actor
{
    
    private int speed;
    
    public carro2(int v){
        speed = v;
    }
    /**
     * Act - do whatever the carro2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(),getY() + speed);
        if (getY () >= getWorld().getHeight()-1){
            MyWorld juego =(MyWorld) getWorld ();
            juego.removeObject(this);
            
            juego.subir_puntos(10);
            juego.bajar_num_rivales();
            juego.subir_num_adelantamientos();
        }
    }
}
