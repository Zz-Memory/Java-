package cn.ecut.LibraryManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;


//¼��ͼ����Ϣ
public class LibraryInsert extends LibraryGetConn{
    public int libraryInsert(String loginID,String bookName,String author,String bookID,String publisher,String publishTime,Double price) throws SQLException {
        //�������SQL���
        String insql="insert ignore into LibraryInformation (loginID,bookName,author,bookID,publisher,publishTime,price) values(?,?,?,?,?,?,?)";
        //����PreparedStatement����
        PreparedStatement pstmtAdd=  conn.prepareStatement(insql);

        //ΪҪ�����λ�ø��Ͼ������Ϣ
        pstmtAdd.setString(1, loginID);
        pstmtAdd.setString(2, bookName);
        pstmtAdd.setString(3, author);
        pstmtAdd.setString(4, bookID);
        pstmtAdd.setString(5, publisher);
        pstmtAdd.setString(6, publishTime);
        pstmtAdd.setDouble(7, price);

        //��ȡ��ѯ�õ��ķ���ֵ
        int count=pstmtAdd.executeUpdate();

        //�ͷ���Դ
        pstmtAdd.close();
        conn.close();


        //�����ж�ֵ
        return count;
    }


}
