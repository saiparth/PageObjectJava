package POM.Automation;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliDemo {

	public static void main(String[] args) throws FindFailed {
		Screen sc = new Screen();
		Pattern pc = new Pattern("E:\\sikulirepo\\notepadclick.PNG");
		sc.click(pc);
	}

}
