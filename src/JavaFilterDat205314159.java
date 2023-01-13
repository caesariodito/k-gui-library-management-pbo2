/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dito
 */


import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;


class JavaFilterDat205314159 extends FileFilter {

    private static final String DAT  = "dat";
    private static final char   DOT   = '.';

    //accepts only directories and
    //files with .java extension only
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }

        if (extension(f).equalsIgnoreCase(DAT)) {
            return true;
        } else {
            return false;
        }
    }

    //description of the filtered files
    public String getDescription( ) {
        return "Dat source files (.dat)";
    }

    //extracts the extension from the filename
    private String extension(File f) {

        String filename = f.getName();
        int    loc      = filename.lastIndexOf(DOT);

        if (loc > 0 && loc < filename.length() - 1) {
            //make sure the dot is not
            //at the first or the last character position
            return filename.substring(loc+1);
        } else {
            return "";
        }
    }

}
