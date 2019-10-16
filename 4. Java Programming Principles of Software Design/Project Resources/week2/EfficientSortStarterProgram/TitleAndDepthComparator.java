
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author (Junaid Khan) 
 * @version (2-3-2019)
 */
import java.util.*;
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String title1 = q1.getInfo();
        String title2 = q2.getInfo();
        if(title1.compareTo(title2) < 0){
            return -1;
        }
        if(title1.compareTo(title2) > 0){
            return 1;
        }
        
        double d1 = q1.getDepth();
        double d2 = q2.getDepth();
        if(d1 - d2 < 0){
            return -1;
        }
        if(d1 - d2 > 0){
            return 1;
        }
        return 0;
    }

}
