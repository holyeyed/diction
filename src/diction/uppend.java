/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author ADMIN
 */
public class uppend {

    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;

    public uppend(String fn) {
        try {
            fw = new FileWriter(fn);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        } catch (Exception e) {
        }
    }

    public void uppend(String s) {
        try {
            pw.write(s);
        } catch (Exception e) {
        }
    }

    public void close() {
        try {
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
}
