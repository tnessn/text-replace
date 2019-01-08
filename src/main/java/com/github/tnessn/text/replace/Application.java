package com.github.tnessn.text.replace;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

public class Application {
	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.dir") + "\\config";
		System.out.println("config path:" + path);

		List<String> readLines = FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
		String filepath = "";
		String oldStr = "";
		String newStr = "";
		boolean regex = false;
		for (String line : readLines) {
			if (StringUtils.isBlank(line)) {
				return;
			}
			filepath = line.split("\\t+")[0];
			oldStr = line.split("\\t+")[1];
			newStr = line.split("\\t+")[2];
			regex = BooleanUtils.toBoolean(line.split("\\t+")[3]);
			replace(new File(filepath), oldStr, newStr, regex);
		}
	}

	private static void replace(File file, String oldStr, String newStr, boolean regex) throws IOException {

		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + " not found!");
			return;
		}

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				replace(f, oldStr, newStr, regex);
			}
		} else {
			System.out.println(file.getAbsolutePath());
			if (file.getName().endsWith(".md")) {
				String readFileToString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

				String resule = "";
				if (regex) {
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
