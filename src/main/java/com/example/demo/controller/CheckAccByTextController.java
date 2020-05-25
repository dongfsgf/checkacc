package com.example.demo.controller;

import com.example.demo.config.ParmaConfig;
import com.example.demo.util.FileUtil;
import com.example.demo.util.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Objects;

/**
 * @Author xiaodwei
 */
@Controller
public class CheckAccByTextController {
    private static final Logger log = LoggerFactory.getLogger(CheckAccByTextController.class);
    private static final int ACC_LENGTH = 9; //账号长度
    private static final String ACC_TYPE = "60"; //账号类型

    @Autowired
    private ParmaConfig parmaConfig;

    @RequestMapping(value = "/page")
    @ResponseBody
    public ModelAndView query(String acc) {
        ModelAndView mode = new ModelAndView();

        log.info("go to the query the acc:" + acc);
        if (StringUtils.isEmpty(acc) || acc.length() != ACC_LENGTH || !acc.startsWith(ACC_TYPE)) {
            mode.addObject("error", "NO");
            mode.setViewName("error111");
            return mode;

        }

        acc = Md5Utils.MD5(acc);
        log.info("go to the query the MD5acc:" + acc);


        String error = "NO";
        String work = parmaConfig.getWork();
        String error1 = parmaConfig.getError();

        File errorFile = new File(error1);
        File file = new File(work);

        File[] files = file.listFiles();
        if (files.length == 0) {
            mode.addObject("error", "work目录下没有文件,请及时上传文件！");
            mode.setViewName("error111");
            return mode;
        }
        String workpath = work+"\\acc.txt";
        File workfile = new File(workpath);
        String pathTarget =
                workpath.substring(0,workpath.indexOf("."))+
                        "_md5" + workpath.substring(workpath.indexOf("."));
        String accInFile;
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        log.info("parse the file has taken " + (endTime - startTime) + " ms");
        boolean flag = false;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(pathTarget)));
            while ((accInFile = in.readLine()) != null) {
                if (Objects.requireNonNull(acc).equalsIgnoreCase(accInFile)) {
                    flag = true;
                    break;
                }
            }
            in.close();
            if (!flag) {

                mode.addObject("error", error);
                mode.setViewName("error111");
                return mode;
            }

        } catch (Exception e) {
            e.printStackTrace();
            error = error + e.getMessage();
            log.error("parse file is error:" + error);
            try {
                FileCopyUtils.copy(workfile, errorFile);
                workfile.delete();
            } catch (IOException e1) {
                log.error("error e1:" + e1.getMessage(), e1);
            }

            mode.addObject("error", error);
            mode.setViewName("error111");
            return mode;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mode.setViewName("success");
        return mode;
    }
}