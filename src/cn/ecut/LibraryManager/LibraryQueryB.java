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
        //定义按书名查询图书信息SQL语句
        String sqlQB="select * from LibraryInformation where bookName=?";
        //通过Connection对象获取，并传入对应的sql语句
        PreparedStatement pstmtQB= conn.prepareStatement(sqlQB);
        //设置?（参数）的值
        pstmtQB.setString(1,bookName);
        //执行SQL语句
        ResultSet rsQB = pstmtQB.executeQuery();
        //处理结果List<LibraryInformation>封装LibraryInformation对象，装载List集合
        LibraryInformation libraryInformationQB=null;//节约空间，可以在外部先行处理
        //创建LibraryInformation形式的内容清单
        List<LibraryInformation> bookListQb = new ArrayList<>();
        while(rsQB.next()){
            //接收查询到的数据
            String loginIDQB=rsQB.getString("loginID");
            String bookNameQB=rsQB.getString("bookName");
            String authorQB=rsQB.getString("author");
            String bookIDQB=rsQB.getString("bookID");
            String publisherQB=rsQB.getString("publisher");
            String publishTimeQB=rsQB.getString("publishTime");
            double priceQB=rsQB.getDouble("price");

            //封装libraryInformation对象
            libraryInformationQB=new LibraryInformation(loginIDQB,bookNameQB,authorQB,bookIDQB,publisherQB,publishTimeQB,priceQB);


            //将数据装载到内容清单bookList中
            bookListQb.add(libraryInformationQB);
        }
        //创建以bookListQb为数据来源的ObservableList对象bookListQB
        ObservableList<LibraryInformation> bookListQB= FXCollections.observableArrayList(bookListQb);

        //释放资源
        rsQB.close();
        pstmtQB.close();

        //返回数据表
        return bookListQB;
    }
}
