package net.cq.test;

import java.util.Comparator;

public class FileComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		String strNum0 = o1.substring(o1.indexOf("ตฺ")+1,o1.indexOf("ีย"));
		String strNum1 = o2.substring(o2.indexOf("ตฺ")+1,o2.indexOf("ีย"));
		return Integer.parseInt(strNum0) - Integer.parseInt(strNum1);
	}

	
}
