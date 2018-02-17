
public class Class {
    
    private int number;
    private String names;
    private String[] preRequired;

    
    public Class(int numCredits, String name, String[] prereqs) {
        
        number = numCredits;
        names = name;
        preRequired = prereqs;
    }
    
    
    public int getNumberOfCredits() {
        return number;
    }
    
    public String getName() {
        return names;
        
    }
    
    public String[] getPrereqs() {
        return preRequired;
    }
    
}

