package cn.ecut.LibraryManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryQueryB extends LibraryGetConn{
    public ObservableList queryB(String bookName) throws SQLException {
        //���尴������ѯͼ����ϢSQL���
        String sqlQB="select * from LibraryInformation where bookName=?";
        //ͨ��Connection�����ȡ���������Ӧ��sql���
        PreparedStatement pstmtQB= conn.prepareStatement(sqlQB);
        //����?����������ֵ
        pstmtQB.setString(1,bookName);
        //ִ��SQL���
        ResultSet rsQB = pstmtQB.executeQuery();
        //������List<LibraryInformation>��װLibraryInformation����װ��List����
        LibraryInformation libraryInformationQB=null;//��Լ�ռ䣬�������ⲿ���д���
        //����LibraryInformation��ʽ�������嵥
        List<LibraryInformation> bookListQb = new ArrayList<>();
        while(rsQB.next()){
            //���ղ�ѯ��������
            String loginIDQB=rsQB.getString("loginID");
            String bookNameQB=rsQB.getString("bookName");
            String authorQB=rsQB.getString("author");
            String bookIDQB=rsQB.getString("bookID");
            String publisherQB=rsQB.getString("publisher");
            String publishTimeQB=rsQB.getString("publishTime");
            double priceQB=rsQB.getDouble("price");

            //��װlibraryInformation����
            libraryInformationQB=new LibraryInformation(loginIDQB,bookNameQB,authorQB,bookIDQB,publisherQB,publishTimeQB,priceQB);


            //������װ�ص������嵥bookList��
            bookListQb.add(libraryInformationQB);
        }
        //������bookListQbΪ������Դ��ObservableList����bookListQB
        ObservableList<LibraryInformation> bookListQB= FXCollections.observableArrayList(bookListQb);

        //�ͷ���Դ
        rsQB.close();
        pstmtQB.close();

        //�������ݱ�
        return bookListQB;
    }
}
