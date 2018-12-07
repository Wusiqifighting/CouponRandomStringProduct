package com.capmi.RandomString;

import java.util.Random;

public class RandomString {
	

	String s = "";


	/***
	 * 产生默认随机数的方法
	 * 
	 * @param length
	 * @return
	 */
	public String getCharAndNumr(int length) {
		if (length >= 0) {
			String val = "";
			Random random = new Random();
			// t0、t1、t2用来标识大小写和数字是否在产生的随机数中出现
//			int t0 = 0;
			int t1 = 0;
//			int t2 = 0;
			for (int i = 0; i < length; i++) {
				String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
				// 产生的是字母
				if ("char".equalsIgnoreCase(charOrNum)) // 字符串
				{
					// int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
					// //取得大写字母还是小写字母
					int choice = 0;
					if (random.nextInt(2) % 2 == 0) {
						choice = 65;
//						t0 = 1;
					} else {
						choice = 97;
						t1 = 1;
					}
					val += (char) (choice + random.nextInt(26));
				}
				// 产生的是数字
				else if ("num".equalsIgnoreCase(charOrNum)) // 数字
				{
					val += String.valueOf(random.nextInt(10));
//					t2 = 1;
				}
			}
			// 用于判断是是否包括大写字母、小写字母、数字
			if (t1==1 || val.contains("O")||val.contains("I")||val.contains("L")) {
				val = getCharAndNumr(length); // 不满足则递归调用该方法
				return val;
			}

			else
				return val;

		} else {

			return "sha";
		}
	}
	
	/**
	 * 产生多个默认优惠券随机数
	 * @param 武斯琪
	 * @since 20181202
	 */
	public String[] getCharAndNumrnum(int sum,int length,String front){
		String[] nums = new String[sum];
		for(int i=0;i<nums.length;i++){
			nums[i]=front+getCharAndNumr(length);
		}
		return nums;
	}
	
	
	/**
	 * 产生多个自定义优惠券随机数
	 * @param sum 个数
	 * @param length 长度
	 * @param front 前缀
	 * @param flag判断是哪种组合类型的优惠券
	 * 1:只大写 2：只小写 3：只数字   4：大写+数字 5：小写+数字  6:大写+小写 7：大写+小写+数字
	 * @param notcontain 不包含的字母或数字
	 * @return 自定义优惠券数组
	 */
	public String[] getCusCharAndNumrnum(int sum,int length,String front,int flag,String noncon){

		String[]counts = new String[sum];
		for(int i=0;i<counts.length;i++){  
			if(flag == 1){
			counts[i] = front+getCus65CharAndNumr(length,noncon);	
			} else if(flag ==2){			
				counts[i] = front+getCus97CharAndNumr(length,noncon);
			} else if(flag ==3){			
				counts[i] = front+getCusnumCharAndNumr(length,noncon);	
			} else if(flag ==4){
				counts[i] = front+getChar65AndNumr(length,noncon);
			} else if(flag ==5){
				counts[i] = front+getChar97AndNumr(length,noncon);
			} else if(flag == 6){
				counts[i] = front+getChar97And65Numr(length,noncon);
			}else{
				counts[i] = front+getChar97And65AndnumNumr(length,noncon);
			}
			
		}
		return counts;
	}
	
	
	
	
	/**
	 * 产生指定长度自定义大写字母优惠券
	 * @param length
	 * @since 20181203
	 * @return XJTGOW
	 * TLCSK
	 */
	public String getCus65CharAndNumr(int length,String nc){
		
		String var ="";
		Random rand=new Random();  
		for(int i=0;i<length;i++){
		int index = rand.nextInt(26);
		int rerand = index+65;
		var +=(char) rerand;
		} 
		String[] s={};
		if(nc!=null&&!nc.equals("")){
		s = nc.split(","); 
		if(var.contains(s[0])){
			var = getCus65CharAndNumr(length,nc);
			return var;  
		}else if(nc.length()>1){
			var = getCus65CharAndNumr(length,nc.substring(2));
			if(var.contains(s[0])){
				var = getCus65CharAndNumr(length,nc);
			}
			return var;
		}
		}
		return var;
	}
	
	
	/**
	 * 产生指定长度自定义小写字母优惠券
	 * @param length
	 * @since 20181203
	 * @return
	 */
	public String getCus97CharAndNumr(int length,String nc){
		String var ="";
		Random rand=new Random();
		for(int i=0;i<length;i++){
		int index = rand.nextInt(26);
		int rerand = index+97;
		var +=(char) rerand;
		}
		String[] s={};
		if(nc!=null&&!nc.equals("")){
		s = nc.split(","); 
		if(var.contains(s[0])){
			var = getCus97CharAndNumr(length,nc);
			return var;  
		}else if(nc.length()>1){
			var = getCus97CharAndNumr(length,nc.substring(2));
			if(var.contains(s[0])){
				var = getCus97CharAndNumr(length,nc);
			}
			return var;
		}}
		return var;
	}
	
	/**
	 * 产生指定长度自定义数字优惠券
	 * @param length
	 * @since 20181203
	 * @return
	 */
	public String getCusnumCharAndNumr(int length,String nc){
		String var ="";
		Random rand=new Random();
		for(int i=0;i<length;i++){
		int index = rand.nextInt(10);
		var += index;
		}
		String[] s={};
		if(nc!=null&&!nc.equals("")){
		s = nc.split(","); 
		if(var.contains(s[0])){
			var = getCusnumCharAndNumr(length,nc);
			return var;  
		}else if(nc.length()>1){
			var = getCusnumCharAndNumr(length,nc.substring(2));
			if(var.contains(s[0])){
				var = getCusnumCharAndNumr(length,nc);
			}
			return var;
		}}
		return var;
	}
	
	
	/***
	 * 产生小写和数字随机数的方法
	 * 
	 * @param length
	 * @return
	 */
	public String getChar97AndNumr(int length,String nc) {
//		String[] s = nc.split(","); 
		if (length >= 0) {
			String val = "";
			Random random = new Random();
			// t0、t1、t2用来标识大小写和数字是否在产生的随机数中出现
			int t0 = 0;
			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < length; i++) {
				String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
				// 产生的是字母
				if ("char".equalsIgnoreCase(charOrNum)) // 字符串
				{
					// int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
					// //取得大写字母还是小写字母
					int choice = 0;
					if (random.nextInt(2) % 2 == 0) {
						choice = 65;
						t0 = 1;
					} else {
						choice = 97;
						t1 = 1;
					}
					val += (char) (choice + random.nextInt(26));
				}
				// 产生的是数字
				else if ("num".equalsIgnoreCase(charOrNum)) // 数字
				{
					val += String.valueOf(random.nextInt(10));
					t2 = 1;
				}
			}
			// 用于判断是是否包括大写字母、小写字母、数字
			if (t0==1) {
				val = getChar97AndNumr(length,nc); // 不满足则递归调用该方法
				return val;
			}			
			else {
				String[] s={};
				if(nc!=null&&!nc.equals("")){
				s = nc.split(","); 
				if(val.contains(s[0])){
					val = getChar97AndNumr(length,nc);
					return val;  
				}else if(nc.length()>1){
					val = getChar97AndNumr(length,nc.substring(2));
					if(val.contains(s[0])){
						val = getChar97AndNumr(length,nc);
					}
					return val;
				}}
				return val;
		}} else {
			return "sha";
		}
	}
	
	
	/***
	 * 产生大写和数字随机数的方法
	 * 
	 * @param length
	 * @return
	 */
	public String getChar65AndNumr(int length,String nc) {
//		String[] s = nc.split(","); 
		if (length >= 0) {
			String val = "";
			Random random = new Random();
			// t0、t1、t2用来标识大小写和数字是否在产生的随机数中出现
			int t0 = 0;
			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < length; i++) {
				String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
				// 产生的是字母
				if ("char".equalsIgnoreCase(charOrNum)) // 字符串
				{
					// int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
					// //取得大写字母还是小写字母
					int choice = 0;
					if (random.nextInt(2) % 2 == 0) {
						choice = 65;
						t0 = 1;
					} else {
						choice = 97;
						t1 = 1;
					}
					val += (char) (choice + random.nextInt(26));
				}
				// 产生的是数字
				else if ("num".equalsIgnoreCase(charOrNum)) // 数字
				{
					val += String.valueOf(random.nextInt(10));
					t2 = 1;
				}
			}
			// 用于判断是是否包括大写字母、小写字母、数字
			if (t1==1) {
				val = getChar65AndNumr(length,nc); // 不满足则递归调用该方法
				return val;
			}

			else {
				String[] s={};
				if(nc!=null&&!nc.equals("")){
				s = nc.split(",");
				if(val.contains(s[0])){
				val = getChar65AndNumr(length,nc);
				return val;  
			}else if(nc.length()>1){
				val = getChar65AndNumr(length,nc.substring(2));
				if(val.contains(s[0])){
					val = getChar65AndNumr(length,nc);
				}
				return val;
			}}
				return val;

		}} else {

			return "sha";
		}
	}
	
	
	/***
	 * 产生小写和大写随机数的方法
	 * 
	 * @param length
	 * @return
	 */
	public String getChar97And65Numr(int length,String nc) {
//		String[] s = nc.split(","); 
		if (length >= 0) {
			String val = "";
			Random random = new Random();
			// t0、t1、t2用来标识大小写和数字是否在产生的随机数中出现
			int t0 = 0;
			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < length; i++) {
				String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
				// 产生的是字母
				if ("char".equalsIgnoreCase(charOrNum)) // 字符串
				{
					// int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
					// //取得大写字母还是小写字母
					int choice = 0;
					if (random.nextInt(2) % 2 == 0) {
						choice = 65;
						t0 = 1;
					} else {
						choice = 97;
						t1 = 1;
					}
					val += (char) (choice + random.nextInt(26));
				}
				// 产生的是数字
				else if ("num".equalsIgnoreCase(charOrNum)) // 数字
				{
					val += String.valueOf(random.nextInt(10));
					t2 = 1;
				}
			}
			// 用于判断是是否包括大写字母、小写字母、数字
			if (t2==1) {
				val = getChar97And65Numr(length,nc); // 不满足则递归调用该方法
				return val;
			}

			else {
				String[] s={};
				if(nc!=null&&!nc.equals("")){
				s = nc.split(",");
				if(val.contains(s[0])){
				val = getChar97And65Numr(length,nc);
				return val;  
			}else if(nc.length()>1){
				val = getChar97And65Numr(length,nc.substring(2));
				if(val.contains(s[0])){
					val = getChar97And65Numr(length,nc);
				}
				return val;
			}}
				return val;

		}} else {

			return "sha";
		}
	}
	
	
	/***
	 * 产生小写和大写和数字随机数的方法
	 * 
	 * @param length
	 * @return
	 */
	public String getChar97And65AndnumNumr(int length,String nc) {
//		String[] s = nc.split(","); 
		if (length >= 0) {
			String val = "";
			Random random = new Random();
			// t0、t1、t2用来标识大小写和数字是否在产生的随机数中出现
			int t0 = 0;
			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < length; i++) {
				String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
				// 产生的是字母
				if ("char".equalsIgnoreCase(charOrNum)) // 字符串
				{
					// int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
					// //取得大写字母还是小写字母
					int choice = 0;
					if (random.nextInt(2) % 2 == 0) {
						choice = 65;
						t0 = 1;
					} else {
						choice = 97;
						t1 = 1;
					}
					val += (char) (choice + random.nextInt(26));
				}
				// 产生的是数字
				else if ("num".equalsIgnoreCase(charOrNum)) // 数字
				{
					val += String.valueOf(random.nextInt(10));
					t2 = 1;
				}
			}
			// 用于判断是是否包括大写字母、小写字母、数字
/*			if (0==1) {
				val = getChar97And65AndnumNumr(length); // 不满足则递归调用该方法
				return val;
			}

			else*/
			String[] s={};
			if(nc!=null&&!nc.equals("")){
			s = nc.split(",");

			if(val.contains(s[0])){
				val = getChar97And65AndnumNumr(length,nc);
				return val;  
			}else if(nc.length()>1){
				val = getChar97And65AndnumNumr(length,nc.substring(2));
				if(val.contains(s[0])){
					val = getChar97And65AndnumNumr(length,nc);
				}
				return val;
			}
				return val;
			}else return val;
		} else {
			return "sha";
		}
	}
	
	public static void main(String[] args){
		RandomString a = new RandomString();
		String[] hehe = a.getCusCharAndNumrnum(100,7,"E",7,"H,m,6,K,S");
		for(String s:hehe){
			System.out.println(s);
		}
	//	System.out.println(a.getCusCharAndNumrnum(10,5,"XJY",6));;
		
	/*	String ss="P";
		String sde = ss.substring(2);
		System.out.println(sde);*/
		
	//	System.out.println(a.deductcontain("e,a"));
	}





}
