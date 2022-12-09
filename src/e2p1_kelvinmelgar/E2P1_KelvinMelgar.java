/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e2p1_kelvinmelgar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author kelvi
 */
public class E2P1_KelvinMelgar {
    
    static ActionListener ACrearMaquina ;
    static ActionListener AEvaluar;
    
    static JLabel titulo;
    static JLabel nombre;
    
    static JButton btCrearMaquina;
    static JButton btEvaluar;
    
    static JFrame menu;
    
    static MaquinaEstados maquina;

    private static final long serialVersionUID = 34534511L;
    public static void main(String[] args) {
        
        ACrearMaquina = new ActionListener(){
         @Override
            public void actionPerformed(ActionEvent e) {
                //Crea el frame para crear la maquina y las listas
                frameCrearMaquina cream = new frameCrearMaquina(menu, true);
                
                //asigna todo lo que hizo anteriormente al objeto del main
                maquina = cream.mq;
            }
    };
        
        
        AEvaluar= new ActionListener(){
         @Override
            public void actionPerformed(ActionEvent e) {
                
                //if(maquina != null){ //significa que esta vacia
                    
                    new frameEvaluarCadena(menu, true, maquina);
               // }
                
            }
    };
        
         //cambia todo el aspecto del proyecto ^^
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        menu = new JFrame();
        
        
        
        menu.setSize(450, 500);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLayout(new BorderLayout());
        menu.setBackground(new Color(240,234,234));
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
        
        JPanel banner = new JPanel();
        banner.setPreferredSize(new Dimension(500,150));
        banner.setLayout(null);
        banner.setBackground(new Color(149, 158, 157));
        
        titulo = new JLabel("Examen 2 Programacion I");
        titulo.setFont(new Font("LCDMono2", Font.PLAIN, 33));
        titulo.setBounds(55, 10, 400, 50);
        
        nombre = new JLabel("Kelvin J. Melgar Quiroz");
        nombre.setFont(new Font("Candara", Font.PLAIN, 16));
        nombre.setBounds(160, 60, 200, 50);
        
        banner.add(titulo);
        banner.add(nombre);
        
        JPanel opciones = new JPanel();
        opciones.setPreferredSize(new Dimension(500,220));
        opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 50,25));
        
       
        
        btCrearMaquina = new JButton("Crear Maquina");
        btCrearMaquina.setPreferredSize(new Dimension(150, 55 ));
        btCrearMaquina.setBackground(new Color(240,234,234));
        btCrearMaquina.setForeground(new Color(73, 47, 42));
        btCrearMaquina.setFont(new Font("Candara", Font.PLAIN, 18));
        btCrearMaquina.setFocusable(false);
        btCrearMaquina.setHorizontalTextPosition(JButton.CENTER);
        btCrearMaquina.setVerticalTextPosition(JButton.CENTER);
        btCrearMaquina.addActionListener(ACrearMaquina);
        
        btEvaluar = new JButton("Evaluar cadena");
        btEvaluar.setFont(new Font("Candara", Font.PLAIN, 18));
        btEvaluar.setPreferredSize(new Dimension(150, 55 ));
        btEvaluar.setBackground(new Color(240,234,234));
        btEvaluar.setForeground(new Color(73, 47, 42));
        btEvaluar.setFocusable(false);
        btEvaluar.addActionListener(AEvaluar);
        
        
        opciones.add(btCrearMaquina);
        opciones.add(btEvaluar);
        
        menu.add(banner, BorderLayout.NORTH);
        menu.add(opciones, BorderLayout.SOUTH);
        
        menu.repaint();
        menu.setVisible(true);
        
        
        
        
        
        
        
    }
    
    
    
    
}
