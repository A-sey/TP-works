// �������� ������� � ������ ������. ����������� ������ ��� ��������� ��� 
import java.io.IOException;

/** 
 * �����, ���������� ����� main � ���������� �������� � ������ �������
 */
public class Lect1 {

	/**
	 * @param args - ������� ��������� ���������
	 * @throws IOException - �������� �� ����������� ������������� ���������� �����/������
	 */
	public static void main(String[] args) throws IOException {
		// ��������� ������� ������, ������ �� ����� 256 �������� 
		byte[] buff = new byte[255];
		System.in.read(buff);
		
		// �������� ���������� ������ Cutter cutter
		Cutter cutter = new Cutter();
		// �������� � cutter ������� ������
		cutter.setText(new String(buff));
		// �������������� ������ (�������� ������� ��������)
		cutter.cut();
		// ����� ������������ ������
		System.out.println(cutter.getNewText());
				
		// �������� ���������� ������ Replace repl
		Replacer repl = new Replacer();
		// �������� � repl ������� ������
		repl.setText(new String(buff));
		// ������ � ������ ���� ' ' �� '_'
		repl.replace();
		// ����� ������������ ������
		System.out.println(repl.getNewText());
		// �������� ���� ������� '_' �� ������, ������������ �� ������� �����
		repl.cut();
		// ����� ������������ ������
		System.out.println(repl.getNewText());
		// ��������� ��������� ������
		repl.update();
		// ������ ���� �������� 'a' �� '_'
		repl.replace("a");
		// ����� ������������ ������
		System.out.println(repl.getNewText());
		
		Cutter cut = new Cutter();
	}
}

// �������� ������:
// dert  tre     ret aaa ytre