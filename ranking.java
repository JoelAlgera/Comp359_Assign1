import java.util.ArrayList;

public class ranking {
public static void main(String[] args) {    
    ArrayList<entry> entries = new ArrayList<>(); //Create an array list to hold entries
    //Add entries here, only relevant data is slide number, textbook count, and lecture count - The rest are for display purposes
    entries.add(new entry(1030, 1, "Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne", "Marcel dall'Agnol, Maryam Hedayati, Kevin Wayne", "COS 226", "Princeton University", 24));
    entries.add(new entry(1505, 3, "Tim Roughgarden, Algorithms Illuminated, Volumes I, II, and III", "Mary Wootters", "CS161", "Stanford University", 17));
    entries.add(new entry(439, 1, "Introduction to Algorithms by Cormen, Leiserson, Rivest, and Stein", "Erik Demaine, Srini Devadas, Nancy Lynch", "Design and Analysis of Algorithms", "MIT", 24));
    entries.add(new entry(1504, 1, "Algorithm Design by Jon Kleinberg and Éva Tardos", "Michael Kim", "CS 4820", "Cornell University", 41));
    entries.add(new entry(310, 1, "Algorithms - Sanjoy Dasgupta, Christos H. Papadimitriou, and Umesh V. Vazirani", "Sanjam Garg, John Wright", "CS 170", "UC Berkley", 25));
    entries.add(new entry(683, 1, " Algorithm Design by Jon Kleinberg and Éva Tardos", "Richard Anderson", "CSE 417", "University of Washington", 25));
    entries.add(new entry(1307, 2, "Algorithm Design by Jon Kleinberg and Éva Tardos | Algorithms/Thomas H. Cormen, Charles E. Leiserson, Ronald L Rivest, Clifford Stein Introduction to Algorithms, Third Edition  2009 | Algorithms - Sanjoy Dasgupta, Christos H. Papadimitriou, and Umesh V. Vazirani ", "Shahrokh Shahi", "CS 161", "Georgia Tech", 18));
    entries.add(new entry(236, 1, "Design and Analysis of Computer Algorithms, David M. Mount Department of Computer Science.", "David M. Mount", "CMSC 451", "U of Maryland", 21));
    entries.add(new entry(308, 1, "Introduction to Algorithms, by Cormen, Leiserson, Rivest, and Stein", "Jelani Nelson", "CS 125", "Harvard", 24));
    entries.add(new entry(965, 2, "1.\tData Structures, Algorithms, and Applications in C++, 2nd Edition, Sartaj Sahni | The art of Multiprocessor Programming by Maurice Herliky and Nir Shavit", "Yogesh Simmhan", "DS286", "Indian Institute of Science", 20));
    
    //Run insertion sort
    sort(entries);

    //Print sorted entries in descending order to put highest rank first
    for (int i = 0; i < entries.size(); i++) {
        System.out.println(entries.get(entries.size()-i-1).toString());
    }

}
    //Insertion sort function to sort entries based on course rank
    static void sort(ArrayList<entry> list){
        int n = list.size();
        for (int i = 1; i < n; i++) {
            entry key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).courseRank > key.courseRank) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
            }
        }
    }
 

    //Entry class to hold data for each course
class entry {
    int slides;
    int textbookCount;
    String textbooks;
    String professorName;
    String courseName;
    String universityName;
    int lectureCount;
    int courseRank;

    public entry(int slides, int textbookCount, String textbooks, String professorName, String courseName, String universityName, int lectureCount) {
        this.slides = slides;
        this.textbookCount = textbookCount;
        this.textbooks = textbooks;
        this.professorName = professorName;
        this.courseName = courseName;
        this.universityName = universityName;
        this.lectureCount = lectureCount;
        // Calculate the course rank based on our equation
        this.courseRank = (int)((slides/lectureCount) * textbookCount);
    }

    public String toString() {
        // Print out nice formatted version of relevant data
        return("courseRank: " + courseRank + " | " + courseName + " at " + universityName);
        //return " (Rank: " + courseRank + "), Course: " + courseName + ", Professor: " + professorName + ", University: " + universityName +  ", Slides: " + slides + ", Textbooks: " + textbookCount;
    } 
}
