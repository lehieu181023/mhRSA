/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author lehie
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;

public class WriteToFileInFolder {
    public void xuatfile (BigInteger n, List<BigInteger> ckmh,String tenfile){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            // Đường dẫn đến thư mục chứa tập tin txt
            String folderPath = "D:\\ATBM\\chuky"; // Thay đổi đường dẫn này thành đường dẫn của thư mục bạn muốn lưu tập tin

            // Tạo thư mục nếu chưa tồn tại
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs(); // Tạo thư mục nếu chưa tồn tại
            }

            // Đường dẫn đến tập tin txt
            String filePath = folderPath + "\\"+tenfile+".txt"; // Tên tập tin là output.txt

            // Tạo đối tượng FileWriter để ghi vào tập tin
            FileWriter fileWriter = new FileWriter(filePath);

            // Tạo đối tượng BufferedWriter để ghi dữ liệu một cách hiệu quả
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0 ; i< ckmh.size();i++) {
                stringBuilder.append("-"+ckmh.get(i)); // Thêm ký tự vào chuỗi
            }
            // Dữ liệu cần ghi vào tập tin
            String data ="n-"+ n +"\n"+"ck"+stringBuilder;

            // Ghi dữ liệu vào tập tin
            bufferedWriter.write(data);

            // Đóng bufferedWriter sau khi ghi xong
            bufferedWriter.close();

            JOptionPane.showMessageDialog(null, "Dữ liệu đã được ghi vào tập tin " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

