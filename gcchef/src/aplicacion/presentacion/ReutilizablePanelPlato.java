package aplicacion.presentacion;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import aplicacion.dominio.Plato;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class ReutilizablePanelPlato extends JPanel {
    
    private Color color;
    private boolean selected = false;
    private Plato local;
    /**
     * Create the panel.
     */
    public ReutilizablePanelPlato(Plato plato) {
        setBackground(Color.WHITE);
        local = plato;
        if(plato != null)setBackground(Color.WHITE);
        if(plato != null)setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{20, 0, 50, 0, 50, 0};
        gridBagLayout.rowHeights = new int[]{5, 0, 5, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel_1 = new JLabel("");
        if(plato != null) 
        {
            switch(plato.getTipo())
            {
                case PESCADO:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/pescado.png")));
                break;
                case ARROZ:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/arroz.png")));
                    break;
                case CARNE:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/carne.png")));
                    break;
                case PASTA:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/pasta.png")));
                    break;
                case REPOSTERIA:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/postre.png")));
                    break;
                case ENSALADA:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/ensalada.png")));
                    break;
                case VERDURAS:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/verduras.png")));
                    break;
                case LEGUMBRES:
                    lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/legumbres.png")));
                    break;
            }
            
        }
        
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        if(plato != null) lblNewLabel.setText(plato.getNombre());
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 3;
        gbc_lblNewLabel.gridy = 1;
        add(lblNewLabel, gbc_lblNewLabel);

        if(plato != null)addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                color = getBackground();
                setBackground(new Color(250,250,190));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(!selected)setBackground(color);
            }
            
            public void mouseClicked(MouseEvent e)
            {
                for(int i = 0; i < getParent().getComponentCount(); i++)
                {
                    getParent().getComponent(i).setBackground(new Color(255,255,255));
                    ((ReutilizablePanelPlato) getParent().getComponent(i)).setSelected(false);
                }
                setBackground(new Color(252, 255, 70));
                selected = true;
                ((PanelSeleccionPlato) getParent().getParent().getParent().getParent()).setSelected(local);
                ((PanelSeleccionPlato) getParent().getParent().getParent().getParent()).actualizarInfo();
            }   
        });
    }
    
    public void setSelected(boolean value)
    {
        this.selected = value;
    }
    
    public Plato getPlato()
    {
        return this.local;
    }

}
