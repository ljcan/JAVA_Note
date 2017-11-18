package cn.just.Note;
import java.awt.Frame;
import java.awt.Menu;
/**
 * ��˵�����Ӷ���˵�������ע�ᶯ��������
 */
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MyMenuBar extends MenuBar{
   public MyMenuBar(Frame parent){
	   parent.setMenuBar(this);         //��parent�������
   }
   //�����menu[i]Ϊ����Ĳ˵�
   public void addMenus(String menu[]){
	  for(int i=0;i<menu.length;i++){
		  add(new Menu(menu[i]));
	  }
   }
   //Ϊÿ���˵����ѡ��
   public void addMenuItems(int menuNumber,String[] items){
	   for(int i=0;i<items.length;i++){
		   //���ַ���Ϊ�գ�����ӷָ���separator���������ѡ��
		   if(items[i]!=null){
			   getMenu(menuNumber).add(new MenuItem(items[i]));
		   }
	   }
   }
   //ע�ᶯ���¼�������
   public void addActionListener(ActionListener al){
	   //ѭ�����˵��ĸ���
	   for(int i=0;i<getMenuCount();i++){
		   //ѭ������i�˵��ĸ���
		   for(int j=0;j<getMenu(i).getItemCount();j++){
			   //���i�˵��ĵ�j����Ŀע�ᶯ���¼�������
			   getMenu(i).getItem(j).addActionListener(al);
		  }
	   }
   }
  
   
}   
   
   
   
   
   
   


