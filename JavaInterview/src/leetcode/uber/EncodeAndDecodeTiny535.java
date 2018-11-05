package leetcode.uber;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * 535. Encode and Decode TinyURL
DescriptionHintsSubmissionsDiscussSolution
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL 
such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * 
 * 
 * @author habhavsar
 *
 */
public class EncodeAndDecodeTiny535 {

	public static void main(String[] args) {
		EncodeAndDecodeTiny535 codec = new EncodeAndDecodeTiny535();
		String longUrl = "https://www.dailymail.co.uk/femail/article-6352045/Can-spot-20-coat-Asda-supermarket-steals-chuck-trolley-week.html";
		String shortUrl = codec.encode(longUrl);
		System.out.println(shortUrl);
		System.out.println(codec.decode(shortUrl));
	}

	private static final String TINY_DOMAIN = "http://tinyurl.com/";

	private static final int TINY_DOMAIN_LEN = 19;

	private Map<String, String> codeDB;

	private Map<String, String> longUrls;

	private int codeLength;

	public EncodeAndDecodeTiny535() {
		this.codeDB = new HashMap<>();
		this.longUrls = new HashMap<>();
		this.codeLength = 6;
	}

	public EncodeAndDecodeTiny535(int codeLength) {
		this.codeDB = new HashMap<>();
		this.longUrls = new HashMap<>();
		this.codeLength = codeLength;
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {

		if (longUrls.containsKey(longUrl)) {
			return TINY_DOMAIN + longUrls.get(longUrl);
		}
		String key = generateKey();
		longUrls.put(longUrl, key);
		codeDB.put(key, longUrl);

		return TINY_DOMAIN + key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		String code = shortUrl.substring(TINY_DOMAIN_LEN, TINY_DOMAIN_LEN + codeLength);
		return codeDB.get(code);
	}

	private String generateKey() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < codeLength; i++) {
			int index = rand.nextInt(26);
			sb.append((char) (index + 'a'));
		}
		String key = sb.toString();
		if (codeDB.containsKey(key)) {
			return generateKey();
		}
		return key;
	}
}
