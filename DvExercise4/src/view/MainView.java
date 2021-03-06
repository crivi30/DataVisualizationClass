package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class MainView {
	
	public ChartPanel chartPanel;
    public JFrame f;
    public JButton zoomIn;
    public JButton zoomOut;
    public JButton zoom;
    public JButton dateSelect;
    public JFreeChart pieChart;
    public JComboBox start;
    public JComboBox end;
    public JLabel errorLabel;
    public JLabel startLabel;
    public JLabel endLabel;
    public JPanel zoomPanel;
    public JPanel dateSelectPanel;
    public JComboBox chartList;
    public JButton viewSelect;
    public JButton regionSelect;
    public JPanel menuPanel;
    public ArrayList<JCheckBox> boxes;
    public ArrayList<String> currentRegSelection;
    public String[] charts = {"Line Chart", "Bar Chart", "Pie Chart", "Heat map"};

    /**
     *  A Constructor for objects of class View. Initializes 
     *  GUI components.
     */
    public MainView(){
    	
        // zoom buttons:
        zoomIn = new JButton("Zoom in");
        zoomOut = new JButton("Zoom out");
        zoom = new JButton("Reset zoom");

        // date selection buttons:
        String[] s = new String[29];
        for(int i = 1980; i < 2009; i++){
            s[i-1980] = Integer.toString(i);
        }
        
        dateSelect = new JButton("Select");
        start = new JComboBox(s);
        end = new JComboBox(s);
        startLabel = new JLabel("Start year: ");
        endLabel = new JLabel("End year: ");
        errorLabel = new JLabel();;
        dateSelectPanel = new JPanel();
        dateSelectPanel.add(startLabel);
        dateSelectPanel.add(start);
        dateSelectPanel.add(endLabel);
        dateSelectPanel.add(end);
        dateSelectPanel.add(dateSelect);
        dateSelectPanel.add(errorLabel);

        // country select menu:
        String[] regions = new String[] { 
        		"China",
        		"Africa",
        		"India",
        		"North America",
        		"Central & South America",
        		"Europe",
        		"United States",
                "All"};
        
        boxes = new ArrayList();
        regionSelect = new JButton("   Select regions:   ");
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(190,400));
        menuPanel.add(regionSelect);
        for(String r : regions){
            JCheckBox cb = new JCheckBox(r);
            boxes.add(cb);
            menuPanel.add(cb);
        }

        // build lower panel:
        zoomPanel = new JPanel();
        zoomPanel.add(zoomOut);
        zoomPanel.add(zoomIn);
        zoomPanel.add(zoom);

        //chart view select:
        chartList = new JComboBox(charts);
        viewSelect = new JButton("Select view");
        zoomPanel.add(chartList);
        zoomPanel.add(viewSelect);

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout(0,5));
        f.add(menuPanel, BorderLayout.EAST);
        f.add(dateSelectPanel, BorderLayout.NORTH);
        f.add(zoomPanel,  BorderLayout.SOUTH);
    }
    
}
