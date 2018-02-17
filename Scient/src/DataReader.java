package src;
import java.io.FileNotFoundException;

public class DataReader {
    
    
    
    public DataReader(String checkSheetFileName)
        throws FileNotFoundException {
        
        if (checkSheetFileName == null) {
            throw new IllegalArgumentException();
        }
    }
    
    
    /**
     * data structure to be implemented will be how we manage the classes
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public dataStructure readData(String fileName)
        throws FileNotFoundException {
        
        if (fileName == null) {
            throw new FileNotFoundException();
        }
    }

}



