package cn.ecut.LibraryManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryScan extends LibraryGetConn{
    public ObservableList scan() throws SQLException {
        //�������SQL���
        String sqlQuery = "select * from LibraryInformation";
        //��ȡ����
        PreparedStatement pstmtQuery = conn.prepareStatement(sqlQuery);
        //ִ������ȡ����ֵ
        ResultSet rs = pstmtQuery.executeQuery();
        //������List<LibraryInformation>��װLibraryInformation����װ��List����
        LibraryInformation libraryInformation=null;//��Լ�ռ䣬�������ⲿ���д���
        //����LibraryInformation��ʽ�������嵥
        List<LibraryInformation> bookList=new ArrayList<>();
        //�����б����
        ObservableList<LibraryInformation> bookListob=null;

        while(rs.next()){
            //���ղ�ѯ��������
            String loginID=rs.getString("loginID");
            String bookName=rs.getString("bookName");
            String author=rs.getString("author");
            String bookID=rs.getString("bookID");
            String publisher=rs.getString("publisher");
            String publishTime=rs.getString("publishTime");
            Double price=rs.getDouble("price");

            //��װlibraryInformation����
            libraryInformation=new LibraryInformation(loginID,bookName,author,bookID,publisher,publishTime,price);
            //������װ�ص������嵥bookList��
            bookList.add(libraryInformation);
            //������bookListΪ������Դ��ObservableList����bookListob
            bookListob= FXCollections.observableArrayList(bookList);
        }
        //�ͷ���Դ
        rs.close();
        pstmtQuery.close();

        //�����б�����
        return bookListob;
    }
}
