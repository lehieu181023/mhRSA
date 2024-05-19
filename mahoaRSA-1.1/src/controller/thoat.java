/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;

/**
 *
 * @author lehie
 */
public class thoat {
    public void btthoat(){
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát khỏi ứng dụng?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0); // Thoát khỏi ứng dụng
                }
    }
}
