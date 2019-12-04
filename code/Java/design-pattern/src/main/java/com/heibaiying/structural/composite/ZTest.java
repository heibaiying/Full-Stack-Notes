package com.heibaiying.structural.composite;

public class ZTest {
	public static void main(String[] args) {
		Folder rootDir = new Folder("ROOT目录");
		Folder nginx = new Folder("Nginx安装目录");
		Folder tomcat = new Folder("Tomcat安装目录");
		File startup = new File("startup.bat");
		rootDir.add(nginx);
		rootDir.add(tomcat);
		rootDir.add(startup);
		rootDir.print();
		startup.vim("java -jar");
		startup.cat();
		nginx.cat();

	}
}
