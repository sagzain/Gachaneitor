package aplicacion.presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.dominio.Menu;
import aplicacion.dominio.Paso;
import aplicacion.dominio.PasoMaquina;
import aplicacion.dominio.Plato;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.Container;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{

    public JFrame frame;
    private Container information_panel;
    private int index = 0;
    
    JPanel panel_inicio;
    JPanel panel_seleccionMenu;
    JPanel panel_seleccionPlato;
    JPanel panel_pasoIntroducir;
    JPanel panel_pasoSacar;
    JPanel panel_pasoMaquina;
    JPanel panel_error;
    JPanel panel_paso;
    JPanel panel_final;
    
    JPanel boton_siguiente;
    JPanel boton_anterior;
    
    private ArrayList<Menu> menus = new ArrayList<Menu>();
  
    /**
     * Create the application.
     */
    public VentanaPrincipal(ArrayList<Menu> menu) {
        initialize(menu);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(ArrayList<Menu> menu) {
        menus = menu;
        
        frame = new JFrame();
        frame.setBounds(100, 100, 720, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*The method setLocationRelativeTo(null) will center our window in the
          middle of our screen*/
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(102, 204, 255));
        panel_1.setBorder(null);
        panel.add(panel_1, BorderLayout.NORTH);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{20, 150, 0, 150, 20, 0};
        gbl_panel_1.rowHeights = new int[]{10, 40, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        boton_anterior = new ReutilizablePanelBoton("Anterior");
        boton_anterior.setVisible(false);
        GridBagConstraints gbc_boton_anterior = new GridBagConstraints();
        gbc_boton_anterior.insets = new Insets(0, 0, 0, 5);
        gbc_boton_anterior.fill = GridBagConstraints.BOTH;
        gbc_boton_anterior.gridx = 1;
        gbc_boton_anterior.gridy = 1;
        panel_1.add(boton_anterior, gbc_boton_anterior);
        
        boton_siguiente = new ReutilizablePanelBoton("Siguiente");
        GridBagConstraints gbc_boton_siguiente = new GridBagConstraints();
        gbc_boton_siguiente.insets = new Insets(0, 0, 0, 5);
        gbc_boton_siguiente.fill = GridBagConstraints.BOTH;
        gbc_boton_siguiente.gridx = 3;
        gbc_boton_siguiente.gridy = 1;
        panel_1.add(boton_siguiente, gbc_boton_siguiente);
        
        information_panel = new Container();
        panel.add(information_panel, BorderLayout.CENTER);
        information_panel.setLayout(new CardLayout(0,0));
        
        panel_inicio = new PanelInicio();
        information_panel.add(panel_inicio, "PanelInicio");
        
        panel_seleccionMenu = new PanelSeleccionMenu(menus);
        information_panel.add(panel_seleccionMenu, "PanelSeleccionMenu");
        
        panel_seleccionPlato = new PanelSeleccionPlato(null);
        information_panel.add(panel_seleccionPlato, "PanelSeleccionPlato");
        
        panel_pasoIntroducir = new PanelPasoIntroducir("");
        information_panel.add(panel_pasoIntroducir, "PanelPasoIntroducir");
        
        panel_pasoSacar = new PanelPasoSacar("");
        information_panel.add(panel_pasoSacar, "PanelPasoSacar");
        
        panel_pasoMaquina = new PanelPasoMaquina();
        information_panel.add(panel_pasoMaquina, "PanelPasoMaquina");
        
        panel_error = new PanelError();
        information_panel.add(panel_error, "PanelError");
        
        panel_paso = new PanelPaso();
        information_panel.add(panel_paso, "PanelPaso");
        
        panel_final = new PanelFinal();
        information_panel.add(panel_final,"PanelFinal");
        
        acoplar(boton_siguiente);
        acoplar(boton_anterior);
        
        
           
    }
    
    public void acoplar(JPanel p)
    {
        p.addMouseListener(new MouseAdapter() {  
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel)p.getComponent(0);
                
                for(Component component : information_panel.getComponents()) 
                {
                    if(component.isShowing())
                    {
                        cambioSeleccion(component.getClass().getName(), label.getText());
                        break;
                    }
                }
            }
        });
    }
    
    public void cambioSeleccion(String panel, String boton)
    {
        String [] partes = panel.split(Pattern.quote("."));
        String clase = partes[2];
        String mostrar_panel;
        
        if(boton.equals("Siguiente")) 
            mostrar_panel = cambioSiguiente(clase);
        else 
            mostrar_panel = cambioAnterior(clase);
        
        
        ((CardLayout) information_panel.getLayout()).show(information_panel, mostrar_panel);
    }
    
    public String cambioSiguiente(String panel)
    {
        String s = panel;
        
        
        switch(panel)
        {
            case "PanelInicio":
                boton_anterior.setVisible(true);
                s = "PanelSeleccionMenu";
            break;
            
            case "PanelSeleccionMenu":
                
                try {
                    ((PanelSeleccionPlato) panel_seleccionPlato).actualizarPlatos(((PanelSeleccionMenu) panel_seleccionMenu).getSelected().getPlatos());
                    s = "PanelSeleccionPlato";
                }catch(Exception e){
                    System.out.println("No se ha seleccionado un menu");
                }
            break;
            
            case "PanelSeleccionPlato":
                try {
                    actualizarPaso((Paso)((PanelSeleccionPlato) panel_seleccionPlato).getSelected().getPasos().get(index));
                    
                    s = "Panel"+((PanelSeleccionPlato) panel_seleccionPlato).getSelected().getPasos().get(index).getClass().getName().split(Pattern.quote("."))[2];
                }catch(Exception e)
                {
                    System.out.println("No se ha seleccionado un plato.");
                }
            break;
            
            case "PanelPaso":
            case "PanelPasoIntroducir":
            case "PanelPasoSacar":
            case "PanelPasoMaquina":
                try {
                    index+=1;
                    actualizarPaso((Paso)((PanelSeleccionPlato) panel_seleccionPlato).getSelected().getPasos().get(index));
                    
                    s = "Panel"+((PanelSeleccionPlato) panel_seleccionPlato).getSelected().getPasos().get(index).getClass().getName().split(Pattern.quote("."))[2];
                }catch(Exception e)
                {
                    boton_siguiente.setVisible(false);
                    s = "PanelFinal";
                }
           break;
           
           case "PanelFinal":
               boton_siguiente.setVisible(true);
               
               index = 0;
               if(!((ReutilizablePanelBoton) boton_siguiente).getRegresar())
                   s = "PanelSeleccionPlato";
               else {
                   boton_anterior.setVisible(false);
                   s = "PanelInicio";
               }
           break;     
           
        }
        return s;
    }
    
    public String cambioAnterior(String panel)
    {
        String s = "PanelError";
        
        switch(panel)
        {
            case "PanelSeleccionMenu":
                boton_anterior.setVisible(false);
                s = "PanelInicio";
            break;
            
            case "PanelSeleccionPlato":
                s = "PanelSeleccionMenu";
            break;
            
            case "PanelPaso":
            case "PanelPasoIntroducir":
            case "PanelPasoSacar":
            case "PanelPasoMaquina":
                index-=1;
                
                if(index < 0)
                {
                    index = 0;
                    s = "PanelSeleccionPlato";
                }
                else   
                    try {
                        actualizarPaso((Paso)((PanelSeleccionPlato) panel_seleccionPlato).getSelected().getPasos().get(index));
                        
                        s = "Panel"+((PanelSeleccionPlato) panel_seleccionPlato).getSelected().getPasos().get(index).getClass().getName().split(Pattern.quote("."))[2];
                    }catch(Exception e)
                    {
                        System.out.println("Error con el index");
                    }
            break;
        }
        return s;
    }
    
    public void actualizarPaso(Paso paso)
    {
        switch(paso.getClass().getName().split(Pattern.quote("."))[2])
        {
            case "Paso":
               ((PanelPaso) panel_paso).actualizarPaso(paso);
            break;
            case "PasoSacar":
                ((PanelPasoSacar)panel_pasoSacar).actualizarPaso(paso);
            break;
            case "PasoIntroducir":
                ((PanelPasoIntroducir)panel_pasoIntroducir).actualizarPaso(paso);
            break;
            case "PasoMaquina":
                ((PanelPasoMaquina)panel_pasoMaquina).actualizarPaso(paso);
            break;
        }
    }
}
