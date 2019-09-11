/**
 * ����� ��� ������ �������� �� '_'
 */
public class Replacer extends Cutter {
	/**
	 * ����������� ������
	 */
	public Replacer() {	}
	
	/**
	 * ������ ���� �������� �� ������ �������������
	 */
	public void replace() {
		newText = newText.replaceAll(" ", "_");
	}
	
	/**
	 * ������ �������� ��������� �� ������ �������������
	 * @param r - ��������� ��� ������
	 */
	protected void replace(String r) {
		newText = newText.replace(r, "_");
	}
	
	/**
	 * ����������� ���� ������� ������ �������������
	 */
	public void cut() {
		// ��������� ����������, ���������� ����� ��� ���������
		String result = newText;
		while(true) {
			// ������ "__" �� "_"
			String temp = result.replace("__", "_");
			// ���� ������ �� ����������.. 
			if (result.equals(temp)) {
				// ..�� ��������� ��������� � ��������� ���������� �������
				newText = result;
				return;
			}
			else {
				// ..����� ������������� ��������� � ���������� ����������
				result = temp;
			}
		}
	}

}
