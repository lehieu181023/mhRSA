
package mahoarsa;

import javax.swing.UIManager;

import View.MenuExampleView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MenuExampleView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
}