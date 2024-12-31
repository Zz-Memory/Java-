package cn.ecut.LibraryManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryQueryA extends LibraryGetConn{
    public ObservableList queryA(String author) throws SQLException {
        //定义按书名查询图书信息SQL语句
        String sqlQA="select * from LibraryInformation where author=?";
        //通过Connection对象获取，并传入对应的sql语句
        PreparedStatement pstmtQA= conn.prepareStatement(sqlQA);
        //设置?（参数）的值
        pstmtQA.setString(1,author);
        //执行SQL语句
        ResultSet rsQA = pstmtQA.executeQuery();
        //处理结果List<LibraryInformation>封装LibraryInformation对象，装载List集合
        LibraryInformation libraryInformationQA=null;//节约空间，可以在外部先行处理
        //创建LibraryInformation形式的内容清单
        List<LibraryInformation> bookListQa = new ArrayList<>();
        while(rsQA.next()){
            String loginIDQA=rsQA.getString("loginID");
            String bookNameQA=rsQA.getString("bookName");
            String authorQA=rsQA.getString("author");
            String bookIDQA=rsQA.getString("bookID");
            String publisherQA=rsQA.getString("publisher");
            String publishTimeQA=rsQA.getString("publishTime");
            Double priceQA=rsQA.getDouble("price");

            //封装libraryInformation对象
            libraryInformationQA=new LibraryInformation(loginIDQA,bookNameQA,authorQA,bookIDQA,publisherQA,publishTimeQA,priceQA);


            //将数据装载到内容清单bookList中
            bookListQa.add(libraryInformationQA);
        }
        //创建以bookListQa为数据来源的ObservableList对象bookListQA
        ObservableList<LibraryInformation> bookListQA= FXCollections.observableArrayList(bookListQa);

        //释放资源
        rsQA.close();
        pstmtQA.close();

        //返回数据表
        return bookListQA;
    }
}
