package com.capmi.RandomString;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportExcel {

	/**
	 * 创建一个指定路径的空excel
	 * @param path 指定路径
	 * @throws IOException
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	public void createExcel(String[] list,String path) {
		WritableWorkbook wwb = null;
		String filename = path;
		File file = new File(filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 //以fileName为文件名来创建一个Workbook
		 try {
			wwb = Workbook.createWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 创建工作表
		 WritableSheet ws = wwb.createSheet("Coupon number", 0);
		 
		//要插入到的Excel表格的行号，默认从0开始
         Label labelId= new Label(0, 0, "CouponNumber");
         try {
			ws.addCell(labelId);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         for (int i = 0; i < list.length; i++) {
             Label labelId_i= new Label(0, i+1, list[i]+"");
             try {
				ws.addCell(labelId_i);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         
         //写进文档
          try {
			wwb.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         // 关闭Excel工作簿对象
          try {
			wwb.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws RowsExceededException, WriteException, IOException{
		//String path= "D://book.xls";
		String[] a = new String[5];
		a[0] = ("usnal");
		a[1] = ("icnvv");
		a[2] = ("aocam");
		a[3] = ("capnu");
		a[4] = ("cajin");
	//	System.out.println(a.get(0));;
		ExportExcel ee = new ExportExcel();
		ee.createExcel(a,"D://lalala.xls");
	}
	
	
}
