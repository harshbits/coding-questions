import java.awt.Rectangle;
import java.lang.reflect.Field;

public class ReflTest {

	public static void main(String[] args) {

		Rectangle r = new Rectangle(100, 325);
		String value = getAttributeValueByField(r, "height");
		System.out.println(value);
	}

	private static String getAttributeValueByField(Object object, String key) {
		try {
			Field field = object.getClass().getField(key);
			String value = field.get(object).toString();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
