package tasks.three.a;

/** Студент */
public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int birthYear;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    /** Пустой конструктор */
    public Student() {
        this.address = "-";
        this.phone = "-";
    }

    /** Конструктор без адреса и телефона */
    public Student(int id, String lastName, String firstName, String middleName, int birthYear,
                   String faculty, int course, String group) {
        this();
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    /** Конструктор со всеми полями */
    public Student(int id, String lastName, String firstName, String middleName, int birthYear,
                   String address, String phone, String faculty, int course, String group) {
        this(id, lastName, firstName, middleName, birthYear, faculty, course, group);
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return id + ". " + lastName + " " + firstName + " " + middleName
                + ", " + birthYear + " г.р., адрес: " + address + ", тел.: " + phone
                + ", " + faculty + ", " + course + " курс, группа " + group;
    }
}
