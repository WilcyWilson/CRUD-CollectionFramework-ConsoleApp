package io.github.wilcywilson.crud.crudlogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import io.github.wilcywilson.crud.dto.StudentDto;
import io.github.wilcywilson.crud.entrypoint.MenuCreator;
import io.github.wilcywilson.crud.enums.ListMenuChoice;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.enums.Menu;
import io.github.wilcywilson.crud.interfaces.ListOperations;
import io.github.wilcywilson.crud.interfaces.MainOperations;
import io.github.wilcywilson.crud.utils.InputUtil;

public class ListMain implements MainOperations {
    static List<StudentDto> studentDtoArrayList = new ArrayList<>();
    private final String additionalInfo;

    public ListMain(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public void storageEngineLoop(Scanner scanner) {
        int input;
        do {
            MenuCreator.createMenu(Menu.LIST_STORAGE_ENGINE, additionalInfo);
            input = InputUtil.prompt(scanner, "Enter Your Choice : ", Integer::parseInt);

            switch (input) {
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
        } while (input != 0);
    }

    private static ListOperations selectList(int input) {
        ListMenuChoice listMenuChoice = ListMenuChoice.choiceFromInteger(input).orElse(ListMenuChoice.UNKNOWN);

        return switch (listMenuChoice) {
            case UNKNOWN -> new UnknownStorageEngine();
            case EXIT -> new ExitStorageEngine();
            case ARRAYLIST -> new ArrayListStorageEngine(listMenuChoice.name());
            case LINKED_LIST -> new LinkedListStorageEngine(listMenuChoice.name());
        };
    }

//    public void storageEngineLoop(Scanner scanner) {
//        int ch;
//        do {
//            MenuCreator.createMenu(Menu.CRUD, additionalInfo);
//            ch = InputUtil.prompt(scanner, "Enter Your Choice : ", Integer::parseInt);
//
//            switch (ch) {
//                case 1:
//                    System.out.println();
//                    insertList(scanner);
//                    System.out.println();
//                    break;
//                case 2:
//                    System.out.println();
//                    displayList();
//                    System.out.println();
//                    break;
//                case 3:
//                    System.out.println();
//                    searchList(scanner);
//                    System.out.println();
//                    break;
//                case 4:
//                    System.out.println();
//                    deleteList(scanner);
//                    System.out.println();
//                    break;
//                case 5:
//                    System.out.println();
//                    updateList(scanner);
//                    System.out.println();
//                    break;
//            }
//        } while (ch != 0);
//    }


    public static void insertList(Scanner scanner) {
        int studentId = InputUtil.prompt(scanner, "Enter Student Id : ", Integer::parseInt);
        String studentName = InputUtil.prompt(scanner, "Enter Student Name : ", s -> s);
        System.out.print("Enter Student Faculty : ");
        String studentFaculty = scanner.nextLine();
        studentDtoArrayList.add(new StudentDto(studentId, studentName, studentFaculty));
    }

    public static void displayList() {
        "-".repeat(20);
        Iterator<StudentDto> itr = studentDtoArrayList.iterator();
        while (itr.hasNext()) {
            StudentDto student = itr.next();
            System.out.println(student);
        }
        "-".repeat(20);
    }

    public static void searchList(Scanner scanner) {
        boolean found = false;

        int studentId = InputUtil.prompt(scanner, "Enter Student Id to Search : ", Integer::parseInt);
        "-".repeat(20);
        Iterator<StudentDto> itr = studentDtoArrayList.iterator();
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
        int studentId = InputUtil.prompt(scanner, "Enter Student Id to Delete : ", Integer::parseInt);
        "-".repeat(20);
        Iterator<StudentDto> itr = studentDtoArrayList.iterator();
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
        int studentId = InputUtil.prompt(scanner, "Enter Student Id to Update : ", Integer::parseInt);
        "-".repeat(20);
        ListIterator<StudentDto> itr = studentDtoArrayList.listIterator();
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
