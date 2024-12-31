package cn.ecut.LibraryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryUpdate extends LibraryGetConn{
    public int update(String loginID,String bookName,String author,String bookID,String publisher,String publishTime,Double price) throws SQLException {
        String sqlUP="update libraryInformation set bookName=?,author=?,bookID=?,publisher=?,publishTime=?,price=? where loginID=?";
        PreparedStatement pstmtUP= conn.prepareStatement(sqlUP);
        //��ȡ����
        pstmtUP.setString(7,loginID);
        pstmtUP.setString(1,bookName);
        pstmtUP.setString(2,author);
        pstmtUP.setString(3,bookID);
        pstmtUP.setString(4,publisher);
        pstmtUP.setString(5,publishTime);
        pstmtUP.setDouble(6,price);

        //ִ���޸�
        int count=pstmtUP.executeUpdate();

        //�ͷ���Դ
        pstmtUP.close();

        //�����ж�ֵ
        return count;
    }

    public LibraryInformation queryUP(String loginID) throws SQLException {
        //�����޸�ͼ����Ϣʱ�Ĳ�ѯ���
        String sqlUPin="select * from libraryInformation where loginID=?";
        //��������
        PreparedStatement pstmtUPin=conn.prepareStatement(sqlUPin);
        //���ò���
        pstmtUPin.setString(1,loginID);
        //ִ����䲢��ȡ����ֵ
        ResultSet rsUPin = pstmtUPin.executeQuery();
        //������װ���ݶ���
        LibraryInformation libraryInformation=null;

        while(rsUPin.next()) {
            String bookNameUP = rsUPin.getString("bookName");
            String authorUP = rsUPin.getString("author");
            String bookIDUP = rsUPin.getString("bookID");
            String publisherUP = rsUPin.getString("publisher");
            String publishTimeUP = rsUPin.getString("publishTime");
            Double priceUP = rsUPin.getDouble("price");

            libraryInformation=new LibraryInformation(loginID,bookNameUP,authorUP,bookIDUP,publisherUP,publishTimeUP,priceUP);
        }
        //�ͷ���Դ
        rsUPin.close();
        pstmtUPin.close();

        //���ز�ѯ��������
        return libraryInformation;
    }
}
