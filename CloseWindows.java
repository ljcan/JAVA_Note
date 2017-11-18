package cn.just.Note;
/**
 * 关闭窗口
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class CloseWindows {

	 public void launchFrame(){
    	//   利用WindowsAdapter，创建匿名类实现窗口的关闭
    	 addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
    		 
    	 });
     }

	private void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}
}
