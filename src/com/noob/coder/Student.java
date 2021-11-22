package com.noob.coder;

import java.util.Scanner;

import com.noob.coder.crudlogic.HashMapCrud;
import com.noob.coder.crudlogic.HashSetCrud;
import com.noob.coder.crudlogic.ListCrud;

public class Student {

	public static void main(String[] args) {
		chooseCollectionFramework();
	}

	public static void chooseCollectionFramework() {
		Scanner s = new Scanner(System.in);
		int ch = 0;

		System.out.println("1.List");
		System.out.println("2.HashSet");
		System.out.println("3.HashMap");
		System.out.println("Enter Your Choice : ");
		ch = s.nextInt();

		switch (ch) {
		case 1:
			ListCrud.crudLoop();
			break;
		case 2:
			HashSetCrud.crudLoop();
			break;
		case 3:
			HashMapCrud.crudLoop();
			break;
		}
	}
}
