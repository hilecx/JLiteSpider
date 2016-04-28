package Test.fccs;

import core.Saver;

import java.io.*;

/**
 * author : Yixin Luo
 * 2016/3/5
 * 
 * 对保存接口的实现，将结果打印出来
 * 
 * **/
public class FileSaver implements Saver<String> {

	public void save(String key, String value) {
        File file = new File("/Users/Zach/dev/code/tmp/fccsfile/"+key+".html");
        try {
            file.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file),"GB18030"));
//            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(value); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }


	}

}
