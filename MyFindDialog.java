package cn.just.Note;
import java.awt.Button;
/**
 * ���������滻�Ի���
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
	private static boolean truereplace=false;    // ���鵽�������������ַ�����ȵ��ַ���һֱ�滻
	
   //�����Ի�����ʹ�õ����
	private Label lFind=new Label("�����ַ�����");
	private Label lReplace=new Label("�滻�ַ�����");
	private TextField tFind=new TextField(10);        //���մ�����ַ���
	private TextField tReplace=new TextField(10);      //����Ҫ�滻���ַ���
	private Button bFind=new Button("����");           //���Ұ�ť
	private Button bReplace=new Button("�滻");         //�滻��ť
	private TextArea ta;       // taΪ�������ַ�����TextFiled
	public MyFindDialog(Frame owner,TextArea ta) {        //������
		super(owner,"����",false);        //��ģʽ�Ի���,�������ǵ�ǰ�Ի���ľ��
		this.ta=ta;
		setLayout(null);                    //��setlayout��Ϊnull
		//���������λ�ô�С
		lFind.setBounds(10,30, 80, 20);
		lReplace.setBounds(10, 70, 80, 20);
		tFind.setBounds(90,30,90,20);
		tReplace.setBounds(90,70,90,20);
		bFind.setBounds(190, 30, 80, 20);
		bReplace.setBounds(190,70,80,20);
		//������
		add(lFind); add(lReplace);
		add(tFind); add(tReplace);
		add(bFind); add(bReplace);
		//��ֹ�û������Ի���Ĵ�С
		setResizable(false);
		//Ϊ������ťע�ᶯ��������
		bFind.addActionListener(this);
		bReplace.addActionListener(this);
		//Ϊ�Ի���ע�ᴰ�ڹر��¼�������
		addWindowListener(new WindowAdapter(){
			public void windowsClosing(WindowEvent e){
				MyFindDialog.this.dispose();
			}
		});	
	}      //���캯������
   //���ò��ҶԻ���
	public void showFind(){
		setTitle("����");
		setSize(280,60);
		setVisible(true);
	}
	//���ò����滻�Ի���
	public void showReplace(){
		setTitle("�����滻");
		setSize(280,110);
		setVisible(true);
	}
	public void find(){
		String text=ta.getText();         //��ta�л�ȡ�ַ���������text��
		String str=tFind.getText();        //��ȡtFind�ַ���������str��
		int end=text.length();          //��ȡta�ַ����ĳ���
		int len=str.length();             //��ȡtFind���ַ����ĳ���
		int start=ta.getSelectionEnd();       //�ӹ��λ�ÿ�ʼ�����ַ���
		if(start==end) start=0;                //�����λ��ĩβ�����ͷ��ʼ����
		for(;start<=end-len;start++){
			if(text.substring(start, start+len).equals(str)){       //���ҵ������ַ���
				ta.setSelectionStart(start);
				ta.setSelectionEnd(start+len);
				return;
			}
		}
		//���Ҳ��������ַ������򽫹������ĩβ
		ta.setSelectionStart(end);
		ta.setSelectionEnd(end);
		truereplace=true;                   /////////////////////////
	}
	public void replace(){
		
		String str=tReplace.getText();         //��ȡ�����ַ���
		//��ѡ�е��ַ���������ַ���һ�£������滻Ϊ�滻�ַ���
		//��ѡ�е��ַ���������ַ�����ͬ�����������
		
				
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
