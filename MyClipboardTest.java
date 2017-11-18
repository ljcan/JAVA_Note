package cn.just.Note;

public class MyClipboardTest {

	public static void main(String[] args) {
		MyClipboard mycb=new MyClipboard();
		String s=new String("ABC");
		System.out.println("½«×Ö·û´®´æÈë¼ôÌù°å");
		mycb.setData(s);
		System.out.println("´Ó¼ôÌù°å¶ÁÈ¡×Ö·û´®");
		System.out.println("ÄÚÈİ£º"+mycb.getData());
	}

}
