package tma.hibernate.configspring;

import java.util.HashSet;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tma.hibernate.configspring.entity.*;
import tma.hibernate.configspring.util.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// Call Spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Scanner scanner = new Scanner(System.in);
		ManagerStudent MStudent = (ManagerStudent) context.getBean("managerStudent");


		while (true) {
			System.out.println("----------------------------------------------------------------------");
            System.out.println("************************** MANAGER STUDENTS **************************");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Press 1: Insert student");
			System.out.println("Press 2: Update student");
			System.out.println("Press 3: Delete student");
            System.out.println("Press 4: Students list");
            System.out.println("Press 5: Search max GPA");
            System.out.println("Press 6: Search min GPA");
            System.out.println("Press 0: Exit");
            System.out.print("Key Press: ");
			String line = scanner.nextLine();

			switch (line) {
				case "1": {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("*************************** INSERT STUDENT ***************************");
					System.out.println("----------------------------------------------------------------------");
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

					for (int i=0; i<m; i++) {
						System.out.print("-------Student " + i + "-------\n");
						System.out.print("Enter name: ");
						String student_name = scanner.nextLine();

						System.out.print("Enter year of birth: ");
						String year_of_birth = scanner.nextLine();

						System.out.print("Enter gender: ");
						String gender;

						System.out.println("1: Male | 2: Female | 3: Other");
						String gen = scanner.nextLine();
						while (!(gen.equals("1") || gen.equals("2") || gen.equals("3"))){
							System.out.println("------------------------");
							System.out.println("Invalid, please re-enter");
							System.out.println("1: Male | 2: Female | 3: Other");
							gen = scanner.nextLine();
						}
						
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

						HashSet<Subject> subjects = new HashSet<Subject>();
						for (int j=0; j<n; j++) {
							System.out.print("-------Subject " + j + "-------\n");
							System.out.print("Enter subject name: ");
							String subject_name = scanner.nextLine();

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
							
							subjects.add(new Subject(subject_name, mark));
						}

						MStudent.addStudent(student_name, year_of_birth, gender, subjects);
						System.out.println("\n");
					}

					MStudent.listStudent();
					break;
				}

				case "2": {
					System.out.println("---------------------------------------------------------------------");
					System.out.println("*************************** UPDATE STUDENT **************************");
					System.out.println("---------------------------------------------------------------------");
					MStudent.listStudent();

					System.out.print("Enter student ID: ");
					int student_id = scanner.nextInt();
					scanner.nextLine();

					boolean check_id = MStudent.findStudent(student_id);
					System.out.println(check_id);
					while (!check_id) {
						System.out.println("------------------------");
						System.out.println("Invalid, please re-enter");
						System.out.println("Student does not exist!!");
						System.out.print("Enter student ID: ");
						student_id = scanner.nextInt();
						scanner.nextLine();

						check_id = MStudent.findStudent(student_id);
					}

					System.out.print("Enter name: ");
						String student_name = scanner.nextLine();

						System.out.print("Enter year of birth: ");
						String year_of_birth = scanner.nextLine();

						System.out.print("Enter gender: ");
						String gender;

						System.out.println("1: Male | 2: Female | 3: Other");
						String gen = scanner.nextLine();
						while (!(gen.equals("1") || gen.equals("2") || gen.equals("3"))){
							System.out.println("------------------------");
							System.out.println("Invalid, please re-enter");
							System.out.println("1: Male | 2: Female | 3: Other");
							gen = scanner.nextLine();
						}
						
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

						HashSet<Subject> subjects = new HashSet<Subject>();
						for (int j=0; j<n; j++) {
							System.out.print("-------Subject " + j + "-------\n");
							System.out.print("Enter subject name: ");
							String subject_name = scanner.nextLine();

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
							
							subjects.add(new Subject(subject_name, mark));
						}

						MStudent.updateStudent(student_id, student_name, year_of_birth, gender, subjects);
						MStudent.listStudent();
					break;
				}

				case "3": {
					System.out.println("---------------------------------------------------------------------");
					System.out.println("*************************** DELETE STUDENT **************************");
					System.out.println("---------------------------------------------------------------------");
					
					System.out.print("Enter student ID: ");
					int student_id = scanner.nextInt();
					scanner.nextLine();

					boolean check_id = MStudent.findStudent(student_id);
					System.out.println(check_id);
					while (!check_id) {
						System.out.println("------------------------");
						System.out.println("Invalid, please re-enter");
						System.out.println("Student does not exist!!");
						System.out.print("Enter student ID: ");
						student_id = scanner.nextInt();
						scanner.nextLine();
						
						check_id = MStudent.findStudent(student_id);
					}

					MStudent.deleteStudent(student_id);
					MStudent.listStudent();
					
					break;
				}

				case "4": {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("*************************** STUDENTS LIST ****************************");
					System.out.println("----------------------------------------------------------------------");
					MStudent.listStudent();
					break;
				}

				case "5": {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("************************ STUDENTS HAS MAX GPA ************************");
					System.out.println("----------------------------------------------------------------------");
					MStudent.maxGPA();
					break;
				}

				case "6": {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("************************ STUDENTS HAS MIN GPA ************************");
					System.out.println("----------------------------------------------------------------------");
					MStudent.minGPA();
					break;
				}

				case "0": {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("******************************* CLOSE ********************************");
					System.out.println("----------------------------------------------------------------------");
					scanner.close();
					return;
				}

				default:
					System.out.println("Invalid");
					continue;
			}
		}
	}
}
