package report;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PrintMain extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	final static String URL = "http://10.0.0.14:8080/WebSite/wish/update";
	static JFrame frame;
	static  Panel p2;
	
	static int FONG_SIZE = 15;
	static int FONG_SIZE_DETILE = 13;
	static String year;//年
	static String month;//月
	static String day;//日
	static String week;//星期
	static String time;//时间
	static String total;//进馆人数
	static String number;//第几位
	static String name;//姓名
	static String daycount;//今天进馆次数
	static String stunum;//学号
	static String readtotail;//借阅总数
	static String school;//学院
	static String currentcount;//当前借阅书
	static String major;//专业
	static String noreturn;//未归还
	
	static JTextArea textArea;
	static JTextArea textArea1;
	static JTextArea textArea2;
	static JTextArea textArea3;
	
	static JTextArea textArea5;
	static JTextArea textArea7;
	static JTextArea textArea9;
	static JTextArea textArea11;
	static JTextArea textArea13;
	static JTextArea textArea15;
	static JTextArea textArea17;
	static JTextArea textArea19;
	static JTextArea textArea21;
	static JTextArea textArea23;
	
	public static void main(String[] args) {
		init();
		PrintMain.startPanel();
		thread();
	}
	/**
	 * 初始化
	 */
	public static void init(){
		year = DateUtil.getYear(new Date());
		month = DateUtil.getMonth(new Date());
		day = DateUtil.getDay(new Date());
		week = DateUtil.getWeekOfDate(new Date());
		time = DateUtil.getTime(new Date());
		System.out.println(getData());
	}
	/**
	 * 加载数据
	 */
	public  static String  getData(){
		return HttpUtil.sendPostUrl(URL, "username=1&pwd=12&wish.accId=1111111111", "utf-8");
	}
	/**
	 * 刷新数据
	 */
	public static void reloadData(){
		init();
		textArea.setText("    " + year + " 年  " + month + " 月  " + day + " 日"); 
		textArea2.setText(week); 
		//textArea3.setText(time);
		textArea5.setText(total);
	    textArea7.setText(number + " 位读者");  
		textArea9.setText(name);
		textArea11.setText(daycount);  
		textArea13.setText(stunum);  
		textArea15.setText(readtotail);  
		textArea17.setText(school);
		textArea19.setText(currentcount);  
		textArea21.setText(major);  
	    textArea23.setText(noreturn); 
	}
	/**
	 * 启动面板
	 */
	public static void startPanel(){
		 frame = new JFrame();  
		 frame.setLayout(new GridLayout(0,1));
		 p2 = new Panel();
		 p2.setLayout(new GridLayout(6,4));
		 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 frame.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				 System.exit(0);
			 }
		 });
		 
		 textArea = new JTextArea(); 
	     textArea.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE));
	     
	     textArea2 = new JTextArea(); 
	     textArea2.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE));
	     
	     textArea3 = new JTextArea();
	     textArea3.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE));
	     textArea3.setText(time); 
	     
	     JTextArea textArea4 = new JTextArea();
	     textArea4.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea4.setText("总进馆人数");  
	     
	     textArea5 = new JTextArea();
	     textArea5.setForeground(Color.blue);
	     textArea5.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	    
	     JTextArea textArea6 = new JTextArea();
	     textArea6.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea6.setText("您是第");  
	     
	     textArea7 = new JTextArea();
	     textArea7.setForeground(Color.blue);
	     textArea7.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	    
	     JTextArea textArea8 = new JTextArea();
	     textArea8.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea8.setText("欢迎您");  
	     
	     textArea9 = new JTextArea();
	     textArea9.setForeground(Color.blue);
	     textArea9.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     
	     JTextArea textArea10 = new JTextArea();
	     textArea10.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea10.setText("今天进馆次数");  
	     
	     textArea11 = new JTextArea();
	     textArea11.setForeground(Color.blue);
	     textArea11.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	    
	     JTextArea textArea12 = new JTextArea();
	     textArea12.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea12.setText("学号");  
	     
	     textArea13 = new JTextArea();
	     textArea13.setForeground(Color.blue);
	     textArea13.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     
	     JTextArea textArea14 = new JTextArea();
	     textArea14.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea14.setText("借阅总数");  
	     
	     textArea15 = new JTextArea();
	     textArea15.setForeground(Color.blue);
	     textArea15.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     
	     JTextArea textArea16 = new JTextArea();
	     textArea16.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea16.setText("学院");  
	     
	     textArea17 = new JTextArea();
	     textArea17.setForeground(Color.blue);
	     textArea17.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     
	     JTextArea textArea18 = new JTextArea();
	     textArea18.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea18.setText("当前借阅图书");  
	     
	     textArea19 = new JTextArea();
	     textArea19.setForeground(Color.blue);
	     textArea19.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	    
	     JTextArea textArea20 = new JTextArea();
	     textArea20.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea20.setText("专业");  
	     
	     textArea21 = new JTextArea();
	     textArea21.setForeground(Color.blue);
	     textArea21.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     
	     JTextArea textArea22 = new JTextArea();
	     textArea22.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
	     textArea22.setText("到期未还图书");  
	     
	     textArea23 = new JTextArea();
	     textArea23.setForeground(Color.blue);
	     textArea23.setFont(new Font(Font.DIALOG,Font.BOLD,FONG_SIZE_DETILE));
		
		 p2.add(textArea);
		 p2.add(new JTextArea(""));
		 p2.add(textArea2);
		 p2.add(textArea3);
		 
		 p2.add(textArea4);
		 p2.add(textArea5);
		 p2.add(textArea6);
		 p2.add(textArea7);
		 
		 p2.add(textArea8);
		 p2.add(textArea9);
		 p2.add(textArea10);
		 p2.add(textArea11);
		 
		 p2.add(textArea12);
		 p2.add(textArea13);
		 p2.add(textArea14);
		 p2.add(textArea15);
		 
		 p2.add(textArea16);
		 p2.add(textArea17);
		 p2.add(textArea18);
		 p2.add(textArea19);
		 
		 p2.add(textArea20);
		 p2.add(textArea21);
		 p2.add(textArea22);
		 p2.add(textArea23);
		 
		 p2.setVisible(true);
		
	     frame.add(p2);
	     frame.setSize(620,300);  
	     frame.setResizable(false);
	     frame.setVisible(true);  
	    
	}
	/**
	 * 启动线程
	 */
	public static void thread(){
		
		Thread t1 = new TreadTime();
		Thread t2 = new TreadData();
		t1.start();  
	    t2.start();  
	    
	}
	/**
	 * 时间线程
	 */
	static class TreadTime extends Thread {  
	    public void run() {  
	    	 try {
	    		 while(true){
	    			 Thread.sleep(1000);
	    			 System.out.println("RunnableTreadTime："+ new Date().getSeconds());
	    			 time = DateUtil.getTime(new Date());
	    			 textArea3.setText(time);
	    		 }
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }  
	  
	} 
	/**
	 * 加载数据线程
	 */
	static class TreadData extends Thread {  
	    public void run() {  
	    	 try {
	    		 while(true){
	    			 System.out.println("RunnableTreadData：" + new Date().getSeconds());
	    			 reloadData();
			         p2.revalidate();
			         frame.revalidate();
			         Thread.sleep(5000);
	    		 }
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }  
	  
	} 
	
}
