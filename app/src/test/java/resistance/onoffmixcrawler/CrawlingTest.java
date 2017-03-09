package resistance.onoffmixcrawler;

import android.util.Log;

import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by GwanYongKim on 2017-03-09.
 */

public class CrawlingTest {


    OnOffMixCrawler onOffMixCrawler;


    @Before
    public void init(){
        onOffMixCrawler = new OnOffMixCrawler();
    }

    @Test
    public void connect(){
        String html = onOffMixCrawler.searchMeeting("프로그래밍");
        assertNotEquals(html.length(), 0);
    }


}
