//package com.example.demo.controller;
//
//import com.example.demo.config.ParmaConfig;
//import com.example.demo.pojo.ExportComeInsureInfo;
//import com.example.demo.util.ExcelHelper;
//import com.example.demo.util.Md5Utils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
///**
// * @Author xiaodwei
// */
//@Controller
//public class CheckAccController {
//    private static final Logger log = LoggerFactory.getLogger(CheckAccController.class);
//    private static final int ACC_LENGTH = 9;
//    private static final String ACC_TYPE = "60";
//
//    @Autowired
//    private ParmaConfig parmaConfig;
//
//    @RequestMapping(value="/page")
//    @ResponseBody
//    public ModelAndView query(String acc) {
//        ModelAndView mode = new ModelAndView();
//
//        log.info("go to the query the acc:" + acc);
//        if (StringUtils.isEmpty(acc) || acc.length() !=  ACC_LENGTH || !acc.startsWith(ACC_TYPE)) {
//            mode.addObject("error", "账号为空或者格式不正确！");
//            mode.setViewName("error111");
//            return mode;
//
//        }
//
//        acc = Md5Utils.MD5(acc);
//        log.info("go to the query the MD5acc:" + acc);
//        String error = "false";
//        String work = parmaConfig.getWork();
//        String error1 = parmaConfig.getError();
//
//        File errorFile = new File(error1);
//        File file = new File(work);
//
//        File[] files = file.listFiles();
//        if (files.length == 0) {
//            mode.addObject("error", "work目录下没有文件,请及时上传文件！");
//            mode.setViewName("error111");
//            return mode;
//        }
//        String workpath = files[files.length - 1].getPath();
//        File workfile = new File(workpath);
//
//        String accexcel;
//        long startTime = System.currentTimeMillis();
//        try {
//            ExcelHelper eh = ExcelHelper.readExcel(workpath);
//            List<ExportComeInsureInfo> entitys = eh.toEntitys(ExportComeInsureInfo.class);
//            long endTime = System.currentTimeMillis();
//            log.info("parse the execl has taken " + (endTime - startTime) + " ms");
//            boolean flag = false;
//            for (ExportComeInsureInfo comeInsureInfo : entitys) {
//                accexcel = comeInsureInfo.getAcc();
//                if (acc.equalsIgnoreCase(accexcel)) {
//                    flag = true;
//                    break;
//                }
//            }
//
//            if (!flag) {
//
//                mode.addObject("error", error);
//                mode.setViewName("error111");
//                return mode;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            error = error + e.getMessage();
//            log.error("parse excel is error:" + error);
//            try {
//                FileCopyUtils.copy(workfile, errorFile);
//                workfile.delete();
//            } catch (IOException e1) {
//                log.error("error e1:"+e1.getMessage(),e1);
//            }
//
//            mode.addObject("error", error);
//            mode.setViewName("error111");
//            return mode;
//        }
//
//        errorFile =null;
//        file =null;
//        files =null;
//        workfile=null;
//
//        mode.setViewName("success");
//        return mode;
//    }
//}