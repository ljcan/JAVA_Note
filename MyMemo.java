package cn.just.Note;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * 实现一个笔记本APP的功能
 * @author Shinelon
 *
 */
public class MyMemo extends Frame implements ActionListener{
   private TextArea editor=new TextArea();      //可编辑的TextArea
   private MyFile mf=new MyFile(this);       
   private MyClipboard cb=new MyClipboard();
   private MyFindDialog findDlg=new MyFindDialog(this,editor);        //查找对话框
  public MyMemo(String title){
	  super(title);
	  MyMenuBar mb=new MyMenuBar(this);
	  mb.addMenus(new String[]{"文本","编辑","查找","帮助"});
	  mb.addMenuItems(0, new String[]{"新建","打开","保存",null,"退出"});
	  mb.addMenuItems(1,new String[]{"剪贴","复制","粘贴","清除",null,"全选"});
	  mb.addMenuItems(2, new String[]{"查找",null,"查找替换"});
	  mb.addMenuItems(3, new String[]{"我的记事本信息"});
	  add(editor);
	  mb.addActionListener(this);       //为菜单项注册动作事件监听器
	 /* addWindowsListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent e){
			  MyMemo.this.disable();
		  }
	  });*/
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
   		 
   	 });	
  }          //构造函数结束
public void actionPerformed(ActionEvent e) {
	String selected=e.getActionCommand();        //获取菜单项标题
	if(selected.equals("新建")){
		editor.setText("");
	}else if(selected.equals("打开")){
		try {
			editor.setText(mf.getData());
		} catch (IOException e1) {
			//e1.printStackTrace();
		}
	}else if(selected.equals("保存")){
		try {
			mf.setData(editor.getText());
		} catch (IOException e1) {
	    //		e1.printStackTrace();
		}
	}else if(selected.equals("退出")){
		dispose();
	}else if(selected.equals("剪贴")){
		//将选中字符串复制到剪贴板中并清除字符串
		cb.setData(editor.getSelectedText());
		editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
	}else if(selected.equals("复制")){
		//将选中的文字复制到剪贴板中
		cb.setData(editor.getSelectedText());
	}else if(selected.equals("粘贴")){
		//从剪贴板中读取字符串，并粘贴到光标所在的位置
		String str=cb.getData();
		editor.replaceRange(str, editor.getSelectionStart(), editor.getSelectionEnd());
	}else if(selected.equals("清除")){
		editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
	}else if(selected.equals("全选")){
		//选中所有内容
		editor.setSelectionStart(0);
		editor.setSelectionEnd(editor.getText().length());
	}else if(selected.equals("查找")){
		//显示查找对话框
		findDlg.showFind();
	}else if(selected.equals("查找替换")){
		findDlg.showReplace();
	}
}
   public static void main(String[] args){
	MyMemo memo=new MyMemo("我的记事本");
	memo.setSize(600, 600);
	memo.setVisible(true);  
   }
}
