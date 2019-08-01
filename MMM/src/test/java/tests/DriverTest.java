package tests;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DriverTest {

	@Test
	public void test() throws Exception {

		ArrayList<String> a;
		String path = "C:\\Users\\HI\\Desktop\\MMM\\src\\test\\resources\\testdata\\data_xls.xls";
		Workbook w = Workbook.getWorkbook(new File(path));
		Sheet s = w.getSheet(0);
		int rows = s.getRows();
		int cols = s.getColumns();

		for (int i = 1; i < rows; i++) {
			a = new ArrayList<>();
			System.out.println("testcase :" + i);
			for (int j = 0; j < cols; j++) {
				a.add(s.getCell(j, i).getContents().trim());
			}
			for (String methodName : a) {
				DriverTest.executeMethod(methodName);
			}

		}

	}

	public static void executeMethod(String method) throws Exception {

		File folder = new File("C:\\Users\\HI\\Desktop\\MMM\\src\\main\\java\\components");
		File files[] = folder.listFiles();
		for (File f : files) {
			String classname = f.getName().replaceAll(".java", "");
			// System.out.println(classname);
			Class<?> c = Class.forName("components." + classname);
			Object obj = c.newInstance();
			Method methods[] = c.getDeclaredMethods();
			for (Method m : methods) {
				if (method.equals(m.getName().trim())) {
					m.invoke(obj);
				}

			}
		}

	}

}
