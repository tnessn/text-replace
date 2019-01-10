package com.github.tnessn.text.replace;

import cc.aicode.e2e.annotation.ExcelEntity;
import cc.aicode.e2e.annotation.ExcelProperty;

@ExcelEntity
public class Place {
	@ExcelProperty("文件路径")
	private String filePath;
	@ExcelProperty("旧字符串")
	private String oldStr;
	@ExcelProperty("新字符串")
	private String newStr;
	@ExcelProperty("是否支持正则表达式,默认不支持(TRUE/FALSE)")
	private String supportRegex;
	@ExcelProperty("查找扩展名(默认扫描所有,多个以空格分隔)")
	private String extension;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getOldStr() {
		return oldStr;
	}
	public void setOldStr(String oldStr) {
		this.oldStr = oldStr;
	}
	public String getNewStr() {
		return newStr;
	}
	public void setNewStr(String newStr) {
		this.newStr = newStr;
	}
	
	public String getSupportRegex() {
		return supportRegex;
	}
	public void setSupportRegex(String supportRegex) {
		this.supportRegex = supportRegex;
	}

	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
}
