/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kelvi
 */
public class frameCrearMaquina extends JDialog implements ActionListener{
    MaquinaEstados mq;
    
    JPanel titulo;
    JPanel pl_campos;
    JLabel lbTitulo;
    
    JButton btCrear;
    JTextField txtEstados;
    JTextField txtTransiciones;
    
    JLabel lbEstados;
    JLabel lbTrans;
    
    frameCrearMaquina(JFrame parent, boolean modal){
        
        super(parent, modal);
        
        this.mq = mq;
        
        this.setSize(450, 500);
        this.setTitle("Maquina Estados");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        titulo = new JPanel();
        titulo.setLayout(null);
        titulo.setPreferredSize(new Dimension(450, 100));
        titulo.setBackground(new Color(149, 158, 157));
        
        lbTitulo = new JLabel("Crear Maquina");
        lbTitulo.setFont(new Font("Consolas", Font.PLAIN, 25));
        lbTitulo.setBounds(125, 30, 300, 50);
        
        titulo.add(lbTitulo);
        
        pl_campos = new JPanel();
        pl_campos.setLayout(new FlowLayout(FlowLayout.CENTER, 25,15));
        pl_campos.setPreferredSize(new Dimension(225, 300));
        
        lbEstados = new JLabel("Estados");
        lbEstados.setFont(new Font("Consolas", Font.PLAIN, 20));
        
        txtEstados = new JTextField();
        txtEstados.setPreferredSize(new Dimension(350,40));
        txtEstados.setFont(new Font("Consolas", Font.PLAIN, 15));
        
        pl_campos.add(lbEstados);
        pl_campos.add(txtEstados);
        
        
         lbTrans = new JLabel("Transiciones");
        lbTrans.setFont(new Font("Consolas", Font.PLAIN, 20));
        
        txtTransiciones = new JTextField();
        txtTransiciones.setPreferredSize(new Dimension(350,40));
        txtTransiciones.setFont(new Font("Consolas", Font.PLAIN, 15));
        
        pl_campos.add(lbTrans);
        pl_campos.add(txtTransiciones);
        
        
        btCrear = new JButton("Crear");
        btCrear.setFont(new Font("Consolas", Font.PLAIN, 16));
        btCrear.setPreferredSize(new Dimension(100, 50));
        btCrear.addActionListener(this);
        
        pl_campos.add(btCrear);
        this.add(titulo, BorderLayout.NORTH);
        this.add(pl_campos, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == btCrear){
            
            mq = new MaquinaEstados(txtEstados.getText(), txtTransiciones.getText());
            this.dispose();
        }
    
        
    }
    
}
