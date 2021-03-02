
/**
 * Write a description of class Herbivore here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Herbivore
{
    private int PLANT_FOOD_VALUE;
    
    public Herbivore(int PLANT_FOOD_VALUE){
        this.PLANT_FOOD_VALUE = PLANT_FOOD_VALUE;
        
    }
    
    /**
     * Look for plants adjacent to the current location.
     * Only the first live plant is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    abstract public Location findPlants();
    
}
