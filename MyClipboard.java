package cn.just.Note;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MyClipboard {
   private Clipboard cb;        //剪贴板
   public MyClipboard(){        //构造函数，获取系统剪贴板
	   cb=Toolkit.getDefaultToolkit().getSystemClipboard();        
   }
   public void setData(String data){        //将字符串存入剪贴板
	   cb.setContents(new StringSelection(data), null);
   }
   public String getData(){          //从剪贴板读取数据，并将其返回
	   Transferable content=cb.getContents(null);
	   try {
		   //DataFlavor.stringFlavor会将剪贴板中的字符串转换成Unicode码形式的String 对象
		   //DataFlavor类是与存储在剪贴板上的数据的形式有关的类
		return (String)content.getTransferData(DataFlavor.stringFlavor);
	} catch (UnsupportedFlavorException | IOException e) {
		//e.printStackTrace();
	}
	   return null;
   }
}
