package com.github.tnessn.text.replace;

import java.io.File;
import java.util.List;

import com.github.tnessn.text.replace.util.ReplaceUtil;
import com.github.tnessn.text.replace.util.XmlUtils;

public class Application {
	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.dir") + "\\config.xml";
		ReplaceMsg replaceMsg = XmlUtils.parseFromXml(ReplaceMsg.class, new File(path));
		System.out.println("config path:" + path);
		List<Place> places = replaceMsg.getPlaces();
		for (Place place : places) {
			ReplaceUtil.start(replaceMsg.getExtension(),new File(place.getFilePath()), place.getOldStr(), place.getNewStr(),place.getSupportRegex());
		}
	}
}
