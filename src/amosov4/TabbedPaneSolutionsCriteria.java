package amosov4;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;




public class TabbedPaneSolutionsCriteria
{
	private JPanel panelGeneral;
	private JPanel panelSolutions;
	private JPanel panelCriteria;
	private JPanel panelLabelSolutions;
	private ArrayList<String> arrSolutions;
	private ArrayList<JCheckBox> arrCheckToDelete;
	
	public TabbedPaneSolutionsCriteria()
	{
		arrSolutions = new ArrayList<>();
		arrSolutions.add("Kia Rio");
		arrSolutions.add("Renault Logan");
		arrSolutions.add("Hyundai Solaris");
		
		arrCheckToDelete = new ArrayList<>();
		
		panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridBagLayout());
		
		Border etched = BorderFactory.createEtchedBorder();
		
		
		panelSolutions = new JPanel(new GridBagLayout());
		panelSolutions.setBorder(BorderFactory.createTitledBorder(etched, "Возможные решения"));
		JTextArea textAreaSolut = new JTextArea(1, 20);
		JButton buttonSolutAdd = new JButton("add");
		buttonSolutAdd.addActionListener(event ->
		{
			if(textAreaSolut.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Empty. Please, enter solution", "Error", 0);
			else
			{
				arrSolutions.add(textAreaSolut.getText());
				panelLabelSolutions.removeAll();
				CreateArraySolutions();
				//panelGeneral.repaint();
				
			}
		});
		panelLabelSolutions = new JPanel(new GridBagLayout());
		panelLabelSolutions.setBorder(BorderFactory.createEtchedBorder());
		CreateArraySolutions();
		JButton buttonDeleteSolut = new JButton("Delete");
		buttonDeleteSolut.addActionListener(event ->
		{
			ArrayList<String> str = new ArrayList<>();
			for(int i = 0; i < arrCheckToDelete.size(); i++)
				if(arrCheckToDelete.get(i).isSelected())
					str.add(arrSolutions.get(i));
			arrSolutions.removeAll(str);
			CreateArraySolutions();
		});
		panelSolutions.add(textAreaSolut, new GBC(0,0).setAnchor(GBC.WEST).setInsets(10));
		panelSolutions.add(buttonSolutAdd, new GBC(1,0).setAnchor(GBC.EAST).setInsets(10));
		panelSolutions.add(new JScrollPane(panelLabelSolutions), new GBC(0,1, 2, 1).setAnchor(GBC.CENTER).setInsets(10));
		panelSolutions.add(buttonDeleteSolut, new GBC(1,2).setAnchor(GBC.EAST).setInsets(10));
		
		
		panelCriteria = new JPanel(new GridBagLayout());
		panelCriteria.setBorder(BorderFactory.createTitledBorder(etched, "Возможные решения"));
		
		panelGeneral.add(panelSolutions, new GBC(0,0).setAnchor(GBC.WEST));
		panelGeneral.add(panelCriteria, new GBC(1,0).setAnchor(GBC.WEST));

	}
	
	public JPanel getPanel()
	{
		return panelGeneral;
	}
	
	private void CreateArraySolutions()
	{
		arrCheckToDelete.clear();
		for(int i = 0; i < arrSolutions.size(); i++)
		{
			arrCheckToDelete.add(new JCheckBox());
			panelLabelSolutions.add(arrCheckToDelete.get(i), new GBC(0, i).setAnchor(GBC.WEST).setInsets(2));
			panelLabelSolutions.add(new JLabel(arrSolutions.get(i)), new GBC(1, i).setAnchor(GBC.WEST).setInsets(2));
		}
	}
	
}
