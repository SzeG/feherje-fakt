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
    public static void betolto() {
        FileReader buta;
        try {
            buta = new FileReader("aminosav.txt");
            BufferedReader okos = new BufferedReader(buta);
            String ideiglenes= new String();
            for (int i = 0; i < 200; i++) {
                ideiglenes=okos.readLine();
                if (ideiglenes==null) {
                    break;
                }
                
                System.out.println(ideiglenes);
                
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Nem találhetó a file!");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }
        
    }
    public static void main(String[] args) {
        betolto();
    }
    
}
