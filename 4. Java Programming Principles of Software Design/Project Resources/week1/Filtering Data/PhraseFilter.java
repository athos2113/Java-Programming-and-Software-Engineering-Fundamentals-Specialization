
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    private String request;
    private String phrase;
    private String name;
    
    public PhraseFilter(String requestSent, String phraseSent){
        request = requestSent;
        phrase = phraseSent;
        name = "PhraseFilter";
    }
    
    public boolean satisfies(QuakeEntry qe){
            String title = qe.getInfo();
            
            if(request.equals("start") && title.startsWith(phrase)){
                return true;
            }
            
            else if(request.equals("end") && title.endsWith(phrase)){
                return true;
            }
            
            else if(request.equals("any") && title.contains(phrase)){
                return true;
            }
        
        
        return false;
    
    }
    
    public String getName(){
        return name;
    }
}
