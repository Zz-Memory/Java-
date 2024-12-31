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
        //定义查找SQL语句
        String sqlQuery = "select * from LibraryInformation";
        //获取对象
        PreparedStatement pstmtQuery = conn.prepareStatement(sqlQuery);
        //执行语句获取返回值
        ResultSet rs = pstmtQuery.executeQuery();
        //处理结果List<LibraryInformation>封装LibraryInformation对象，装载List集合
        LibraryInformation libraryInformation=null;//节约空间，可以在外部先行处理
        //创建LibraryInformation形式的内容清单
        List<LibraryInformation> bookList=new ArrayList<>();
        //创建列表对象
        ObservableList<LibraryInformation> bookListob=null;

        while(rs.next()){
            //接收查询到的数据
            String loginID=rs.getString("loginID");
            String bookName=rs.getString("bookName");
            String author=rs.getString("author");
            String bookID=rs.getString("bookID");
            String publisher=rs.getString("publisher");
            String publishTime=rs.getString("publishTime");
            Double price=rs.getDouble("price");

            //封装libraryInformation对象
            libraryInformation=new LibraryInformation(loginID,bookName,author,bookID,publisher,publishTime,price);
            //将数据装载到内容清单bookList中
            bookList.add(libraryInformation);
            //创建以bookList为数据来源的ObservableList对象bookListob
            bookListob= FXCollections.observableArrayList(bookList);
        }
        //释放资源
        rs.close();
        pstmtQuery.close();

        //返回列表数据
        return bookListob;
    }
}
