/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feherje.fakt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gergely.vajda
 */
public class FeherjeFakt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            FileReader buta = new FileReader("aminosav.txt");
            BufferedReader okos = new BufferedReader(buta);
            String ideiglenes = new String();
            String[][] hetes = new String[100][7];
            String[][] betuk = new String[100][2];
            Integer[][] szamok = new Integer[100][5];

            for (int i = 0; i < 200; i++) {
                if (ideiglenes == null) {
                    break;
                }
                for (int j = 0; j < 7; j++) {
                    if (ideiglenes == null) {
                        break;
                    }
                    ideiglenes = okos.readLine();

                    hetes[i][j] = ideiglenes;

                }
            }

            for (int i = 0; i < hetes.length; i++) {
                for (int j = 0; j < 2; j++) {
                    if (hetes[i][j] == null) {
                        break;
                    }
                    betuk[i][j] = hetes[i][j];
                    //System.out.println(betuk[i][j]);
                }
            }

            for (int i = 0; i < hetes.length; i++) {
                for (int j = 2; j < 7; j++) {
                    if (hetes[i][j] == null) {
                        break;
                    }
                    szamok[i][j - 2] = Integer.parseInt(hetes[i][j]);
                    //System.out.println(szamok[i][j]);
                }
            }
            //--Második feladat--
            Integer[] moltom = new Integer[100];
            for (int i = 0; i < szamok.length; i++) {
                if (szamok[i][0] == null) {
                    break;
                }
                moltom[i] = ((12 * szamok[i][0]) + (1 * szamok[i][1]) + (16 * szamok[i][2]) + (14 * szamok[i][3]) + (32 * szamok[i][4]));
            }
            //--Harmadik feladat--
            System.out.println("--Harmadik feladat--");
            Integer[][] rendMolTom = new Integer[100][2];
            Integer legnagyobb = 0;
            Integer x = 0;
            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < moltom.length; i++) {
                    if (moltom[i]==null) {
                    i=i++;
                    }else{
                        if (legnagyobb <= moltom[i]) {
                            legnagyobb = moltom[i];
                        } else {
                            rendMolTom[x][1] = moltom[i];
                            rendMolTom[x][0] = i;
                            moltom[i] = null;
                            legnagyobb = 0;
                            x = x++;
                        }
                    }

                }
            }
            for (int i = 0; i < rendMolTom.length; i++) {
                System.out.println(rendMolTom[i][0]+" "+rendMolTom[i][1]);
            }

            FileWriter buta2 = new FileWriter("eredmeny.txt");
            PrintWriter okos2 = new PrintWriter(buta2);

            okos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nem találhetó a file!");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }

    }

}
