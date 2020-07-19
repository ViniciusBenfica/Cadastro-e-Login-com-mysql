/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Telas.Escolha;
import connection.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        Escolha escolha = new Escolha();
        escolha.setVisible(true); // Aparecer na tela
        escolha.setLocationRelativeTo(null); //Aparecer no centro da tela
        
      
        
        try{
            JOptionPane.showMessageDialog(null, "Testando a conexão");
            Connection con = new connection.ConnectionFactory().conecta();
            JOptionPane.showMessageDialog(null, "Está conectado");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
        
        
    }
    
}
