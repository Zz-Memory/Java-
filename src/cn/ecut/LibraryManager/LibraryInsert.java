package cn.ecut.LibraryManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;


//录入图书信息
public class LibraryInsert extends LibraryGetConn{
    public int libraryInsert(String loginID,String bookName,String author,String bookID,String publisher,String publishTime,Double price) throws SQLException {
        //定义插入SQL语句
        String insql="insert ignore into LibraryInformation (loginID,bookName,author,bookID,publisher,publishTime,price) values(?,?,?,?,?,?,?)";
        //定义PreparedStatement对象
        PreparedStatement pstmtAdd=  conn.prepareStatement(insql);

        //为要插入的位置赋上具体的信息
        pstmtAdd.setString(1, loginID);
        pstmtAdd.setString(2, bookName);
        pstmtAdd.setString(3, author);
        pstmtAdd.setString(4, bookID);
        pstmtAdd.setString(5, publisher);
        pstmtAdd.setString(6, publishTime);
        pstmtAdd.setDouble(7, price);

        //获取查询得到的返回值
        int count=pstmtAdd.executeUpdate();

        //释放资源
        pstmtAdd.close();
        conn.close();


        //返回判断值
        return count;
    }


}
