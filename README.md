# 성환이네 샐러드 가게 
KB IT's your life 5조 미니프로젝트

## 팀원 소개 
- 팀장 : 서은효
- 팀원 : 김혜인 박예린 조성환 

## 개발 일정 
 - 04.05 ~ 6 (약 이틀)
 - 03.31 ~ 04 ~ 03 비대면 기획
 
![image](https://user-images.githubusercontent.com/89370421/230291487-c879d758-c1f6-4b3b-b24c-6714cf6a91e0.png)


## 기획의도 

 - 최근 가장 많이 먹었던 점심 메뉴였던 샐러드. 
 - 샐러드 가게의 키오스크는 보통 원하는 샐러드를 선택하고 토핑을 추가, 사이드 메뉴를 마지막으로 추가 후 최종적으로 결제를 진행. 
 - 기존의 키오스크는 고객의 시각에서 그저 주문만 하는 기능을 가지고 있어 여러 테이블을 관리할 수 있는 기능이 없어 기능이 부족하다 생각.
 - 따라서 관리자의 파트를 함께 진행해보면 DB 관리도 학습할 수 있다고 생각해 기능을 추가.
 ![image](https://user-images.githubusercontent.com/89370421/230291308-afc4c445-08b5-492a-bcd1-452c1351089a.png)

 
 ## 개발 환경 
  - 언어 : ava 11 , OracleDataBase 21C XE
  - 개발 Tool : eclipse IDE , SQL DEVELOPER
  - DB : Oracle
  - 협업 Tool : Github, Matter Most, Kakao Talk
  
  ![image](https://user-images.githubusercontent.com/89370421/230291412-c3b76a43-c7c5-4370-9895-ad73ebad4e79.png)

  ## 프로세스 
  ![image](https://user-images.githubusercontent.com/89370421/230291906-3ef85b5a-8150-40c7-a370-211b0ab8e75a.png)

  ## DB설계
   - Menu
    -	 product_code/ product_name/ price/ category
   - orders 
    -	 order_code/ payment_time/ total_amount/ eat_how
   - orders_detail
   	-	 detail_code/ product_code/ payment_time/ total_amount/ eat_how 
		
		![image](https://user-images.githubusercontent.com/89370421/230292782-a362898c-93f1-4c8e-b440-36a5d79ddb9a.png)
		
	## MVC 모델
	![image](https://user-images.githubusercontent.com/89370421/230292889-355e66a0-2574-4439-a55d-55bed83fcbe3.png)

## 주요 기능 
 - 관리자 
 	: 메뉴 추가 / 삭제 / 변경 / 주문내역확인 / 분류별 매출 확인
 - 고객
  : 주문 / 선택 / 결제
	
	![image](https://user-images.githubusercontent.com/89370421/230293112-69631abf-99ba-4122-ac99-bf712f49ce16.png)

## DAO
![image](https://user-images.githubusercontent.com/89370421/230293164-8f72c53e-c39c-414e-be98-afec585c47a5.png)
![image](https://user-images.githubusercontent.com/89370421/230293180-351cf6b0-7d23-4ff7-8e7a-f042eb5bfa63.png)

## DTO
![image](https://user-images.githubusercontent.com/89370421/230293240-22ba7171-be92-4eac-8618-7a645e591487.png)

![image](https://user-images.githubusercontent.com/89370421/230293273-b8e206ff-dcd1-4027-ae15-404fdc9603cb.png)

## 후기

![image](https://user-images.githubusercontent.com/89370421/230293346-384860ac-9d92-4b1a-97fb-944d21fe7942.png)
