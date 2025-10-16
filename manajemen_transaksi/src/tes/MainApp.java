/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tes;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainApp extends JFrame {
    private JTextField txtAkunPengirim;
    private JTextField txtAkunPenerima;
    private JTextField txtJumlahTransfer;
    private JButton btnTransfer;
    private JTextArea txtResult;

    public MainApp() {
        setTitle("Manajemen Transaksi - Transfer Saldo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel lblAkunPengirim = new JLabel("Akun Pengirim (ID):");
        lblAkunPengirim.setBounds(20, 20, 150, 25);
        panel.add(lblAkunPengirim);
        
        txtAkunPengirim = new JTextField();
        txtAkunPengirim.setBounds(180, 20, 150, 25);
        panel.add(txtAkunPengirim);
        
        JLabel lblAkunPenerima = new JLabel("Akun Penerima (ID):");
        lblAkunPenerima.setBounds(20, 60, 150, 25);
        panel.add(lblAkunPenerima);
        
        txtAkunPenerima = new JTextField();
        txtAkunPenerima.setBounds(180, 60, 150, 25);
        panel.add(txtAkunPenerima);
        
        JLabel lblJumlahTransfer = new JLabel("Jumlah Transfer:");
        lblJumlahTransfer.setBounds(20, 100, 150, 25);
        panel.add(lblJumlahTransfer);
        
        txtJumlahTransfer = new JTextField();
        txtJumlahTransfer.setBounds(180, 100, 150, 25);
        panel.add(txtJumlahTransfer);
        
        btnTransfer = new JButton("Transfer");
        btnTransfer.setBounds(130, 150, 100, 30);
        panel.add(btnTransfer);
        
        txtResult = new JTextArea();
        txtResult.setBounds(20, 190, 350, 50);
        txtResult.setEditable(false);
        panel.add(txtResult);

        add(panel);
        
        // Action Listener untuk button Transfer
        btnTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pengirim = Integer.parseInt(txtAkunPengirim.getText());
                int penerima = Integer.parseInt(txtAkunPenerima.getText());
                double jumlah = Double.parseDouble(txtJumlahTransfer.getText());
                
                try {
                    TransactionManager.transferSaldo(pengirim, penerima, jumlah);
                    txtResult.setText("Transfer berhasil.");
                } catch (Exception ex) {
                    txtResult.setText("Error: " + ex.getMessage());
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}
