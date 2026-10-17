package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.infrastructure.engine.ArrayListStorageEngine;
import io.github.wilcywilson.crud.infrastructure.engine.LinkedListStorageEngine;
import io.github.wilcywilson.crud.ui.MenuCreator;
import io.github.wilcywilson.crud.domain.enums.ListMenuChoice;
import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.ui.UiText;
import io.github.wilcywilson.crud.shared.interfaces.MainOperations;
import io.github.wilcywilson.crud.shared.interfaces.Operations;
import io.github.wilcywilson.crud.ui.InputUtil;

import java.io.PrintStream;
import java.util.Scanner;

public class ListMain implements MainOperations {
    private final String additionalInfo;

    public ListMain(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        while (true) {
            MenuCreator.createMenu(out, Menu.LIST_STORAGE_ENGINE, additionalInfo);

            int input = InputUtil.prompt(scanner, out, UiText.ENTER_YOUR_CHOICE.getMessage(), Integer::parseInt);

            ListMenuChoice listMenuChoice = ListMenuChoice.choiceFromInteger(input).orElse(ListMenuChoice.UNKNOWN);

            if (listMenuChoice == ListMenuChoice.EXIT) {
                out.println(UiText.BACK_TO_MAIN.getMessage());
                return LoopStatus.CONTINUE;
            }

            if (listMenuChoice == ListMenuChoice.UNKNOWN) {
                out.println(UiText.INVALID_SELECTION.getMessage());
                continue;
            }

            String listMenuChoiceName = listMenuChoice.getName();

            Operations listOperations = switch (listMenuChoice) {
                case ARRAYLIST -> new ArrayListStorageEngine(listMenuChoiceName);
                case LINKED_LIST -> new LinkedListStorageEngine(listMenuChoiceName);
                default -> throw new IllegalStateException("Unreachable" + listMenuChoiceName);
            };

            if (listOperations.run(scanner, out) == LoopStatus.EXIT) {
                return LoopStatus.EXIT;
            }
        }
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


//    public static void insertList(Scanner scanner) {
//        int studentId = InputUtil.prompt(scanner, "Enter Student Id : ", Integer::parseInt);
//        String studentName = InputUtil.prompt(scanner, "Enter Student Name : ", s -> s);
//        System.out.print("Enter Student Faculty : ");
//        String studentFaculty = scanner.nextLine();
//        studentDtoArrayList.add(new StudentDto(studentId, studentName, studentFaculty));
//    }
//
//    public static void displayList() {
//        "-".repeat(20);
//        Iterator<StudentDto> itr = studentDtoArrayList.iterator();
//        while (itr.hasNext()) {
//            StudentDto student = itr.next();
//            System.out.println(student);
//        }
//        "-".repeat(20);
//    }
//
//    public static void searchList(Scanner scanner) {
//        boolean found = false;
//
//        int studentId = InputUtil.prompt(scanner, "Enter Student Id to Search : ", Integer::parseInt);
//        "-".repeat(20);
//        Iterator<StudentDto> itr = studentDtoArrayList.iterator();
//        while (itr.hasNext()) {
//            StudentDto student = itr.next();
//            if (student.studentId() == studentId) {
//                System.out.println("Record Found");
//                System.out.println(student);
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("Record Not Found");
//        }
//        "-".repeat(20);
//    }
//
//    public static void deleteList(Scanner scanner) {
//        boolean found = false;
//        int studentId = InputUtil.prompt(scanner, "Enter Student Id to Delete : ", Integer::parseInt);
//        "-".repeat(20);
//        Iterator<StudentDto> itr = studentDtoArrayList.iterator();
//        while (itr.hasNext()) {
//            StudentDto student = itr.next();
//            if (student.studentId() == studentId) {
//                itr.remove();
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("Record Not Found");
//        } else {
//            System.out.println("Record Found and Deleted Successfully");
//        }
//        "-".repeat(20);
//    }
//
//    public static void updateList(Scanner scanner) {
//        boolean found = false;
//        int studentId = InputUtil.prompt(scanner, "Enter Student Id to Update : ", Integer::parseInt);
//        "-".repeat(20);
//        ListIterator<StudentDto> itr = studentDtoArrayList.listIterator();
//        while (itr.hasNext()) {
//            StudentDto student = itr.next();
//            if (student.studentId() == studentId) {
//                System.out.println("Enter new Student Name :");
//                String studentName = scanner.nextLine();
//                System.out.println("Enter new Student Faculty :");
//                String studentFaculty = scanner.nextLine();
//                itr.set(new StudentDto(studentId, studentName, studentFaculty));
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("Record Not Found");
//        } else {
//            System.out.println("Record Updated Successfully");
//        }
//        "-".repeat(20);
//    }
}
