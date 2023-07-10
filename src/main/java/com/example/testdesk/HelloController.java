package com.example.testdesk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private ObservableList<DataChem> dataChem = FXCollections.observableArrayList();

    private int operationCount = 0;

    @FXML
    private TextField amorfField;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button calculateButton;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private TextField textField4;

    @FXML
    private TextField textField5;

    @FXML
    private TextField textField6;

    @FXML
    private TextField textField7;

    @FXML
    private TextField textField8;

    @FXML
    private TextField textField9;

    @FXML
    private Button information;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private Button saveResult;

    @FXML
    private Button buttonDelete;

    private double layoutX = 345.0;
    private double layoutY = 97.0;

    private double getLayoutY() {
        if (layoutY <= 370)
            layoutY += 40;
        return layoutY;
    }

    @FXML
    private TextField pathFile;

    @FXML
    TableView<DataChem> tableElements;
    @FXML
    TableColumn<DataChem, Double> withAmorf;
    @FXML
    TableColumn<DataChem, String> elements;
    @FXML
    TableColumn<DataChem, Double> exAmorf;

    @FXML
    private Button refreshId;

    @FXML
    private Button refreshId1;

    private int idText = 9;

    private int getIdText() {
        if (idText <= 16)
            idText += 1;
        return idText;
    }

    private int removeIdText() {

        if (idText > 1) {
            idText -= 1;
        }
        return idText + 1;
    }

    List<String> data = new ArrayList<>();

    List<String> finalData;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(actionEvent -> {
            if (idText >= 1 && idText < 16) {
                if (idText <= 8) {
                    layoutX = 32;
                } else {
                    layoutX = 345;
                }
                if (idText == 8)
                    layoutY = 413;
                else if (idText == 9){
                    layoutY = 97;
                }
                layoutY += 40;
                TextField newText = new TextField();
                newText.layoutXProperty().set(layoutX);
                newText.layoutYProperty().set(layoutY);
                int id = getIdText();
                newText.idProperty().set("textField" + id);
                newText.setMinSize(73,26);
                newText.setMaxSize(73, 26);
                TextField newText1 = new TextField();
                newText1.layoutXProperty().set(layoutX+77);
                newText1.layoutYProperty().set(layoutY);
                newText1.idProperty().set("textFieldNEW" + id);
                newText1.setMinSize(73,26);
                newText1.setMaxSize(73, 26);
                mainPage.getChildren().add(newText1);
                mainPage.getChildren().add(newText);
            }
        });
        buttonDelete.setOnAction(actionEvent -> {
            if (idText > 1 && idText <= 16) {
                if (idText <= 9) {
                    layoutX = 32;
                } else {
                    layoutX = 345;
                }
                if (idText == 9){
                    layoutY = 413;
                }

                else if (idText == 10)
                    layoutY = 97;
                else if (idText < 9)
                    layoutY -= 40;
                else if (idText > 10) layoutY -= 40;

                else if (idText == 16)
                    layoutY = 370;
                int id = removeIdText();
                TextField textField = (TextField) mainPage.lookup("#textField" + id);
                TextField textField1 = (TextField) mainPage.lookup("#textFieldNEW" + id);
                mainPage.getChildren().remove(textField);
                mainPage.getChildren().remove(textField1);
            }
        });


        calculateButton.setOnAction(actionEvent -> {
            operationCount+=1;
            data.clear();
            double result = 0;
            for (int i = 1; i <= idText; i++) {
                TextField text = (TextField) mainPage.lookup("#textField" + i);
                TextField newText = (TextField) mainPage.lookup("#textFieldNEW" + i);
                if (text.getText().split(" ").length != 1 && !text.getText().isEmpty()) {
                    Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);

                    VBox vbox = new VBox(new Text("Check the correctness of the data\n" +
                            "in the field under the number " + i));
                    vbox.setAlignment(Pos.CENTER);
                    vbox.setPadding(new Insets(15));
                    dialogStage.setScene(new Scene(vbox));
                    dialogStage.show();
                }
                if (!text.getText().isEmpty() && !newText.getText().isEmpty()) {
                    String line = "";
                    line += text.getText();
                    line += " " + newText.getText();
                    data.add(line);
                    System.out.println("Добавил: " + line);
                    result += Double.parseDouble(newText.getText().replace(',', '.'));
                }
            }
            finalData = new ArrayList<>();
            if (result > 99 && result < 101){
                if (result != 100){
                    double maxEl = Double.MIN_VALUE;
                    for (int i = 0; i < idText; i++) {
                        TextField newText1 = (TextField) mainPage.lookup("#textFieldNEW" + i);
                        if (newText1!=null){
                            if (!newText1.getText().isEmpty()){
                                double dob = Double.parseDouble(newText1.getText().replace(',', '.'));
                                if (dob > maxEl)
                                    maxEl = dob;
                            }
                        }
                    }
                    for (String el : data){
                        double dob = Double.parseDouble(el.split(" ")[1].replace(',', '.'));
                        if (dob == maxEl){
                            if (result < 100){
                                dob += 100 - result;
                            }
                            else {
                                dob -= result - 100 ;
                            }
                            System.out.println("Удалил: " + el);
                            el = el.split(" ")[0] + " " + dob;
                            System.out.println("Добавил: " + el);
                        }
                        finalData.add(el);
                    }
                }
                else{
                    finalData = data;
                }
                if (amorfField.getText().isEmpty()) {
                    Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    VBox vbox = new VBox(new Text("Enter the value the amorf\nin the range from 0 to 100"));
                    vbox.setAlignment(Pos.CENTER);
                    vbox.setPadding(new Insets(15));
                    dialogStage.setScene(new Scene(vbox));
                    dialogStage.show();
                }
                System.out.println(finalData.toString());

                Calculator calculator = new Calculator(finalData, amorfField.getText());
                var resultMap = calculator.getResultProgram();

                tableElements.getItems().clear();
                for (var el : resultMap.entrySet()) {
                    dataChem.add(new DataChem(el.getKey(), Double.parseDouble(String.format("%.3f",el.getValue().get(0)).replace(',', '.')),
                            Double.parseDouble(String.format("%.3f",el.getValue().get(1)).replace(',', '.'))));
                }
                elements.setCellValueFactory(new PropertyValueFactory<>("elem"));
                exAmorf.setCellValueFactory(new PropertyValueFactory<>("massXRD"));
                withAmorf.setCellValueFactory(new PropertyValueFactory<>("massAmorf"));
                tableElements.setItems(dataChem);
            }
            else {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);

                VBox vbox = new VBox(new Text("Некорректный процент XRD (" + result +")"));
                vbox.setAlignment(Pos.CENTER);
                vbox.setPadding(new Insets(15));
                dialogStage.setScene(new Scene(vbox));
                dialogStage.show();
            }
        });

        saveResult.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(new Stage());
            String path = file.getPath();
            try {
                FileWriter writer = new FileWriter(path, true);
                writer.write("Обращение: "+ "\n");
                writer.write("Введенные данные: \n");
                for (var el : finalData) {
                    writer.write(" Формула: " + el.split(" ")[0].replace(',', '.') + "\t");
                    writer.write(" Процент XRD: " + el.split(" ")[1].replace(',', '.') + "%\n");
                }
                writer.write("Полученные данные: \n");
                for(var el: dataChem){
                    writer.write(" Элемент: " + el.getElem() + "\t С учетом XRD: " + el.getMassXRD() + "%\t С учетом аморфа: " + el.getMassAmorf()+ "%\n");
                }
                writer.write('\n');
                writer.flush();
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);

                VBox vbox = new VBox(new Text("Записал данные с таблицы в файл " + file.getName()));
                vbox.setAlignment(Pos.CENTER);
                vbox.setPadding(new Insets(15));
                dialogStage.setScene(new Scene(vbox));
                dialogStage.show();

            } catch (IOException e) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                VBox vbox = new VBox(new Text("Неверный формат пути."));
                vbox.setAlignment(Pos.CENTER);
                vbox.setPadding(new Insets(15));
                dialogStage.setScene(new Scene(vbox));
                dialogStage.show();
            }
        });

        information.setOnAction(actionEvent -> {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);

            VBox vbox = new VBox(new Text("Инструкция пользователя\n" +
                    "1) Ввод фазы осуществляется в отдельной ячейке с заглавной буквы без пробелов\n" +
                    "Пример - Ti3O2\n" +
                    "2) Число атомов может быть дробным, ввод через \".\" или \",\"\n" +
                    "Пример - Fe0,8S\n" +
                    "3) Сброс таблицы результатов автоматически производится при вводе новых фаз. \n" +
                    "4) Пример ввода фаз вида - KAlCl3*12(H2O) (слитно без пробелов)\n" +
                    "5) Для сохранения результатов необходимо создать текстовый файл формата .txt\n" +
                    " и выбрать его в контекстном меню, нажав на кнопку Save Result"));
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));
            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
        });

        refreshId.setOnAction(actionEvent -> {
            tableElements.getItems().clear();
        });

        refreshId1.setOnAction(actionEvent -> {
            for (int i = 0; i < idText; i++) {
                TextField text = (TextField) mainPage.lookup("#textField" + i);
                TextField newText = (TextField) mainPage.lookup("#textFieldNEW" + i);
                if (text!=null && newText!=null){
                    text.clear();
                    newText.clear();
                }
            }
        });

    }



}