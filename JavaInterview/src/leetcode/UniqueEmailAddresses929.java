package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Every email consists of a local name and a domain name, separated by the @
 * sign.
 * 
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com
 * is the domain name.
 * 
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * 
 * If you add periods ('.') between some characters in the local name part of an
 * email address, mail sent there will be forwarded to the same address without
 * dots in the local name. For example, "alice.z@leetcode.com" and
 * "alicez@leetcode.com" forward to the same email address. (Note that this rule
 * does not apply for domain names.)
 * 
 * If you add a plus ('+') in the local name, everything after the first plus
 * sign will be ignored. This allows certain emails to be filtered, for example
 * m.y+name@email.com will be forwarded to my@email.com. (Again, this rule does
 * not apply for domain names.)
 * 
 * It is possible to use both of these rules at the same time.
 * 
 * Given a list of emails, we send one email to each address in the list. How
 * many different addresses actually receive mails?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2 Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com"
 * actually receive mails
 * 
 * 
 * Note:
 * 
 * 1 <= emails[i].length <= 100 1 <= emails.length <= 100 Each emails[i]
 * contains exactly one '@' character.
 * 
 * 
 * @author habhavsar
 *
 *
 *         Beats 99.37%
 * 
 */
public class UniqueEmailAddresses929 {

	public static void main(String[] args) {

		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		
		var ans = new UniqueEmailAddresses929().numUniqueEmails(emails);
		System.out.println(ans);
		
	}

	public int numUniqueEmails(String[] emails) {

		Set<String> uniqueEmails = new HashSet<>();

		for (String email : emails) {
//			String[] parts = email.split("@");
//			// String e = parts[0].replaceAll(".");
//			int index = parts[0].indexOf("+");
//			String e = parts[0].substring(0, index).replaceAll(".", "");
//			uniqueEmails.add(e + parts[1]);
			
			uniqueEmails.add(getActualAddress(email));
		}
		return uniqueEmails.size();
	}
	
	private String getActualAddress(String email) {
		StringBuilder sb = new StringBuilder();
		boolean plusFound = false;
		char[] sc = email.toCharArray();
		for(int i=0; i< sc.length; i++) {
			char c = sc[i];
			
			// ignore the rest of the check and add domain to the string builder.
			if (plusFound) {
				if (c == '@') {
					sb.append(Arrays.copyOfRange(sc, i, sc.length));
					break;
				}
			}else {
				if (c == '@') {
					sb.append(Arrays.copyOfRange(sc, i, sc.length));
					break;
				}
				else if (c == '+') {
					plusFound = true;
				}
				else if (c == '.') {
					continue;
				}else {
					sb.append(c);
				}
			}
		}
		return sb.toString();

	}
}
