package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.MapMenuChoice;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.domain.model.StudentDto;
import io.github.wilcywilson.crud.infrastructure.engine.*;
import io.github.wilcywilson.crud.shared.menu.MainOperations;
import io.github.wilcywilson.crud.shared.menu.MapOperations;
import io.github.wilcywilson.crud.shared.menu.MenuChoiceUtil;
import io.github.wilcywilson.crud.shared.menu.Operations;
import io.github.wilcywilson.crud.ui.ConsolePrompt;
import io.github.wilcywilson.crud.ui.MenuCreator;
import io.github.wilcywilson.crud.ui.UiText;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class MapMain implements MainOperations {
    private final String additionalInfo;

    public MapMain(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        while (true) {
            MenuCreator.createMenu(out, Menu.MAP_STORAGE_ENGINE, additionalInfo);

            int input = ConsolePrompt.prompt(scanner, out, UiText.ENTER_YOUR_CHOICE.getMessage(), Integer::parseInt);

            MapMenuChoice mapMenuChoice = MenuChoiceUtil.fromCode(MapMenuChoice.class, input)
                                                        .orElse(MapMenuChoice.INVALID_SELECTION);

            if (mapMenuChoice == MapMenuChoice.EXIT) {
                out.println(UiText.BACK_TO_MAIN.getMessage());
                return LoopStatus.CONTINUE;
            }

            if (mapMenuChoice == MapMenuChoice.INVALID_SELECTION) {
                out.println(UiText.INVALID_SELECTION.getMessage());
                continue;
            }

            MapOperations mapOperations = createListOperation(mapMenuChoice);

            if (mapOperations.run(scanner, out) == LoopStatus.EXIT) {
                return LoopStatus.EXIT;
            }
        }
    }

    private MapOperations createListOperation(MapMenuChoice mapMenuChoice) {
        return switch (mapMenuChoice) {
            case HASHMAP -> new HashMapStorageEngine(mapMenuChoice.getDisplayName());
            case LINKED_HASHMAP -> new LinkedHashMapStorageEngine(mapMenuChoice.getDisplayName());
            case TREEMAP ->  new TreeMapStorageEngine(mapMenuChoice.getDisplayName());
            default -> throw new IllegalStateException("Unreachable" + mapMenuChoice);
        };
    }

//    public static void insertHashMap() {
//        Scanner sId = new Scanner(System.in);
//        Scanner sName = new Scanner(System.in);
//        Scanner sFaculty = new Scanner(System.in);
//        System.out.println("Enter Student Id :");
//        int studentId = sId.nextInt();
//        System.out.println("Enter Student Name :");
//        String studentName = sName.nextLine();
//        System.out.println("Enter Student Faculty :");
//        String studentFaculty = sFaculty.nextLine();
//        al.put(studentId, new StudentDto(studentId, studentName, studentFaculty));
//    }
//
//    public static void displayHashMap() {
//        "-".repeat(20);
//        for (Map.Entry m : al.entrySet()) {
//            System.out.println(m.getValue());
//        }
//        "-".repeat(20);
//    }
//
//    public static void searchHashMap() {
//        boolean found = false;
//        Scanner sId = new Scanner(System.in);
//        System.out.println("Enter Student Id to Search:");
//        int studentId = sId.nextInt();
//        "-".repeat(20);
//        if (al.containsKey(studentId)) {
//            System.out.println(al.get(studentId));
//            found = true;
//        }
//        if (!found) {
//            System.out.println("Record Not Found");
//        }
//        "-".repeat(20);
//    }
//
//    public static void deleteHashMap() {
//        boolean found = false;
//        Scanner sId = new Scanner(System.in);
//        System.out.println("Enter Student Id to Delete:");
//        int studentId = sId.nextInt();
//        "-".repeat(20);
//        if (al.containsKey(studentId)) {
//            al.remove(studentId);
//            found = true;
//        }
//        if (!found) {
//            System.out.println("Record Not Found");
//        } else {
//            System.out.println("Record Found and Deleted Successfully");
//        }
//        "-".repeat(20);
//    }
//
//    public static void updateHashMap() {
//        boolean found = false;
//        Scanner sId = new Scanner(System.in);
//        Scanner sName = new Scanner(System.in);
//        Scanner sFaculty = new Scanner(System.in);
//        System.out.println("Enter Student Id to Update:");
//        int studentId = sId.nextInt();
//        "-".repeat(20);
//        if (al.containsKey(studentId)) {
//            System.out.println("Enter new Student Name :");
//            String studentName = sName.nextLine();
//            System.out.println("Enter new Student Faculty :");
//            String studentFaculty = sFaculty.nextLine();
//            al.replace(studentId, new StudentDto(studentId, studentName, studentFaculty));
//            found = true;
//        }
//        if (!found) {
//            System.out.println("Record Not Found");
//        } else {
//            System.out.println("Record Updated Successfully");
//        }
//        "-".repeat(20);
//    }
}
