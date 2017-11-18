package cn.just.Note;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * ����MyFile
 * @author Shinelon
 *
 */
public class MyFileTest {
  public static void main(String[] args){
	  Frame f=new Frame("MyFile Test");
	  TextArea ta=new TextArea();
	  f.add(ta);
	  f.setSize(300,300);
	  f.setVisible(true);
	  MyFile mf=new MyFile(f);                        //λMyFile����Frame
	  try {
		ta.setText(mf.getData());         //���ļ���ȡ����ta������ʾ��ta
		  mf.setData(ta.getText());         //��ta�е����ݴ洢���ļ���
	} catch (IOException e) {
		//e.printStackTrace();
	}
		//�رմ���
		f.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
 		 
 	 });
	  
	  
	  
  }
}
