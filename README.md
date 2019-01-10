## 使用说明

1 .  编译生成可运行jar包

 ```
 mvn package
 ```

2 .  拷贝classpath 中的config.xlsx文件与jar同级

3 . 在config.xlsx文件配置替换内容

* 支持替换单个文件和文件夹的所有文件
* 用@line 表示一行

4 .  开始替换

 ```
 java -jar .\text-replace-0.0.1-SNAPSHOT.jar
 ```

