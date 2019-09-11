/**
 * Класс для удаления двойных пробелов
 */
public class Cutter {
	// Изначальный текст
	private String oldText;
	// Новый текст (полученный после изменений)
	protected String newText;
	
	/**
	 * Конструктор класса. Просто создаёт объект класса не инициализируя какие-либо значения
	 */
	public Cutter() {}
	
	/**
	 * Внесение текста
	 * @param str - текст для последующей обработки
	 */
	public void setText(String str) {
		oldText = newText = str;
	}
	
	/**
	 * Возвращение содержимого строки к первоначальному состоянию
	 */
	public void update() {
		newText = oldText;
	}
	
	/**
	 * Уничтожение всех двойных пробелов
	 */
	public void cut() {
		// Пересохранение изменяемого текста
		String result = newText;
		while(true) {
			// Замена двойных пробелов на одинарные
			String temp = result.replace("  ", " ");
			// Если строка не изменилась..
			if (result.equals(temp)) {
				// ..то сохраняем результат и завершаем выполнение функции
				newText = result;
				return;
			}
			else {
				// ..иначе пересохраняем результат во временную переменную и пробуем ещё раз
				result = temp;
			}
		}
	}
	
	/**
	 * Получение изначального текста, заданного функцией getText(String str)
	 * @return - изначальный текст
	 */
	public String getOldText() {
		return oldText;
	}
	
	/**
	 * Получение изменённого текста
	 * @return - текст после изменений
	 */
	public String getNewText() {
		return newText;
	}

}
