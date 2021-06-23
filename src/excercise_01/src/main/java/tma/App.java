package tma;

import java.util.Scanner;

public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ManagerStudent student_list = new ManagerStudent();

        while (true) {
            System.out.println("-------------------------------");
            System.out.println("********MANAGER STUDENT********");
            System.out.println("-------------------------------");
            System.out.println("Press 1: Insert student");
            System.out.println("Press 2: Show information student");
            System.out.println("Press 3: Search max GPA");
            System.out.println("Press 4: Search min GPA");
            System.out.println("Press 5: Exit");
            System.out.print("Key Press: ");

            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("------------------------------");
                    System.out.println("********INSERT STUDENT********");
                    System.out.println("------------------------------");
                    System.out.print("Enter number student: ");
                    int m = scanner.nextInt();
                    scanner.nextLine();

                    while (m<1){
                        System.out.println("------------------------");
                        System.out.println("Invalid, please re-enter");
                        System.out.println("Number student must be greater than 0");
                        System.out.print("Enter number student: ");
                        m = scanner.nextInt();
                        scanner.nextLine();
                    }

                    Student[] students = new Student[m];

                    for (int i = 0; i < m; i++) {
                        System.out.print("-------Student " + i + "-------\n");

                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter id: ");
                        String id = scanner.nextLine();

                        System.out.print("Enter year of birth: ");
                        String year_of_birth = scanner.nextLine();

                        System.out.print("Enter gender: ");
                        String gender;

                        System.out.println("1: Male | 2: Female | 3: Other");
                        String gen = scanner.nextLine();

                        switch (gen) {
                            case "1": {
                                gender = "Male";
                                break;
                            }

                            case "2": {
                                gender = "Female";
                                break;
                            }

                            case "3": {
                                gender = "Other";
                                break;
                            }

                            default:
                                System.out.println("Invalid, please re-enter");
                            continue;
                        }
                        students[i] = new Student(name, id, year_of_birth, gender);
                        
                        System.out.print("Enter number subject: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();

                        while (n<1){
                            System.out.println("------------------------");
                            System.out.println("Invalid, please re-enter");
                            System.out.println("Number subject must be greater than 0");
                            System.out.print("Enter number subject: ");
                            n = scanner.nextInt();
                            scanner.nextLine();
                        }

                        Subject[] subjects = new Subject[n];
                        for (int j = 0; j < n; j++) {
                            System.out.print("-------Subject " + j + "-------\n");
                            System.out.print("Enter subject name: ");
                            String subject_name = scanner.nextLine();

                            System.out.print("Enter subject id: ");
                            String subject_id = scanner.nextLine();

                            System.out.println("Mark form 0 to 10");
                            System.out.print("Enter mark: ");
                            float mark = scanner.nextFloat();
                            scanner.nextLine();

                            while (mark<0 || mark>10){
                                System.out.println("------------------------");
                                System.out.println("Invalid, please re-enter");
                                System.out.println("Mark form 0 to 10");
                                System.out.print("Enter mark: ");
                                mark = scanner.nextFloat();
                                scanner.nextLine();
                            }

                            subjects[j] = new Subject(subject_name, subject_id, mark);
                            students[i].addSubject(subjects[j]);
                        }

                        students[i].calculateGPA();
                        System.out.println("---------------------------");
                        System.out.println(students[i].toString());

                        student_list.addStudent(students[i]);
                    }

                    break;
                }

                case "2": {
                    System.out.println("-------------------------------");
                    System.out.println("******INFORMATION STUDENT******");
                    System.out.println("-------------------------------");
                    student_list.showStudents();
                    break;
                }

                case "3": {
                    System.out.println("------------------------------");
                    System.out.println("*****STUDENTS HAS MAX GPA*****");
                    System.out.println("------------------------------");
                    student_list.maxGPA();
                    break;
                }

                case "4": {
                    System.out.println("------------------------------");
                    System.out.println("*****STUDENTS HAS MIN GPA*****");
                    System.out.println("------------------------------");
                    student_list.minGPA();
                    break;
                }

                case "5": {
                    return;
                }

                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
