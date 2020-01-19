package aplicacion.presentacion;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import aplicacion.dominio.Plato;

@SuppressWarnings("serial")
public class PanelSeleccionPlato extends JPanel {
    private String selected = "";
    private JPanel panel;
    /**
     * Create the panel.
     */
    public PanelSeleccionPlato(ArrayList<Plato> platos) {
        setBackground(new Color(102, 204, 255));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{60, 280, 80, 0, 60, 0};
        gridBagLayout.rowHeights = new int[]{60, 0, 220, 50, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblSeleccionaUnPlato = new JLabel("Selecciona un plato");
        lblSeleccionaUnPlato.setFont(new Font("Tahoma", Font.BOLD, 17));
        GridBagConstraints gbc_lblSeleccionaUnPlato = new GridBagConstraints();
        gbc_lblSeleccionaUnPlato.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionaUnPlato.gridx = 3;
        gbc_lblSeleccionaUnPlato.gridy = 1;
        add(lblSeleccionaUnPlato, gbc_lblSeleccionaUnPlato);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setEnabled(false);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 2;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 1;
        add(scrollPane, gbc_scrollPane);
        
        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(PanelSeleccionPlato.class.getResource("/aplicacion/presentacion/resources/plato_icono.png")));
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 3;
        gbc_label.gridy = 2;
        add(label, gbc_label);
    }

    public void generarPlatos(ArrayList<Plato> platos)
    {
        if(platos != null)
        for(int i = 0; i < platos.size(); i++)
        {
            panel.add(new ReutilizablePanelPlato(platos.get(i)));
        }
        
        for(int i = 0; i < 4; i++)
        {
            panel.add(new ReutilizablePanelPlato(null));
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
