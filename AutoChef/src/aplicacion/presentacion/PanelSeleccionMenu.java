package aplicacion.presentacion;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import aplicacion.dominio.Ingrediente;
import aplicacion.dominio.Menu;
import aplicacion.dominio.Plato;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelSeleccionMenu extends JPanel {
    private JLabel label_nombre;
    private JLabel label_autor;
    private JLabel label_nplatos;
    private JLabel label_comensales;
    private JTextArea textArea;
    private Menu selected;
    /**
     * Create the panel.
     */
    public PanelSeleccionMenu(ArrayList<Menu> menus) {
        setBackground(new Color(102, 204, 255));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{80, 0, 200, 30, 280, 70, 0};
        gridBagLayout.rowHeights = new int[]{40, 0, 20, 0, 0, 0, 0, 0, 120, 40, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel_1 = new JLabel("Selecciona un menu de la lista");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.gridwidth = 2;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 8;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 4;
        gbc_scrollPane.gridy = 1;
        add(scrollPane, gbc_scrollPane);
        
        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 3;
        add(lblNewLabel, gbc_lblNewLabel);
        
        label_nombre = new JLabel("");
        label_nombre.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_nombre = new GridBagConstraints();
        gbc_label_nombre.anchor = GridBagConstraints.EAST;
        gbc_label_nombre.insets = new Insets(0, 0, 5, 5);
        gbc_label_nombre.gridx = 2;
        gbc_label_nombre.gridy = 3;
        add(label_nombre, gbc_label_nombre);
        
        JLabel lblNewLabel_2 = new JLabel("Autor:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 4;
        add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        label_autor = new JLabel("");
        label_autor.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_autor = new GridBagConstraints();
        gbc_label_autor.anchor = GridBagConstraints.EAST;
        gbc_label_autor.insets = new Insets(0, 0, 5, 5);
        gbc_label_autor.gridx = 2;
        gbc_label_autor.gridy = 4;
        add(label_autor, gbc_label_autor);
        
        JLabel lblNewLabel_3 = new JLabel("N\u00BA de platos:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 5;
        add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        label_nplatos = new JLabel("");
        label_nplatos.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_nplatos = new GridBagConstraints();
        gbc_label_nplatos.anchor = GridBagConstraints.EAST;
        gbc_label_nplatos.insets = new Insets(0, 0, 5, 5);
        gbc_label_nplatos.gridx = 2;
        gbc_label_nplatos.gridy = 5;
        add(label_nplatos, gbc_label_nplatos);
        
        JLabel lblTotalComensales = new JLabel("Total Comensales:");
        lblTotalComensales.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblTotalComensales = new GridBagConstraints();
        gbc_lblTotalComensales.anchor = GridBagConstraints.WEST;
        gbc_lblTotalComensales.insets = new Insets(0, 0, 5, 5);
        gbc_lblTotalComensales.gridx = 1;
        gbc_lblTotalComensales.gridy = 6;
        add(lblTotalComensales, gbc_lblTotalComensales);
        
        label_comensales = new JLabel("");
        label_comensales.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_comensales = new GridBagConstraints();
        gbc_label_comensales.anchor = GridBagConstraints.EAST;
        gbc_label_comensales.insets = new Insets(0, 0, 5, 5);
        gbc_label_comensales.gridx = 2;
        gbc_label_comensales.gridy = 6;
        add(label_comensales, gbc_label_comensales);
        
        JLabel lblIngredientes = new JLabel("Ingredientes Totales:");
        lblIngredientes.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblIngredientes = new GridBagConstraints();
        gbc_lblIngredientes.gridwidth = 2;
        gbc_lblIngredientes.anchor = GridBagConstraints.WEST;
        gbc_lblIngredientes.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngredientes.gridx = 1;
        gbc_lblIngredientes.gridy = 7;
        add(lblIngredientes, gbc_lblIngredientes);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
        textArea.setBackground(new Color(102, 204, 255));
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.anchor = GridBagConstraints.EAST;
        gbc_textArea.gridwidth = 2;
        gbc_textArea.insets = new Insets(0, 0, 5, 5);
        gbc_textArea.fill = GridBagConstraints.VERTICAL;
        gbc_textArea.gridx = 1;
        gbc_textArea.gridy = 8;
        add(textArea, gbc_textArea);
        
        for(int i = 0; i < menus.size(); i++)
        {
            panel.add(new ReutilizablePanelMenu(menus.get(i)));
        }
        
        for(int i = 0; i < 4; i++)
        {
            panel.add(new ReutilizablePanelMenu(null));
        }
    }
    
    public void setSelected(Menu value)
    {
        this.selected = value;
    }
    
    public Menu getSelected()
    {
        return this.selected;
    }
    
    public void actualizarInfo()
    {
        String ingred = "";
        
        int comensales = 0;
        
        label_nombre.setText(selected.getNombre());
        label_autor.setText(selected.getNickname());
        
        for (Plato plato : selected.getPlatos())
        {
            comensales += plato.getComensales();
        }
        label_comensales.setText(Integer.toString(comensales));
        label_nplatos.setText(Integer.toString(selected.getPlatos().size()));
        
        for(Ingrediente ingrediente : selected.getIngredientesGlobales())
        {
            ingred += "- "+ Double.toString(ingrediente.getCantidad()) +" "+ ingrediente.getMedida() +" "+ ingrediente.getNombre()+"\n";
        }
        
        textArea.setText(ingred);
    }
}
