package bliptracker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import bliptracker.controller.Controller;

/**
 * Top level Java Swing {@code JFrame} responsible for setting up and managing Swing 
 * subcomponents as a GUI view for the Bliptracker application.
 */
public class TrackerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final String APPLICATION_NAME = "Bliptracker";
	private final int COMPONENT_BORDER_SIZE = 10;
	private final int MAP_SIZE = 300;
	private final int OPTION_WIDTH = 200;
	private final int INFO_HEIGHT = 100;
	private final boolean APP_IS_RESIZABLE = false; 
	private final String ICON_PATH = "map.gif";
	private MapPanel mapPanel; 
	
	/**
	 * Creates an instance of a {@code TrackerFrame}. 
	 * @param controller The application controller.
	 */
	public TrackerFrame(Controller controller) {
		ImageIcon icon = new ImageIcon(ICON_PATH);
		this.setIconImage(icon.getImage());
	
		this.setTitle(APPLICATION_NAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(APP_IS_RESIZABLE);
		this.setLayout(new BorderLayout(COMPONENT_BORDER_SIZE, COMPONENT_BORDER_SIZE)); //Margins
		
		setUpPanels();		
		this.pack();
		this.setVisible(true);
		controller.connectAndSubscribe(mapPanel);
	}
	
	private void setUpPanels() {		
		this.mapPanel = new MapPanel(new Dimension(MAP_SIZE, MAP_SIZE));
		OptionPanel optionPanel = new OptionPanel(new Dimension(OPTION_WIDTH, MAP_SIZE), mapPanel);
		InfoPanel infoPanel = new InfoPanel(new Dimension(MAP_SIZE + OPTION_WIDTH, INFO_HEIGHT));
		this.add(mapPanel, BorderLayout.CENTER);
		this.add(optionPanel, BorderLayout.EAST);
		this.add(infoPanel, BorderLayout.SOUTH);
	}
}
