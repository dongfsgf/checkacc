
package com.example.demo;

import com.example.demo.util.FileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.File;

@SpringBootApplication



// 内置tomcat启动项
//public class Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//
//}

//tomcat 启动项
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("程序启动------------------------------------>>>>");
		String workpath ="C:\\file\\work\\acc.txt";
		File workfile = new File(workpath);
		String pathSource = workfile.getPath();
		String pathTarget =
				workpath.substring(0,workpath.indexOf("."))+
						"_md5" + workpath.substring(workpath.indexOf("."));
		FileUtil.encryptionChar(pathSource, pathTarget);

		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}