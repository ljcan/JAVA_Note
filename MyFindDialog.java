package cn.just.Note;
import java.awt.Button;
/**
 * 创建查找替换对话框
 */
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFindDialog extends Dialog implements ActionListener{
	private static boolean truereplace=false;    // 若查到到多个与待查找字符串相等的字符则一直替换
	
   //创建对话框所使用的组件
	private Label lFind=new Label("查找字符串：");
	private Label lReplace=new Label("替换字符串：");
	private TextField tFind=new TextField(10);        //接收待查的字符串
	private TextField tReplace=new TextField(10);      //接收要替换的字符串
	private Button bFind=new Button("查找");           //查找按钮
	private Button bReplace=new Button("替换");         //替换按钮
	private TextArea ta;       // ta为含待查字符串的TextFiled
	public MyFindDialog(Frame owner,TextArea ta) {        //构造器
		super(owner,"查找",false);        //非模式对话框,及不考虑当前对话框的句柄
		this.ta=ta;
		setLayout(null);                    //将setlayout设为null
		//设置组件的位置大小
		lFind.setBounds(10,30, 80, 20);
		lReplace.setBounds(10, 70, 80, 20);
		tFind.setBounds(90,30,90,20);
		tReplace.setBounds(90,70,90,20);
		bFind.setBounds(190, 30, 80, 20);
		bReplace.setBounds(190,70,80,20);
		//添加组件
		add(lFind); add(lReplace);
		add(tFind); add(tReplace);
		add(bFind); add(bReplace);
		//禁止用户调整对话框的大小
		setResizable(false);
		//为两个按钮注册动作监听器
		bFind.addActionListener(this);
		bReplace.addActionListener(this);
		//为对话框注册窗口关闭事件监听器
		addWindowListener(new WindowAdapter(){
			public void windowsClosing(WindowEvent e){
				MyFindDialog.this.dispose();
			}
		});	
	}      //构造函数结束
   //设置查找对话框
	public void showFind(){
		setTitle("查找");
		setSize(280,60);
		setVisible(true);
	}
	//设置查找替换对话框
	public void showReplace(){
		setTitle("查找替换");
		setSize(280,110);
		setVisible(true);
	}
	public void find(){
		String text=ta.getText();         //从ta中获取字符串并存入text中
		String str=tFind.getText();        //获取tFind字符串并存入str中
		int end=text.length();          //获取ta字符串的长度
		int len=str.length();             //获取tFind的字符串的长度
		int start=ta.getSelectionEnd();       //从光标位置开始查找字符串
		if(start==end) start=0;                //若光标位于末尾，则从头开始查找
		for(;start<=end-len;start++){
			if(text.substring(start, start+len).equals(str)){       //若找到查找字符串
				ta.setSelectionStart(start);
				ta.setSelectionEnd(start+len);
				return;
			}
		}
		//若找不到待查字符串，则将光标至于末尾
		ta.setSelectionStart(end);
		ta.setSelectionEnd(end);
		truereplace=true;                   /////////////////////////
	}
	public void replace(){
		
		String str=tReplace.getText();         //获取待查字符串
		//若选中的字符串与待查字符串一致，则将其替换为替换字符串
		//若选中的字符串与待查字符串不同，则继续查找
		
				
		if(ta.getSelectedText().equals(tFind.getText()))
			ta.replaceRange(str, ta.getSelectionStart(),ta.getSelectionEnd());
		else while(!truereplace){find();}         ///////////////////
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bFind)
			find();
		else if(e.getSource()==bReplace)
			replace();
	}
	

}
