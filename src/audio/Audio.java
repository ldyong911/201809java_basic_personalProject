package audio;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Audio {
	/*
	 * Clip인터페이스는 오디오 데이터를 리얼 타임에 스트림 화하는 것이 아니라, 재생 전에 로드 할 수있는 특수한 종류의 데이터 라인을
	 * 나타냅니다. 데이터가 미리로드되어 있고 길이가 알려지기 때문에 오디오 데이터의 어느 위치에서나 클립이 재생되도록 설정할 수
	 * 있습니다. 클립을 재생할 때 반복적으로 반복되도록 루프를 만들 수도 있습니다. 루프는 시작 및 끝 샘플 프레임과 루프가
	 * 재생되어야하는 횟수로 지정됩니다.
	 */
	
	/*
	 * 스레드를 stop으로 멈추지말고 interrupt으로 멈춰야 한다(오류발생할 수 있음)
	 */

	public static void main(String[] args) {
		AudioThread at = new AudioThread();
		
		boolean isContinue = true;
		
		while(isContinue){
			System.out.println("=========================");
			System.out.println("1.음악");
			System.out.println("2.플레이리스트");
			System.out.println("3.플레이리스트에 음악 추가하기");
			System.out.println("4.플레이리스트에 음악 삭제하기");
			System.out.println("5.종료하기");
			System.out.print("> ");
			int menu = tryCatch();
			System.out.println("=========================");

			switch (menu) {
			case 1:
				// 음악
				at.run();
				break;
			case 2:
				// 플레이리스트
				at.listPlay();
				break;
			case 3:
				// 플레이리스트에 음악 추가하기
				at.add();
				break;
			case 4:
				// 플레이리스트에 음악 삭제하기
				break;
			case 5:
				System.out.println("메뉴 종료합니다.");
				System.out.println("=========================");
				isContinue = false;
				break;
			default:
				continue;
			}
		}
		
	}

	//숫자입력예외처리
	static int tryCatch() {
		Scanner s = new Scanner(System.in);
		int menu = 0;

		while (true) {
			try {
				menu = s.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요!");
				s = new Scanner(System.in); //Scanner 초기화
			}
		}
		return menu;
	}

}//main class