package com.example.demo.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @description: fileUtils 将source的文件加密后输出到target目标文件
 * @author: fashion wei
 * @create: 2020-05-13
 **/
public class FileUtil {
    public static void encryptionChar(String pathSource,String pathTarget){


        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(pathSource), StandardCharsets.UTF_8));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathTarget), StandardCharsets.UTF_8));

            String str;
            while ((str=br.readLine())!=null){
//                System.out.println(str);
                bw.write(Objects.requireNonNull(Md5Utils.MD5(str)));
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

        File file =new File(pathSource);
        if (file.exists()){
            file.deleteOnExit();
        }
    }
}
