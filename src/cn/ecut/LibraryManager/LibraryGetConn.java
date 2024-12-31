package cn.ecut.LibraryManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryGetConn {
    String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
    String user = "root";
    String password = "ecut";
    Connection conn;

    {
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
