package view;

/**
 * @author hyein
 */

import java.util.Scanner;

import model.dto.MenuDTO;
import controller.ManagerController;

public class ManagerView {

	/**
	 * 로그인/로그아웃
	 */
	public static void Login() {

		Scanner sc = new Scanner(System.in);
		boolean logIn = false;
		String adminId = "a";
		String adminPw = "a";

		System.out.println("=====로그인=====");
		while (!logIn) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();

			if (id.equals(adminId) && pw.equals(adminPw)) {
				System.out.println("로그인성공");
				logIn = true;
				displayService();
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				MainView.main(null);
			}
		}
		sc.close();
	}

	public static void displayService() {
		boolean flag = true;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("===== 관리자 서비스 =====");
			System.out.println("1. 전체 메뉴 확인");
			System.out.println("2. 메뉴 추가");
			System.out.println("3. 메뉴 삭제");
			System.out.println("4. 메뉴 변경");
			System.out.println("5. 주문 내역 확인");
			System.out.println("6. 로그아웃");
			System.out.print("선택: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("전체 메뉴 확인을 선택하였습니다");
				ManagerController.selectMenuAll();
				break;
			case 2:
				System.out.println("메뉴 추가를 선택하였습니다");
				inputInsertMenu();
				break;
			case 3:
				System.out.println("메뉴 삭제를 선택하였습니다");
				inputDeleteMenu();
				break;
			case 4:
				System.out.println("메뉴 변경을 선택하였습니다");
				inputUpdateMenu();
				break;
			case 5:
				System.out.println("주문 내역 확인을 선택하였습니다");
				ManagerController.selectOrderAll();
				break;
			case 6:
				System.out.println("로그아웃을 선택하였습니다");
				LogOut();
				flag = false;
				break;
			default:
				System.out.println("잘못되었습니다..다시 입력해주세요.");

			}
			sc.close();
		}
	}

	/**
	 * 1. 전체 메뉴 선택 5. 주문 내역 조회는 controller에서 가져옴
	 */

	/**
	 * 2. 메뉴 추가 선택
	 */
	public static void inputInsertMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("새로운 메뉴의 코드를 입력하세요");
		String productCode = sc.nextLine();

		System.out.println("새로운 메뉴의 이름을 입력하세요");
		String productName = sc.nextLine();

		System.out.println("새로운 메뉴의 가격은 입력하세요");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.println("새로운 메뉴의 분류를 입력하세요");
		int category = Integer.parseInt(sc.nextLine());

		MenuDTO menu = new MenuDTO(productCode, productName, price, category);
		ManagerController.menuInsert(menu);
		sc.close();
	}

	/**
	 * 3. 메뉴 삭제
	 */
	public static void inputDeleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제하는 메뉴의 이름를 입력하세요");
		String productName = sc.nextLine();
		ManagerController.menuDelete(productName);
		sc.close();
	}

	/**
	 * 4. 메뉴 변경
	 */

	public static void inputUpdateMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("변경할 메뉴의 이름을 입력하세요");
		String productName = sc.nextLine();
		
		System.out.println("무엇을 변경하실껀가요?(이름, 가격, 분류)");
		String updatecolumn = sc.nextLine();
		
		System.out.println("변경할 내용을 입력해주세요.");
		String updatecontent = sc.nextLine();
		
	
		ManagerController.menuUpdate(productName, updatecolumn, updatecontent);
		sc.close();
	}

	/**
	 * 6.로그아웃
	 */
	public static void LogOut() {
		System.out.println("로그아웃 되었습니다.");
	}
}