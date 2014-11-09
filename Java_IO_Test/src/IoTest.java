import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IoTest {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args){
		System.out.print("Hello my friend!\n");
		// ...
		System.out.print("Good-bye!\n");
	}
	/**
	 *
	 */
	public static File getFileObjFromPathName(String dirPath, String fileName) {
		File file = null;
		// TODO Do not forget to check dirPath before using it
		if (null==fileName || fileName.isEmpty()) {
			file = null;
			return (file);
		}
		file = new File(dirPath, fileName);
		return (file);
	}
	/**
	 *
	 */
	public static String readDataFromFile(File file) {
		String s;

		s = "";
		if (null==file
		 || !file.exists()
		 || !file.isFile()  // File对象实际可能为一个目录
		 || file.length() <= 0) {
			s = "";
			return (s);
		}

		FileReader r;
		try {
			r = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s = "";
			return (s);
		}
		s = "";
		char[] buf = new char[20];
		int nRead = 0;
		while (true) {
			try {
				nRead = r.read(buf, 0, buf.length);
				if (nRead <= 0) {
					break;
				}
				s += new String(buf, 0, (int)nRead);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (s);
	}
}
