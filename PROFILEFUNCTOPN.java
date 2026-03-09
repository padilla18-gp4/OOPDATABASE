/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jhescel Ann
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

public class ProfilePanel extends JPanel {

    JLabel nameLabel;
    JLabel profilePic;
    JButton changePicBtn;
    JButton resetPassBtn;
    JTextField newPassword;

    String username = "Cashier1";

    public ProfilePanel() {

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3,1));

        nameLabel = new JLabel("User: " + username);
        topPanel.add(nameLabel);

        profilePic = new JLabel();
        profilePic.setPreferredSize(new Dimension(120,120));
        profilePic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topPanel.add(profilePic);

        changePicBtn = new JButton("Change Profile Picture");
        topPanel.add(changePicBtn);

        add(topPanel, BorderLayout.NORTH);

        JPanel passPanel = new JPanel();

        passPanel.add(new JLabel("New Password:"));
        newPassword = new JTextField(15);
        passPanel.add(newPassword);

        resetPassBtn = new JButton("Reset Password");
        passPanel.add(resetPassBtn);

        add(passPanel, BorderLayout.CENTER);

        changePicBtn.addActionListener(e -> changeProfilePicture());
        resetPassBtn.addActionListener(e -> resetPassword());
    }

    private void changeProfilePicture() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Images", "jpg","png","jpeg");
        chooser.setFileFilter(filter);

        int result = chooser.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION){

            ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getPath());
            Image img = icon.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
            profilePic.setIcon(new ImageIcon(img));

        }
    }

    private void resetPassword(){

        String pass = newPassword.getText();

        if(pass.isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter new password");
        }else{
            JOptionPane.showMessageDialog(this,"Password Updated");
        }
    }
}
