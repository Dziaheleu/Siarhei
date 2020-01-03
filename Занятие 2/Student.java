public class Student extends Person {
    private String name, gender;

    Student(String faculty, String name, String gender) {
        super(name, gender);
        this.faculty = faculty;
    }

    protected void getInfo() {
        System.out.println("Faculty " + faculty + ", Student " + name + ", Gender " + gender);
    }
    private String getGender() {
        return gender;
    }
}