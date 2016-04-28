package Test.fccs;

import Test.Douban.DoubanProcessor;
import Test.Douban.DoubanUrlList;
import core.Spider;
import extension.DefaultDownloader;
import extension.PrintSaver;

public class FccsMain {
	public static final String AGENT= "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) "
			+ "AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31";
    public static final String cookie = "uuid=ECCE6B64045AF94CD59B087E221A6F21; lAvL_2b59_saltkey=qVTpKnnp; lAvL_2b59_lastvisit=1460380918; lAvL_2b59_auth=e4b7U7JhRXFDWOcgxYkrLdzXeMCHh27dbJqVkOytsS%2FHnSZL%2B9nkka36cVy1Ar5jsmubs%2BznJclL8KJ1PszhKxQZit60; Hm_lvt_d8e1ca741719222e7bdea1581ab95414=1460902461,1460903765,1461159717,1461244292; lAvL_2b59_ulastactivity=1461315763%7C0; JSESSIONID=EC24D1E45DC1BEC2A2613EE7114159E7; communication=f7e433e2a0084abbd7e53cdea7144b728b1b244c00e05c3a; prvUsersMsgCount=0; chatName=3687538; chatNameType=2; userMapCookie=eff07920f1f1bd90ece0a65b16e9e189d622ead262dc387d118bafc9b217ace89c7b2de7d848c377f6f5d64966af50d29614474dd33bbd61ade5b60595e6125a7748d5f5fe3579441c86278d3342407f1eecefc1f6acd23876f420f92b1416cc5480cf6ea5fa18bcbea9eb3266f0bf5170261a4d06db207e742adbcabbbf745d716de002f4bb132f; fccsUrl=jx.fccs.com; fccsCity=07523f8106152d57";
    public static final int  pagenum = 11;

    public static void main(String[] args) {
		Spider.create().setUrlList(new FccsUrlList())
					   .setDownloader(new DefaultDownloader()
                               .setThreadPoolSize(1)
                               .setUserAgent(AGENT)
                               .setCookie(FccsMain.cookie)
                       )
					   .setProcessor(new FccsProcesser())
					   .setSaver(new PrintSaver())
					   .begin();
	}
}

