package cn.just.Note;
/**
 * �رմ���
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class CloseWindows {

	 public void launchFrame(){
    	//   ����WindowsAdapter������������ʵ�ִ��ڵĹر�
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
