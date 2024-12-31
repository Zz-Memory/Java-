package cn.ecut.LibraryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryDelete extends LibraryGetConn{
    public int delete(String loginID) throws SQLException {
        //创建判断值
        int count = 0;
        //定义删除语句
        String sqlDE = "delete from libraryInformation where loginID=?";
        //定义删除图书信息时的查询语句
        String sqlDEin = "select * from libraryInformation where loginID=?";

        //获取删除图书信息的对象
        PreparedStatement pstmtDE = conn.prepareStatement(sqlDE);
        //获取参数
        pstmtDE.setString(1, loginID);

        //获取删除图书信息时用于查询信息的对象
        PreparedStatement pstmtDEin = conn.prepareStatement(sqlDEin);
        //获取参数
        pstmtDEin.setString(1, loginID);

        //执行语句并获取返回值
        ResultSet rsDEin = pstmtDEin.executeQuery();

        //判断loginID是否存在与数据库中
        if (rsDEin.next()) {
            pstmtDE.executeUpdate();
            count=1;
        }

        //释放资源
        rsDEin.close();
        pstmtDEin.close();
        pstmtDE.close();

        //返回判断值
        return count;
    }
}
