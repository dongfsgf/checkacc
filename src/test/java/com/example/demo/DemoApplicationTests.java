//package com.example.demo;
//
////import org.junit.jupiter.api.Test;
////import org.springframework.boot.test.context.SpringBootTest;
//
//import com.dhl.excelutil.ExcelHelper;
//import com.dhl.excelutil.exception.ExcelContentInvalidException;
//import com.dhl.excelutil.exception.ExcelParseException;
//import com.dhl.excelutil.exception.ExcelRegexpValidFailedException;
//import com.example.demo.pojo.ExportComeInsureInfo;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//
//import java.io.IOException;
//import java.util.List;
//
////@SpringBootTest
//class DemoApplicationTests {
//
////	@Test
////	void contextLoads() {
////	}
//
//	public static void main(String[] args) {
//		try {
//			String accexcel = "";
//			String svc = "";
//			String cmpname = "";
//			String path = "C:\\Users\\Administrator\\Desktop\\20200408221707.xlsx";
//
////			ExcelHelper.registerNewType(MyDataType.class);
//			ExcelHelper eh = ExcelHelper.readExcel(path);
//			List<ExportComeInsureInfo> entitys = eh.toEntitys(ExportComeInsureInfo.class);
//			boolean flag = false;
//			for (ExportComeInsureInfo comeInsureInfo : entitys) {
//				accexcel = comeInsureInfo.getAcc();
//				svc = comeInsureInfo.getSvc();
//				cmpname = comeInsureInfo.getCmpname();
//				if ("604827269".equalsIgnoreCase(accexcel)) {
//					flag = true;
//					break;
//				}
//			}
//		} catch (ExcelParseException e) {
//			e.printStackTrace();
//		} catch (ExcelContentInvalidException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ExcelRegexpValidFailedException e) {
//			e.printStackTrace();
//		} catch (InvalidFormatException e) {
//			e.printStackTrace();
//		}
//	}
//}
