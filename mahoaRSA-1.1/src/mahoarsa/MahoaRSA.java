/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mahoarsa;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lehie
 */
public class MahoaRSA {
    
    public static final int VERSION = 1024;//số bit
    public static final BigInteger E = new BigInteger("65537");

    private BigInteger p;
    private BigInteger q;
    public BigInteger n;
    private BigInteger phiN;
    private BigInteger d;
    
    public void ini(){
        p = BigInteger.probablePrime(VERSION/2 , new Random());
        q = BigInteger.probablePrime(VERSION/2, new Random());
        n = p.multiply(q);
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        d = E.modInverse(phiN);  //mod nghịch đảo
    }
    
    public BigInteger mahoa(BigInteger a , BigInteger b){
        return a.modPow(E, b);//a mũ E mod b
    }
    
    public BigInteger giaima(BigInteger mk){
        return mk.modPow(this.d,this.n);
    } 
    
    public  BigInteger taock(BigInteger chuky){
        return chuky.modPow(this.d, this.n);
    }
    
    public BigInteger kiemdinhck(BigInteger ck, BigInteger n){
        return ck.modPow(E, n);
    }
    //chuyển từ ký tự sang mã ASCII
    public void CharToASCII(String text, List<BigInteger> asciiValues) {
        // Duyệt qua từng ký tự trong chuỗi
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            BigInteger ascii;
            if (Character.isLetter(ch)) {
                // Nếu là ký tự chữ, chuyển ký tự thành số theo bảng mã ASCII
                ascii = BigInteger.valueOf((int) ch);
            } else if (Character.isDigit(ch)) {
                // Nếu là ký tự số, chuyển ký tự thành số BigInteger và thêm vào danh sách
                ascii = BigInteger.valueOf(Character.getNumericValue(ch));
            } else {
                // Nếu không phải chữ hoặc số, bỏ qua
                continue;
            }
            // Đưa số vào danh sách
            asciiValues.add(ascii);
        }
    }
    //Chuyển từ mã ASCII sang ký tự
    public  StringBuilder ASCIIToChar(List<BigInteger> asciiValues) {
        StringBuilder stringBuilder = new StringBuilder();
        for (BigInteger ascii : asciiValues) {
            int value = ascii.intValue();
            char ch;
            if (value >= 0 && value <= 9) {
                // Nếu số nằm trong khoảng từ 0 đến 9, giữ nguyên và thêm vào chuỗi
                stringBuilder.append(value);
            } else {
                // Nếu không, chuyển đổi số thành ký tự theo bảng mã ASCII và thêm vào chuỗi
                ch = (char) value;
                stringBuilder.append(ch);
            }
        }
        return stringBuilder;
    }
    public static void main(String[] args) {
        MahoaRSA k = new MahoaRSA();
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("115532461701921574357444872512889664912152945755789124086022239300258796856024822042010592878494610155502012630404400104454813024032483165711595808200222318446353500938729733408055692604354862889603698431005078304770478967010597880088924157115420948966547310762685756680555214725968614748102429105701648916897");
        k.ini();
        BigInteger h = k.kiemdinhck(a,b);
        
        System.out.println(h);
    }

}


