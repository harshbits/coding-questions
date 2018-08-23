import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

//	21.AUG.2018
	
	
	
	public static void main(String[] args) {
		
		System.out.println(new DateTest().getTodayDate());


	}
	
	private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd.MMM.yyyy");

	private static final ThreadLocal<SimpleDateFormat> formatterDate = new ThreadLocal<>() {
        @Override
        protected SimpleDateFormat initialValue()
        {
            return sdfDateTime;
        }
    };
	
	public String getTodayDate() {
		return formatterDate.get().format(new Date());
	}
	
}

