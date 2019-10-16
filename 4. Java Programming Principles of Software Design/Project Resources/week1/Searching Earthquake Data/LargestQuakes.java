
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (Junaid Khan) 
 * @version (1-31-2019)
 */
import java.util.*;
import edu.duke.*;
public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        //for(QuakeEntry qe : list){
        //    System.out.println(qe);
        //}
        System.out.println("read data for " + list.size() + " quakes");
        
        //int indexOfLargest = indexOfLargest(list);
        //System.out.println("Location " + indexOfLargest);
        ArrayList<QuakeEntry> LargestQuake = getLargest(list, 50);
        for(QuakeEntry qe : LargestQuake){
            System.out.println(qe);
        }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int largest = 0;
        double max_mag = 0.0;
        for(QuakeEntry qe : data){
            if(qe.getMagnitude() > max_mag){
                max_mag = qe.getMagnitude();
                largest = data.indexOf(qe);
            }
        }
        System.out.println("Largest Magnitute is = " + max_mag);
        return largest;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = quakeData;
        
        while(answer.size() < howMany || copy.size() == 0){
            int index = indexOfLargest(copy);
            answer.add(copy.get(index));
            copy.remove(index);
        }
        
        
        return answer;
    }
}
