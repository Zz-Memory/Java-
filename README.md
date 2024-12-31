### 1.如果打开之后出现中文乱码

​	那么请打开IntelliJ IDEA的Settings，找到Editor下的File Encodings，将以下三项设置为以下内容：

​	Global Encoding: UTF-8

​	Project Encoding: GBK

​	Default encoding for properties files: <Default>

### 2.项目首先需要创建一个数据库library

​	建表SQL语句在cn.ecut.LibraryManager的LibraryMySQLCreate.java。

​	可以直接运行该文件来创建表，创建成功之后控制台会出现提示，表中数据按自己喜好填写。

​	运行不成功可能是缺少驱动，在 IntelliJ IDEA 中，可以在项目结构中添加依赖，选择 `File` -> `Project Structure`，在 `Libraries` 部分添加 JAR 文件。

​	不想找的可以去我的博客中下载，博客地址：https://blog.csdn.net/ZzMemory/article/details/144847858?fromshare=blogdetail&sharetype=blogdetail&sharerId=144847858&sharerefer=PC&sharesource=ZzMemory&sharefrom=from_link
