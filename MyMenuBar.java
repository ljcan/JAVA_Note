package cn.just.Note;
import java.awt.Frame;
import java.awt.Menu;
/**
 * 向菜单条添加多个菜单，并且注册动作监听器
 */
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MyMenuBar extends MenuBar{
   public MyMenuBar(Frame parent){
	   parent.setMenuBar(this);         //向parent添加自身
   }
   //添加以menu[i]为标题的菜单
   public void addMenus(String menu[]){
	  for(int i=0;i<menu.length;i++){
		  add(new Menu(menu[i]));
	  }
   }
   //为每个菜单添加选项
   public void addMenuItems(int menuNumber,String[] items){
	   for(int i=0;i<items.length;i++){
		   //若字符串为空，则添加分割线separator，否则，添加选项
		   if(items[i]!=null){
			   getMenu(menuNumber).add(new MenuItem(items[i]));
		   }
	   }
   }
   //注册动作事件监听器
   public void addActionListener(ActionListener al){
	   //循环到菜单的个数
	   for(int i=0;i<getMenuCount();i++){
		   //循环到第i菜单的个数
		   for(int j=0;j<getMenu(i).getItemCount();j++){
			   //向第i菜单的第j个项目注册动作事件监听器
			   getMenu(i).getItem(j).addActionListener(al);
		  }
	   }
   }
  
   
}   
   
   
   
   
   
   


