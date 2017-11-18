package cn.just.Note;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MyClipboard {
   private Clipboard cb;        //������
   public MyClipboard(){        //���캯������ȡϵͳ������
	   cb=Toolkit.getDefaultToolkit().getSystemClipboard();        
   }
   public void setData(String data){        //���ַ������������
	   cb.setContents(new StringSelection(data), null);
   }
   public String getData(){          //�Ӽ������ȡ���ݣ������䷵��
	   Transferable content=cb.getContents(null);
	   try {
		   //DataFlavor.stringFlavor�Ὣ�������е��ַ���ת����Unicode����ʽ��String ����
		   //DataFlavor������洢�ڼ������ϵ����ݵ���ʽ�йص���
		return (String)content.getTransferData(DataFlavor.stringFlavor);
	} catch (UnsupportedFlavorException | IOException e) {
		//e.printStackTrace();
	}
	   return null;
   }
}
