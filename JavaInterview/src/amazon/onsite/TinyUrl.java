package amazon.onsite;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: This is a companion problem to the System Design problem: Design
 * 
 * TinyURL. TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need to
 * ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 * @author hbhavsar
 *
 */
public class TinyUrl {
	
	public static void main(String[] args) {
		TinyUrl t = new TinyUrl();
		String url = "";

		String encoded = t.encode(url);
		System.out.println(encoded);

		String decoded = t.decode(encoded);
		System.out.println(decoded);
	}

	// Registered host
	String host = "http://tinyurl.com/";

	// Assuming that this is global store
	Map<Integer, String> urlMap = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		urlMap.put(longUrl.hashCode(), longUrl);
		return host + longUrl.hashCode();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return urlMap.get(Integer.parseInt(shortUrl.replace(host, "")));
	}
}
