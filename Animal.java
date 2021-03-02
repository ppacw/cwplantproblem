import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
//test comment
public abstract class Animal
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    // The animal's gender
    private Sex sex;
    
    private boolean nocturnal;
    
        
    /**
     * Create a new animal at location in field with sex(Male/Female).
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     * @param sex The gender of the animal
     */
    public Animal(Field field, Location location)
    {
        //Randomises the sex of an animal and stores it in its field.
        int randomSexNum;
        randomSexNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        if(randomSexNum == 0){
            sex = Sex.MALE;
        } else { 
            sex = Sex.FEMALE; }

        alive = true;
        this.field = field;
        setLocation(location);
        nocturnal = false;
    }
    
    public void setNocturnal()
    {
        nocturnal = true;
    }
    
    public boolean isNocturnal()
    {
        return nocturnal;
    }
    
    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    abstract public void act(List<Animal> newAnimals);


    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * 
     * @return animal's gender;
     */
    protected Sex getSex()
    {
        return sex;
    } 

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
