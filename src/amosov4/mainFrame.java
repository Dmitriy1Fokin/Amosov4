package amosov4;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class mainFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	private JTabbedPane tabbedPane;
	private TabbedPaneSolutionsCriteria tabPaneSolutionsCriteria;
	
	public mainFrame()
	{
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Возможные решения и критерии", null, null);
		tabbedPane.addTab("Бинарные отношения", null, null);
		tabbedPane.addTab("Вывод", null, null);
		
		add(tabbedPane);
		pack();
		
		tabbedPane.addChangeListener(event ->
		{
			if(tabbedPane.getSelectedComponent() == null)
				LoadTab(tabbedPane.getSelectedIndex());
		});
		
		LoadTab(0);
		
		Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (screenSize.width - DEFAULT_WIDTH) / 2;
		int screenHeight = (screenSize.height - DEFAULT_HEIGHT) / 2;
		setBounds(screenWidth, screenHeight, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
	}
	
	private void LoadTab(int n)
	{
		switch (n) {
		case 0: 
			{
				if(tabPaneSolutionsCriteria == null)
				{
					tabPaneSolutionsCriteria = new TabbedPaneSolutionsCriteria();
					tabbedPane.setComponentAt(0, tabPaneSolutionsCriteria.getPanel());
				}
			}		
			break;
		case 1: 
			{
//				if(tabPaneAllDZ == null)
//				{
//					tabPaneAllDZ = new TabbedPaneAllDZ();
//					tabbedPane.setComponentAt(1, tabPaneAllDZ.getPanel());
//				}
			}
			break;
		case 2: 
			{
//				testDB();
//				//tabbedPane.setComponentAt(n, new JLabel("Soon 3"));
			}
			break;
		default:
			break;
		}
	}
	
	public void repaintFrame() 
	{
		this.repaint();
		this.revalidate();
		this.pack();
	}
	
	
	
}
