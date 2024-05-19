/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBconnect{
    private ResultSet rs;
    public void update(String sql){
        Connection conn; 
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=ckRSA;user=sa;password=111111118";
            conn = DriverManager.getConnection(dbURL);
            Statement sttm = conn.createStatement();
            sttm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thực hiện thành công");
        } catch (Exception e) {
            int choice = JOptionPane.showConfirmDialog(null, "Lỗi:"+e.toString(), "ERO", JOptionPane.YES_OPTION);
        }
    }
    public Connection getconn(){
        Connection conn = null; 
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=ckRSA;user=sa;password=111111118";
            conn = DriverManager.getConnection(dbURL);
            return conn;
        } catch (Exception e) {
            int choice = JOptionPane.showConfirmDialog(null, "Lỗi:"+e.toString(), "ERO", JOptionPane.YES_OPTION);
            return conn;
        }      
    }
    public void select(String sql){
        Connection conn; 
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=ckRSA;user=sa;password=111111118";
            conn = DriverManager.getConnection(dbURL);
            Statement sttm = conn.createStatement();
            this.rs = sttm.executeQuery(sql);
        } catch (Exception e) {
            int choice = JOptionPane.showConfirmDialog(null, "Lỗi:"+e.toString(), "ERO", JOptionPane.YES_OPTION);
        }
    }
    public String getck(){
        String ss = null;
        try {
             while (rs.next()) {                
                ss = rs.getString("ChuKy"); 
            }         
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Lỗi : "+e.getMessage());
        }
        return ss;
    }
    public String gettenf(){
        String ss = null;
        try {
             while (rs.next()) {                
                ss = rs.getString("mafile"); 
            }         
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Lỗi : "+e.getMessage());
        }
        return ss;
    }
    
    public String getsimpeldate(Date a){       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = sdf.format(a);
        return formattedDate;
    }

    
}
