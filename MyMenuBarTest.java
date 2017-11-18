package cn.just.Note;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyMenuBarTest implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());      //输出菜单项的标题
	}
	public static void main(String[] args){
		Frame f=new Frame("MyMenuBar Test");    
		MyMenuBar mb=new MyMenuBar(f);        //创建mb对象并添加到Frame中
		mb.addMenus(new String[]{"文件","查找"});
		//添加菜单选项
		mb.addMenuItems(0, new String[]{"新建","打开","保存",null,"退出"});
		mb.addMenuItems(1, new String[]{"查找",null,"查找替代"});
		//注册ActionListener
		mb.addActionListener(new MyMenuBarTest());
			//关闭窗口
		f.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
   		 
   	 });
		
		
		f.setSize(300,300);
		f.setVisible(true);
		
		
	}
	
	
	
}