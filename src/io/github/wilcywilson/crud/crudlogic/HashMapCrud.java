package io.github.wilcywilson.crud.crudlogic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import io.github.wilcywilson.crud.dto.StudentDto;
import io.github.wilcywilson.crud.interfaces.CrudOperations;
import io.github.wilcywilson.crud.utils.InputUtil;

public class HashMapCrud implements CrudOperations {
    static HashMap<Integer, StudentDto> al = new HashMap<>();

    @Override
    public String crudMenu() {
        return """
                ------ HashMap Menu ------
                1.INSERT
                2.DISPLAY
                3.SEARCH
                4.DELETE
                5.UPDATE
                0.EXIT
                
                """;
    }

    @Override
    public void crudMainLoop(Scanner scanner) {
        int ch;
        do {
            System.out.print(crudMenu());
            ch = InputUtil.readInt(scanner, "Enter Your Choice : ");

            switch (ch) {
                case 1:
                    System.out.println();
                    insertHashMap();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    displayHashMap();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    searchHashMap();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    deleteHashMap();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    updateHashMap();
                    System.out.println();
                    break;
            }
        } while (ch != 0);
    }

    public static void insertHashMap() {
        Scanner sId = new Scanner(System.in);
        Scanner sName = new Scanner(System.in);
        Scanner sFaculty = new Scanner(System.in);
        System.out.println("Enter Student Id :");
        int studentId = sId.nextInt();
        System.out.println("Enter Student Name :");
        String studentName = sName.nextLine();
        System.out.println("Enter Student Faculty :");
        String studentFaculty = sFaculty.nextLine();
        al.put(studentId, new StudentDto(studentId, studentName, studentFaculty));
    }

    public static void displayHashMap() {
        "-".repeat(20);
        for (Map.Entry m : al.entrySet()) {
            System.out.println(m.getValue());
        }
        "-".repeat(20);
    }

    public static void searchHashMap() {
        boolean found = false;
        Scanner sId = new Scanner(System.in);
        System.out.println("Enter Student Id to Search:");
        int studentId = sId.nextInt();
        "-".repeat(20);
        if (al.containsKey(studentId)) {
            System.out.println(al.get(studentId));
            found = true;
        }
        if (!found) {
            System.out.println("Record Not Found");
        }
        "-".repeat(20);
    }

    public static void deleteHashMap() {
        boolean found = false;
        Scanner sId = new Scanner(System.in);
        System.out.println("Enter Student Id to Delete:");
        int studentId = sId.nextInt();
        "-".repeat(20);
        if (al.containsKey(studentId)) {
            al.remove(studentId);
            found = true;
        }
        if (!found) {
            System.out.println("Record Not Found");
        } else {
            System.out.println("Record Found and Deleted Successfully");
        }
        "-".repeat(20);
    }

    public static void updateHashMap() {
        boolean found = false;
        Scanner sId = new Scanner(System.in);
        Scanner sName = new Scanner(System.in);
        Scanner sFaculty = new Scanner(System.in);
        System.out.println("Enter Student Id to Update:");
        int studentId = sId.nextInt();
        "-".repeat(20);
        if (al.containsKey(studentId)) {
            System.out.println("Enter new Student Name :");
            String studentName = sName.nextLine();
            System.out.println("Enter new Student Faculty :");
            String studentFaculty = sFaculty.nextLine();
            al.replace(studentId, new StudentDto(studentId, studentName, studentFaculty));
            found = true;
        }
        if (!found) {
            System.out.println("Record Not Found");
        } else {
            System.out.println("Record Updated Successfully");
        }
        "-".repeat(20);
    }
}
