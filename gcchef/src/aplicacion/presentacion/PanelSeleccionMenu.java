package aplicacion.presentacion;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import aplicacion.dominio.Menu;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PanelSeleccionMenu extends JPanel {
    
    private String selected = "";
    /**
     * Create the panel.
     */
    public PanelSeleccionMenu(ArrayList<Menu> menus) {
        setBackground(new Color(102, 204, 255));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{60, 200, 50, 280, 60, 0};
        gridBagLayout.rowHeights = new int[]{60, 0, 220, 50, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel_1 = new JLabel("Selecciona un menu de la lista");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(PanelSeleccionMenu.class.getResource("/aplicacion/presentacion/resources/menu.png")));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 2;
        add(lblNewLabel, gbc_lblNewLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 2;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 3;
        gbc_scrollPane.gridy = 1;
        add(scrollPane, gbc_scrollPane);
        
        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        for(int i = 0; i < menus.size(); i++)
        {
            panel.add(new ReutilizablePanelMenu(menus.get(i).getNombre()));
        }
        
        for(int i = 0; i < 4; i++)
        {
            panel.add(new ReutilizablePanelMenu(""));
        }
    }
    
    public void setSelected(String value)
    {
        this.selected = value;
    }
    
    public String getSelected()
    {
        return this.selected;
    }

}
