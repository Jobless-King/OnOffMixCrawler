package resistance.onoffmixcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;

/**
 * Created by GwanYongKim on 2017-03-09.
 */
public class OnOffMixCrawler {

    public String searchMeeting(String keyword) {
        StringBuilder html = new StringBuilder();
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(String.format(Locale.KOREA, "http://onoffmix.com/event?s=%s", URLEncoder.encode(keyword, "UTF-8")));
            connection = (HttpURLConnection)url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
                html.append(line);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //URL Error
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null) try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(connection != null) connection.disconnect();
        }
        return html.toString();
    }
}
