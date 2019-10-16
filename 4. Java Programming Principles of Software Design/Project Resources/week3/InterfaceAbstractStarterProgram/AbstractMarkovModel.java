
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int order;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    //abstract public String getRandomText(int numChars);
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key){
        ArrayList<String> answer = new ArrayList<String>();
        int pos = 0;
        while(true){
            int index = myText.indexOf(key,pos);
            int indexOfSuccessor = index + key.length();
            
            if(index == -1 || indexOfSuccessor >= myText.length()){
                break;
            }
            
            String successor = myText.substring(indexOfSuccessor, indexOfSuccessor +1);
            answer.add(successor);
            pos = index + 1;
        }
        
        return answer;
    }
    
    @Override
    public String toString(){
        return "MarkovModel of order : " + order;
    }
}
