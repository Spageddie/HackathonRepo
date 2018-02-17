
public class Checksheet {
    
    private LinkedList<Class> listOfClasses;
    private int hours;
    private String nameOfMajor;
    
    public Checksheet(LinkedList<Class> classes, int totalHours, String name) {
        listOfClasses = classes;
        hours = totalHours;
        nameOfMajor = name;
    }

    /**
     * added this
     * @return
     */
    public LinkedList<Class> getListOfClasses() {
        return listOfClasses;
    }
    
    public int getNumberOfHours() {
        return hours;
    }
    
    public String getName() {
        return nameOfMajor;
    }
    
    /**
     * adding stuff
     * @param currentHoursTaken
     * @return
     */
    public int getRemainingNumberOfCreditHours(int currentHoursTaken) {
        return hours - currentHoursTaken;
    }
    
    
    public LinkedList<Class> determineClassesNotTaken(LinkedList<Class> classesTaken) {
        for (int i = 0; i < listOfClasses.size(); i++) {
            Class curr = classesTaken.get(i);
            if (listOfClasses.contains(curr)) {
                listOfClasses.remove(curr);
            }
        }
        return listOfClasses;
    }
}


