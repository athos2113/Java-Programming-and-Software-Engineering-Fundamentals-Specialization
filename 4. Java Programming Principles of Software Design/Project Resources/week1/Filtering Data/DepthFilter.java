
/**
 * Write a description of DepthFilter here.
 * 
 * @author (Junaid Khan) 
 * @version (1-31-2019)
 */
public class DepthFilter implements Filter
{
    private double depMin;
    private double depMax;
    private String name;
    
    public DepthFilter(double min, double max) { 
        depMin = min;
        depMax = max;
        name = "DepthFilter";
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getDepth() >= depMin && qe.getDepth() <= depMax;
    } 
    
    public String getName(){
        return name;
    }
}   
