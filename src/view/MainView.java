package view;

import java.util.Scanner;


public class MainView {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(true) {
		System.out.println("==============샐러드 바 On==============");
		System.out.println("1. 관리자 모드");
		System.out.println("2. 주문 모드");
		System.out.println("0. 종료 ");
		try {
            int menu = Integer.parseInt(sc.nextLine());//
            switch (menu) {
			  case 1:
//				ManagerView.ManageMenu();
				break;
             case 2:
          	   	MenuView.Instore();
				break;
             case 0:
           	  System.out.println("ㅂㅂ");
   			 System.exit(0);	
   			break;
            }
            sc.close();
		}catch (NumberFormatException e) {
			System.out.println("메뉴는 숫자만 가능합니다.");
		}
	}
	}
}
