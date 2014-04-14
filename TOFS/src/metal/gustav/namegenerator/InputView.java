package metal.gustav.namegenerator;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class InputView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	String[] genrelist = {"All genres",
			"Evil Metal",
			"Thrash Metal",
			"Rock N Roll"};
	
	JMenuBar menuBar;
	JMenu menu, submenu;
	JRadioButtonMenuItem testModeOff, testModeOn, testModeExtra;
	
	JComboBox cb1 = new JComboBox(genrelist);
	JButton close = new JButton("Close");
	JButton generate = new JButton("Generate!");
	JTextField input = new JTextField();
	
	public InputView() {
		menuBar = new JMenuBar();
		menu = new JMenu("Advanced options");
		menuBar.add(menu);
		submenu = new JMenu("Test mode");
		menu.add(submenu);
		testModeOff = new JRadioButtonMenuItem("Off", true);
		submenu.add(testModeOff);
		testModeOn = new JRadioButtonMenuItem("On");
		submenu.add(testModeOn);
		testModeExtra = new JRadioButtonMenuItem("Only selected sentences");
		submenu.add(testModeExtra);
		ButtonGroup group = new ButtonGroup();
	    group.add(testModeOff);
	    group.add(testModeOn);
	    group.add(testModeExtra);
		
		setJMenuBar(menuBar);
		
		setLayout(new GridLayout(3,2));
		add(new JLabel("Choose genre:"));
		add(cb1);
		add(new JLabel("Number of titles:"));
		add(input);
		add(close);
		add(generate);
		
		generate.addActionListener(this);
		close.addActionListener(this);
		input.addActionListener(this);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		input.requestFocusInWindow();
		
		// Get the size of the screen
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    // Determine the new location of the window
	    int w = getSize().width;
	    int h = getSize().height;
	    int x = (dim.width-w)/2;
	    int y = (dim.height-h)/2;
	    
	    // Move the window
	    setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generate) {
			generate();
		} else if (e.getSource() == input) {
			generate();
		} else if (e.getSource() == close) {
			System.exit(0);
		}
	}
	
	private void generate() {
		int testMode = 0;
		
		if (testModeOn.isSelected())
			testMode = 1;
		else if (testModeExtra.isSelected())
			testMode = 2;
		
		try {
			TOFSNameGen.generate(cb1.getSelectedIndex(), Integer.parseInt(input.getText()), testMode);
		} catch (NumberFormatException e1) {
			System.out.println("Incorrect input!");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
