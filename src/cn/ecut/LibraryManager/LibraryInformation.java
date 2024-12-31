package cn.ecut.LibraryManager;

public class LibraryInformation {
    //创建图书的各项相关属性
    private String loginID;
    private String bookName;
    private String author;
    private String bookID;
    private String publisher;
    private String publishTime;
    private Double price;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LibraryInformation(String loginID, String bookName, String author, String bookID, String publisher, String publishTime, Double price) {
        this.loginID = loginID;
        this.bookName = bookName;
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.publishTime = publishTime;
        this.price = price;
    }
}
