import java.util.List;
/**
 * Write a description of interface Prey here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Prey
{
    public void act(List<Actor> newRabbits);
    
    public boolean isAlive();
    
    public void setDead();
    
    public Sex getSex();
}
