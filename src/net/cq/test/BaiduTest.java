package net.cq.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaiduTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "http://api.map.baidu.com/geocoder/v2/?address=北京市海淀区上地十街10号&output=json&ak=http://api.map.baidu.com/geocoder/v2/?address=上海市浦东新区云桥路875号&output=json&ak=Gbd18carIDozqgzH2RmuX4zezhDXl3OX";
		try {
			URL url = new URL(str);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("content-Type", "application/x-www-form-urlencoded");
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.connect();

			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			System.out.println(sb.toString());
			conn.disconnect();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
