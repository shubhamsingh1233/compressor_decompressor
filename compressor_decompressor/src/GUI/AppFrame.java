package GUI;

import Compression_Decompression.compressor;
import Compression_Decompression.decompressor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton=new JButton("Select File To Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,200,200,30);

        decompressButton=new JButton("Select File To Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 200, 200, 30);

        this.add(compressButton);
        this.add(decompressButton);
        this.setTitle("Compressor&Decompressor");
        this.setLayout(new BorderLayout());
        this.setSize(500,400);
        this.getContentPane().setBackground(Color.darkGray);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try
                {
                    compressor.method(file);
                }
                catch(Exception excp)
                {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }

        if(e.getSource()==decompressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try
                {
                    decompressor.method(file);
                }
                catch(Exception excp)
                {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }
}