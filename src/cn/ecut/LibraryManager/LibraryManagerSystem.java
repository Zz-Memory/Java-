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
        //创建标签对象

        //创建欢迎界面场景的标签
        Label label1 = new Label("欢迎使用图书信息管理系统");
        //创建操作系统场景的标签
        Label label2 = new Label("请按需求选择菜单选项");
        //创建录入图书信息场景的标签
        Label inlabel1 = new Label("登录号：");
        Label inlabel2 = new Label("书名：");
        Label inlabel3 = new Label("作者名：");
        Label inlabel4 = new Label("分类号：");
        Label inlabel5 = new Label("出版单位：");
        Label inlabel6 = new Label("出版时间：");
        Label inlabel7 = new Label("价格：");
        Label inlabel=new Label("(登录号唯一)");
        //创建分类号的选项
        ChoiceBox<String> infield4 = new <String>ChoiceBox();
        String[] bookClass = {"A（哲学类）", "B（社会科学类）", "C（政治类）", "D（法律类）", "E（军事类）", "F（经济类）", "G（文化类）", "H（教育类）", "I（体育类）", "J（语言文字类）", "K（艺术类）", "L（历史类）", "M（地理类）", "N（天文学类）", "O（生物学类）", "P（医学卫生类）", "Q（农业类）"};
        for (int i = 0; i < bookClass.length; i++) {
            infield4.getItems().add(bookClass[i]);
        }
        //创建判断录入图书是否操作成功的标签
        Label labelSet = new Label("存入成功");
        Label labelunSet = new Label("存入失败（数据库连接有误或登录号重复）");
        Label labelRe = new Label("重置成功");
        //创建按书名查询图书信息场景的标签
        Label qblabel=new Label("请输入书名：");
        //创建按作者名查询图书信息场景的标签
        Label qalabel=new Label("请输入作者名：");
        //创建修改图书信息场景的标签
        Label uplabel1 = new Label("请在右框输入需修改图书的登录号：");
        Label uplabel2 = new Label("书名：");
        Label uplabel3 = new Label("作者名：");
        Label uplabel4 = new Label("分类号：");
        Label uplabel5 = new Label("出版单位：");
        Label uplabel6 = new Label("出版时间：");
        Label uplabel7 = new Label("价格：");
        Label islabelUP = new Label("修改成功");
        Label nolabelUP = new Label("修改失败");
        Label uplabelX=new Label("登录号不存在");
        Label uplabelRe=new Label("重置成功");
        //创建分类号的选项
        ChoiceBox<String> upfield4 = new <String>ChoiceBox();
        String[] bookClassUP = {"A（哲学类）", "B（社会科学类）", "C（政治类）", "D（法律类）", "E（军事类）", "F（经济类）", "G（文化类）", "H（教育类）", "I（体育类）", "J（语言文字类）", "K（艺术类）", "L（历史类）", "M（地理类）", "N（天文学类）", "O（生物学类）", "P（医学卫生类）", "Q（农业类）"};
        for (int i = 0; i < bookClassUP.length; i++) {
            upfield4.getItems().add(bookClassUP[i]);
        }
        //创建删除图书信息场景的标签
        Label DElabel=new Label("请在下框输入需删除的图书信息的登录号");
        Label DElabelis=new Label("删除成功");
        Label DElabelno=new Label("登录号不存在");



        //创建按钮对象

        //创建欢迎界面场景的“进入”和“退出”按钮
        Button button1 = new Button("进入");
        Button button2 = new Button("退出");
        //创建操作系统的“退出”按钮
        Button button3 = new Button("退出");
        //创建录入图书信息场景返回操作系统场景的按钮
        Button inbutton = new Button("返回");
        //创建录入图书信息场景的按钮
        Button inbutton1 = new Button("确认");
        Button inbutton2 = new Button("重置");
        //创建浏览图书信息场景返回操作系统场景的按钮
        Button scanbutton = new Button("返回");
        //创建按书名查询图书信息场景的按钮
        Button qbbutton1=new Button("确认");
        Button qbbutton2=new Button("返回");
        //创建按作者名查询图书信息场景的按钮
        Button qabutton1=new Button("确认");
        Button qabutton2=new Button("返回");
        //创建修改图书信息场景的按钮
        Button upbutton1=new Button("确认修改");
        Button upbutton2=new Button("返回");
        Button upbutton3=new Button("确认");
        Button upbutton4=new Button("重置");
        //创建删除图书信息场景的按钮
        Button DEbutton1=new Button("确认删除");
        Button DEbutton2=new Button("返回");



        //创建输入框对象

        //创建录入图书场景的输入框
        TextField infield1 = new TextField();
        TextField infield2 = new TextField();
        TextField infield3 = new TextField();
        TextField infield5 = new TextField();
        TextField infield6 = new TextField();
        TextField infield7 = new TextField();
        //创建按书名查询图书信息场景的输入框
        TextField qbfield=new TextField();
        //创建按作者名查询图书信息场景的输入框
        TextField qafield=new TextField();
        //创建修改图书信息的输入框
        TextField upfield1=new TextField();
        TextField upfield2=new TextField();
        TextField upfield3=new TextField();
        TextField upfield5=new TextField();
        TextField upfield6=new TextField();
        TextField upfield7=new TextField();
        //创建删除图书信息的输入框
        TextField DEfield=new TextField();



        //创建一个垂直箱子以配合TableView的使用
        VBox vBox=new VBox();



        //创建TableView对象用以将查询数据以列表形式输出至窗口
        TableView<LibraryInformation> bookViewScan=new TableView<>();
        TableView<LibraryInformation> bookViewQB=new TableView<>();
        TableView<LibraryInformation> bookViewQA=new TableView<>();
        //设置表的大小
        bookViewScan.setPrefSize(840,800);
        bookViewQB.setPrefSize(840,800);
        bookViewQA.setPrefSize(840,800);
        //设置列数和列名
        TableColumn firstColumScan=new TableColumn<>("登录号");
        TableColumn secondColumScan=new TableColumn<>("书名");
        TableColumn thirdColumScan=new TableColumn<>("作者名");
        TableColumn fourthtColumScan=new TableColumn<>("分类号");
        TableColumn fifthColumScan=new TableColumn<>("出版社");
        TableColumn sixthColumScan=new TableColumn<>("出版时间");
        TableColumn seventhColumScan=new TableColumn<>("价格");

        TableColumn firstColumQB=new TableColumn<>("登录号");
        TableColumn secondColumQB=new TableColumn<>("书名");
        TableColumn thirdColumQB=new TableColumn<>("作者名");
        TableColumn fourthtColumQB=new TableColumn<>("分类号");
        TableColumn fifthColumQB=new TableColumn<>("出版社");
        TableColumn sixthColumQB=new TableColumn<>("出版时间");
        TableColumn seventhColumQB=new TableColumn<>("价格");

        TableColumn firstColumQA=new TableColumn<>("登录号");
        TableColumn secondColumQA=new TableColumn<>("书名");
        TableColumn thirdColumQA=new TableColumn<>("作者名");
        TableColumn fourthtColumQA=new TableColumn<>("分类号");
        TableColumn fifthColumQA=new TableColumn<>("出版社");
        TableColumn sixthColumQA=new TableColumn<>("出版时间");
        TableColumn seventhColumQA=new TableColumn<>("价格");
        //设置列要显示的内容
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
        //将标题列加入到bookView中
        bookViewScan.getColumns().addAll(firstColumScan,secondColumScan,thirdColumScan,fourthtColumScan,fifthColumScan,sixthColumScan,seventhColumScan);
        bookViewQB.getColumns().addAll(firstColumQB,secondColumQB,thirdColumQB,fourthtColumQB,fifthColumQB,sixthColumQB,seventhColumQB);
        bookViewQA.getColumns().addAll(firstColumQA,secondColumQA,thirdColumQA,fourthtColumQA,fifthColumQA,sixthColumQA,seventhColumQA);




        //创建菜单对象

        //创建操作系统场景的菜单
        Menu menu1 = new Menu("录入图书信息");
        Menu menu2 = new Menu("浏览图书信息");
        Menu menu3 = new Menu("查询图书信息");
        Menu menu4 = new Menu("修改与删除图书信息");
        MenuItem menuItem1 = new MenuItem("进入");
        MenuItem menuItem2 = new MenuItem("进入");
        MenuItem menuItem3 = new MenuItem("按书名查询");
        MenuItem menuItem4 = new MenuItem("按作者名查询");
        MenuItem menuItem5 = new MenuItem("修改图书信息");
        MenuItem menuItem6 = new MenuItem("删除图书信息");
        //为录入图书信息提供子项
        menu1.getItems().addAll(menuItem1);
        //为浏览图书信息提供子项
        menu2.getItems().addAll(menuItem2);
        //为查询图书信息提供子项
        menu3.getItems().addAll(menuItem3, menuItem4);
        //为修改和删除图书信息提供子项
        menu4.getItems().addAll(menuItem5,menuItem6);
        //创建操作系统场景的菜单条
        MenuBar menuBar1 = new MenuBar();
        menuBar1.getMenus().addAll(menu1, menu2, menu3, menu4);
        //设置操作系统菜单的宽度适应父级窗口
        menuBar1.prefWidthProperty().bind(stage.widthProperty());



        //创建关闭窗口弹出事件
        Platform.setImplicitExit(false);//关闭操作系统平台的默认关闭事件
        //创建关闭窗口时的点击事件
        stage.setOnCloseRequest(event -> {
            event.consume();//取消关闭窗口的功能
            //设置弹出窗口
            Alert close=new Alert(Alert.AlertType.CONFIRMATION);
            close.setTitle("退出程序");
            close.setHeaderText(null);
            close.setContentText("您是否要退出程序？");
            Optional<ButtonType> closeResult=close.showAndWait();
            if (closeResult.get()==ButtonType.OK){
                Platform.exit();
            }
        });



        //创建布局对象

        //创建欢迎界面布局
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.getChildren().addAll(label1, button1, button2);
        //创建操作系统布局
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.getChildren().addAll(menuBar1, label2, button3);
        //创建录入图书信息的布局
        AnchorPane anchorPaneIn = new AnchorPane();
        anchorPaneIn.getChildren().addAll(inlabel, inbutton, inbutton1, inbutton2, inlabel1, inlabel2, inlabel3, inlabel4, inlabel5, inlabel6, inlabel7, infield1, infield2, infield3, infield4, infield5, infield6, infield7);
        //创建浏览图书信息的布局
        AnchorPane anchorPaneScan = new AnchorPane(scanbutton,bookViewScan);
        //创建按书名查询图书信息的布局
        AnchorPane anchorPaneQB=new AnchorPane();
        anchorPaneQB.getChildren().addAll(qbfield,qbbutton1,qbbutton2,qblabel,bookViewQB);
        //创建按作者名查询图书信息的布局
        AnchorPane anchorPaneQA=new AnchorPane();
        anchorPaneQA.getChildren().addAll(qafield,qabutton1,qabutton2,qalabel,bookViewQA);
        //创建修改图书信息的布局
        AnchorPane anchorPaneUP=new AnchorPane();
        anchorPaneUP.getChildren().addAll(upbutton1,upbutton2,upbutton3,upbutton4,uplabel1,uplabel2,uplabel3,uplabel4,uplabel5,uplabel6,uplabel7,upfield1,upfield2,upfield3,upfield4,upfield5,upfield6,upfield7);
        //创建删除图书信息的布局
        AnchorPane anchorPaneDE=new AnchorPane();
        anchorPaneDE.getChildren().addAll(DElabel,DEbutton1,DEbutton2,DEfield);



        //创建场景对象

        //创建欢迎界面场景
        Scene scene1 = new Scene(anchorPane1);
        //创建操作系统场景
        Scene scene2 = new Scene(anchorPane2);
        //创建录入图书信息的场景
        Scene sceneIn = new Scene(anchorPaneIn);
        //创建浏览图书信息的场景
        Scene sceneScan = new Scene(anchorPaneScan);
        //创建按书名查询图书信息的场景
        Scene sceneQB=new Scene(anchorPaneQB);
        // 创建按作者名查询图书信息的场景
        Scene sceneQA=new Scene(anchorPaneQA);
        //创建修改图书信息的场景
        Scene sceneUP=new Scene(anchorPaneUP);
        //创建删除图书信息的场景
        Scene sceneDE=new Scene(anchorPaneDE);



        //为操作系统场景的菜单创建点击事件

        //进入“录入图书信息”
        menuItem1.setOnAction(event -> {
            stage.setScene(sceneIn);
        });

        //进入"浏览图书信息"
        menuItem2.setOnAction(event -> {
            stage.setScene(sceneScan);
            LibraryScan libraryScan=new LibraryScan();
            try {
                //获取方法返回的数据
                ObservableList<LibraryInformation> bookListob=libraryScan.scan();
                //将bookListob作为bookView的数据来源
                bookViewScan.setItems(bookListob);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        //进入”按书名查询图书信息“
        menuItem3.setOnAction(event -> {
            stage.setScene(sceneQB);
        });

        //进入”按作者名查询图书信息“
        menuItem4.setOnAction(event -> {
            stage.setScene(sceneQA);
        });

        //进入”修改图书信息“
        menuItem5.setOnAction(event -> {
            stage.setScene(sceneUP);
        });

        //进入”删除图书信息“
        menuItem6.setOnAction(event -> {
            stage.setScene(sceneDE);
        });



        //创建按钮点击事件

        //创建欢迎界面的点击事件

        //”进入“按钮
        button1.setOnAction(event -> {
            stage.setScene(scene2);
        });

        //”退出“按钮
        button2.setOnAction(event -> {
            //退出操作系统
            Platform.exit();
        });



        //创建操作系统界面的”退出“按钮点击事件
        button3.setOnAction(event -> {
            //退出操作系统
            Platform.exit();
        });



        //创建录入图书信息的点击事件

        //“确认”按钮
        inbutton1.setOnAction(event -> {
                    //获取输入框的数据
                    String loginID = infield1.getText();
                    String bookName = infield2.getText();
                    String author = infield3.getText();
                    String bookID = infield4.getValue().toString();
                    String publisher = infield5.getText();
                    String publishTime = infield6.getText();
                    Double price = Double.parseDouble(infield7.getText());
                    //创建录入图书信息类的对象
                    LibraryInsert libraryInsert = new LibraryInsert();
                    try {
                        int count = libraryInsert.libraryInsert(loginID, bookName, author, bookID, publisher, publishTime, price);
                        //以返回值判断数据是否插入成功
                        if (count > 0) {
                            //设置存入成功提示
                            anchorPaneIn.getChildren().remove(labelSet);
                            anchorPaneIn.getChildren().remove(labelRe);
                            anchorPaneIn.getChildren().remove(labelunSet);
                            anchorPaneIn.getChildren().add(labelSet);
                        } else {
                            //设置失败提示
                            anchorPaneIn.getChildren().remove(labelunSet);
                            anchorPaneIn.getChildren().remove(labelRe);
                            anchorPaneIn.getChildren().remove(labelSet);
                            anchorPaneIn.getChildren().add(labelunSet);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        //”重置“按钮
        inbutton2.setOnAction(event -> {
            infield1.setText("");
            infield2.setText("");
            infield3.setText("");
            infield4.getSelectionModel().clearSelection();
            infield5.setText("");
            infield6.setText("");
            infield7.setText("");
            //设置重置成功提示
            anchorPaneIn.getChildren().remove(labelRe);
            anchorPaneIn.getChildren().remove(labelunSet);
            anchorPaneIn.getChildren().remove(labelSet);
            anchorPaneIn.getChildren().add(labelRe);
        });
        //”返回“按钮
        inbutton.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //为浏览图书信息场景创建点击事件

        //“返回”按钮
        scanbutton.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //为按书名查询图书信息场景创建点击事件

        //”确认“按钮
        qbbutton1.setOnAction(event -> {
            LibraryQueryB libraryQueryB=new LibraryQueryB();
            try {
                ObservableList<LibraryInformation> bookListQB=libraryQueryB.queryB(qbfield.getText());
                bookViewQB.setItems(bookListQB);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //”返回“按钮
        qbbutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //为按作者名查询图书信息创建点击事件

        //”确认“按钮
        qabutton1.setOnAction(event -> {
            LibraryQueryA libraryQueryA=new LibraryQueryA();
            try {
                ObservableList<LibraryInformation> bookListQA=libraryQueryA.queryA(qafield.getText());
                bookViewQA.setItems(bookListQA);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //”返回“按钮
        qabutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //为修改图书信息创建点击事件

        //”确认修改“按钮
        upbutton1.setOnAction(event -> {
            LibraryUpdate libraryUpdate=new LibraryUpdate();
            try {
                //调用修改图书信息方法并获取判断值
                int count=libraryUpdate.update(upfield1.getText(),upfield2.getText(),upfield3.getText(),upfield4.getValue().toString(),upfield5.getText(),upfield6.getText(),Double.parseDouble(upfield7.getText()));
                //设置提示
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
        //”返回“按钮
        upbutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });
        //”确认“按钮
        upbutton3.setOnAction(event -> {
            LibraryUpdate libraryUpdate=new LibraryUpdate();
            try {
                LibraryInformation libraryInformation= libraryUpdate.queryUP(upfield1.getText());


                //判断登录号是否存在
                if (libraryInformation==null){
                    //登录号不存在
                    anchorPaneUP.getChildren().remove(uplabelRe);
                    anchorPaneUP.getChildren().remove(uplabelX);
                    anchorPaneUP.getChildren().remove(islabelUP);
                    anchorPaneUP.getChildren().remove(nolabelUP);
                    anchorPaneUP.getChildren().add(uplabelX);
                }else {
                    //登录号存在

                    //接收查询到的数据
                    String bookNameUP=libraryInformation.getBookName();
                    String authorUP=libraryInformation.getAuthor();
                    String bookIDUP=libraryInformation.getBookID();
                    String publisherUP=libraryInformation.getPublisher();
                    String publishTimeUP=libraryInformation.getPublishTime();
                    Double priceUP=libraryInformation.getPrice();
                    //填入查询数据
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
        //”重置“按钮
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



        //为删除图书信息创建点击事件
        //”确认删除“按钮
        DEbutton1.setOnAction(event -> {
            //创建删除图书信息时的弹出事件
            //设置弹出窗口
            Alert DE=new Alert(Alert.AlertType.CONFIRMATION);
            DE.setTitle("警告！");
            DE.setHeaderText(null);
            DE.setContentText("您是否确定删除此图书信息？");
            Optional<ButtonType> DEResult=DE.showAndWait();
            if (DEResult.get()==ButtonType.OK){
                LibraryDelete libraryDelete=new LibraryDelete();
                try {
                //获取返回值
                int count=libraryDelete.delete(DEfield.getText());

                //设置提示
                if (count==1){
                    anchorPaneDE.getChildren().remove(DElabelis);
                    anchorPaneDE.getChildren().remove(DElabelno);
                    anchorPaneDE.getChildren().add(DElabelis);
                }else if (count==0){
                    anchorPaneDE.getChildren().remove(DElabelno);
                    anchorPaneDE.getChildren().remove(DElabelis);
                    anchorPaneDE.getChildren().add(DElabelno);
                }
                //清空输入框
                DEfield.clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }

        });
        //”返回“按钮
        DEbutton2.setOnAction(event -> {
            stage.setScene(scene2);
        });



        //设置各项组件的位置和大小

        //设置欢迎界面场景标签位置
        label1.setFont(new Font(30));
        label1.setLayoutY(200);
        label1.setLayoutX(300);
        //设置操作系统场景标签的位置
        label2.setFont(new Font(30));
        label2.setLayoutY(300);
        label2.setLayoutX(360);

        //设置录入图书信息标签位置
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


        //设置按书名查询图书信息的标签位置
        qblabel.setLayoutY(0);
        qblabel.setLayoutX(300);
        //设置按作者名查询图书信息的标签位置
        qalabel.setLayoutY(0);
        qalabel.setLayoutX(300);

        //设置修改图书信息的标签位置
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

        //设置删除图书信息场景的标签位置
        DElabel.setLayoutY(230);
        DElabel.setLayoutX(315);

        DElabelis.setLayoutY(450);
        DElabelis.setLayoutX(410);

        DElabelno.setLayoutY(450);
        DElabelno.setLayoutX(410);



        //设置录入图书信息输入框位置
        infield1.setLayoutY(50);
        infield1.setLayoutX(380);

        infield2.setLayoutY(100);
        infield2.setLayoutX(380);

        infield3.setLayoutY(150);
        infield3.setLayoutX(380);

        //设置录入图书信息分类号框的宽度
        infield4.setMinWidth(202);
        infield4.setLayoutY(200);
        infield4.setLayoutX(380);

        infield5.setLayoutY(250);
        infield5.setLayoutX(380);

        infield6.setLayoutY(300);
        infield6.setLayoutX(380);

        infield7.setLayoutY(350);
        infield7.setLayoutX(380);

        //设置按书名查询图书信息场景的输入框位置
        qbfield.setLayoutY(0);
        qbfield.setLayoutX(400);
        //设置按作者名查询图书信息场景的输入框位置
        qafield.setLayoutY(0);
        qafield.setLayoutX(400);

        //设置修改图书信息场景的输入框位置
        upfield1.setLayoutY(0);
        upfield1.setLayoutX(440);

        upfield2.setLayoutY(70);
        upfield2.setLayoutX(380);

        upfield3.setLayoutY(120);
        upfield3.setLayoutX(380);

        //设置修改图书信息分类号框的宽度
        upfield4.setMinWidth(202);
        upfield4.setLayoutY(170);
        upfield4.setLayoutX(380);

        upfield5.setLayoutY(220);
        upfield5.setLayoutX(380);

        upfield6.setLayoutY(270);
        upfield6.setLayoutX(380);

        upfield7.setLayoutY(320);
        upfield7.setLayoutX(380);


        //设置删除图书信息场景的输入框位置
        DEfield.setLayoutY(300);
        DEfield.setLayoutX(350);


        //设置欢迎界面的“进入”和“退出”按钮位置
        button1.setPrefWidth(100);
        button1.setLayoutY(360);
        button1.setLayoutX(320);

        button2.setPrefWidth(100);
        button2.setLayoutY(360);
        button2.setLayoutX(550);

        //设置操作系统场景的“退出”按钮位置
        button3.setPrefWidth(100);
        button3.setLayoutY(560);
        button3.setLayoutX(430);

        //设置录入图书信息的"确认"和“重置”按钮位置
        inbutton1.setLayoutY(400);
        inbutton1.setLayoutX(400);

        inbutton2.setLayoutY(400);
        inbutton2.setLayoutX(520);

        //设置按书名查询图书信息场景的“确认”按钮的位置
        qbbutton1.setLayoutY(0);
        qbbutton1.setLayoutX(670);
        //设置按作者名查询图书信息场景的“确认”按钮的位置
        qabutton1.setLayoutY(0);
        qabutton1.setLayoutX(670);

        //设置修改图书信息场景的”确认修改“按钮位置
        upbutton1.setLayoutY(400);
        upbutton1.setLayoutX(360);
        //设置修改图书信息场景的“确认”按钮位置
        upbutton3.setLayoutY(0);
        upbutton3.setLayoutX(670);
        //设置修改图书信息场景的”重置“按钮位置
        upbutton4.setLayoutY(400);
        upbutton4.setLayoutX(490);

        //设置删除图书信息场景的”确认删除“按钮位置
        DEbutton1.setLayoutY(350);
        DEbutton1.setLayoutX(410);

        //设置列的宽度
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
        //设置列表位置
        bookViewScan.setLayoutY(50);
        bookViewScan.setLayoutX(80);

        bookViewQB.setLayoutY(50);
        bookViewQB.setLayoutX(80);

        bookViewQA.setLayoutY(50);
        bookViewQA.setLayoutX(80);




        //设置窗口的标题
        stage.setTitle("图书信息管理系统");
        //设置窗口的布局
        stage.setScene(scene1);
        //设置窗口的尺寸
        stage.setHeight(1000);
        stage.setWidth(1000);
        //启动窗口
        stage.show();
    }
}
