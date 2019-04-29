package audio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlTextCall {

	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			URL obj = new URL("https://www.naver.com"); // 호출할 url
			HttpURLConnection con = (HttpURLConnection)obj.openConnection();
			con.setRequestMethod("GET");
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line; while((line = in.readLine()) != null) { // response를 차례대로 출력
				System.out.println(line);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}

	}
}