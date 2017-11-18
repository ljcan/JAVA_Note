package cn.just.Note;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试MyFindDialog类
 * @author Shinelon
 *
 */
public class MyFindDialogTest {
     public static void main(String[] args){
    	 Frame f=new Frame("MyFindDialog Test");
    	 TextArea ta=new TextArea();
    	 f.add(ta);
    	 MyFindDialog fDlg=new MyFindDialog(f,ta);       //查找替换对话框
    	 f.setSize(300,300);
    	 f.setVisible(true);
    	 fDlg.showFind();
    	 fDlg.showReplace();             //显示查找替换对话框
     }
}
