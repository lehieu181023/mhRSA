/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author lehie
 */
public class ngaythanght {
    public String ng;
    public String laynt() {
        // Lấy thời gian hiện tại
        Calendar now = Calendar.getInstance();

        // Định dạng chuỗi ngày tháng năm giờ phút giây
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        // Tạo chuỗi từ thời gian hiện tại
        String dateTimeString = sdf.format(now.getTime());
        ng = sdf2.format(now.getTime());

        // In ra chuỗi kết quả
        return dateTimeString;
    }
    
}
