package com.example.demo.util;

/**
 * @description: md5util
 * @author: fashion wei
 * @create: 2020-05-12
 **/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Objects;

public class Md5Utils {
    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '5', '6', '7', '8', '9',
                'A', 'F', 'C', 'D', 'E', 'G' ,'z','I','J','K','X','Y','w'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 8 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String sss = "604827269";
        System.out.println(MD5(sss));
        String workpath ="C:\\file\\work\\acc.txt";
        String pathTarget =
                workpath.substring(0,workpath.indexOf("."))+
                        "_md5" + workpath.substring(workpath.indexOf("."));
        System.out.println(pathTarget);
       /* String pathSource ="C:\\file\\work\\acc.txt";
        String pathTarget ="C:\\file\\work\\acc_1.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
             br = new BufferedReader(new InputStreamReader(new FileInputStream(pathSource), StandardCharsets.UTF_8));
             bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathTarget), StandardCharsets.UTF_8));

            String str;
            while ((str=br.readLine())!=null){
                System.out.println(str);
                bw.write(Objects.requireNonNull(MD5(str)));
                bw.newLine();

            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
*/
//        try {
//            ExcelHelper eh = ExcelHelper.readExcel("C:\\file\\work\\20200513.xlsx");
//            List<ExportComeInsureInfo> entitys = eh.toEntitys(ExportComeInsureInfo.class);
//            for (ExportComeInsureInfo comeInsureInfo : entitys) {
//                String accexcel = comeInsureInfo.getAcc();
//                String xxx = MD5(accexcel);
//                System.out.println(xxx);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}