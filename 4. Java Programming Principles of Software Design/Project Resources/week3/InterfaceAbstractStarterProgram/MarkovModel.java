
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class MarkovModel extends AbstractMarkovModel {
    
    //private String myText;
    //private Random myRandom;
    private int N;
    
    public MarkovModel(int num) {
        myRandom = new Random();
        N = num;
        order = num;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-N);
        String key = myText.substring(index, index + N);
        sb.append(key);
        
        for(int k = 0; k < numChars - N; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
            }
            
            index = myRandom.nextInt(follows.size());
            String successor = follows.get(index);
            sb.append(successor);
            key = key.substring(key.length() - (N -1)) + successor;
        }
        
        return sb.toString();
    }
    

}
