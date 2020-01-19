package aplicacion.presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

import aplicacion.dominio.Paso;

@SuppressWarnings("serial")
public class PanelPasoIntroducir extends JPanel {
    private JTextPane txtpnIntroducirElIngrediente;
    /**
     * Create the panel.
     */
    public PanelPasoIntroducir(String texto) {
        setBackground(new Color(102, 204, 255));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{80, 0, 100, 300, 0, 0};
        gridBagLayout.rowHeights = new int[]{50, 0, 0, 50, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(PanelPasoIntroducir.class.getResource("/aplicacion/presentacion/resources/comida-y-restaurante.png")));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.gridheight = 2;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        txtpnIntroducirElIngrediente = new JTextPane();
        txtpnIntroducirElIngrediente.setBackground(new Color(102, 204, 255));
        txtpnIntroducirElIngrediente.setEditable(false);
        txtpnIntroducirElIngrediente.setFont(new Font("Tahoma", Font.BOLD, 25));
        txtpnIntroducirElIngrediente.setText("Introducir "+texto+" en el recipiente de la maquina.");
        GridBagConstraints gbc_txtpnIntroducirElIngrediente = new GridBagConstraints();
        gbc_txtpnIntroducirElIngrediente.gridheight = 2;
        gbc_txtpnIntroducirElIngrediente.insets = new Insets(0, 0, 5, 5);
        gbc_txtpnIntroducirElIngrediente.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtpnIntroducirElIngrediente.gridx = 3;
        gbc_txtpnIntroducirElIngrediente.gridy = 1;
        add(txtpnIntroducirElIngrediente, gbc_txtpnIntroducirElIngrediente);

    }

    public void actualizarPaso(Paso paso)
    {
        txtpnIntroducirElIngrediente.setText(paso.getDescripcion());
    }
}
