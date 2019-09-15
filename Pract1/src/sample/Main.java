package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.*;


public class Main extends Application {
    Prefs prefs;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Создание переменной для хранения настроек
        prefs = new Prefs();
        // Создание панели для последующей разметки
        TilePane root = new TilePane();
        // Установка выравнивания элементов
        root.setAlignment(Pos.CENTER);
        // Установка расстояния между элементами
        root.setVgap(10);
        root.setHgap(10);
        // Связывание главного окна и текущей разметки. Установка размеров окна
        primaryStage.setScene(new Scene(root, 450, 100));

        // Установка кнопки выбора файлов
        Button setFiles = new Button("Выбрать файлы");
        // Задание действий для выполнения при нажатии на кнопку
        setFiles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Открытие окна для установки имён файлов
                setFiles();
            }
        });

        // Кнопка для изменения файла
        Button doIt = new Button("Преобразовать файл");
        // Задание действий при нажатии на кнопку
        doIt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Выполнение преобразования
                    doAll();
                }catch (Exception e){
                    e.getStackTrace();
                }
            }
        });

        // Кнопка для открытия итогового файла в блокноте
        Button openFile = new Button("Открыть файл");
        // Задание действий при нажатии
        openFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    // Открытие файла
                    Process process = Runtime.getRuntime().exec("cmd /c notepad.exe " + prefs.getRecipientFile());
                }catch (Exception e){
                    e.getStackTrace();
                }
            }
        });

        // Добавление кнопок на панель
        root.getChildren().addAll(setFiles, doIt, openFile);
        // Открытие окна
        primaryStage.show();
    }

    /**
     * Окно задания имён файлам
     */
    private void setFiles(){
        // Обозначение нового окна
        Stage firstStage = new Stage();
        // Панель для нового окна
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        // Установка выравнивания
        pane.setAlignment(Pos.CENTER);
        // Установка расстояния между объектами
        pane.setHgap(10);
        pane.setVgap(10);
        // Текстовое поле для имени редактируемого файла
        TextField dArea = new TextField();
        // Установка размеров поля
        dArea.setPrefWidth(450);
        // Установка значения имени из переменной настроек
        dArea.setText(prefs.getDonorFile());
        // Поле для имени итогового файла
        TextField rArea = new TextField();
        // Установка имени файла из переменной настроек
        rArea.setText(prefs.getRecipientFile());
        // Установка размеров поля
        rArea.setPrefWidth(450);
        // Кнопка для подтверждения
        Button ok = new Button("Выбрать");
        // Установка размеров кнопки
        ok.setPrefWidth(450);
        // Задание действий при нажатии
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Внесение в настройки новых имён файлов
                prefs.setDonorFile(dArea.getText());
                prefs.setRecipientFile(rArea.getText());
                // Закрытие окна выбора имён
                firstStage.close();
            }
        });

        // Привязка окна к разметке
        firstStage.setScene(new Scene(pane, 500, 150));
        // Добавление на разметку объектов
        pane.getChildren().addAll(dArea, rArea, ok);
        // Открытие окна
        firstStage.show();
    }

    /**
     * Редактирование файла
     * @throws Exception
     */
    private void doAll() throws Exception{
        // Переменная для чтения старого файла
        BufferedReader reader = new BufferedReader(new FileReader(prefs.getDonorFile()));
        // Переменная для записи в новый файл
        BufferedWriter writer = new BufferedWriter(new FileWriter(prefs.getRecipientFile()));
        // Считываем первую строку во временную переменную
        String line = reader.readLine();
        // Пока строка не равна null
        while(line!=null){
            // Замена нулей на null
            line = line.replace("  0,0 ", " null ");
            line = line.replace("   0 ", "null ");
            // Запись строки в новый файл
            writer.write(line+"\r\n");
            // Считывание новой строки
            line = reader.readLine();
        }
        // Закрытие переменных
        reader.close();
        writer.close();

        // Создание окна подтверждения
        Stage secondStage = new Stage();
        // Панель с вертикальной ориентацией
        TilePane pane = new TilePane(Orientation.VERTICAL);
        // Установка отступов
        pane.setVgap(10);
        // Установка выравнивания
        pane.setAlignment(Pos.CENTER);
        // Текст про успешность выполнения
        Label text = new Label("Job done!");
        // Кнопка для закрытия окна
        Button ok = new Button("OK");
        ok.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Закрытие окна
                secondStage.close();
            }
        });
        // Связывание окна и разметки
        secondStage.setScene(new Scene(pane,150, 100));
        // Добавление элементов на панель
        pane.getChildren().addAll(text,ok);
        // Открытие окна
        secondStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
