
/**
 * Write a description of MatchAllFilter here.
 * 
 * @author (Junaid Khan) 
 * @version (2-2-2019)
 */
import java.util.*;
import edu.duke.*;

public class MatchAllFilter implements Filter {
    private ArrayList<Filter> filters;
    
    public MatchAllFilter(){
        filters = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter f_temp){
        filters.add(f_temp);
    }
    
    public boolean satisfies(QuakeEntry qe){
        for(Filter f : filters){
            if(!f.satisfies(qe)){
                return false;
            }
        }
        return true;
    }
    
    public String getName(){
        String name = "";
        for(Filter f : filters){
            name = name + f.getName() + " ";
        }
        return name;
    }
}
