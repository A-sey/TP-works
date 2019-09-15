package sample;

/**
 * Класс для хранения настроек приложения
 */
public class Prefs {
    // Имя редактируемого файла
    private String donName;
    // Имя итогового файла
    private String recName;

    /**
     * Конструктор по умолчанию. Заполняет строки с именами файлов стандартными значениями
     */
    public Prefs(){
        donName = "C:\\Temp\\logdet15-08-11.log";
        recName = "C:\\Temp\\newFile.txt";
    }

    /**
     * Конструктор класса. Позволяет задать имена файлов.
     * @param donorFile - Имя редактируемого файла
     * @param recipientFile - Имя итогового файла
     */
    public Prefs(String donorFile, String recipientFile){
        donName = donorFile;
        recName = recipientFile;
    }

    /**
     * Получение имени редактируемого файла
     * @return - Имя файла
     */
    public String getDonorFile(){
        return donName;
    }

    /**
     * Получение имени итогового файла
     * @return - Имя файла
     */
    public String getRecipientFile(){
        return recName;
    }

    /**
     * Установка имени редактируемого файла
     * @param donorFile - Имя файла
     */
    public void setDonorFile(String donorFile){
        donName = donorFile;
    }

    /**
     * Установка имени итогового файла
     * @param recipientFile - Имя файла
     */
    public void setRecipientFile(String recipientFile){
        recName = recipientFile;
    }
}
