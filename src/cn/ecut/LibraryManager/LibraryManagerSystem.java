package cn.ecut.LibraryManager;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.Optional;


public class LibraryManagerSystem extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //������ǩ����

        //������ӭ���泡���ı�ǩ
        Label label1 = new Label("��ӭʹ��ͼ����Ϣ����ϵͳ");
        //��������ϵͳ�����ı�ǩ
        Label label2 = new Label("�밴����ѡ��˵�ѡ��");
        //����¼��ͼ����Ϣ�����ı�ǩ
        Label inlabel1 = new Label("��¼�ţ�");
        Label inlabel2 = new Label("������");
        Label inlabel3 = new Label("��������");
        Label inlabel4 = new Label("����ţ�");
        Label inlabel5 = new Label("���浥λ��");
        Label inlabel6 = new Label("����ʱ�䣺");
        Label inlabel7 = new Label("�۸�");
        Label inlabel=new Label("(��¼��Ψһ)");
        //��������ŵ�ѡ��
        ChoiceBox<String> infield4 = new <String>ChoiceBox();
        String[] bookClass = {"A����ѧ�ࣩ", "B������ѧ�ࣩ", "C�������ࣩ", "D�������ࣩ", "E�������ࣩ", "F�������ࣩ", "G���Ļ��ࣩ", "H�������ࣩ", "I�������ࣩ", "J�����������ࣩ", "K�������ࣩ", "L����ʷ�ࣩ", "M�������ࣩ", "N������ѧ�ࣩ", "O������ѧ�ࣩ", "P��ҽѧ�����ࣩ", "Q��ũҵ�ࣩ"};
        for (int i = 0; i < bookClass.length; i++) {
            infield4.getItems().add(bookClass[i]);
        }
        //�����ж�¼��ͼ���Ƿ�����ɹ��ı�ǩ
        Label labelSet = new Label("����ɹ�");
        Label labelunSet = new Label("����ʧ�ܣ����ݿ�����������¼���ظ���");
        Label labelRe = new Label("���óɹ�");
        //������������ѯͼ����Ϣ�����ı�ǩ
        Label qblabel=new Label("������������");
        //��������������ѯͼ����Ϣ�����ı�ǩ
        Label qalabel=new Label("��������������");
        //�����޸�ͼ����Ϣ�����ı�ǩ
        Label uplabel1 = new Label("�����ҿ��������޸�ͼ��ĵ�¼�ţ�");
        Label uplabel2 = new Label("������");
        Label uplabel3 = new Label("��������");
        Label uplabel4 = new Label("����ţ�");
        Label uplabel5 = new Label("���浥λ��");
        Label uplabel6 = new Label("����ʱ�䣺");
        Label uplabel7 = new Label("�۸�");
        Label islabelUP = new Label("�޸ĳɹ�");
        Label nolabelUP = new Label("�޸�ʧ��");
        Label uplabelX=new Label("��¼�Ų�����");
        Label uplabelRe=new Label("���óɹ�");
        //��������ŵ�ѡ��
        ChoiceBox<String> upfield4 = new <String>ChoiceBox();
        String[] bookClassUP = {"A����ѧ�ࣩ", "B������ѧ�ࣩ", "C�������ࣩ", "D�������ࣩ", "E�������ࣩ", "F�������ࣩ", "G���Ļ��ࣩ", "H�������ࣩ", "I�������ࣩ", "J�����������ࣩ", "K�������ࣩ", "L����ʷ�ࣩ", "M�������ࣩ", "N������ѧ�ࣩ", "O������ѧ�ࣩ", "P��ҽѧ�����ࣩ", "Q��ũҵ�ࣩ"};
        for (int i = 0; i < bookClassUP.length; i++) {
            upfield4.getItems().add(bookClassUP[i]);
        }
        //����ɾ��ͼ����Ϣ�����ı�ǩ
        Label DElabel=new Label("�����¿�������ɾ����ͼ����Ϣ�ĵ�¼��");
        Label DElabelis=new Label("ɾ���ɹ�");
        Label DElabelno=new Label("��¼�Ų�����");



        //������ť����

        //������ӭ���泡���ġ����롱�͡��˳�����ť
        Button button1 = new Button("����");
        Button button2 = new Button("�˳�");
        //��������ϵͳ�ġ��˳�����ť
        Button button3 = new Button("�˳�");
        //����¼��ͼ����Ϣ�������ز���ϵͳ�����İ�ť
        Button inbutton = new Button("����");
        //����¼��ͼ����Ϣ�����İ�ť
        Button inbutton1 = new Button("ȷ��");
        Button inbutton2 = new Button("����");
        //�������ͼ����Ϣ�������ز���ϵͳ�����İ�ť
        Button scanbutton = new Button("����");
        //������������ѯͼ����Ϣ�����İ�ť
        Button qbbutton1=new Button("ȷ��");
        Button qbbutton2=new Button("����");
        //��������������ѯͼ����Ϣ�����İ�ť
        Button qabutton1=new Button("ȷ��");
        Button qabutton2=new Button("����");
        //�����޸�ͼ����Ϣ�����İ�ť
        Button upbutton1=new Button("ȷ���޸�");
        Button upbutton2=new Button("����");
        Button upbutton3=new Button("ȷ��");
        Button upbutton4=new Button("����");
        //����ɾ��ͼ����Ϣ�����İ�ť
        Button DEbutton1=new Button("ȷ��ɾ��");
        Button DEbutton2=new Button("����");



        //������������

        //����¼��ͼ�鳡���������
        TextField infield1 = new TextField();
        TextField infield2 = new TextField();
        TextField infield3 = new TextField();
        TextField infield5 = new TextField();
        TextField infield6 = new TextField();
        TextField infield7 = new TextField();
        //������������ѯͼ����Ϣ�����������
        TextField qbfield=new TextField();
        //��������������ѯͼ����Ϣ�����������
        TextField qafield=new TextField();
        //�����޸�ͼ����Ϣ�������
        TextField upfield1=new TextField();
        TextField upfield2=new TextField();
        TextField upfield3=new TextField();
        TextField upfield5=new TextField();
        TextField upfield6=new TextField();
        TextField upfield7=new TextField();
        //����ɾ��ͼ����Ϣ�������
        TextField DEfield=new TextField();



        //����һ����ֱ���������TableView��ʹ��
        VBox vBox=new VBox();



        //����TableView�������Խ���ѯ�������б���ʽ���������
        TableView<LibraryInformation> bookViewScan=new TableView<>();
        TableView<LibraryInformation> bookViewQB=new TableView<>();
        TableView<LibraryInformation> bookViewQA=new TableView<>();
        //���ñ�Ĵ�С
        bookViewScan.setPrefSize(840,800);
        bookViewQB.setPrefSize(840,800);
        bookViewQA.setPrefSize(840,800);
        //��������������
        TableColumn firstColumScan=new TableColumn<>("��¼��");
        TableColumn secondColumScan=new TableColumn<>("����");
        TableColumn thirdColumScan=new TableColumn<>("������");
        TableColumn fourthtColumScan=new TableColumn<>("�����");
        TableColumn fifthColumScan=new TableColumn<>("������");
        TableColumn sixthColumScan=new TableColumn<>("����ʱ��");
        TableColumn seventhColumScan=new TableColumn<>("�۸�");

        TableColumn firstColumQB=new TableColumn<>("��¼��");
        TableColumn secondColumQB=new TableColumn<>("����");
        TableColumn thirdColumQB=new TableColumn<>("������");
        TableColumn fourthtColumQB=new TableColumn<>("�����");
        TableColumn fifthColumQB=new TableColumn<>("������");
        TableColumn sixthColumQB=new TableColumn<>("����ʱ��");
        TableColumn seventhColumQB=new TableColumn<>("�۸�");

        TableColumn firstColumQA=new TableColumn<>("��¼��");
        TableColumn secondColumQA=new TableColumn<>("����");
        TableColumn thirdColumQA=new TableColumn<>("������");
        TableColumn fourthtColumQA=new TableColumn<>("�����");
        TableColumn fifthColumQA=new TableColumn<>("������");
        TableColumn sixthColumQA=new TableColumn<>("����ʱ��");
        TableColumn seventhColumQA=new TableColumn<>("�۸�");
        //������Ҫ��ʾ������
        firstColumScan.setCellValueFactory(new PropertyValueFactory<>("loginID"));
        secondColumScan.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        thirdColumScan.setCellValueFactory(new PropertyValueFactory<>("author"));
        fourthtColumScan.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        fifthColumScan.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        sixthColumScan.setCellValueFactory(new PropertyValueFactory<>("publishTime"));
        seventhColumScan.setCellValueFactory(new PropertyValueFactory<>("price"));

        firstColumQB.setCellValueFactory(new PropertyValueFactory<>("loginID"));
        secondColumQB.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        thirdColumQB.setCellValueFactory(new PropertyValueFactory<>("author"));
        fourthtColumQB.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        fifthColumQB.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        sixthColumQB.setCellValueFactory(new PropertyValueFactory<>("publishTime"));
        seventhColumQB.setCellValueFactory(new PropertyValueFactory<>("price"));

        firstColumQA.setCellValueFactory(new PropertyValueFactory<>("loginID"));
        secondColumQA.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        thirdColumQA.setCellValueFactory(new PropertyValueFactory<>("author"));
        fourthtColumQA.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        fifthColumQA.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        sixthColumQA.setCellValueFactory(new PropertyValueFactory<>("publishTime"));
        seventhColumQA.setCellValueFactory(new PropertyValueFactory<>("price"));
        //�������м��뵽bookView��
        bookViewScan.getColumns().addAll(firstColumScan,secondColumScan,thirdColumScan,fourthtColumScan,fifthColumScan,sixthColumScan,seventhColumScan);
        bookViewQB.getColumns().addAll(firstColumQB,secondColumQB,thirdColumQB,fourthtColumQB,fifthColumQB,sixthColumQB,seventhColumQB);
        bookViewQA.getColumns().addAll(firstColumQA,secondColumQA,thirdColumQA,fourthtColumQA,fifthColumQA,sixthColumQA,seventhColumQA);




        //�����˵�����

        //��������ϵͳ�����Ĳ˵�
        Menu menu1 = new Menu("¼��ͼ����Ϣ");
        Menu menu2 = new Menu("���ͼ����Ϣ");
        Menu menu3 = new Menu("��ѯͼ����Ϣ");
        Menu menu4 = new Menu("�޸���ɾ��ͼ����Ϣ");
        MenuItem menuItem1 = new MenuItem("����");
        MenuItem menuItem2 = new MenuItem("����");
        MenuItem menuItem3 = new MenuItem("��������ѯ");
        MenuItem menuItem4 = new MenuItem("����������ѯ");
        MenuItem menuItem5 = new MenuItem("�޸�ͼ����Ϣ");
        MenuItem menuItem6 = new MenuItem("ɾ��ͼ����Ϣ");
        //Ϊ¼��ͼ����Ϣ�ṩ����
        menu1.getItems().addAll(menuItem1);
        //Ϊ���ͼ����Ϣ�ṩ����
        menu2.getItems().addAll(menuItem2);
        //Ϊ��ѯͼ����Ϣ�ṩ����
        menu3.getItems().addAll(menuItem3, menuItem4);
        //Ϊ�޸ĺ�ɾ��ͼ����Ϣ�ṩ����
        menu4.getItems().addAll(menuItem5,menuItem6);
        //��������ϵͳ�����Ĳ˵���
        MenuBar menuBar1 = new MenuBar();
        menuBar1.getMenus().addAll(menu1, menu2, menu3, menu4);
        //���ò���ϵͳ�˵��Ŀ����Ӧ��������
        menuBar1.prefWidthProperty().bind(stage.widthProperty());



        //�����رմ��ڵ����¼�
        Platform.setImplicitExit(false);//�رղ���ϵͳƽ̨��Ĭ�Ϲر��¼�
        //�����رմ���ʱ�ĵ���¼�
        stage.setOnCloseRequest(event -> {
            event.consume();//ȡ���رմ��ڵĹ���
            //���õ�������
            Alert close=new Alert(Alert.AlertType.CONFIRMATION);
            close.setTitle("�˳�����");
            close.setHeaderText(null);
            close.setContentText("���Ƿ�Ҫ�˳�����");
            Optional<ButtonType> closeResult=close.showAndWait();
            if (closeResult.get()==ButtonType.OK){
                Platform.exit();
            }
        });



        //�������ֶ���

        //������ӭ���沼��
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.getChildren().addAll(label1, button1, button2);
        //��������ϵͳ����
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.getChildren().addAll(menuBar1, label2, button3);
        //����¼��ͼ����Ϣ�Ĳ���
        AnchorPane anchorPaneIn = new AnchorPane();
        anchorPaneIn.getChildren().addAll(inlabel, inbutton, inbutton1, inbutton2, inlabel1, inlabel2, inlabel3, inlabel4, inlabel5, inlabel6, inlabel7, infield1, infield2, infield3, infield4, infield5, infield6, infield7);
        //�������ͼ����Ϣ�Ĳ���
        AnchorPane anchorPaneScan = new AnchorPane(scanbutton,bookViewScan);
        //������������ѯͼ����Ϣ�Ĳ���
        AnchorPane anchorPaneQB=new AnchorPane();
        anchorPaneQB.getChildren().addAll(qbfield,qbbutton1,qbbutton2,qblabel,bookViewQB);
        //��������������ѯͼ����Ϣ�Ĳ���
        AnchorPane anchorPaneQA=new AnchorPane();
        anchorPaneQA.getChildren().addAll(qafield,qabutton1,qabutton2,qalabel,bookViewQA);
        //�����޸�ͼ����Ϣ�Ĳ���
        AnchorPane anchorPaneUP=new AnchorPane();
        anchorPaneUP.getChildren().addAll(upbutton1,upbutton2,upbutton3,upbutton4,uplabel1,uplabel2,uplabel3,uplabel4,uplabel5,uplabel6,uplabel7,upfield1,upfield2,upfield3,upfield4,upfield5,upfield6,upfield7);
        //����ɾ��ͼ����Ϣ�Ĳ���
        AnchorPane anchorPaneDE=new AnchorPane();
        anchorPaneDE.getChildren().addAll(DElabel,DEbutton1,DEbutton2,DEfield);



        //������������

        //������ӭ���泡��
        Scene scene1 = new Scene(anchorPane1);
        //��������ϵͳ����
        Scene scene2 = new Scene(anchorPane2);
        //����¼��ͼ����Ϣ�ĳ���
        Scene sceneIn = new Scene(anchorPaneIn);
        //�������ͼ����Ϣ�ĳ���
        Scene sceneScan = new Scene(anchorPaneScan);
        //������������ѯͼ����Ϣ�ĳ���
        Scene sceneQB=new Scene(anchorPaneQB);
        // ��������������ѯͼ����Ϣ�ĳ���
        Scene sceneQA=new Scene(anchorPaneQA);
        //�����޸�ͼ����Ϣ�ĳ���
        Scene sceneUP=new Scene(anchorPaneUP);
        //����ɾ��ͼ����Ϣ�ĳ���
        Scene sceneDE=new Scene(anchorPaneDE);



        //Ϊ����ϵͳ�����Ĳ˵���������¼�

        //���롰¼��ͼ����Ϣ��
        menuItem1.setOnAction(event -> {
            stage.setScene(sceneIn);
        });

        //����"���ͼ����Ϣ"
        menuItem2.setOnAction(event -> {
            stage.setScene(sceneScan);
            LibraryScan libraryScan=new LibraryScan();
            try {
                //��ȡ�������ص�����
                ObservableList<LibraryInformation> bookListob=libraryScan.scan();
                //��bookListob��ΪbookView��������Դ
                bookViewScan.setItems(bookListob);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        //���롱��������ѯͼ����Ϣ��
        menuItem3.setOnAction(event -> {
            stage.setScene(sceneQB);
        });

        //���롱����������ѯͼ����Ϣ��
        menuItem4.setOnAction(event -> {
            stage.setScene(sceneQA);
        });

        //���롱�޸�ͼ����Ϣ��
        menuItem5.setOnAction(event -> {
            stage.setScene(sceneUP);
        });

        //���롱ɾ��ͼ����Ϣ��
        menuItem6.setOnAction(event -> {
            stage.setScene(sceneDE);
        });



        //������ť����¼�

        //������ӭ����ĵ���¼�

        //�����롰��ť
        button1.setOnAction(event -> {
            stage.setScene(scene2);
        });

        //���˳�����ť
        button2.setOnAction(event -> {
            //�˳�����ϵͳ
            Platform.exit();
        });



        //��������ϵͳ����ġ��˳�����ť����¼�
        button3.setOnAction(event -> {
            //�˳�����ϵͳ
            Platform.exit();
        });



        //����¼��ͼ����Ϣ�ĵ���¼�

        //��ȷ�ϡ���ť
        inbutton1.setOnAction(event -> {
                    //��ȡ����������
                    String loginID = infield1.getText();
                    String bookName = infield2.getText();
                    String author = infield3.getText();
                    String bookID = infield4.getValue().toString();
                    String publisher = infield5.getText();
                    String publishTime = infield6.getText();
                    Double price = Double.parseDouble(infield7.getText());
                    //����¼��ͼ����Ϣ��Ķ���
                    LibraryInsert libraryInsert = new LibraryInsert();
                    try {
                        int count = libraryInsert.libraryInsert(loginID, bookName, author, bookID, publisher, publishTime, price);
                        //�Է���ֵ�ж������Ƿ����ɹ�
                        if (count > 0) {
                            //���ô���ɹ���ʾ
                            anchorPaneIn.getChildren().remove(labelSet);
                            anchorPaneIn.getChildren().remove(labelRe);
                            anchorPaneIn.getChildren().remove(labelunSet);
                            anchorPaneIn.getChildren().add(labelSet);
                        } else {
                            //����ʧ����ʾ
                            anchorPaneIn.getChildren().remove(labelunSet);
                            anchorPaneIn.getChildren().remove(labelRe);
                            anchorPaneIn.getChildren().remove(labelSet);
                            anchorPaneIn.getChildren().add(labelunSet);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        //�����á���ť
        inbutton2.setOnAction(event -> {
            infield1.setText("");
            infield2.setText("");
            infield3.setText("");
            infield4.getSelectionModel().clearSelection();
            infield5.setText("");
            infield6.setText("");
            infield7.setText("");
            //�������óɹ���ʾ
            anchorPaneIn.getChildren().remove(labelRe);
            anchorPaneIn.getChildren().remove(labelunSet);
            anchorPaneIn.getChildren().remove(labelSet);
            anchorPaneIn.getChildren().add(labelRe);
        });
        //�����ء���ť
        inbutton.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //Ϊ���ͼ����Ϣ������������¼�

        //�����ء���ť
        scanbutton.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //Ϊ��������ѯͼ����Ϣ������������¼�

        //��ȷ�ϡ���ť
        qbbutton1.setOnAction(event -> {
            LibraryQueryB libraryQueryB=new LibraryQueryB();
            try {
                ObservableList<LibraryInformation> bookListQB=libraryQueryB.queryB(qbfield.getText());
                bookViewQB.setItems(bookListQB);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //�����ء���ť
        qbbutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //Ϊ����������ѯͼ����Ϣ��������¼�

        //��ȷ�ϡ���ť
        qabutton1.setOnAction(event -> {
            LibraryQueryA libraryQueryA=new LibraryQueryA();
            try {
                ObservableList<LibraryInformation> bookListQA=libraryQueryA.queryA(qafield.getText());
                bookViewQA.setItems(bookListQA);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //�����ء���ť
        qabutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //Ϊ�޸�ͼ����Ϣ��������¼�

        //��ȷ���޸ġ���ť
        upbutton1.setOnAction(event -> {
            LibraryUpdate libraryUpdate=new LibraryUpdate();
            try {
                //�����޸�ͼ����Ϣ��������ȡ�ж�ֵ
                int count=libraryUpdate.update(upfield1.getText(),upfield2.getText(),upfield3.getText(),upfield4.getValue().toString(),upfield5.getText(),upfield6.getText(),Double.parseDouble(upfield7.getText()));
                //������ʾ
                if (count>0){
                    anchorPaneUP.getChildren().remove(uplabelRe);
                    anchorPaneUP.getChildren().remove(islabelUP);
                    anchorPaneUP.getChildren().remove(nolabelUP);
                    anchorPaneUP.getChildren().remove(uplabelX);
                    anchorPaneUP.getChildren().add(islabelUP);
                }else {
                    anchorPaneUP.getChildren().remove(uplabelRe);
                    anchorPaneUP.getChildren().remove(nolabelUP);
                    anchorPaneUP.getChildren().remove(islabelUP);
                    anchorPaneUP.getChildren().remove(uplabelX);
                    anchorPaneUP.getChildren().add(nolabelUP);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //�����ء���ť
        upbutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });
        //��ȷ�ϡ���ť
        upbutton3.setOnAction(event -> {
            LibraryUpdate libraryUpdate=new LibraryUpdate();
            try {
                LibraryInformation libraryInformation= libraryUpdate.queryUP(upfield1.getText());


                //�жϵ�¼���Ƿ����
                if (libraryInformation==null){
                    //��¼�Ų�����
                    anchorPaneUP.getChildren().remove(uplabelRe);
                    anchorPaneUP.getChildren().remove(uplabelX);
                    anchorPaneUP.getChildren().remove(islabelUP);
                    anchorPaneUP.getChildren().remove(nolabelUP);
                    anchorPaneUP.getChildren().add(uplabelX);
                }else {
                    //��¼�Ŵ���

                    //���ղ�ѯ��������
                    String bookNameUP=libraryInformation.getBookName();
                    String authorUP=libraryInformation.getAuthor();
                    String bookIDUP=libraryInformation.getBookID();
                    String publisherUP=libraryInformation.getPublisher();
                    String publishTimeUP=libraryInformation.getPublishTime();
                    Double priceUP=libraryInformation.getPrice();
                    //�����ѯ����
                    upfield2.setText(bookNameUP);
                    upfield3.setText(authorUP);
                    upfield4.setValue(bookIDUP);
                    upfield5.setText(publisherUP);
                    upfield6.setText(publishTimeUP);
                    upfield7.setText(String.valueOf(priceUP));

                    anchorPaneUP.getChildren().remove(uplabelRe);
                    anchorPaneUP.getChildren().remove(uplabelX);
                    anchorPaneUP.getChildren().remove(islabelUP);
                    anchorPaneUP.getChildren().remove(nolabelUP);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //�����á���ť
        upbutton4.setOnAction(event -> {
            upfield1.setText("");
            upfield2.setText("");
            upfield3.setText("");
            upfield4.getSelectionModel().clearSelection();
            upfield5.setText("");
            upfield6.setText("");
            upfield7.setText("");
            anchorPaneUP.getChildren().remove(uplabelRe);
            anchorPaneUP.getChildren().remove(uplabelX);
            anchorPaneUP.getChildren().remove(islabelUP);
            anchorPaneUP.getChildren().remove(nolabelUP);
            anchorPaneUP.getChildren().add(uplabelRe);
        });



        //Ϊɾ��ͼ����Ϣ��������¼�
        //��ȷ��ɾ������ť
        DEbutton1.setOnAction(event -> {
            //����ɾ��ͼ����Ϣʱ�ĵ����¼�
            //���õ�������
            Alert DE=new Alert(Alert.AlertType.CONFIRMATION);
            DE.setTitle("���棡");
            DE.setHeaderText(null);
            DE.setContentText("���Ƿ�ȷ��ɾ����ͼ����Ϣ��");
            Optional<ButtonType> DEResult=DE.showAndWait();
            if (DEResult.get()==ButtonType.OK){
                LibraryDelete libraryDelete=new LibraryDelete();
                try {
                //��ȡ����ֵ
                int count=libraryDelete.delete(DEfield.getText());

                //������ʾ
                if (count==1){
                    anchorPaneDE.getChildren().remove(DElabelis);
                    anchorPaneDE.getChildren().remove(DElabelno);
                    anchorPaneDE.getChildren().add(DElabelis);
                }else if (count==0){
                    anchorPaneDE.getChildren().remove(DElabelno);
                    anchorPaneDE.getChildren().remove(DElabelis);
                    anchorPaneDE.getChildren().add(DElabelno);
                }
                //��������
                DEfield.clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }

        });
        //�����ء���ť
        DEbutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //���ø��������λ�úʹ�С

        //���û�ӭ���泡����ǩλ��
        label1.setFont(new Font(30));
        label1.setLayoutY(200);
        label1.setLayoutX(300);
        //���ò���ϵͳ������ǩ��λ��
        label2.setFont(new Font(30));
        label2.setLayoutY(300);
        label2.setLayoutX(360);

        //����¼��ͼ����Ϣ��ǩλ��
        inlabel1.setLayoutY(50);
        inlabel1.setLayoutX(300);

        inlabel2.setLayoutY(100);
        inlabel2.setLayoutX(300);

        inlabel3.setLayoutY(150);
        inlabel3.setLayoutX(300);

        inlabel4.setLayoutY(200);
        inlabel4.setLayoutX(300);

        inlabel5.setLayoutY(250);
        inlabel5.setLayoutX(300);

        inlabel6.setLayoutY(300);
        inlabel6.setLayoutX(300);

        inlabel7.setLayoutY(350);
        inlabel7.setLayoutX(300);


        inlabel.setLayoutY(50);
        inlabel.setLayoutX(600);

        labelSet.setLayoutY(450);
        labelSet.setLayoutX(455);

        labelunSet.setLayoutY(450);
        labelunSet.setLayoutX(350);

        labelRe.setLayoutY(450);
        labelRe.setLayoutX(455);


        //���ð�������ѯͼ����Ϣ�ı�ǩλ��
        qblabel.setLayoutY(0);
        qblabel.setLayoutX(300);
        //���ð���������ѯͼ����Ϣ�ı�ǩλ��
        qalabel.setLayoutY(0);
        qalabel.setLayoutX(300);

        //�����޸�ͼ����Ϣ�ı�ǩλ��
        uplabel1.setLayoutY(0);
        uplabel1.setLayoutX(200);

        uplabel2.setLayoutY(70);
        uplabel2.setLayoutX(300);

        uplabel3.setLayoutY(120);
        uplabel3.setLayoutX(300);

        uplabel4.setLayoutY(170);
        uplabel4.setLayoutX(300);

        uplabel5.setLayoutY(220);
        uplabel5.setLayoutX(300);

        uplabel6.setLayoutY(270);
        uplabel6.setLayoutX(300);

        uplabel7.setLayoutY(320);
        uplabel7.setLayoutX(300);

        uplabelX.setLayoutY(450);
        uplabelX.setLayoutX(430);

        islabelUP.setLayoutY(450);
        islabelUP.setLayoutX(430);

        nolabelUP.setLayoutY(450);
        nolabelUP.setLayoutX(430);

        uplabelRe.setLayoutY(450);
        uplabelRe.setLayoutX(430);

        //����ɾ��ͼ����Ϣ�����ı�ǩλ��
        DElabel.setLayoutY(230);
        DElabel.setLayoutX(315);

        DElabelis.setLayoutY(450);
        DElabelis.setLayoutX(410);

        DElabelno.setLayoutY(450);
        DElabelno.setLayoutX(410);



        //����¼��ͼ����Ϣ�����λ��
        infield1.setLayoutY(50);
        infield1.setLayoutX(380);

        infield2.setLayoutY(100);
        infield2.setLayoutX(380);

        infield3.setLayoutY(150);
        infield3.setLayoutX(380);

        //����¼��ͼ����Ϣ����ſ�Ŀ��
        infield4.setMinWidth(202);
        infield4.setLayoutY(200);
        infield4.setLayoutX(380);

        infield5.setLayoutY(250);
        infield5.setLayoutX(380);

        infield6.setLayoutY(300);
        infield6.setLayoutX(380);

        infield7.setLayoutY(350);
        infield7.setLayoutX(380);

        //���ð�������ѯͼ����Ϣ�����������λ��
        qbfield.setLayoutY(0);
        qbfield.setLayoutX(400);
        //���ð���������ѯͼ����Ϣ�����������λ��
        qafield.setLayoutY(0);
        qafield.setLayoutX(400);

        //�����޸�ͼ����Ϣ�����������λ��
        upfield1.setLayoutY(0);
        upfield1.setLayoutX(440);

        upfield2.setLayoutY(70);
        upfield2.setLayoutX(380);

        upfield3.setLayoutY(120);
        upfield3.setLayoutX(380);

        //�����޸�ͼ����Ϣ����ſ�Ŀ��
        upfield4.setMinWidth(202);
        upfield4.setLayoutY(170);
        upfield4.setLayoutX(380);

        upfield5.setLayoutY(220);
        upfield5.setLayoutX(380);

        upfield6.setLayoutY(270);
        upfield6.setLayoutX(380);

        upfield7.setLayoutY(320);
        upfield7.setLayoutX(380);


        //����ɾ��ͼ����Ϣ�����������λ��
        DEfield.setLayoutY(300);
        DEfield.setLayoutX(350);


        //���û�ӭ����ġ����롱�͡��˳�����ťλ��
        button1.setPrefWidth(100);
        button1.setLayoutY(360);
        button1.setLayoutX(320);

        button2.setPrefWidth(100);
        button2.setLayoutY(360);
        button2.setLayoutX(550);

        //���ò���ϵͳ�����ġ��˳�����ťλ��
        button3.setPrefWidth(100);
        button3.setLayoutY(560);
        button3.setLayoutX(430);

        //����¼��ͼ����Ϣ��"ȷ��"�͡����á���ťλ��
        inbutton1.setLayoutY(400);
        inbutton1.setLayoutX(400);

        inbutton2.setLayoutY(400);
        inbutton2.setLayoutX(520);

        //���ð�������ѯͼ����Ϣ�����ġ�ȷ�ϡ���ť��λ��
        qbbutton1.setLayoutY(0);
        qbbutton1.setLayoutX(670);
        //���ð���������ѯͼ����Ϣ�����ġ�ȷ�ϡ���ť��λ��
        qabutton1.setLayoutY(0);
        qabutton1.setLayoutX(670);

        //�����޸�ͼ����Ϣ�����ġ�ȷ���޸ġ���ťλ��
        upbutton1.setLayoutY(400);
        upbutton1.setLayoutX(360);
        //�����޸�ͼ����Ϣ�����ġ�ȷ�ϡ���ťλ��
        upbutton3.setLayoutY(0);
        upbutton3.setLayoutX(670);
        //�����޸�ͼ����Ϣ�����ġ����á���ťλ��
        upbutton4.setLayoutY(400);
        upbutton4.setLayoutX(490);

        //����ɾ��ͼ����Ϣ�����ġ�ȷ��ɾ������ťλ��
        DEbutton1.setLayoutY(350);
        DEbutton1.setLayoutX(410);

        //�����еĿ��
        firstColumScan.setMinWidth(120);
        secondColumScan.setMinWidth(120);
        thirdColumScan.setMinWidth(120);
        fourthtColumScan.setMinWidth(120);
        fifthColumScan.setMinWidth(120);
        sixthColumScan.setMinWidth(120);
        seventhColumScan.setMinWidth(120);

        firstColumQB.setMinWidth(120);
        secondColumQB.setMinWidth(120);
        thirdColumQB.setMinWidth(120);
        fourthtColumQB.setMinWidth(120);
        fifthColumQB.setMinWidth(120);
        sixthColumQB.setMinWidth(120);
        seventhColumQB.setMinWidth(120);

        firstColumQA.setMinWidth(120);
        secondColumQA.setMinWidth(120);
        thirdColumQA.setMinWidth(120);
        fourthtColumQA.setMinWidth(120);
        fifthColumQA.setMinWidth(120);
        sixthColumQA.setMinWidth(120);
        seventhColumQA.setMinWidth(120);
        //�����б�λ��
        bookViewScan.setLayoutY(50);
        bookViewScan.setLayoutX(80);

        bookViewQB.setLayoutY(50);
        bookViewQB.setLayoutX(80);

        bookViewQA.setLayoutY(50);
        bookViewQA.setLayoutX(80);




        //���ô��ڵı���
        stage.setTitle("ͼ����Ϣ����ϵͳ");
        //���ô��ڵĲ���
        stage.setScene(scene1);
        //���ô��ڵĳߴ�
        stage.setHeight(1000);
        stage.setWidth(1000);
        //��������
        stage.show();
    }
}
