package audio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

class AudioThread implements Runnable{
	final static String FADED = "Faded2.wav"; //파일명을 상수로 설정
	final static String THE_SPECTRE = "The Spectre2.wav";
	final static String HEAVEN = "Heaven.wav";
	final static String LIP = "Lip.wav";
	final static String MANSPIRIT = "Man Spirit.wav";
	final static String LASTDANCE = "Last Dance.wav";
	final static String NOTITLE = "No Title.wav";
	final static String LOVE = "Love.wav";
	final static String REGGAE = "Reggae.wav";
	final static String MYWAY = "My Way.wav";
	
	//숫자입력예외처리
	int tryCatch() {
		Scanner s = new Scanner(System.in);
		int menu = 0;

		while (true) {
			try {
				menu = s.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요!");
				s = new Scanner(System.in); // Scanner 초기화
			}
		}
		return menu;
	}
	
	//파일에 맞는 오디오입력스트림 반환
	public AudioInputStream aisReturn(String fileName){
		try {
			File audioFile = new File(fileName);
			AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
			return stream;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//파일에 맞는 오디오 재생하기
	public void clipReturn(Clip clip, AudioInputStream ais){
		try {
			clip = AudioSystem.getClip();
			clip.open(ais); //오디오입력스트림을 클립으로 오픈
			System.out.println(clip.getMicrosecondLength());
			clip.setFramePosition(0); //처음 시작위치 초기화
			clip.start();

			System.out.println("다른 노래를 듣고싶으면 아무 번호를 누르세요!");
			System.out.print("> ");
			tryCatch();
			System.out.println("=========================");
			
			clip.close(); //오디오끝내기
			ais.close(); //스트림끝내기
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean isContinue = true;
		Clip clip = null;
		while(isContinue){
			try {
				System.out.println("=========================");
				System.out.println("재생할 노래를 선택해주세요.");
				System.out.println("1.Faded         2.The Spectre    3.Heaven    4.Lip       5.Man Spirit");
				System.out.println("6.Last Dance    7.No Title       8.Love      9.Reggae    10.My Way");
				System.out.println("0.뒤로가기");
				System.out.print("> ");
				int n = tryCatch();
				System.out.println("=========================");

				switch (n) {
				case 1:
//					File audioFile = new File("Faded2.wav"); //경로지정 파일
//					AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
					
					//위에 두 줄을 한줄로
//					aisReturn("Faded2.wav");
					
					//-------------------------------------------------------------------
					
//					clip = AudioSystem.getClip();
//					clip.open(aisReturn(FADED)); //오디오입력스트림을 오픈
//					System.out.println(clip.getMicrosecondLength());
//					
//					clip.setFramePosition(0); //처음 시작위치 초기화
//					clip.start(); //오디오시작하기
////				Thread.sleep(10000); //쓰레드 사용시간을 음악파일 시간과 동일하게(sleep은 밀리초단위 1초=1000밀리초) -> 음악파일시간 * 1000
//					
//					System.out.println("다른 노래를 듣고싶으면 아무 번호를 누르세요!");
//					tryCatch();
//					clip.close(); //오디오끝내기
//					aisReturn(FADED).close(); //스트림끝내기
					
					//위에 9줄을 한줄로
					clipReturn(clip, aisReturn(FADED));
					break;
				case 2:
					clipReturn(clip, aisReturn(THE_SPECTRE));
					break;
				case 3:
					clipReturn(clip, aisReturn(HEAVEN));
					break;
				case 4:
					clipReturn(clip, aisReturn(LIP));
					break;
				case 5:
					clipReturn(clip, aisReturn(MANSPIRIT));
					break;
				case 6:
					clipReturn(clip, aisReturn(LASTDANCE));
					break;
				case 7:
					clipReturn(clip, aisReturn(NOTITLE));
					break;
				case 8:
					clipReturn(clip, aisReturn(LOVE));
					break;
				case 9:
					clipReturn(clip, aisReturn(REGGAE));
					break;
				case 10:
					clipReturn(clip, aisReturn(MYWAY));
					break;
				case 0:
					isContinue = false;
					break;
				default:
					System.out.println("=========================");
					System.out.println("유효하지 않은 목록입니다.");
					System.out.println("=========================");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//------------------------------리스트 미완성---------------------------------
	
	//파일에 맞는 오디오 재생하기
	public void clipReturn2(Clip clip, AudioInputStream ais) {
		try {
			clip = AudioSystem.getClip();
			clip.open(ais); // 오디오입력스트림을 클립으로 오픈
			System.out.println(ais);
			System.out.println(clip.getMicrosecondLength());
			clip.setFramePosition(0); // 처음 시작위치 초기화
			clip.start();

			Thread.sleep(clip.getMicrosecondLength() / 1000);

			clip.close(); // 오디오끝내기
			ais.close(); // 스트림끝내기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listPlay(){
		for(int i=0; i<aisList.size(); i++){
			Clip clip = null;
			clipReturn2(clip, aisList.get(i));
		}
	}
	
	ArrayList<AudioInputStream> aisList = new ArrayList<AudioInputStream>();
	ArrayList<String> fileList = new ArrayList<String>();
	{
		fileList.add(FADED);
		fileList.add(THE_SPECTRE);
		fileList.add(REGGAE);
	}
	
	public void add(){
		while(true){
			for(int i=0; i<fileList.size(); i++){
				System.out.print(i+1 + "번 "+fileList.get(i) + " ");
			}
			System.out.println("\n리스트에 추가할 노래를 선택하세요(0을 입력하면 종료)");
			System.out.print("> ");
			int num = tryCatch();
			if(num <= 0){
				break;
			}
			aisList.add(aisReturn(fileList.get(num-1)));
		}
	}

}//audiothread class