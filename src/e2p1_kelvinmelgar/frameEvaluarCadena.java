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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kelvi
 */
public class frameEvaluarCadena extends JDialog implements ActionListener{
    
    MaquinaEstados maquina;
    
    JPanel titulo;
    JPanel pl_campos;
    JLabel lbTitulo;
    
    JButton btEvaluar;
    JTextField txtCadenaEva;
    JTextArea txtResultado;
    
    JLabel lbCadenaEva;
    
    frameEvaluarCadena(JFrame parent, boolean modal, MaquinaEstados maquina){
        
        super(parent, modal);
        
        this.maquina = maquina;
        
        this.setSize(450, 700);
        this.setTitle("Maquina Estados");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        titulo = new JPanel();
        titulo.setLayout(null);
        titulo.setPreferredSize(new Dimension(450, 100));
        titulo.setBackground(new Color(149, 158, 157));
        
        lbTitulo = new JLabel("Evaluar Cadena");
        lbTitulo.setFont(new Font("Consolas", Font.PLAIN, 25));
        lbTitulo.setBounds(125, 30, 300, 50);
        
        titulo.add(lbTitulo);
        
        pl_campos = new JPanel();
        pl_campos.setLayout(new FlowLayout(FlowLayout.CENTER, 25,20));
        pl_campos.setPreferredSize(new Dimension(225, 300));
        
        lbCadenaEva = new JLabel("Cadena a Evaluar");
        lbCadenaEva.setFont(new Font("Consolas", Font.PLAIN, 16));
        
        txtCadenaEva = new JTextField();
        txtCadenaEva.setPreferredSize(new Dimension(350,40));
        txtCadenaEva.setFont(new Font("Consolas", Font.PLAIN, 15));
        
        pl_campos.add(lbCadenaEva);
        pl_campos.add(txtCadenaEva);
       
        
        txtResultado = new JTextArea();
        txtResultado.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtResultado.setPreferredSize(new Dimension(400,370));
        txtResultado.setEditable(false);
        pl_campos.add(txtResultado);        

        
        
        btEvaluar = new JButton("Evaluar");
        btEvaluar.setFont(new Font("Consolas", Font.PLAIN, 16));
        btEvaluar.setPreferredSize(new Dimension(100, 50));
        btEvaluar.addActionListener(this);
        
        pl_campos.add(btEvaluar);
        this.add(titulo, BorderLayout.NORTH);
        this.add(pl_campos, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == btEvaluar){
            
            String cadena = maquina.computeStr(txtCadenaEva.getText());
            
            txtResultado.setText(cadena);
            
            
        }
    
        
    }
    
    
}
