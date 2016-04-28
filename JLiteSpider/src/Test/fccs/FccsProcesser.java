package Test.fccs;

import core.Processor;
import core.Saver;
import core.Spider;
import core.UrlList;
import extension.DefaultDownloader;
import extension.PrintSaver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 16/4/26.
 */
public class FccsProcesser implements Processor<String> {
//    <a href="/agency/saleHouse.do?saleId=39558233">房源修改</a>
    public void process(List<String> pages, Saver saver) {
        // TODO Auto-generated method stub

        for (String each : pages) {
//            try {
//                Thread.sleep(1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Document doc = Jsoup.parse(each);
            Element ele = doc.body();
            Elements es = ele.select("a[href~=/agency/saleHouse.do(\\?)saleId=[0-9]+]");
            for (int i = 0; i < es.size(); i++) {
//                es.get(i).attr("href");
                List<String> detailList = new ArrayList<String>();
                detailList.add("http://member.fccs.com"+es.get(i).attr("href"));
                System.out.println("url--->" + es.get(i).attr("href"));
                Spider.create().setUrlList(new FccsDetailUrlList(detailList))
                        .setDownloader(new DefaultDownloader()
                                        .setThreadPoolSize(1)
                                        .setUserAgent(FccsMain.AGENT)
                                        .setCookie(FccsMain.cookie)
                        )
                        .setProcessor(new FccsDetailProcesser())
                        .setSaver(new FileSaver())
                        .begin();
//                saver.save("href", es.get(i).select("dt").select("a").attr("href"));
//                saver.save("title", es.get(i).select("dd").select("a").text());
            }
        }


    }

}
