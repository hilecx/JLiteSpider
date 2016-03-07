package extension;

import core.Saver;
/**
 * author : Yixin Luo
 * 2016/3/5
 * 
 * 对保存接口的实现，将结果打印出来
 * 
 * **/
public class PrintSaver implements Saver<String> {

	public void save(String key, String value) {
		System.out.println(key+"->"+value);
	}

}
