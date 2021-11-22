package com.noob.coder.crudlogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.noob.coder.dto.StudentDto;

public class ListCrud {
	static List<StudentDto> al = new ArrayList<StudentDto>();
	
	public static void crudLoop() {
		Scanner s = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("3.SEARCH");
			System.out.println("4.DELETE");
			System.out.println("5.UPDATE");
			System.out.println("0.EXIT");
			System.out.println("Enter Your Choice : ");
			ch = s.nextInt();

			switch (ch) {
			case 1:
				insertList();
				break;
			case 2:
				displayList();
				break;
			case 3:
				searchList();
				break;
			case 4:
				deleteList();
				break;
			case 5:
				updateList();
				break;
			}
		} while (ch != 0);
	}

	public static void insertList() {
		Scanner sId = new Scanner(System.in);
		Scanner sName = new Scanner(System.in);
		Scanner sFaculty = new Scanner(System.in);
		System.out.println("Enter Student Id :");
		int studentId = sId.nextInt();
		System.out.println("Enter Student Name :");
		String studentName = sName.nextLine();
		System.out.println("Enter Student Faculty :");
		String studentFaculty = sFaculty.nextLine();
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

	public static void searchList() {
		boolean found = false;
		Scanner sId = new Scanner(System.in);
		System.out.println("Enter Employee Id to Search:");
		int studentId = sId.nextInt();
		"-".repeat(20);
		Iterator<StudentDto> itr = al.iterator();
		while (itr.hasNext()) {
			StudentDto student = itr.next();
			if (student.getStudentId() == studentId) {
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

	public static void deleteList() {
		boolean found = false;
		Scanner sId = new Scanner(System.in);
		System.out.println("Enter Employee Id to Delete:");
		int studentId = sId.nextInt();
		"-".repeat(20);
		Iterator<StudentDto> itr = al.iterator();
		while (itr.hasNext()) {
			StudentDto student = itr.next();
			if (student.getStudentId() == studentId) {
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

	public static void updateList() {
		boolean found = false;
		Scanner sId = new Scanner(System.in);
		Scanner sName = new Scanner(System.in);
		Scanner sFaculty = new Scanner(System.in);
		System.out.println("Enter Employee Id to Update:");
		int studentId = sId.nextInt();
		"-".repeat(20);
		ListIterator<StudentDto> itr = al.listIterator();
		while (itr.hasNext()) {
			StudentDto student = itr.next();
			if (student.getStudentId() == studentId) {
				System.out.println("Enter new Student Name :");
				String studentName = sName.nextLine();
				System.out.println("Enter new Student Faculty :");
				String studentFaculty = sFaculty.nextLine();
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
