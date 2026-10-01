package io.github.wilcywilson.crud.crudlogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import io.github.wilcywilson.crud.dto.StudentDto;
import io.github.wilcywilson.crud.interfaces.CrudOperations;

public class ListCrud implements CrudOperations {
	static List<StudentDto> al = new ArrayList<StudentDto>();

	@Override
	public void crudLoop(Scanner scanner) {
		int ch;
		do {
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("3.SEARCH");
			System.out.println("4.DELETE");
			System.out.println("5.UPDATE");
			System.out.println("0.EXIT");
			System.out.println("Enter Your Choice : ");
			ch = scanner.nextInt();

			switch (ch) {
			case 1:
				System.out.println();
				insertList(scanner);
				System.out.println();
				break;
			case 2:
				System.out.println();
				displayList();
				System.out.println();
				break;
			case 3:
				System.out.println();
				searchList(scanner);
				System.out.println();
				break;
			case 4:
				System.out.println();
				deleteList(scanner);
				System.out.println();
				break;
			case 5:
				System.out.println();
				updateList(scanner);
				System.out.println();
				break;
			}
		} while (ch != 0);
	}

	public static void insertList(Scanner scanner) {
		System.out.println("Enter Student Id :");
		int studentId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Student Name :");
		String studentName = scanner.nextLine();
		System.out.println("Enter Student Faculty :");
		String studentFaculty = scanner.nextLine();
		al.add(new StudentDto(studentId, studentName, studentFaculty));
	}

	public static void displayList() {
		"-".repeat(20);
		Iterator<StudentDto> itr = al.iterator();
		while (itr.hasNext()) {
			StudentDto student = itr.next();
			System.out.println(student);
		}
		"-".repeat(20);
	}

	public static void searchList(Scanner scanner) {
		boolean found = false;
		System.out.println("Enter Student Id to Search:");
		int studentId = scanner.nextInt();
		"-".repeat(20);
		Iterator<StudentDto> itr = al.iterator();
		while (itr.hasNext()) {
			StudentDto student = itr.next();
			if (student.studentId() == studentId) {
				System.out.println("Record Found");
				System.out.println(student);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Record Not Found");
		}
		"-".repeat(20);
	}

	public static void deleteList(Scanner scanner) {
		boolean found = false;
		System.out.println("Enter Student Id to Delete:");
		int studentId = scanner.nextInt();
		"-".repeat(20);
		Iterator<StudentDto> itr = al.iterator();
		while (itr.hasNext()) {
			StudentDto student = itr.next();
			if (student.studentId() == studentId) {
				itr.remove();
				found = true;
			}
		}
		if (!found) {
			System.out.println("Record Not Found");
		} else {
			System.out.println("Record Found and Deleted Successfully");
		}
		"-".repeat(20);
	}

	public static void updateList(Scanner scanner) {
		boolean found = false;
		System.out.println("Enter Student Id to Update:");
		int studentId = scanner.nextInt();
		"-".repeat(20);
		ListIterator<StudentDto> itr = al.listIterator();
		while (itr.hasNext()) {
			StudentDto student = itr.next();
			if (student.studentId() == studentId) {
				System.out.println("Enter new Student Name :");
				String studentName = scanner.nextLine();
				System.out.println("Enter new Student Faculty :");
				String studentFaculty = scanner.nextLine();
				itr.set(new StudentDto(studentId, studentName, studentFaculty));
				found = true;
			}
		}
		if (!found) {
			System.out.println("Record Not Found");
		} else {
			System.out.println("Record Updated Successfully");
		}
		"-".repeat(20);
	}
}
