
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (Junaid Khan) 
 * @version (1-31-2019)
 */
public class DistanceFilter implements Filter
{
    
    private Location loc;
    private double max_dist;
    private String name;
    
    public DistanceFilter(Location location, double distance){
        loc = location;
        max_dist = distance;
        name = "DistanceFilter";
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        Location quakeLoc = qe.getLocation();
        float dist = loc.distanceTo(quakeLoc);
        
        if(dist < max_dist){
            return true;
        }
        return false;
    }
    
    public String getName(){
        return name;
    }
}