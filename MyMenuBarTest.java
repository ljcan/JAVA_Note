package cn.just.Note;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyMenuBarTest implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());      //����˵���ı���
	}
	public static void main(String[] args){
		Frame f=new Frame("MyMenuBar Test");    
		MyMenuBar mb=new MyMenuBar(f);        //����mb������ӵ�Frame��
		mb.addMenus(new String[]{"�ļ�","����"});
		//��Ӳ˵�ѡ��
		mb.addMenuItems(0, new String[]{"�½�","��","����",null,"�˳�"});
		mb.addMenuItems(1, new String[]{"����",null,"�������"});
		//ע��ActionListener
		mb.addActionListener(new MyMenuBarTest());
			//�رմ���
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