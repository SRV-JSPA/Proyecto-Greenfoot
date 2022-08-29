import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private counter puntaje;
    private counter nivel;
    
    private int velocidad_carro;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private carro azul;
    private int num_rivales;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(450, 900, 1); 
        num_adelantamientos = 0;
        num_adelantamientos_nivel = 4;
        velocidad_carro = 4;
        puntaje = new counter("puntaje: ");
        nivel = new counter("nivel: ");
        nivel.add(1);
        azul = new carro(velocidad_carro);
        
        addObject(azul, 300, 600);
        addObject(nivel, 205, 90);
        addObject(puntaje, 205, 60);
    }
    
    public void act(){
        aumentar_dificultad();
        añadir_rivales();
    }
    
    public int getRandomNumber(int empezar,int terminar){
        int normal = Greenfoot.getRandomNumber(terminar-empezar+1);
        return normal+empezar;
    }
    
    public void subir_puntos(int valor){
        puntaje.add(valor);
    }
    
    public void subir_num_adelantamientos(){
        num_adelantamientos++;
    }
    
    public void bajar_num_rivales(){
        num_rivales--; 
    }
    
    public void aumentar_dificultad(){
        if (num_adelantamientos == num_adelantamientos_nivel){
            num_adelantamientos = 0;
            num_adelantamientos_nivel = num_adelantamientos_nivel + 2;
            velocidad_carro++;
            nivel.add(1);
            azul.aumenta_velocidad(); 
        }
    }
    
    public void añadir_rivales(){
        if (num_rivales == 0){
            
            int carril = getRandomNumber (0,3);
            
            if (carril == 0){
                addObject(new carro2(velocidad_carro),180,80);
            }
            else if (carril == 1){
                addObject(new carro2(velocidad_carro),290,80);
            }
            
            else {
                addObject(new carro2(velocidad_carro),410,80);
            }
            
            carril++;
            
            carril = carril % 3;
            
            if (carril == 0){
                addObject(new carro2(velocidad_carro),180,80);
            }
            else if (carril == 1){
                addObject(new carro2(velocidad_carro),290,80);
            }
            
            else {
                addObject(new carro2(velocidad_carro),410,80);
            }
            
            num_rivales = 2;
        }
    }
    
}
