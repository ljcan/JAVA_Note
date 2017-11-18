package cn.just.Note;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFile {
    private FileDialog fDlg;        //�ļ��Ի���
    public MyFile(Frame parent){
    	fDlg=new FileDialog(parent,"",FileDialog.LOAD);     //��ʼ���ļ��Ի���
    }
    private String getPath(){
    	return fDlg.getDirectory()+"\\"+fDlg.getFile();          //����ѡ���ļ�·��
    }
    public String getData() throws IOException{
    	fDlg.setTitle("��");
    	fDlg.setMode(FileDialog.LOAD);            //���ļ��Ի����ģʽ�趨Ϊ��ģʽ
    	fDlg.setVisible(true);
    	//��ȡ�ļ��Ի�����ļ������ݲ����䷵��
    	BufferedReader br=new BufferedReader(new FileReader(getPath()));
    	StringBuffer sb=new StringBuffer();
    	String aline;
    	while((aline=br.readLine())!=null)
    		sb.append(aline+'\n');                 //��ȡ���ݵ��ַ�������
    		br.close();
    		return sb.toString();
    }
    public void setData(String data) throws IOException{
    	//��ʾ����ģʽ�Ի��򣬲�������data����ѡ�е��ļ���
    	fDlg.setTitle("����");
    	fDlg.setMode(FileDialog.SAVE);
    	fDlg.setVisible(true);
    	BufferedWriter bw=new BufferedWriter(new FileWriter(getPath()));
    	bw.write(data);
    	bw.close();
  	
    }
    
    
}
