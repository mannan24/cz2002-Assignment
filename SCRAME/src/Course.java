
public class Course {

    // Single Responsibility: to store and retrieve course information

    private int courseID;
    private String courseName;
    private String professorName;
    private int capacity;
    private int vacancies;

    private double examWeight;
    private double[] courseworkWeight;
    private int numberOfCoursework;

    private int numLectures;
    private int numTutorials;
    private int numLabs;

    private Lesson[] lectures;
    private Lesson[] tutorials;
    private Lesson[] labs;



    private boolean readyForRegistration = false;

    public Course (String courseName,  String professorName, int capacity, int numLectures, int numTutorials, int numbLabs, int courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.professorName = professorName;
        this.capacity = capacity;
        this.vacancies = capacity;
        setLessons(numLectures, numTutorials, numbLabs);
    }

    //Getters
    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public int getNumLectures() {
        return numLectures;
    }

    public int getNumTutorials() {
        return numTutorials;
    }

    public int getNumLabs() {
        return numLabs;
    }

    //Setters
    public void setComponentWeightage(double examWeight, double[] courseworkWeight){
        this.examWeight = examWeight;
        this.courseworkWeight = courseworkWeight;
        this.numberOfCoursework = courseworkWeight.length;
    }

    private void setLessons(int numLectures, int numTutorials, int numLabs){
        if(numLectures > 0) {
            this.lectures = new Lesson[numLectures];
            for (int i = 0; i < numLectures; i++) {
                int lessonCapacity = capacity/numLectures;
                if (i == 0) {
                    lessonCapacity += capacity%numLectures;
                }
                lectures[i] = new Lesson(i, lessonCapacity);
            }
        }
        if(numTutorials > 0) {
            this.tutorials = new Lesson[numTutorials];
            for (int i = 0; i < numTutorials; i++) {
                int lessonCapacity = capacity/numTutorials;
                if (i == 0) {
                    lessonCapacity += capacity%numTutorials;
                }
                tutorials[i] = new Lesson(i, lessonCapacity);
            }
        }
        if(numLabs > 0) {
            this.labs = new Lesson[numLabs];
            for (int i = 0; i < numLabs; i++) {
                int lessonCapacity = capacity/numLabs;
                if (i == 0) {
                    lessonCapacity += capacity%numLabs;
                }
                labs[i] = new Lesson(i, lessonCapacity);
            }
        }
    }

    //Verifiers
    public boolean isReadyForRegistration(){
        readyForRegistration = isCourseComponentsValid();
        return readyForRegistration;
    }

    private boolean isCourseComponentsValid(){
        if(examWeight != 0 && courseworkWeight != null && numberOfCoursework >= 0){
            return true;
        } else {
            return false;
        }
    }
}
