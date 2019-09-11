/**
 * Класс для замены символов на '_'
 */
public class Replacer extends Cutter {
	/**
	 * Конструктор класса
	 */
	public Replacer() {	}
	
	/**
	 * Замена всех пробелов на нижнее подчёркивание
	 */
	public void replace() {
		newText = newText.replaceAll(" ", "_");
	}
	
	/**
	 * Замена заданной подстроки на нижнее подчеркивание
	 * @param r - подстрока для замены
	 */
	protected void replace(String r) {
		newText = newText.replace(r, "_");
	}
	
	/**
	 * Уничтожение всех двойных нижних подчеркиваний
	 */
	public void cut() {
		// Временная переменная, содержащая текст для изменения
		String result = newText;
		while(true) {
			// Замена "__" на "_"
			String temp = result.replace("__", "_");
			// Если строка не изменилась.. 
			if (result.equals(temp)) {
				// ..то сохраняем результат и завершаем выполнение функции
				newText = result;
				return;
			}
			else {
				// ..иначе пересохраняем результат и продолжаем выполнение
				result = temp;
			}
		}
	}

}
