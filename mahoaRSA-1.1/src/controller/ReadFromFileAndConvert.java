/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author lehie
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromFileAndConvert {
    public BigInteger n = null;
    public List<BigInteger> ck = new ArrayList<>();
    public void docfile(String absolutePath) {
        try {
            FileReader fileReader = new FileReader(absolutePath);

            // Tạo đối tượng BufferedReader để đọc dữ liệu một cách hiệu quả
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Đọc dữ liệu từ tập tin
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Phân tích dòng dữ liệu để tìm "n" và "ck"
                if (line.startsWith("n-")) {
                    n = new BigInteger(line.substring(2).trim());
                } else if (line.startsWith("ck-")) {
                    // Sử dụng biểu thức chính quy để tìm các số trong dòng "ck"
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        // Chuyển đổi số thành BigInteger và thêm vào danh sách
                        ck.add(new BigInteger(matcher.group()));
                    }
                }
            }

            // In các giá trị đã đọc
            System.out.println("Giá trị của n: " + n);
            System.out.println("Giá trị của danh sách ck:");
            for (BigInteger num : ck) {
                System.out.println(num);
            }

            // Đóng bufferedReader sau khi đọc xong
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




