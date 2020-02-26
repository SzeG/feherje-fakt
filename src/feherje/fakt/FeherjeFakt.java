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
                moltom[i][0] = i;
                moltom[i][1] = ((12 * szamok[i][0]) + (1 * szamok[i][1]) + (16 * szamok[i][2]) + (14 * szamok[i][3]) + (32 * szamok[i][4]));
            }

            //--Harmadik feladat--
            System.out.println("--Harmadik feladat--");
            Integer[][] moltomPit = new Integer[1][2];
            moltomPit[0][0] = moltom[0][0];
            moltomPit[0][1] = moltom[0][1];
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < moltom.length - 1; i++) {
                    if (moltom[i][1] < moltom[i + 1][1]) {

                        moltomPit[0][0] = moltom[i][0];
                        moltomPit[0][1] = moltom[i][1];

                        moltom[i][0] = moltom[i + 1][0];
                        moltom[i][1] = moltom[i + 1][1];

                        moltom[i + 1][0] = moltomPit[0][0];
                        moltom[i + 1][1] = moltomPit[0][1];
                    }
                }
            }

            for (int i = 0; i < moltom.length; i++) {
                System.out.println(betuk[(moltom[i][0])][0] + " " + moltom[i][1]);
            }

            FileWriter buta2 = new FileWriter("eredmeny.txt");
            PrintWriter okos2 = new PrintWriter(buta2);
            okos2.println("--Harmadik feladat--");
            for (int i = 0; i < moltom.length; i++) {
                okos2.println(betuk[(moltom[i][0])][0] + " " + moltom[i][1]);
            }
            okos2.close();

            System.out.println("---Negyedik feladat---");
            FileReader buta3 = new FileReader("bsa.txt");
            BufferedReader okos3 = new BufferedReader(buta3);
            String feh = "";
            Integer[] osszegKeplet = new Integer[1000];
            //a bsa.txt fájlon végimenő ciklus
            for (int i = 0; i < 1000; i++) {
                if (feh==null) {
                    break;
                }
                feh=okos3.readLine();
                for (int j = 0; j < 19; j++) {
                    //megkeresi a kiolvesott betűt a táblázatban, és a hozzárendelt számokat összeadja, majd beírja az osszegKeplet tömb aktuális helyére
                    if (feh==betuk[j][1]) {
                        osszegKeplet[i]=(szamok[j][0]+szamok[j][1]+szamok[j][2]+szamok[j][3]+szamok[j][4]);
                    }
                }
            }
            //próba tömb kiíró
            //PROBLÉMA: a tömb értékei kivétel nélkül NULL
            for (int i = 0; i < 1000; i++) {
                System.out.println(osszegKeplet[i]);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Nem találhetó a file!");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }

    }

}
