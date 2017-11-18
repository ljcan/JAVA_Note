package cn.just.Note;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * ʵ��һ���ʼǱ�APP�Ĺ���
 * @author Shinelon
 *
 */
public class MyMemo extends Frame implements ActionListener{
   private TextArea editor=new TextArea();      //�ɱ༭��TextArea
   private MyFile mf=new MyFile(this);       
   private MyClipboard cb=new MyClipboard();
   private MyFindDialog findDlg=new MyFindDialog(this,editor);        //���ҶԻ���
  public MyMemo(String title){
	  super(title);
	  MyMenuBar mb=new MyMenuBar(this);
	  mb.addMenus(new String[]{"�ı�","�༭","����","����"});
	  mb.addMenuItems(0, new String[]{"�½�","��","����",null,"�˳�"});
	  mb.addMenuItems(1,new String[]{"����","����","ճ��","���",null,"ȫѡ"});
	  mb.addMenuItems(2, new String[]{"����",null,"�����滻"});
	  mb.addMenuItems(3, new String[]{"�ҵļ��±���Ϣ"});
	  add(editor);
	  mb.addActionListener(this);       //Ϊ�˵���ע�ᶯ���¼�������
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
  }          //���캯������
public void actionPerformed(ActionEvent e) {
	String selected=e.getActionCommand();        //��ȡ�˵������
	if(selected.equals("�½�")){
		editor.setText("");
	}else if(selected.equals("��")){
		try {
			editor.setText(mf.getData());
		} catch (IOException e1) {
			//e1.printStackTrace();
		}
	}else if(selected.equals("����")){
		try {
			mf.setData(editor.getText());
		} catch (IOException e1) {
	    //		e1.printStackTrace();
		}
	}else if(selected.equals("�˳�")){
		dispose();
	}else if(selected.equals("����")){
		//��ѡ���ַ������Ƶ��������в�����ַ���
		cb.setData(editor.getSelectedText());
		editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
	}else if(selected.equals("����")){
		//��ѡ�е����ָ��Ƶ���������
		cb.setData(editor.getSelectedText());
	}else if(selected.equals("ճ��")){
		//�Ӽ������ж�ȡ�ַ�������ճ����������ڵ�λ��
		String str=cb.getData();
		editor.replaceRange(str, editor.getSelectionStart(), editor.getSelectionEnd());
	}else if(selected.equals("���")){
		editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
	}else if(selected.equals("ȫѡ")){
		//ѡ����������
		editor.setSelectionStart(0);
		editor.setSelectionEnd(editor.getText().length());
	}else if(selected.equals("����")){
		//��ʾ���ҶԻ���
		findDlg.showFind();
	}else if(selected.equals("�����滻")){
		findDlg.showReplace();
	}
}
   public static void main(String[] args){
	MyMemo memo=new MyMemo("�ҵļ��±�");
	memo.setSize(600, 600);
	memo.setVisible(true);  
   }
}
