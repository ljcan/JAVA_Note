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
    private FileDialog fDlg;        //文件对话框
    public MyFile(Frame parent){
    	fDlg=new FileDialog(parent,"",FileDialog.LOAD);     //初始化文件对话框
    }
    private String getPath(){
    	return fDlg.getDirectory()+"\\"+fDlg.getFile();          //返回选中文件路径
    }
    public String getData() throws IOException{
    	fDlg.setTitle("打开");
    	fDlg.setMode(FileDialog.LOAD);            //将文件对话框的模式设定为打开模式
    	fDlg.setVisible(true);
    	//读取文件对话框的文件的内容并将其返回
    	BufferedReader br=new BufferedReader(new FileReader(getPath()));
    	StringBuffer sb=new StringBuffer();
    	String aline;
    	while((aline=br.readLine())!=null)
    		sb.append(aline+'\n');                 //读取数据到字符缓冲区
    		br.close();
    		return sb.toString();
    }
    public void setData(String data) throws IOException{
    	//显示保存模式对话框，并将数据data存入选中的文件中
    	fDlg.setTitle("保存");
    	fDlg.setMode(FileDialog.SAVE);
    	fDlg.setVisible(true);
    	BufferedWriter bw=new BufferedWriter(new FileWriter(getPath()));
    	bw.write(data);
    	bw.close();
  	
    }
    
    
}
