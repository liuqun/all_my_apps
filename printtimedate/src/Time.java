import java.util.Date;

public class Time {
	/**
	 * My Time app
	 * @param args
	 */
	public static void main(String[] args){
		Date date = new Date();
		String ss;
		
		ss = date.toString();
		System.out.print("Time: ");
		System.out.print(ss);
		System.out.print("\n");

	}
}
