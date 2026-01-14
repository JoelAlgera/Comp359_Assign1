import java.util.ArrayList;

public class ranking {
public static void main(String[] args) {
    ArrayList<entry> entries = new ArrayList<>();
    entries.add(new entry(1030, 1, "Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne", "Marcel dall'Agnol, Maryam Hedayati, Kevin Wayne", "COS 226", "Princeton University", 24));
    entries.add(new entry(1505, 3, "Tim Roughgarden, Algorithms Illuminated, Volumes I, II, and III", "Mary Wootters", "CS161", "Stanford University", 17));
    entries.add(new entry(439, 1, "Introduction to Algorithms by Cormen, Leiserson, Rivest, and Stein", "Erik Demaine, Srini Devadas, Nancy Lynch", "Design and Analysis of Algorithms", "MIT", 24));
    sort(entries);


    for (int i = 0; i < entries.size(); i++) {
        System.out.println(entries.get(entries.size()-i-1).toString());
    }

}

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
        this.courseRank = (int)((slides/lectureCount) * textbookCount);
    }

    public String toString() {
        return("courseRank: " + courseRank);
        //return " (Rank: " + courseRank + "), Course: " + courseName + ", Professor: " + professorName + ", University: " + universityName +  ", Slides: " + slides + ", Textbooks: " + textbookCount;
    } 
}
