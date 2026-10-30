package tasks.three.a;

import java.util.Scanner;

/** Вариант A, задание 1: массив студентов и выборки по нему */
public class A {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Student[] students = {
                new Student(1, "Иванов", "Иван", "Иванович", 2005, "ул. Ленина, 1", "89001112233", "ФИТ", 2, "ИТ-21"),
                new Student(2, "Петров", "Петр", "Петрович", 2004, "ул. Мира, 5", "89002223344", "ФИТ", 3, "ИТ-31"),
                new Student(3, "Сидорова", "Анна", "Сергеевна", 2006, "ФИТ", 1, "ИТ-11"),
                new Student(4, "Кузнецов", "Олег", "Андреевич", 2005, "ФЭМ", 2, "ЭК-21"),
                new Student(5, "Смирнова", "Мария", "Олеговна", 2005, "ул. Садовая, 10", "89003334455", "ФИТ", 2, "ИТ-21"),
                new Student(6, "Попов", "Денис", "Игоревич", 2003, "ФЭМ", 4, "ЭК-41")
        };

        System.out.println("Все студенты:");
        printAll(students);

        System.out.println("Введите факультет (например ФИТ или ФЭМ):");
        String faculty = scanner.nextLine().trim();
        System.out.println("a) Студенты факультета " + faculty + ":");
        printByFaculty(students, faculty);

        System.out.println("b) Студенты по факультетам и курсам:");
        printByFacultyAndCourse(students);

        System.out.println("Введите год:");
        try {
            int year = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("c) Студенты, родившиеся после " + year + " года:");
            printBornAfter(students, year);
        } catch (NumberFormatException e) {
            System.out.println("Нужно ввести целое число");
        }

        System.out.println("Введите группу (например ЭК-41):");
        String group = scanner.nextLine().trim();
        System.out.println("d) Студенты группы " + group + ":");
        printByGroup(students, group);
    }

    public static void printAll(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    /** a) Список студентов заданного факультета */
    public static void printByFaculty(Student[] students, String faculty) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFaculty().equalsIgnoreCase(faculty)) {
                System.out.println(students[i]);
            }
        }
    }

    /** b) Списки студентов для каждого факультета и курса */
    public static void printByFacultyAndCourse(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            /** Проверяем, не выводили ли уже такой факультет и курс */
            boolean alreadyPrinted = false;
            for (int j = 0; j < i; j++) {
                if (students[j].getFaculty().equals(students[i].getFaculty())
                        && students[j].getCourse() == students[i].getCourse()) {
                    alreadyPrinted = true;
                }
            }
            if (alreadyPrinted) {
                continue;
            }

            System.out.println(students[i].getFaculty() + ", " + students[i].getCourse() + " курс:");
            for (int j = i; j < students.length; j++) {
                if (students[j].getFaculty().equals(students[i].getFaculty())
                        && students[j].getCourse() == students[i].getCourse()) {
                    System.out.println("  " + students[j]);
                }
            }
        }
    }

    /** c) Список студентов, родившихся после заданного года */
    public static void printBornAfter(Student[] students, int year) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getBirthYear() > year) {
                System.out.println(students[i]);
            }
        }
    }

    /** d) Список учебной группы */
    public static void printByGroup(Student[] students, String group) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGroup().equalsIgnoreCase(group)) {
                System.out.println(students[i]);
            }
        }
    }
}
