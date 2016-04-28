package Test.fccs;

import core.UrlList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 16/4/26.
 */

public class FccsDetailUrlList implements UrlList<String> {

    public List<String> urlList = new ArrayList<String>();
    public FccsDetailUrlList() {
    }
    public FccsDetailUrlList(List<String> list) {
        urlList = list;
    }
    /**

     *   notice: 在这个函数中，新建要创建的url链表并返回
     * **/
    public List<String> returnUrlList() {

        return urlList;
    }

}
