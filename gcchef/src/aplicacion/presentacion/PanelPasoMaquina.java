package aplicacion.presentacion;
import javax.swing.JPanel;

import aplicacion.dominio.Paso;
import aplicacion.dominio.PasoMaquina;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

@SuppressWarnings("serial")
public class PanelPasoMaquina extends JPanel {
    boolean encendido = false;
    boolean invertir = false;
    
    JLabel label_minutos_decenas;
    JLabel label_minutos_unidades;
    JLabel label_segundos_decenas;
    JLabel label_segundos_unidades;
    
    JLabel label_temperatura_centenas;
    JLabel label_temperatura_decenas;
    JLabel label_temperatura_unidades;
    
    JLabel boton_invertir;
    JLabel label_speed;
    JLabel label_descripcion ;
    
    int seconds = 0;
    int minutes = 0;
    int count = 0;
    
    public PanelPasoMaquina() {
        setBackground(new Color(102, 204, 255));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{70, 150, 60, 150, 60, 150, 70, 0};
        gridBagLayout.rowHeights = new int[]{30, 40, 150, 30, 50, 70, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        label_descripcion = new JLabel("");
        label_descripcion.setFont(new Font("Tahoma", Font.BOLD, 20));
        GridBagConstraints gbc_label_descripcion = new GridBagConstraints();
        gbc_label_descripcion.gridwidth = 5;
        gbc_label_descripcion.insets = new Insets(0, 0, 5, 5);
        gbc_label_descripcion.gridx = 1;
        gbc_label_descripcion.gridy = 1;
        add(label_descripcion, gbc_label_descripcion);
        
        JPanel panel = new RoundedPanel(200, Color.WHITE);
        panel.setBackground(new Color(102, 204, 255));
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 2;
        add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{28, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{30, 0, 0, 0, 10, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JLabel boton_up_minutos_decenas = new JLabel("");
        boton_up_minutos_decenas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_up_minutos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_up.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_up_minutos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_minutos_decenas.getText());
                if(num != 9)
                    num+=1;
                label_minutos_decenas.setText(Integer.toString(num));
            }
        });
        GridBagConstraints gbc_boton_up_minutos_decenas = new GridBagConstraints();
        gbc_boton_up_minutos_decenas.insets = new Insets(0, 0, 5, 5);
        gbc_boton_up_minutos_decenas.gridx = 1;
        gbc_boton_up_minutos_decenas.gridy = 1;
        panel.add(boton_up_minutos_decenas, gbc_boton_up_minutos_decenas);
        boton_up_minutos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));
        
        JLabel boton_up_minutos_unidades = new JLabel("");
        boton_up_minutos_unidades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_up_minutos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_up.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_up_minutos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));  
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_minutos_unidades.getText());
                if(num != 9)
                    num+=1;
                label_minutos_unidades.setText(Integer.toString(num));
            }
        });
        GridBagConstraints gbc_boton_up_minutos_unidades = new GridBagConstraints();
        gbc_boton_up_minutos_unidades.insets = new Insets(0, 0, 5, 5);
        gbc_boton_up_minutos_unidades.gridx = 2;
        gbc_boton_up_minutos_unidades.gridy = 1;
        panel.add(boton_up_minutos_unidades, gbc_boton_up_minutos_unidades);
        boton_up_minutos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));
        
        JLabel boton_up_segundos_decenas = new JLabel("");
        boton_up_segundos_decenas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_up_segundos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_up.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_up_segundos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_segundos_decenas.getText());
                if(num != 9)
                    num+=1;
                label_segundos_decenas.setText(Integer.toString(num));
            }
        });
        boton_up_segundos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));
        GridBagConstraints gbc_boton_up_segundos_decenas = new GridBagConstraints();
        gbc_boton_up_segundos_decenas.insets = new Insets(0, 0, 5, 5);
        gbc_boton_up_segundos_decenas.gridx = 4;
        gbc_boton_up_segundos_decenas.gridy = 1;
        panel.add(boton_up_segundos_decenas, gbc_boton_up_segundos_decenas);
        
        JLabel boton_up_segundos_unidades = new JLabel("");
        boton_up_segundos_unidades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_up_segundos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_up.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_up_segundos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_segundos_unidades.getText());
                if(num != 9)
                    num+=1;
                label_segundos_unidades.setText(Integer.toString(num));
            }
            
        });
        boton_up_segundos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));
        GridBagConstraints gbc_boton_up_segundos_unidades = new GridBagConstraints();
        gbc_boton_up_segundos_unidades.insets = new Insets(0, 0, 5, 5);
        gbc_boton_up_segundos_unidades.gridx = 5;
        gbc_boton_up_segundos_unidades.gridy = 1;
        panel.add(boton_up_segundos_unidades, gbc_boton_up_segundos_unidades);
        
        label_minutos_decenas = new JLabel("0");
        GridBagConstraints gbc_label_minutos_decenas = new GridBagConstraints();
        gbc_label_minutos_decenas.insets = new Insets(0, 0, 5, 5);
        gbc_label_minutos_decenas.gridx = 1;
        gbc_label_minutos_decenas.gridy = 2;
        panel.add(label_minutos_decenas, gbc_label_minutos_decenas);
        label_minutos_decenas.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        label_minutos_unidades = new JLabel("0");
        GridBagConstraints gbc_label_minutos_unidades = new GridBagConstraints();
        gbc_label_minutos_unidades.insets = new Insets(0, 0, 5, 5);
        gbc_label_minutos_unidades.gridx = 2;
        gbc_label_minutos_unidades.gridy = 2;
        panel.add(label_minutos_unidades, gbc_label_minutos_unidades);
        label_minutos_unidades.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JLabel label_2 = new JLabel(":");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 3;
        gbc_label_2.gridy = 2;
        panel.add(label_2, gbc_label_2);
        label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        label_segundos_decenas = new JLabel("0");
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.insets = new Insets(0, 0, 5, 5);
        gbc_label_3.gridx = 4;
        gbc_label_3.gridy = 2;
        panel.add(label_segundos_decenas, gbc_label_3);
        label_segundos_decenas.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        label_segundos_unidades = new JLabel("0");
        GridBagConstraints gbc_label_4 = new GridBagConstraints();
        gbc_label_4.insets = new Insets(0, 0, 5, 5);
        gbc_label_4.gridx = 5;
        gbc_label_4.gridy = 2;
        panel.add(label_segundos_unidades, gbc_label_4);
        label_segundos_unidades.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JLabel boton_down_minutos_decenas = new JLabel("");
        boton_down_minutos_decenas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_down_minutos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_down.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_down_minutos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));  
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_minutos_decenas.getText());
                if(num != 0)
                    num-=1;
                label_minutos_decenas.setText(Integer.toString(num));
            }
        });
        GridBagConstraints gbc_boton_down_minutos_decenas = new GridBagConstraints();
        gbc_boton_down_minutos_decenas.insets = new Insets(0, 0, 5, 5);
        gbc_boton_down_minutos_decenas.gridx = 1;
        gbc_boton_down_minutos_decenas.gridy = 3;
        panel.add(boton_down_minutos_decenas, gbc_boton_down_minutos_decenas);
        boton_down_minutos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));
        
        JLabel boton_down_minutos_unidades = new JLabel("");
        boton_down_minutos_unidades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_down_minutos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_down.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_down_minutos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));  
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_minutos_unidades.getText());
                if(num != 0)
                    num-=1;
                label_minutos_unidades.setText(Integer.toString(num));
            }
        });
        boton_down_minutos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));
        GridBagConstraints gbc_boton_down_minutos_unidades = new GridBagConstraints();
        gbc_boton_down_minutos_unidades.insets = new Insets(0, 0, 5, 5);
        gbc_boton_down_minutos_unidades.gridx = 2;
        gbc_boton_down_minutos_unidades.gridy = 3;
        panel.add(boton_down_minutos_unidades, gbc_boton_down_minutos_unidades);
        
        JLabel boton_down_segundos_decenas = new JLabel("");
        boton_down_segundos_decenas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_down_segundos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_down.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_down_segundos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));  
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_segundos_decenas.getText());
                if(num != 0)
                    num-=1;
                label_segundos_decenas.setText(Integer.toString(num));
            }
        });
        boton_down_segundos_decenas.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));
        GridBagConstraints gbc_boton_down_segundos_decenas = new GridBagConstraints();
        gbc_boton_down_segundos_decenas.insets = new Insets(0, 0, 5, 5);
        gbc_boton_down_segundos_decenas.gridx = 4;
        gbc_boton_down_segundos_decenas.gridy = 3;
        panel.add(boton_down_segundos_decenas, gbc_boton_down_segundos_decenas);
        
        JLabel boton_down_segundos_unidades = new JLabel("");
        boton_down_segundos_unidades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_down_segundos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_down.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_down_segundos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));  
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_segundos_unidades.getText());
                if(num != 0)
                    num-=1;
                label_segundos_unidades.setText(Integer.toString(num));
            }
        });
        boton_down_segundos_unidades.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));
        GridBagConstraints gbc_boton_down_segundos_unidades = new GridBagConstraints();
        gbc_boton_down_segundos_unidades.insets = new Insets(0, 0, 5, 5);
        gbc_boton_down_segundos_unidades.gridx = 5;
        gbc_boton_down_segundos_unidades.gridy = 3;
        panel.add(boton_down_segundos_unidades, gbc_boton_down_segundos_unidades);
        
        JLabel lblNewLabel_1 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.gridwidth = 3;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_1.gridx = 2;
        gbc_lblNewLabel_1.gridy = 5;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/reloj.png")));
        
        RoundedPanel roundedPanel = new RoundedPanel(200, Color.WHITE);
        roundedPanel.setBackground(new Color(102, 204, 255));
        GridBagConstraints gbc_roundedPanel = new GridBagConstraints();
        gbc_roundedPanel.insets = new Insets(0, 0, 5, 5);
        gbc_roundedPanel.fill = GridBagConstraints.BOTH;
        gbc_roundedPanel.gridx = 3;
        gbc_roundedPanel.gridy = 2;
        add(roundedPanel, gbc_roundedPanel);
        GridBagLayout gbl_roundedPanel = new GridBagLayout();
        gbl_roundedPanel.columnWidths = new int[]{40, 0, 0, 0, 0, 0, 0};
        gbl_roundedPanel.rowHeights = new int[]{30, 0, 0, 0, 10, 0, 0};
        gbl_roundedPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_roundedPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        roundedPanel.setLayout(gbl_roundedPanel);
        
        JLabel boton_up_temperatura = new JLabel("");
        boton_up_temperatura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_up_temperatura.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_up.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_up_temperatura.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_temperatura_centenas.getText())*100+Integer.parseInt(label_temperatura_decenas.getText())*10+Integer.parseInt(label_temperatura_unidades.getText());
                if((num > 20 && num < 180) || num == 20)
                {
                    num+=10;
                }
                label_temperatura_centenas.setText(Integer.toString((num%1000)/100));
                label_temperatura_decenas.setText(Integer.toString((num%100)/10));
                label_temperatura_unidades.setText(Integer.toString(num%10));
            }
        });
        boton_up_temperatura.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_up.png")));
        GridBagConstraints gbc_boton_up_temperatura = new GridBagConstraints();
        gbc_boton_up_temperatura.gridwidth = 4;
        gbc_boton_up_temperatura.insets = new Insets(0, 0, 5, 5);
        gbc_boton_up_temperatura.gridx = 1;
        gbc_boton_up_temperatura.gridy = 1;
        roundedPanel.add(boton_up_temperatura, gbc_boton_up_temperatura);
        
        label_temperatura_centenas = new JLabel("0");
        label_temperatura_centenas.setFont(new Font("Tahoma", Font.BOLD, 15));
        GridBagConstraints gbc_label_temperatura_centenas = new GridBagConstraints();
        gbc_label_temperatura_centenas.insets = new Insets(0, 0, 5, 5);
        gbc_label_temperatura_centenas.gridx = 1;
        gbc_label_temperatura_centenas.gridy = 2;
        roundedPanel.add(label_temperatura_centenas, gbc_label_temperatura_centenas);
        
        label_temperatura_decenas = new JLabel("2");
        GridBagConstraints gbc_label_temperatura_decenas = new GridBagConstraints();
        gbc_label_temperatura_decenas.insets = new Insets(0, 0, 5, 5);
        gbc_label_temperatura_decenas.gridx = 2;
        gbc_label_temperatura_decenas.gridy = 2;
        roundedPanel.add(label_temperatura_decenas, gbc_label_temperatura_decenas);
        label_temperatura_decenas.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        label_temperatura_unidades = new JLabel("0");
        GridBagConstraints gbc_label_temperatura_unidades = new GridBagConstraints();
        gbc_label_temperatura_unidades.insets = new Insets(0, 0, 5, 5);
        gbc_label_temperatura_unidades.gridx = 3;
        gbc_label_temperatura_unidades.gridy = 2;
        roundedPanel.add(label_temperatura_unidades, gbc_label_temperatura_unidades);
        label_temperatura_unidades.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JLabel lblC = new JLabel("\u00BA C");
        GridBagConstraints gbc_lblC = new GridBagConstraints();
        gbc_lblC.insets = new Insets(0, 0, 5, 5);
        gbc_lblC.gridx = 4;
        gbc_lblC.gridy = 2;
        roundedPanel.add(lblC, gbc_lblC);
        lblC.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JLabel boton_down_temperatura = new JLabel("");
        boton_down_temperatura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton_down_temperatura.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_down.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_down_temperatura.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_temperatura_centenas.getText())*100+Integer.parseInt(label_temperatura_decenas.getText())*10+Integer.parseInt(label_temperatura_unidades.getText());
                if((num > 20 && num < 180) || num ==180)
                {
                    num-=10;
                }
                label_temperatura_centenas.setText(Integer.toString((num%1000)/100));
                label_temperatura_decenas.setText(Integer.toString((num%100)/10));
                label_temperatura_unidades.setText(Integer.toString(num%10));
            }
        });
        boton_down_temperatura.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_down.png")));
        GridBagConstraints gbc_boton_down_temperatura = new GridBagConstraints();
        gbc_boton_down_temperatura.gridwidth = 4;
        gbc_boton_down_temperatura.insets = new Insets(0, 0, 5, 5);
        gbc_boton_down_temperatura.gridx = 1;
        gbc_boton_down_temperatura.gridy = 3;
        roundedPanel.add(boton_down_temperatura, gbc_boton_down_temperatura);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/temperatura.png")));
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.gridwidth = 4;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 5;
        roundedPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        RoundedPanel roundedPanel_1 = new RoundedPanel(200, Color.WHITE);
        roundedPanel_1.setBackground(new Color(102, 204, 255));
        GridBagConstraints gbc_roundedPanel_1 = new GridBagConstraints();
        gbc_roundedPanel_1.insets = new Insets(0, 0, 5, 5);
        gbc_roundedPanel_1.fill = GridBagConstraints.BOTH;
        gbc_roundedPanel_1.gridx = 5;
        gbc_roundedPanel_1.gridy = 2;
        add(roundedPanel_1, gbc_roundedPanel_1);
        GridBagLayout gbl_roundedPanel_1 = new GridBagLayout();
        gbl_roundedPanel_1.columnWidths = new int[]{40, 18, 0, 0, 0};
        gbl_roundedPanel_1.rowHeights = new int[]{55, 0, 28, 10, 0};
        gbl_roundedPanel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_roundedPanel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        roundedPanel_1.setLayout(gbl_roundedPanel_1);
        
        JLabel boton_decrease_speed = new JLabel("");
        boton_decrease_speed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                boton_decrease_speed.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_filled_left.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_decrease_speed.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_left.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_speed.getText());
                if(num > 0 )
                {
                    num-=1;
                }
                
                label_speed.setText(Integer.toString(num));
            }
        });
        boton_decrease_speed.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_left.png")));
        GridBagConstraints gbc_boton_decrease_speed = new GridBagConstraints();
        gbc_boton_decrease_speed.insets = new Insets(0, 0, 5, 5);
        gbc_boton_decrease_speed.gridx = 1;
        gbc_boton_decrease_speed.gridy = 1;
        roundedPanel_1.add(boton_decrease_speed, gbc_boton_decrease_speed);
        
        label_speed = new JLabel("5");
        GridBagConstraints gbc_label_speed = new GridBagConstraints();
        gbc_label_speed.insets = new Insets(0, 0, 5, 5);
        gbc_label_speed.gridx = 2;
        gbc_label_speed.gridy = 1;
        roundedPanel_1.add(label_speed, gbc_label_speed);
        label_speed.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JLabel boton_increase_speed = new JLabel("");
        boton_increase_speed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                boton_increase_speed.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo__filled_right.png")));
            }
            
            public void mouseExited(MouseEvent e)
            {
                boton_increase_speed.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_right.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Integer.parseInt(label_speed.getText());
                if(num < 9 )
                {
                    num+=1;
                }
                
                label_speed.setText(Integer.toString(num));
            }
        });
        boton_increase_speed.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/triangulo_right.png")));
        GridBagConstraints gbc_boton_increase_speed = new GridBagConstraints();
        gbc_boton_increase_speed.insets = new Insets(0, 0, 5, 0);
        gbc_boton_increase_speed.gridx = 3;
        gbc_boton_increase_speed.gridy = 1;
        roundedPanel_1.add(boton_increase_speed, gbc_boton_increase_speed);
        
        boton_invertir = new JLabel("");
        boton_invertir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!encendido)
                {
                    boton_invertir.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/aspas_filled.png")));
                    encendido = true;
                }
                else
                {
                    boton_invertir.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/aspas.png")));
                    encendido = false;
                }
            }
        });
        GridBagConstraints gbc_boton_invertir = new GridBagConstraints();
        gbc_boton_invertir.insets = new Insets(0, 0, 0, 5);
        gbc_boton_invertir.gridx = 2;
        gbc_boton_invertir.gridy = 3;
        roundedPanel_1.add(boton_invertir, gbc_boton_invertir);
        boton_invertir.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/aspas.png")));
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                minutes = Integer.parseInt(label_minutos_decenas.getText())*10 + Integer.parseInt(label_minutos_unidades.getText());
                seconds = Integer.parseInt(label_segundos_decenas.getText())*10 + Integer.parseInt(label_segundos_unidades.getText());

                Timer timer = new Timer();
                TimerTask task = new TimerTask()
                {
                    public void run()
                {      
                    if(seconds != 0 || minutes != 0)
                    {
                        count ++;
                        
                        if(count == 18)
                        {
                            playSound("/aplicacion/presentacion/resources/frying.wav");
                        }
                        if(seconds == 0) {
                            seconds = 60;
                            minutes--;
                        }else seconds--;
                        
                        label_minutos_decenas.setText(Integer.toString(minutes/10));
                        label_minutos_unidades.setText(Integer.toString(minutes%10));
                    
                        label_segundos_decenas.setText(Integer.toString(seconds/10));
                        label_segundos_unidades.setText(Integer.toString(seconds%10));
                    }
                    else
                    {
                        if(encendido) {
                            stopSound();
                            lblNewLabel_2.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/on.png")));
                            encendido = false;
                            boton_up_minutos_unidades.setEnabled(true);
                            boton_up_minutos_decenas.setEnabled(true);
                            boton_down_minutos_unidades.setEnabled(true);
                            boton_down_minutos_decenas.setEnabled(true);
                            
                            boton_up_segundos_unidades.setEnabled(true);
                            boton_up_segundos_decenas.setEnabled(true);
                            boton_down_segundos_unidades.setEnabled(true);
                            boton_down_segundos_decenas.setEnabled(true);
                            
                            boton_up_temperatura.setEnabled(true);
                            boton_down_temperatura.setEnabled(true);
                            
                            boton_increase_speed.setEnabled(true);
                            boton_decrease_speed.setEnabled(true);
                        }
                        timer.cancel();
                    }
                }
                };
            
                if(!encendido && (seconds != 0 || minutes != 0))
                {
                    lblNewLabel_2.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/off.png")));
                    playSound("/aplicacion/presentacion/resources/frying.wav");

                    boton_up_minutos_unidades.setEnabled(false);
                    boton_up_minutos_decenas.setEnabled(false);
                    boton_down_minutos_unidades.setEnabled(false);
                    boton_down_minutos_decenas.setEnabled(false);
                    
                    boton_up_segundos_unidades.setEnabled(false);
                    boton_up_segundos_decenas.setEnabled(false);
                    boton_down_segundos_unidades.setEnabled(false);
                    boton_down_segundos_decenas.setEnabled(false);
                    
                    boton_up_temperatura.setEnabled(false);
                    boton_down_temperatura.setEnabled(false);
                    
                    boton_increase_speed.setEnabled(false);
                    boton_decrease_speed.setEnabled(false);
                    
                    timer.scheduleAtFixedRate(task, 1000, 1000);
                    encendido = true;
                }
                else
                {
                    lblNewLabel_2.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/on.png")));
                    stopSound();
                    encendido = false;
                    
                    label_minutos_decenas.setText(Integer.toString(0));
                    label_minutos_unidades.setText(Integer.toString(0));
                
                    label_segundos_decenas.setText(Integer.toString(0));
                    label_segundos_unidades.setText(Integer.toString(0));
                    
                    timer.cancel();
                }
            }
        });
        lblNewLabel_2.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/on.png")));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 3;
        gbc_lblNewLabel_2.gridy = 4;
        add(lblNewLabel_2, gbc_lblNewLabel_2);
    }
    
    private Clip clip;
    
    public void playSound(String soundName)
    {
      try 
      {
           File file = new File(PanelPasoMaquina.class.getResource(soundName).getFile());
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
           clip = AudioSystem.getClip( );
           clip.open(audioInputStream);
           clip.start( );
      }
      catch(Exception ex)
      {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
      }
    }
    
    public void stopSound()
    {
        clip.stop();
    }
    
    public void actualizarPaso(Paso p)
    {
        PasoMaquina paso = (PasoMaquina) p;
        
        int minuts = paso.getTiempo()/60;
        int secons = minuts == 0 ? paso.getTiempo() : paso.getTiempo()-minuts*60;
        
        label_descripcion.setText(paso.getDescripcion());
        
        label_minutos_decenas.setText(Integer.toString(minuts/10));
        label_minutos_unidades.setText(Integer.toString(minuts%10));
    
        label_segundos_decenas.setText(Integer.toString(secons/10));
        label_segundos_unidades.setText(Integer.toString(secons%10));
        
        label_temperatura_centenas.setText(Integer.toString((paso.getTemperatura()%1000)/100));
        label_temperatura_decenas.setText(Integer.toString((paso.getTemperatura()%100)/10));
        label_temperatura_unidades.setText(Integer.toString(paso.getTemperatura()%10));
        if(paso.getInvertir()) boton_invertir.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/aspas_filled.png")));
        else boton_invertir.setIcon(new ImageIcon(PanelPasoMaquina.class.getResource("/aplicacion/presentacion/resources/aspas.png")));
            
        label_speed.setText(Integer.toString(paso.getVelocidad()));
    }
}
