package cn.just.Note;

public class MyClipboardTest {

	public static void main(String[] args) {
		MyClipboard mycb=new MyClipboard();
		String s=new String("ABC");
		System.out.println("���ַ������������");
		mycb.setData(s);
		System.out.println("�Ӽ������ȡ�ַ���");
		System.out.println("���ݣ�"+mycb.getData());
	}

}
