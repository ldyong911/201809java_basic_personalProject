package audio;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestDesktop {

	public static void main(String[] args) {

		String url = "https://www.youtube.com";
		File file = new File("TEST.txt");

		try {
			Desktop.getDesktop().browse(new URI(url)); //url호출
			Desktop.getDesktop().edit(file); //파일편집
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

}
