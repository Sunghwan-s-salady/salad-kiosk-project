package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.CustomerController;
import model.dto.MenuDTO;

public class MenuView {
	
	// 변수 선언
	public static String place;
	public static List<MenuDTO> purchase_List = new ArrayList<>();
	public static int cost;

	/**
	 * 포장 방법 선택
	 */
	public static void Instore() {
		// 처음화면 가격 초기화 (처음화면 => 장바구니 초기화)
		cost = 0;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("==============먹고가기==============");
			System.out.println("1. 매장");
			System.out.println("2. 포장");
			System.out.println("0. 처음으로 ");
			try {
				System.out.print("입력 : ");
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
			sc.close();
		}
	}

	/**
	 * 메인 메뉴
	 */
	public static void SelectMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		boolean flag = true;
		while (flag) {
			System.out.println("==============메인메뉴==============");
			CustomerController.selectMainMenu();
			System.out.println("0. 이전으로 ");
			try {
				System.out.print("입력 : ");
				int menu = Integer.parseInt(sc.nextLine());
				// mainList.size보다 menu가 크면 다시 선택 (범위를 벗어남)
				if (menu > CustomerController.mainList.size()) {
					System.out.println("잘못된 입력입니다.");
					continue;
				} else if (menu == 0) {
//					만약 이전 단계로 돌아가게 된다면 방금 주문 내역 제거
//					가장 최근 추가 된 내용 + 전에 추가 안함을 선택해서 넘어오지 않았다면 (이전 추가 품목의 카테고리가 현재와 같다면)
					if (purchase_List.get(purchase_List.size() - 1).getCategory() == 1) {
						cost -= (purchase_List.get(purchase_List.size() - 1).getPrice()) * (purchase_List.get(purchase_List.size() - 1).getCount());
						purchase_List.remove(purchase_List.size() - 1);
					}
					flag = false;
					break;
				}

				System.out.print("수량을 입력하세요 : ");
				int cnt = Integer.parseInt(sc.nextLine());
				
				// 현재 선택한 데이터의 가격 * 수량을 총액에 더함
				cost += (CustomerController.mainList.get(menu - 1).getPrice()) * cnt;
				
				// 현재 장바구니에 메뉴 추가 + 수량
				MenuDTO sub = CustomerController.mainList.get(menu - 1);
				MenuDTO men = new MenuDTO(sub.getProductCode(),sub.getProductName(),sub.getPrice(),sub.getCategory(),cnt);
				purchase_List.add(men);
				
				// 현재 장바구니 보여주기
				System.out.print("현재 장바구니 상품 :");
				for (MenuDTO me : purchase_List) {
					System.out.print(me.getProductName() +" "+  me.getCount() + "개 ");
				}
				System.out.println();
				System.out.println("현재까지 가격 : " + cost);
				
				// 토핑추가화면으로
				ToppingMainMenu();
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
			sc.close();
		}
	}

	/**
	 * 토핑 선택...
	 */
	public static void ToppingMainMenu() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("==============토핑 추가==============");
			CustomerController.selectTopping();
			System.out.println("99. 추가 안함");
			System.out.println("0. 이전으로 ");
			try {
				System.out.print("입력 : ");
				int menu = Integer.parseInt(sc.nextLine());
				// toppList.size보다 menu가 크면 다시 선택 (범위를 벗어남)
				if (menu == 99) {
					SideMainMenu();
					continue;
				} else if (menu > CustomerController.toppList.size()) {
					System.out.println("잘못된 입력입니다.");
					continue;
				} else if (menu == 0) {
//					만약 이전 단계로 돌아가게 된다면 방금 주문 내역 제거
//					가장 최근 추가 된 내용 + 전에 추가 안함을 선택해서 넘어오지 않았다면 (이전 추가 품목의 카테고리가 현재와 같다면)
					if (purchase_List.get(purchase_List.size() - 1).getCategory() == 2) {
						cost -= (purchase_List.get(purchase_List.size() - 1).getPrice()) * (purchase_List.get(purchase_List.size() - 1).getCount());
						purchase_List.remove(purchase_List.size() - 1);
					}
					flag = false;
					break;
				}
				System.out.print("수량을 입력하세요 : ");
				int cnt = Integer.parseInt(sc.nextLine());
				// 현재 선택한 데이터의 가격 * 수량을 총액에 더함
				cost += (CustomerController.toppList.get(menu - 1).getPrice()) * cnt;
				
				// 현재 장바구니에 메뉴 추가 + 수량
				MenuDTO sub = CustomerController.toppList.get(menu - 1);
				MenuDTO men = new MenuDTO(sub.getProductCode(),sub.getProductName(),sub.getPrice(),sub.getCategory(),cnt);
				purchase_List.add(men);

				// 현재 장바구니 보여주기
				System.out.print("현재 장바구니 상품 :");
				for (MenuDTO me : purchase_List) {
					System.out.print(me.getProductName() +" "+  me.getCount() + "개 ");
				}
				System.out.println();
				System.out.println("현재까지 가격 : " + cost);
				
				// 사이드 화면으로
				SideMainMenu();
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
			sc.close();
		}
	}

	/**
	 * 사이드 선택...
	 */
	public static void SideMainMenu() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("==============사이드메뉴==============");
			CustomerController.selectSideMenu();
			System.out.println("99. 추가 안함");
			System.out.println("0. 이전으로 ");
			try {
				System.out.print("입력 : ");
				int menu = Integer.parseInt(sc.nextLine());
				// sideList.size보다 menu가 크면 다시 선택
				if (menu == 99) {
					SelectPayment();
					continue;
				} else if (menu > CustomerController.sideList.size()) {
					System.out.println("잘못된 입력입니다.");
					continue;
				} else if (menu == 0) {
//					만약 이전 단계로 돌아가게 된다면 방금 주문 내역 제거
//					가장 최근 추가 된 내용 + 전에 추가 안함을 선택해서 넘어오지 않았다면 (이전 추가 품목의 카테고리가 현재와 같다면)
					if (purchase_List.get(purchase_List.size() - 1).getCategory() == 3) {
						cost -= (purchase_List.get(purchase_List.size() - 1).getPrice()) * (purchase_List.get(purchase_List.size() - 1).getCount());
						purchase_List.remove(purchase_List.size() - 1);
					}
					flag = false;
					break;
				}

				System.out.print("수량을 입력하세요 : ");
				int cnt = Integer.parseInt(sc.nextLine());

				// 현재 선택한 데이터의 가격 * 수량을 총액에 더함
				cost += (CustomerController.sideList.get(menu - 1).getPrice()) * cnt;
				
				// 현재 장바구니에 메뉴 추가 + 수량
				MenuDTO sub = CustomerController.sideList.get(menu - 1);
				MenuDTO men = new MenuDTO(sub.getProductCode(),sub.getProductName(),sub.getPrice(),sub.getCategory(),cnt);
				purchase_List.add(men);
				
				// 장바구니 보여주기
				System.out.println("현재 장바구니 상품");
				for (MenuDTO me : purchase_List) {
					System.out.print(me.getProductName() +" "+  me.getCount() + "개 ");
				}
				System.out.println();
				System.out.println("현재까지 가격 : " + cost);
				
				// 결제 화면으로
				SelectPayment();
				
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
			sc.close();
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
				System.out.print("입력 : ");
				int menu = Integer.parseInt(sc.nextLine());//
				switch (menu) {
				case 1:
					System.out.println("결제가 완료 되었습니다.");
					// 여기서 DB데이터에 insert
					CustomerController.insertOrdersList();
					CustomerController.orderDetailInsert();
					
					// 초기 화면 진입시 장바구니 초기화
					purchase_List = null;
					Instore();
					break;
				case 2:
					System.out.println("추가 구매");
					// 메인 메뉴 선택부터
					SelectMainMenu();
					break;
				case 0:
					// 초기 화면 진입시 장바구니 초기화
					purchase_List = null;
					Instore();
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 가능합니다.");
			}
		}
		sc.close();
	}
}
