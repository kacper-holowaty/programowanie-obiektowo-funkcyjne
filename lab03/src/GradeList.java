import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> grades = new ArrayList<>();
    public void addGrade (double grade) {
        grades.add(grade);
    }
    public double calculateMean () {
        double sum = 0;
        int size = grades.size();
        if (size == 0) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            sum += grades.get(i);
        }
        return sum / size;
    }
    public double findHighestGrade () {
        int size = grades.size();
        if (size == 0) {
            return -1;
        }
        double theHighest = grades.get(0);
        for (int i = 1; i < size; i++) {
            if (grades.get(i) > theHighest) {
                theHighest = grades.get(i);
            }
        }
        return theHighest;
    }
    public double findLowestGrade () {
        int size = grades.size();
        if (size == 0) {
            return -1;
        }
        double theLowest = grades.get(0);
        for (int i = 1; i < size; i++) {
            if (grades.get(i) < theLowest) {
                theLowest = grades.get(i);
            }
        }
        return theLowest;
    }
}
