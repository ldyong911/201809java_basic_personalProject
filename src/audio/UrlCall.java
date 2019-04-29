package audio;

import java.io.IOException;

public class UrlCall {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		String path = "C:/Program Files/Internet Explorer/iexplore.exe";
		
		String path2 = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";

		String cmd = "https://www.naver.com";

		String[] cmds = { path,cmd };

		try {
			runtime.exec(cmds);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}




