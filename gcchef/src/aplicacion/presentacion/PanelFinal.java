package aplicacion.presentacion;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PanelFinal extends JPanel {
    
    public boolean retornar = false;
    /**
     * Create the panel.
     */
    public PanelFinal() {
        setBackground(new Color(102, 204, 255));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{100, 0, 250, 0, 100, 0};
        gridBagLayout.rowHeights = new int[]{100, 0, 100, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JTextArea txtrSeHaCompletado = new JTextArea();
        txtrSeHaCompletado.setBackground(new Color(102, 204, 255));
        txtrSeHaCompletado.setEditable(false);
        txtrSeHaCompletado.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtrSeHaCompletado.setLineWrap(true);
        txtrSeHaCompletado.setText("Se ha completado correctamente los pasos de la receta. \r\n\u00BFDeseas realizar algun otro plato?");
        GridBagConstraints gbc_txtrSeHaCompletado = new GridBagConstraints();
        gbc_txtrSeHaCompletado.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtrSeHaCompletado.gridwidth = 3;
        gbc_txtrSeHaCompletado.insets = new Insets(0, 0, 5, 5);
        gbc_txtrSeHaCompletado.gridx = 1;
        gbc_txtrSeHaCompletado.gridy = 1;
        add(txtrSeHaCompletado, gbc_txtrSeHaCompletado);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        lblNewLabel_1.setIcon(new ImageIcon(PanelFinal.class.getResource("/aplicacion/presentacion/resources/cancelar.png")));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                retornar = true;
            }
        });
        lblNewLabel_2.setIcon(new ImageIcon(PanelFinal.class.getResource("/aplicacion/presentacion/resources/confirmar.png")));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 3;
        gbc_lblNewLabel_2.gridy = 2;
        add(lblNewLabel_2, gbc_lblNewLabel_2);

    }

    public boolean getRetornar()
    {
        return this.retornar;
    }
}
