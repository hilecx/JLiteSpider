package Test.fccs;

import core.Processor;
import core.Saver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 16/4/26.
 */
public class FccsDetailProcesser implements Processor<String> {
//    <a href="/agency/saleHouse.do?saleId=39558233">房源修改</a>
    public void process(List<String> pages, Saver saver) {
        // TODO Auto-generated method stub
        for (String each : pages) {
            Document doc = Jsoup.parse(each);
            Element ele = doc.body();
            Elements es = ele.select("input[id=saleId]");
            for (int i = 0; i < es.size(); i++) {
//                es.get(i).attr("href");
                System.out.println(es.get(i).attr("value"));
                saver.save(es.get(i).attr("value"),doc.toString());
//                saver.save("href", es.get(i).select("dt").select("a").attr("href"));
//                saver.save("title", es.get(i).select("dd").select("a").text());
            }
        }
    }

}
