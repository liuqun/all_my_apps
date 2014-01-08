import java.util.Date;
import java.text.SimpleDateFormat;

public class Time {
	/**
	 * My Time app
	 * @param args
	 */
	public static void main(String[] args){
		String text;
		Date date = new Date();
		SimpleDateFormat tool = new SimpleDateFormat();
		
		tool.applyPattern("yyyy-MM-dd HH:mm:ss");
		text = tool.format(date);
		System.out.println(text);
	}
}
