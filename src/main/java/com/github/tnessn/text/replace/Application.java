package com.github.tnessn.text.replace;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import cc.aicode.e2e.ExcelHelper;

public class Application {
	
	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.dir") .concat(File.separator).concat("config.xlsx");
		System.out.println("配置文件路径:" + path);

		ExcelHelper eh = ExcelHelper.readExcel(path);
	    List<Place> entitys  = eh.toEntitys(Place.class);
	    System.out.println(entitys.size()+"条替换规则");
	    System.out.println(JSON.toJSONString(entitys));
	    
		
	    List<String> extensions=null;
		for (Place place : entitys) {
			if(StringUtils.isNotBlank(place.getExtension())) {
				extensions=Arrays.asList(place.getExtension().split("\\s+"));
			}else {
				extensions=Collections.emptyList();
			}
			replace(new File(place.getFilePath()), place.getOldStr(), place.getNewStr(), BooleanUtils.toBoolean(place.getSupportRegex()),extensions);
		}
	}

	private static void replace(File file, String oldStr, String newStr, boolean supportRegex,List<String> extensions) throws IOException {
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + " not found!");
			return;
		}

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				replace(f, oldStr, newStr, supportRegex,extensions);
			}
		} else {
			if (extensions.isEmpty()||(file.getName().lastIndexOf(".")!=-1&&extensions.contains(file.getName().substring(file.getName().lastIndexOf("."))))) {
				System.out.println("正在替换文件"+file.getAbsolutePath());
				String readFileToString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
				String resule = "";
				if (supportRegex) {
					resule = StringUtils.replacePattern(readFileToString, oldStr, newStr);
				} else {
					resule = StringUtils.replace(readFileToString, oldStr, newStr);
				}
				resule = StringUtils.replace(resule, "@line", System.getProperty("line.separator"));
				FileUtils.write(file, resule, StandardCharsets.UTF_8);
			}
		}

	}
}