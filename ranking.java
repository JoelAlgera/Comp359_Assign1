import java.util.ArrayList;

public class ranking {
public static void main(String[] args) {
    ArrayList<entry> entries = new ArrayList<>();
    entries.add(new entry(150, 2, "bob", "Dr. Smith", "Algorithms 101", "Tech University", 5));
    entries.add(new entry(150, 2, "bob", "Dr. Smith", "Algorithms 101", "Tech University", 2));
    entries.add(new entry(150, 2, "bob", "Dr. Smith", "Algorithms 101", "Tech University", 50));
    entries.add(new entry(150, 2, "bob", "Dr. Smith", "Algorithms 101", "Tech University", 10));
    entries.add(new entry(150, 2, "bob", "Dr. Smith", "Algorithms 101", "Tech University", 15));

    sort(entries);
    for (entry e : entries) {
        System.out.println(e.toString());
    }

}

    static void sort(ArrayList<entry> list){
        int n = list.size();
        for (int i = 1; i < n - 1; i++) {
            entry key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).universityRank > key.universityRank) {
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
    int universityRank;

    public entry(int slides, int textbookCount, String textbooks, String professorName, String courseName, String universityName, int universityRank) {
        this.slides = slides;
        this.textbookCount = textbookCount;
        this.textbooks = textbooks;
        this.professorName = professorName;
        this.courseName = courseName;
        this.universityName = universityName;
        this.universityRank = universityRank;
    }

    public String toString() {
        return "Course: " + courseName + ", Professor: " + professorName + ", University: " + universityName + " (Rank: " + universityRank + "), Slides: " + slides + ", Textbooks: " + textbookCount;
    } 
}
