
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (Junaid Khan) 
 * @version (1-31-2019)
 */
public class MagnitudeFilter implements Filter
{
    private double magMin;
    private double magMax;
    private String name;
    
    public MagnitudeFilter(double min, double max) { 
        magMin = min;
        magMax = max;
        name = "MagnitudeFilter";
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin && qe.getMagnitude() <= magMax;
    } 
    
    public String getName(){
        return name;
    }
}    
     

