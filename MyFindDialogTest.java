package cn.just.Note;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ����MyFindDialog��
 * @author Shinelon
 *
 */
public class MyFindDialogTest {
     public static void main(String[] args){
    	 Frame f=new Frame("MyFindDialog Test");
    	 TextArea ta=new TextArea();
    	 f.add(ta);
    	 MyFindDialog fDlg=new MyFindDialog(f,ta);       //�����滻�Ի���
    	 f.setSize(300,300);
    	 f.setVisible(true);
    	 fDlg.showFind();
    	 fDlg.showReplace();             //��ʾ�����滻�Ի���
     }
}
