import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class HtmlParser {

	public static void main(String[] args) {
		//System.out.println(extractCoinDetail("https://coinmarketcap.com/currencies/pakcoin/"));

		try {
			String parentUrl = "https://coinmarketcap.com";
			String allCoinsUrl   = parentUrl + "/all/views/all/";
			URL url = new URL(allCoinsUrl);
			Document doc = Jsoup.parse(url, 30*1000);
			Elements links = doc.select("a[href]");
			Set<String> linkCoinSet = new HashSet<>();
			Map<String, String> coinsMap = new  LinkedHashMap<>();
			for (Element link : links) {
				String linkString = link.attr("href");
				if(linkString.contains("currencies")){
					linkCoinSet.add(linkString.replaceAll("#markets", ""));
				}
			}
			for (String link : linkCoinSet) {
				coinsMap.put(link,extractCoinDetail(parentUrl + link));
			}
			
			for (Entry<String, String> entry : coinsMap.entrySet()) {
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String extractCoinDetail(String coinUrl){
		try {
			URL url = new URL(coinUrl);
			Document doc = Jsoup.parse(url, 10*1000);
			String title = doc.html();
			if(title.contains("document.title")){
				int beginIndex = title.indexOf("document.title =");
				int endIndex = title.lastIndexOf("| CoinMarketCap");
				return title.substring(beginIndex, endIndex).replaceAll("document.title = \"", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
