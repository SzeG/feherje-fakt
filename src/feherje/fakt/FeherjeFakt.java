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
            String[][] hetes = new String[20][7];
            String[][] betuk = new String[20][2];
            Integer[][] szamok = new Integer[20][5];

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 7; j++) {
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
            //Rendezetlen mol. töm. értékek tömbje
            Integer[][] moltom = new Integer[20][2];
            for (int i = 0; i < szamok.length; i++) {
                if (szamok[i][0] == null) {
                    break;
                }
                moltom[i][0]=i;
                moltom[i][1] = ((12 * szamok[i][0]) + (1 * szamok[i][1]) + (16 * szamok[i][2]) + (14 * szamok[i][3]) + (32 * szamok[i][4]));
            }

            //--Harmadik feladat--
            System.out.println("--Harmadik feladat--");
            Integer[][] moltomPit= new Integer[1][2];
            moltomPit[0][0]=moltom[0][0];
            moltomPit[0][1]=moltom[0][1];
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < moltom.length-1; i++) {
                    if (moltom[i][1]<moltom[i+1][1]) {
                        
                        moltomPit[0][0]=moltom[i][0];
                        moltomPit[0][1]=moltom[i][1];
                        
                        moltom[i][0]=moltom[i+1][0];
                        moltom[i][1]=moltom[i+1][1];
                        
                        moltom[i+1][0]=moltomPit[0][0];
                        moltom[i+1][1]=moltomPit[0][1];
                    }
            }
            }
            
            for (int i = 0; i < moltom.length; i++) {
                System.out.println (betuk[(moltom[i][0])][0]+" "+moltom[i][1]);
            }

            FileWriter buta2 = new FileWriter("eredmeny.txt");
            PrintWriter okos2 = new PrintWriter(buta2);
            okos2.println("--Harmadik feladat--");
            for (int i = 0; i < moltom.length; i++) {
            okos2.println(betuk[(moltom[i][0])][0]+" "+moltom[i][1]);
            }

            okos2.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nem találhetó a file!");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }

    }

}
