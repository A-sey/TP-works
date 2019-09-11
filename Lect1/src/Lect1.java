// Домашнее задание с первой лекции. Программный пример трёх принципов ООП 
import java.io.IOException;

/** 
 * Класс, содержащий метод main и являющийся ключевым в данном проекте
 */
public class Lect1 {

	/**
	 * @param args - Входные параметры программы
	 * @throws IOException - указание на вероятность возникновения исключений ввода/вывода
	 */
	public static void main(String[] args) throws IOException {
		// Получение входной строки, длиной не более 256 символов 
		byte[] buff = new byte[255];
		System.in.read(buff);
		
		// Создание экземпляра класса Cutter cutter
		Cutter cutter = new Cutter();
		// Внесение в cutter входной строки
		cutter.setText(new String(buff));
		// Преобразование строки (удаление двойных пробелов)
		cutter.cut();
		// Вывод получившейся строки
		System.out.println(cutter.getNewText());
				
		// Создание экземпляра класса Replace repl
		Replacer repl = new Replacer();
		// Внесение в repl входной строки
		repl.setText(new String(buff));
		// Замена в строке всех ' ' на '_'
		repl.replace();
		// Вывод получившейся строки
		System.out.println(repl.getNewText());
		// Удаление всех двойных '_' из строки, получившейся на прошлом этапе
		repl.cut();
		// Вывод получившейся строки
		System.out.println(repl.getNewText());
		// Обнуление изменений строки
		repl.update();
		// Замена всех символов 'a' на '_'
		repl.replace("a");
		// Вывод получившейся строки
		System.out.println(repl.getNewText());
		
		Cutter cut = new Cutter();
	}
}

// Тестовый пример:
// dert  tre     ret aaa ytre