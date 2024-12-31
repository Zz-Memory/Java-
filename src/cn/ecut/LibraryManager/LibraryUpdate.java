package cn.ecut.LibraryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryUpdate extends LibraryGetConn{
    public int update(String loginID,String bookName,String author,String bookID,String publisher,String publishTime,Double price) throws SQLException {
        String sqlUP="update libraryInformation set bookName=?,author=?,bookID=?,publisher=?,publishTime=?,price=? where loginID=?";
        PreparedStatement pstmtUP= conn.prepareStatement(sqlUP);
        //获取参数
        pstmtUP.setString(7,loginID);
        pstmtUP.setString(1,bookName);
        pstmtUP.setString(2,author);
        pstmtUP.setString(3,bookID);
        pstmtUP.setString(4,publisher);
        pstmtUP.setString(5,publishTime);
        pstmtUP.setDouble(6,price);

        //执行修改
        int count=pstmtUP.executeUpdate();

        //释放资源
        pstmtUP.close();

        //返回判断值
        return count;
    }

    public LibraryInformation queryUP(String loginID) throws SQLException {
        //创建修改图书信息时的查询语句
        String sqlUPin="select * from libraryInformation where loginID=?";
        //创建对象
        PreparedStatement pstmtUPin=conn.prepareStatement(sqlUPin);
        //设置参数
        pstmtUPin.setString(1,loginID);
        //执行语句并获取返回值
        ResultSet rsUPin = pstmtUPin.executeQuery();
        //创建封装数据对象
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
        //释放资源
        rsUPin.close();
        pstmtUPin.close();

        //返回查询到的数据
        return libraryInformation;
    }
}
