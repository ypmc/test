package net.cq.test;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AutoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "D:\\temp";
		String target = "D:\\整理图片";
		autoSort(source,target);
	}

	public static void autoSort(String source, String target) {
		File f = new File(source);
		File[] files = f.listFiles();
		String created = null;
		String tempPath = null;
		for (File file : files) {
			created = convertTime(file.lastModified());
			System.out.println(created +" "+file.getName());
			tempPath = target + "\\" +created.substring(0,4)+"\\"+ created.substring(0,6);
			System.out.println(created +" "+tempPath+"\\"+ file.getName());
			File tempFile = new File(tempPath);
			if(!tempFile.exists())
			{
				tempFile.mkdirs();
			}
			
			file.renameTo(new File(tempFile+"\\"+file.getName()));
		}

	}

	public static String convertTime(long time) {
		Date date = new Date(time);
		Format format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return format.format(date);
	}

	public static String convertTimeWithTimeZome(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("UTC"));
		cal.setTimeInMillis(time);
		return (cal.get(Calendar.YEAR) + " " + (cal.get(Calendar.MONTH) + 1) + " " + cal.get(Calendar.DAY_OF_MONTH)
				+ " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));

	}
}
