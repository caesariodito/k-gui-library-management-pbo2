/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dito
 */
import java.io.*;
import javax.swing.*;

public class FileChooser205314159 {

    String path;
    
    FileChooser205314159(boolean choose) {
        path = main(choose);
    }
    
    public String getPath(){
        return path;
    }

    public String main(boolean choose) {

        JFileChooser chooser;
        File file, directory;
        int status;

        chooser = new JFileChooser();
        //chooser = new JFileChooser(System.getProperty("user.dir"));
        //chooser = new JFileChooser("N:/Programs");

        // status = chooser.showDialog(null,"Run"); //Customized label
        // Filter only .java files
        chooser.setFileFilter(new JavaFilterDat205314159());

        if (choose == true) {
            status = chooser.showOpenDialog(null);

            if (status == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                directory = chooser.getCurrentDirectory();

                System.out.println("Directory: "
                        + directory.getName());

                System.out.println("File selected to open: "
                        + file.getName());

                System.out.println("Full path name: "
                        + file.getAbsolutePath());
                
                return file.getAbsolutePath();

            } else {
                JOptionPane.showMessageDialog(null, "Open File dialog canceled");
            }
        } else {
            status = chooser.showSaveDialog(null);

            if (status == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                directory = chooser.getCurrentDirectory();

                System.out.println("Directory: "
                        + directory.getName());

                System.out.println("File selected for saving data: "
                        + file.getName());

                System.out.println("Full path name: "
                        + file.getAbsolutePath());
                
                return file.getAbsolutePath()+".dat";
                
            } else {
                JOptionPane.showMessageDialog(null, "Save File dialog canceled");
            }
        }
        return null;
    }
}
