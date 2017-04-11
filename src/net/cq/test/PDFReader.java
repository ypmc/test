package net.cq.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;


public class PDFReader {

	public static String file_path = "d:\\1.pdf";

	public static int getCount(String filepath) {
		int count = 0;
		PDDocument document = null;
		try {
			document = PDDocument.load(new File(filepath));
			count = document.getNumberOfPages();
			System.out.println(filepath + " " + count);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return count;

	}

	public static void getContent(String filepath) {
		int count = 0;
		PDDocument document = null;
		try {
			document = PDDocument.load(new File(filepath));
			count = document.getNumberOfPages();
			System.out.println(filepath + " " + count);

			PDFTextStripper stripper = new PDFTextStripper();
			String docText = stripper.getText(document);
			System.out.println("1 = "+docText +", = " +docText.length());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void appendDocument(String origPath, String appendPath) {

		PDDocument document = null;
		PDDocument appendDocument = null;
		try {
			appendDocument = PDDocument.load(new File(appendPath));
			document = PDDocument.load(new File(origPath));
			document.setAllSecurityToBeRemoved(true);
			appendDocument.setAllSecurityToBeRemoved(true);
			PDPageTree tree = document.getPages();
			Iterator<PDPage> iter = tree.iterator();
			while (iter.hasNext()) {
				appendDocument.addPage(iter.next());
			}
			appendDocument.save(appendPath);
			appendDocument.close();
		} catch (Exception e) {
			System.out.println("Exception@appendDocument" + e.toString());
		} finally {
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (appendDocument != null) {
				try {
					appendDocument.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static int listFile(String filepath) {
		int total = 0;
		File f = new File(filepath);
		File[] files = f.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			if (file.isDirectory()) {
				System.out.println("path " + f.getPath());
				total += listFile(file.getAbsolutePath());
			} else {
				System.out.println("name " + file.getName());
				total += getCount(file.getPath());
			}
		}

		return total;
	}

	public static void appendFileInDirectory(String filepath, String appendPath) {
		File f = new File(filepath);
		File[] files = f.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				appendFileInDirectory(file.getAbsolutePath(), appendPath);
			} else {
				if (file.getPath().endsWith(".pdf")) {	
					flist.add(file.getPath());
					//appendDocument(file.getPath(), appendPath);
				}
			}
		}

	}
	public static LinkedList<String> flist = new LinkedList<String>();
	public static void main(String[] args) {
		//appendDocument("d:\\2.pdf", "D:\\1.pdf");
		// String filepath = "d:\\注册会计师";
		// System.out.println(listFile(filepath));

//		String appendPath = "D:\\于群 注册会计师 公司战略与风险管理 真题班.pdf";
//		String filePath = "D:\\注册会计师\\战略\\真题";
//		appendFileInDirectory(filePath,appendPath);
//		System.out.println(flist.size());
//		//Collections.sort(flist, new FileComparator());		
//		for(int i=0;i<flist.size();i++){
//			System.out.println(flist.get(i));
//			appendDocument(flist.get(i),appendPath);
//		}
		//getContent("d:\\2.pdf");
		arrange();
	}
	
	public static void arrange()
	{
		File file= new File("D:\\KuGou\\");
		File[] files = file.listFiles();
		
		for(File f :files)
		{
			
			if(f.getName().indexOf("杨家将")>-1)
			{
				File yFile = new File("D:\\KuGou\\杨家将\\"+ f.getName());
				f.renameTo(yFile);
			}
			
			if(f.getName().indexOf("樊梨花")>-1)
			{
				File yFile = new File("D:\\KuGou\\樊梨花\\"+ f.getName());
				f.renameTo(yFile);
			}
			
			if(f.getName().indexOf("岳飞")>-1)
			{
				File yFile = new File("D:\\KuGou\\岳飞\\"+ f.getName());
				f.renameTo(yFile);
			}
			
			if(f.getName().indexOf("萧太后")>-1)
			{
				File yFile = new File("D:\\KuGou\\萧太后\\"+ f.getName());
				f.renameTo(yFile);
			}
			
			if(f.getName().indexOf("赵匡胤")>-1)
			{
				File yFile = new File("D:\\KuGou\\赵匡胤\\"+ f.getName());
				f.renameTo(yFile);
			}
		}
		
	}
}
