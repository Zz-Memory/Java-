package cn.ecut.LibraryManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryQueryA extends LibraryGetConn{
    public ObservableList queryA(String author) throws SQLException {
        //���尴������ѯͼ����ϢSQL���
        String sqlQA="select * from LibraryInformation where author=?";
        //ͨ��Connection�����ȡ���������Ӧ��sql���
        PreparedStatement pstmtQA= conn.prepareStatement(sqlQA);
        //����?����������ֵ
        pstmtQA.setString(1,author);
        //ִ��SQL���
        ResultSet rsQA = pstmtQA.executeQuery();
        //������List<LibraryInformation>��װLibraryInformation����װ��List����
        LibraryInformation libraryInformationQA=null;//��Լ�ռ䣬�������ⲿ���д���
        //����LibraryInformation��ʽ�������嵥
        List<LibraryInformation> bookListQa = new ArrayList<>();
        while(rsQA.next()){
            String loginIDQA=rsQA.getString("loginID");
            String bookNameQA=rsQA.getString("bookName");
            String authorQA=rsQA.getString("author");
            String bookIDQA=rsQA.getString("bookID");
            String publisherQA=rsQA.getString("publisher");
            String publishTimeQA=rsQA.getString("publishTime");
            Double priceQA=rsQA.getDouble("price");

            //��װlibraryInformation����
            libraryInformationQA=new LibraryInformation(loginIDQA,bookNameQA,authorQA,bookIDQA,publisherQA,publishTimeQA,priceQA);


            //������װ�ص������嵥bookList��
            bookListQa.add(libraryInformationQA);
        }
        //������bookListQaΪ������Դ��ObservableList����bookListQA
        ObservableList<LibraryInformation> bookListQA= FXCollections.observableArrayList(bookListQa);

        //�ͷ���Դ
        rsQA.close();
        pstmtQA.close();

        //�������ݱ�
        return bookListQA;
    }
}
