package cn.ecut.LibraryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryDelete extends LibraryGetConn{
    public int delete(String loginID) throws SQLException {
        //�����ж�ֵ
        int count = 0;
        //����ɾ�����
        String sqlDE = "delete from libraryInformation where loginID=?";
        //����ɾ��ͼ����Ϣʱ�Ĳ�ѯ���
        String sqlDEin = "select * from libraryInformation where loginID=?";

        //��ȡɾ��ͼ����Ϣ�Ķ���
        PreparedStatement pstmtDE = conn.prepareStatement(sqlDE);
        //��ȡ����
        pstmtDE.setString(1, loginID);

        //��ȡɾ��ͼ����Ϣʱ���ڲ�ѯ��Ϣ�Ķ���
        PreparedStatement pstmtDEin = conn.prepareStatement(sqlDEin);
        //��ȡ����
        pstmtDEin.setString(1, loginID);

        //ִ����䲢��ȡ����ֵ
        ResultSet rsDEin = pstmtDEin.executeQuery();

        //�ж�loginID�Ƿ���������ݿ���
        if (rsDEin.next()) {
            pstmtDE.executeUpdate();
            count=1;
        }

        //�ͷ���Դ
        rsDEin.close();
        pstmtDEin.close();
        pstmtDE.close();

        //�����ж�ֵ
        return count;
    }
}
