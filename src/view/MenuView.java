package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.CustomerDAOImpl;
import model.dto.MenuDTO;

public class MenuView {

	static String place;
	static List<MenuDTO> purchase_List = new ArrayList<>();
	static int cost;

	/**
	 * 포장 방법 선택
	 */
	public static void Instore() {
		cost = 0;
		purchase_List = null;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("==============먹고가기==============");
			System.out.println("1. 매장");
			System.out.println("2. 포장");
			System.out.println("0. 처음으로 ");
			try {
				int menu = Integer.parseInt(sc.nextLine());//
				switch (menu) {
				case 1:
					place = "매장";
					SelectMainMenu();
					break;
				case 2:
					place = "포장";
					SelectMainMenu();
					break;
				case 0:
					flag = false;
					break;
				default:
					System.out.println("해당하는 번호의 입력이 없습니다.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
		}
	}

	/**
	 * 메인 메뉴
	 */
	public static void SelectMainMenu() {
		Scanner sc = new Scanner(System.in);
		List<MenuDTO> mainList = new ArrayList<>();
		boolean flag = true;
		while (flag) {
			System.out.println("==============메인메뉴==============");
// 			for(MenuDTO main : mainList){}
// 			System.out.println((index + 1) + main.(index).getName );
			System.out.println("1. 로스트 닭다리살 샐러드");
			System.out.println("2. 우삼겹 샐러드");
			System.out.println("0. 이전으로 ");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				// mainList.size보다 menu가 크면 다시 선택
				if (menu > 2) {
					System.out.println("잘못된 입력입니다.");
					continue;
				} else if (menu == 0) {
//					만약 이전 단계로 돌아가게 된다면 방금 주문 내역 제거
//					purchase_List.remove(purchase_List.size() - 1);
					flag = false;
					break;
				}
				
				System.out.println("수량을 입력하세요");
				int cnt = Integer.parseInt(sc.nextLine());
				// 해당 메뉴의 숫자를 클릭하면 mainList.get(숫자 - 1)의 (상품코드) 데이터(DTO)를 purchase_List에 넣고 다음 화면?(토핑)
// 				ToppingMainMenu();
				// 임시
				if (menu == 1) {
// 					purchase_List.add(데이터);
					ToppingMainMenu();
				} else if (menu == 2) {
					ToppingMainMenu();
				}

			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
		}
	}

	/**
	 * 토핑 선택...
	 */
	public static void ToppingMainMenu() {
		Scanner sc = new Scanner(System.in);
		List<MenuDTO> toppList = new ArrayList<>();
		boolean flag = true;
		while (flag) {
			System.out.println("==============토핑 추가==============");
//  			for(MenuDTO topp : toppList){}
			System.out.println("1. 구운 파인애플 추가");
			System.out.println("2. 민초 소스 추가");
			System.out.println("99. 추가 안함");
			System.out.println("0. 이전으로 ");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				// toppList.size보다 menu가 크면 다시 선택
				if (menu == 99) {
					SideMainMenu();
					continue;
				}else if (menu > 2) {
					System.out.println("잘못된 입력입니다.");
					continue;
				} else if (menu == 0) {
//					만약 이전 단계로 돌아가게 된다면 방금 주문 내역 제거
//					purchase_List.remove(purchase_List.size() - 1);
					flag = false;
					break;
				} 
				System.out.println("수량을 입력하세요");
				int cnt = Integer.parseInt(sc.nextLine());
				// 해당 메뉴의 숫자를 클릭하면 toppList.get(숫자 - 1)의 데이터(DTO)를 purchase_List에 넣고 다음 화면?(토핑)
// 				SideMainMenu();
				// 임시
				if (menu == 1) {
// 					mainList.add(데이터);
					SideMainMenu();
				} else if (menu == 2) {
					SideMainMenu();
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
		}
	}

	/**
	 * 사이드 선택...
	 */
	public static void SideMainMenu() {
		Scanner sc = new Scanner(System.in);
		List<MenuDTO> sideList = new ArrayList<>();
		boolean flag = true;
		while (flag) {
			System.out.println("==============사이드메뉴==============");
//  			for(MenuDTO side : sideList){}
			System.out.println("1. 콜라");
			System.out.println("2. 사이다");
			System.out.println("99. 추가 안함");
			System.out.println("0. 이전으로 ");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				// sideList.size보다 menu가 크면 다시 선택
				if (menu == 99) {
					SelectPayment();
					continue;
				}else if (menu > 2) {
					System.out.println("잘못된 입력입니다.");
					continue;
				} else if (menu == 0) {
//					만약 이전 단계로 돌아가게 된다면 방금 주문 내역 제거
//					purchase_List.remove(purchase_List.size() - 1);
					flag = false;
					break;
				} 
				
				System.out.println("수량을 입력하세요");
				int cnt = Integer.parseInt(sc.nextLine());

				// 해당 메뉴의 숫자를 클릭하면 sideList.get(숫자 - 1)의 데이터(DTO)를 purchase_List에 넣고 다음 화면?(토핑)
				// 임시
				if (menu == 1) {
// 					mainList.add(데이터);
					SelectPayment();
				} else if (menu == 2) {
					SelectPayment();
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
		}
	}

	/**
	 * 결제 선택...
	 */
	public static void SelectPayment() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("==============결제==============");
//  			for(MenuDTO side : sideList){}
			System.out.println("1. 결제");
			System.out.println("2. 추가 구매");
			System.out.println("0. 처음으로 ");
			try {
				int menu = Integer.parseInt(sc.nextLine());//
				switch (menu) {
				case 1:
					System.out.println("결제가 완료 되었습니다.");
					Instore();
					break;
				case 2:
					System.out.println("추가 구매");
					SelectMainMenu();
					break;
				case 0:
					Instore();
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
		}
	}
}
