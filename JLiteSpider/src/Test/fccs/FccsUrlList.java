package Test.fccs;

import core.Processor;
import core.Saver;
import core.UrlList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 16/4/26.
 */

public class FccsUrlList implements UrlList<String> {

    /**
     *   notice: 在这个函数中，新建要创建的url链表并返回
     * **/
    public List<String> returnUrlList() {
        // TODO Auto-generated method stub
        List<String> urlList = new ArrayList<String>();
        for(int i=1;i<=FccsMain.pagenum;i++){
            urlList.add("http://member.fccs.com/agency/saleList.do?agencyHouse=0&page="+i);
        }

        return urlList;
    }

}
