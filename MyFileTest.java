package cn.just.Note;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * 测试MyFile
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
	  MyFile mf=new MyFile(f);                        //位MyFile创建Frame
	  try {
		ta.setText(mf.getData());         //从文件读取数据ta，并显示在ta
		  mf.setData(ta.getText());         //将ta中的内容存储到文件中
	} catch (IOException e) {
		//e.printStackTrace();
	}
		//关闭窗口
		f.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
 		 
 	 });
	  
	  
	  
  }
}
