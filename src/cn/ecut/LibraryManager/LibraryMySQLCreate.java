package cn.ecut.LibraryManager;

import java.sql.*;

public class LibraryMySQLCreate {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
        String user="root";
        String password="ecut";
        //定义建表SQL语句
        String sql="create table LibraryInformation(loginID VARCHAR(20)NOT NULL ,PRIMARY KEY (loginID),bookName VARCHAR(20),author VARCHAR(20),bookID VARCHAR(20),publisher VARCHAR(20),publishTime VARCHAR(20),price DECIMAL(10,2))";

        Connection conn= DriverManager.getConnection(url,user,password);
//        Statement statement=conn.createStatement();
//        statement.executeUpdate(sql);
        PreparedStatement pstmt= conn.prepareStatement(sql);
        //执行SQL语句，创建表
        pstmt.executeUpdate();
        System.out.println("创建成功");
        //释放资源
        pstmt.close();
        conn.close();
    }
}
