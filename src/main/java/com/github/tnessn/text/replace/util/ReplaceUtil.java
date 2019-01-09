package com.github.tnessn.text.replace.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ReplaceUtil {
	public static void start(String extensions, File file, String oldStr, String newStr, boolean regex)
			throws IOException {
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + " not found!");
			return;
		}
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				start(extensions, f, oldStr, newStr, regex);
			}
		} else {
			List<String> extensionList = Arrays.asList(extensions.split("\\s+"));
			if (extensionList.contains(file.getName().substring(file.getName().lastIndexOf(".")))) {
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
