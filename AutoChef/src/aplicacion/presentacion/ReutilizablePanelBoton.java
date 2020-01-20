package aplicacion.presentacion;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class ReutilizablePanelBoton extends JPanel {
    JLabel lblNewLabel;
    private boolean regresar = false;
    /**
     * Create the panel.
     */
    private Color color;
    
    public ReutilizablePanelBoton(String texto) {
        setForeground(Color.WHITE);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 22, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        lblNewLabel = new JLabel(texto);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setForeground(Color.BLACK);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        add(lblNewLabel, gbc_lblNewLabel);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                color = getBackground();
                setBackground(new Color(250,250,190));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
            }
        });
    }
    public String getLabel()
    {
        return this.lblNewLabel.getText();
    }
    
    public boolean getRegresar()
    {
        return this.regresar;
    }
    
    public void setRegresar(boolean value)
    {
        this.regresar = value;
    }
}
