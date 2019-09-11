/**
 * ����� ��� �������� ������� ��������
 */
public class Cutter {
	// ����������� �����
	private String oldText;
	// ����� ����� (���������� ����� ���������)
	protected String newText;
	
	/**
	 * ����������� ������. ������ ������ ������ ������ �� ������������� �����-���� ��������
	 */
	public Cutter() {}
	
	/**
	 * �������� ������
	 * @param str - ����� ��� ����������� ���������
	 */
	public void setText(String str) {
		oldText = newText = str;
	}
	
	/**
	 * ����������� ����������� ������ � ��������������� ���������
	 */
	public void update() {
		newText = oldText;
	}
	
	/**
	 * ����������� ���� ������� ��������
	 */
	public void cut() {
		// �������������� ����������� ������
		String result = newText;
		while(true) {
			// ������ ������� �������� �� ���������
			String temp = result.replace("  ", " ");
			// ���� ������ �� ����������..
			if (result.equals(temp)) {
				// ..�� ��������� ��������� � ��������� ���������� �������
				newText = result;
				return;
			}
			else {
				// ..����� ������������� ��������� �� ��������� ���������� � ������� ��� ���
				result = temp;
			}
		}
	}
	
	/**
	 * ��������� ������������ ������, ��������� �������� getText(String str)
	 * @return - ����������� �����
	 */
	public String getOldText() {
		return oldText;
	}
	
	/**
	 * ��������� ���������� ������
	 * @return - ����� ����� ���������
	 */
	public String getNewText() {
		return newText;
	}

}
