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

import aplicacion.dominio.Menu;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class ReutilizablePanelMenu extends JPanel {
    
    private Color color;
    private JLabel label_nombre_menu;
    private boolean selected = false;
    private Menu local;
    /**
     * Create the panel.
     */
    public ReutilizablePanelMenu(Menu menu) {
        setBackground(Color.WHITE);
        local = menu;
        if(local == null)setBackground(Color.WHITE);
        if(local != null)setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{20, 0, 50, 0, 50, 0};
        gridBagLayout.rowHeights = new int[]{5, 0, 5, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel_1 = new JLabel("");
        if(local != null) lblNewLabel_1.setIcon(new ImageIcon(ReutilizablePanelMenu.class.getResource("/aplicacion/presentacion/resources/menu_peque.png")));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        label_nombre_menu = new JLabel(menu == null ? "" : local.getNombre());
        label_nombre_menu.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_label_nombre_menu = new GridBagConstraints();
        gbc_label_nombre_menu.insets = new Insets(0, 0, 5, 5);
        gbc_label_nombre_menu.gridx = 3;
        gbc_label_nombre_menu.gridy = 1;
        add(label_nombre_menu, gbc_label_nombre_menu);

        if(local != null)addMouseListener(new MouseAdapter() {
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
                    ((ReutilizablePanelMenu) getParent().getComponent(i)).setSelected(false);
                }
                setBackground(new Color(252, 255, 70));
                selected = true;
                ((PanelSeleccionMenu) getParent().getParent().getParent().getParent()).setSelected(getMenu());
                ((PanelSeleccionMenu) getParent().getParent().getParent().getParent()).actualizarInfo();
            }   
        });
    }
    
    public void setSelected(boolean x)
    {
        this.selected = x;
    }
    
    public Menu getMenu()
    {
        return this.local;
    }
}
