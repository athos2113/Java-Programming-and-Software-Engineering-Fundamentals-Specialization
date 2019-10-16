
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{
    
    
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String t1 = q1.getInfo();
        String t2 = q2.getInfo();
        String title1 = t1.substring(t1.lastIndexOf(" ")+1);
        String title2 = t2.substring(t2.lastIndexOf(" ")+1); 
        int value = title1.compareTo(title2);
        if(value == 0){
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return value;
    }
}
