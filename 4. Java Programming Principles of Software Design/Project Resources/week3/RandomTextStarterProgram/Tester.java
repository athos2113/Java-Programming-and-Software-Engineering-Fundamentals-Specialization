
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class Tester {
    
    public void testGetFollows(){
        FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	//String st = "this is a test yes this is a test.";
	MarkovOne markov = new MarkovOne();
	markov.setTraining(st);
	ArrayList<String> word = markov.getFollows("th");
	System.out.println(word);
	System.out.println("Size of the ArrayList is = " + word.size());
    }
    
    public void testGetFollowsWithFile(){
        
        FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	MarkovOne markov = new MarkovOne();
	markov.setTraining(st);
	ArrayList<String> word = markov.getFollows("he");
	//System.out.println(word);
	System.out.println("Size of the ArrayList is = " + word.size());
    }

}
