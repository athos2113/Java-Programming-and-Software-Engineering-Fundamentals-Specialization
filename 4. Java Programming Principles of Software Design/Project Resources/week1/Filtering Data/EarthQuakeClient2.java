import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        //Filter f = new MinMagFilter(4.0);
        Filter f = new MagnitudeFilter(3.5, 4.5);
        ArrayList<QuakeEntry> answer = filter(list, f);
        
        f = new DepthFilter(-55000.0,-20000.0 );
        answer = filter(list, f);
        
        //Location Denver = new Location(39.7392, -104.9903);
        //float max_dist = 10000000;
        
        //Filter f = new DistanceFilter(Denver, max_dist);
        //ArrayList<QuakeEntry> answer = filter(list, f);
        
        //f = new PhraseFilter("end", "a");
        //answer = filter(list, f);
        
        //ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: answer) { 
            System.out.println(qe);
        }
        System.out.println("Found " + answer.size() + " earthquakes ");
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }
    
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
        
        MatchAllFilter maf =  new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(0.0,5.0);
        //Filter f2 = new DepthFilter(-180000.0,-30000.0);
        Location Billund = new Location(55.7308, 9.1153);
        Filter f2 = new DistanceFilter(Billund, 3000000);
        Filter f3 = new PhraseFilter("any", "e");
        maf.addFilter(f1);
        maf.addFilter(f2);
        maf.addFilter(f3);
        
        ArrayList<QuakeEntry> answer = filter(list, maf);
        for(QuakeEntry qe : answer){
            System.out.println(qe);
        }
        
        System.out.println("Found " + answer.size() + " earthquakes ");
        System.out.println("Filters used are: " + maf.getName());
    }
}
