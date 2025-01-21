import java.util.Objects;

public class Person
{
    /*
    String ID = "";
    String firstName = "";
    String lastName = "";
    String title = "";
    String rec = "";
    int YOB = 0;

    */
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getFullName()
    {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFormalName()
    {
        return this.getTitle() + " " + this.getFullName();
    }

    public String toCSV()
    {
        return this.getID() + ", " + this.getFirstName() + ", " + this.getLastName() + ", " + this.getTitle() + ", " + this.getYOB();
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YOB);
    }
}
