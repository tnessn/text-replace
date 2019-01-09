package com.github.tnessn.text.replace;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("place")
public  class Place {
	
		private String filePath;
		private String oldStr;
		private String newStr;
		private boolean supportRegex;

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

		public boolean getSupportRegex() {
			return supportRegex;
		}

		public void setSupportRegex(boolean supportRegex) {
			this.supportRegex = supportRegex;
		}
	}