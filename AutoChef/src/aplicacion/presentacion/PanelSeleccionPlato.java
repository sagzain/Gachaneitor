package aplicacion.presentacion;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
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

import aplicacion.dominio.Ingrediente;
import aplicacion.dominio.Plato;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelSeleccionPlato extends JPanel {
    private Plato selected;
    private JPanel panel;
    
    private JLabel label_nombre;
    private JLabel label_tipo;
    private JLabel label_comensales;
    private JLabel label_tCocinado;
    private JLabel label_tPreparacion;
    private JLabel label_tTotal;
    private JTextArea label_ingredientes;
    
    /**
     * Create the panel.
     */
    public PanelSeleccionPlato(ArrayList<Plato> platos) {
        setBackground(new Color(102, 204, 255));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{40, 280, 60, 0, 100, 40, 0};
        gridBagLayout.rowHeights = new int[]{40, 0, 15, 0, 0, 0, 0, 0, 0, 0, 90, 50, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblSeleccionaUnPlato = new JLabel("Selecciona un plato");
        lblSeleccionaUnPlato.setFont(new Font("Tahoma", Font.BOLD, 17));
        GridBagConstraints gbc_lblSeleccionaUnPlato = new GridBagConstraints();
        gbc_lblSeleccionaUnPlato.gridwidth = 2;
        gbc_lblSeleccionaUnPlato.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionaUnPlato.gridx = 3;
        gbc_lblSeleccionaUnPlato.gridy = 1;
        add(lblSeleccionaUnPlato, gbc_lblSeleccionaUnPlato);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setEnabled(false);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 10;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 1;
        add(scrollPane, gbc_scrollPane);
        
        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 3;
        gbc_lblNewLabel.gridy = 3;
        add(lblNewLabel, gbc_lblNewLabel);
        
        label_nombre = new JLabel("");
        label_nombre.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_nombre = new GridBagConstraints();
        gbc_label_nombre.anchor = GridBagConstraints.EAST;
        gbc_label_nombre.insets = new Insets(0, 0, 5, 5);
        gbc_label_nombre.gridx = 4;
        gbc_label_nombre.gridy = 3;
        add(label_nombre, gbc_label_nombre);
        
        JLabel lblNewLabel_1 = new JLabel("Tipo:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 3;
        gbc_lblNewLabel_1.gridy = 4;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        label_tipo = new JLabel("");
        label_tipo.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_tipo = new GridBagConstraints();
        gbc_label_tipo.anchor = GridBagConstraints.EAST;
        gbc_label_tipo.insets = new Insets(0, 0, 5, 5);
        gbc_label_tipo.gridx = 4;
        gbc_label_tipo.gridy = 4;
        add(label_tipo, gbc_label_tipo);
        
        JLabel lblNewLabel_2 = new JLabel("Comensales:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 3;
        gbc_lblNewLabel_2.gridy = 5;
        add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        label_comensales = new JLabel("");
        label_comensales.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_comensales = new GridBagConstraints();
        gbc_label_comensales.anchor = GridBagConstraints.EAST;
        gbc_label_comensales.insets = new Insets(0, 0, 5, 5);
        gbc_label_comensales.gridx = 4;
        gbc_label_comensales.gridy = 5;
        add(label_comensales, gbc_label_comensales);
        
        JLabel lblNewLabel_3 = new JLabel("Tiempo de Cocinado:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 3;
        gbc_lblNewLabel_3.gridy = 6;
        add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        label_tCocinado = new JLabel("");
        label_tCocinado.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_tCocinado = new GridBagConstraints();
        gbc_label_tCocinado.anchor = GridBagConstraints.EAST;
        gbc_label_tCocinado.insets = new Insets(0, 0, 5, 5);
        gbc_label_tCocinado.gridx = 4;
        gbc_label_tCocinado.gridy = 6;
        add(label_tCocinado, gbc_label_tCocinado);
        
        JLabel lblNewLabel_4 = new JLabel("Tiempo de Preparacion:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 3;
        gbc_lblNewLabel_4.gridy = 7;
        add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        label_tPreparacion = new JLabel("");
        label_tPreparacion.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_tPreparacion = new GridBagConstraints();
        gbc_label_tPreparacion.anchor = GridBagConstraints.EAST;
        gbc_label_tPreparacion.insets = new Insets(0, 0, 5, 5);
        gbc_label_tPreparacion.gridx = 4;
        gbc_label_tPreparacion.gridy = 7;
        add(label_tPreparacion, gbc_label_tPreparacion);
        
        JLabel lblNewLabel_5 = new JLabel("Tiempo Total:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 3;
        gbc_lblNewLabel_5.gridy = 8;
        add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        label_tTotal = new JLabel("");
        label_tTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_label_tTotal = new GridBagConstraints();
        gbc_label_tTotal.anchor = GridBagConstraints.EAST;
        gbc_label_tTotal.insets = new Insets(0, 0, 5, 5);
        gbc_label_tTotal.gridx = 4;
        gbc_label_tTotal.gridy = 8;
        add(label_tTotal, gbc_label_tTotal);
        
        JLabel lblNewLabel_6 = new JLabel("Ingredientes:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 3;
        gbc_lblNewLabel_6.gridy = 9;
        add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        label_ingredientes = new JTextArea();
        label_ingredientes.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_ingredientes.setBackground(new Color(102, 204, 255));
        label_ingredientes.setLineWrap(true);
        GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
        gbc_textArea_1.anchor = GridBagConstraints.EAST;
        gbc_textArea_1.gridwidth = 2;
        gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
        gbc_textArea_1.fill = GridBagConstraints.VERTICAL;
        gbc_textArea_1.gridx = 3;
        gbc_textArea_1.gridy = 10;
        add(label_ingredientes, gbc_textArea_1);
    }

    public void actualizarPlatos(ArrayList<Plato> platos)
    {
        for(Component component : panel.getComponents())
        {
            panel.remove(component);
        }
        
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
    
    public void setSelected(Plato value)
    {
        this.selected = value;
    }
    
    public Plato getSelected()
    {
        return this.selected;
    }
    
    public void actualizarInfo()
    {
        String ingred = "";
        
        label_nombre.setText(selected.getNombre());
        label_tipo.setText(selected.getTipo().toString());
        label_comensales.setText(Integer.toString(selected.getComensales()));
        label_tPreparacion.setText(selected.getTiempos().getTPreparacion().toString()+" "+selected.getTiempos().getMPreparacion());
        label_tCocinado.setText(selected.getTiempos().getTCocinado().toString()+" "+selected.getTiempos().getMCocinado());
        label_tTotal.setText(selected.getTiempos().getTTotal().toString()+" "+selected.getTiempos().getMTotal());
        
        for(Ingrediente ingrediente : selected.getIngredientes())
        {
            ingred += "- "+ Double.toString(ingrediente.getCantidad()) + ingrediente.getMedida() + ingrediente.getNombre()+"\n";
        }

        label_ingredientes.setText(ingred);
    }
}
