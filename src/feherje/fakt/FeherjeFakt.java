/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feherje.fakt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
            String[][] hetes = new String[200][7];
            
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

        } catch (FileNotFoundException ex) {
            System.out.println("Nem találhetó a file!");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }

    
    }

}
