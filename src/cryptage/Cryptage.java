/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.C;

/**
 *
 * @author admin
 */
public class Cryptage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        List<String> lignes = new ArrayList<String>();
        List<String>lignesmodif = new ArrayList<String>();
        int a = 0;
        String chemin, cle;
        Scanner sc;
        sc = new Scanner(System.in);
        //C:/Users/admin/Desktop/cours/source.txt
        a=affichagemenu();
        switch (a){
                case 1:
                    System.out.println("Chiffrage du fichier");
                    lecture(lignes);
                    cle=clechiff();
                    chifligne(lignes, lignesmodif, cle);
                    ecriture(lignesmodif);
                break;
                case 2:
                    System.out.println("Déchiffrage du fichier");
                    lecture(lignes);
                    cle=clechiff();
                    dechifligne(lignes, lignesmodif, cle);
                    ecriture(lignesmodif);
                break;
                case 3:
                    System.out.println("Le programme va se fermer.");
                    break;
                default :
                    System.out.println("Vous n'avez choisi aucune des options proposées");
            }
        
    }
    
    
    public static String clechiff()
    {
        String cle;
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Saisissez la clé de chiffrage");
        cle = sc.nextLine();
        return cle;
    }
    
    public static int affichagemenu()
    {
        Scanner sc;
        sc = new Scanner(System.in);
        int choix;
        System.out.println("Voulez vous : ");
        System.out.println("1) Chiffrer votre fichier");
        System.out.println("2) Déchiffrer votre fichier");
        System.out.println("0) Quitter le programme");
        choix = sc.nextInt();
        
        return choix;

}
    
    public static void lecture(List<String>lignes) throws Exception
            {
                Scanner sc;
                sc = new Scanner(System.in);
                BufferedReader source;
                String ligne, chemin;
                System.out.println("entrez l'adresse du fichier .txt que vous souhaitez chiffrer");//C:/Users/admin/Desktop/cours/source.txt
                source = new BufferedReader(new FileReader(chemin = sc.nextLine()));
                ligne = source.readLine();
                while (ligne != null) 
                {
                    lignes.add(ligne);
                    ligne = source.readLine();
                }
                source.close();
            }
   
    public static void ecriture(List<String>lignesmodif) throws Exception
            {
                Scanner sc;
                sc = new Scanner(System.in);
                BufferedWriter cible;
                String chemin;
                System.out.println("entrez l'adresse du fichier .txt que ce programme va créer dans lequel vos données seront chiffrées");
                cible = new BufferedWriter(new FileWriter(chemin = sc.nextLine()));
                for (int i = 0; i < lignesmodif.size(); i ++) 
                    {
                        cible.write(lignesmodif.get(i) + "\n");
                    }
                cible.close();
            }
    
       public static void chifligne(List<String>lignes, List<String>lignesmodif, String cle)
    {
        String ligne, lignemodif;
        lignemodif="";
        int i=0;
        /*int k=0;
        int cpt=0;*/
        
        for (i = 0; i < lignes.size(); i ++)
        {
            ligne=lignes.get(i);
            lignemodif=chiffcar(cle, ligne);
            lignesmodif.add(lignemodif);
        }
    }
    
       public static String chiffcar(String cle, String ligne)
       {
           int k=0;
           int l=0;
           int cpt=0;
           String  lignemodif;
           lignemodif="";
           
           
            for(int j=0; j<(ligne.length()); j++ )
                {
                
                    //l++;
                
                    char caract = ligne.charAt(j);
                    int codeASCII = caract;
                    char caracle = cle.charAt(cpt);
                    int codeASCIIcle = caracle;
                    k = codeASCII + codeASCIIcle;
                    if(k>255)
                    {
                        k=k-255;
                    }
                    caract=(char)k;
                    
                    lignemodif=lignemodif+caract;
                    
                    cpt++;
                    if (cpt==cle.length())
                    {
                        cpt=0;
                    }
                    
                }
           
           
            return lignemodif;
       }
       
       
    public static void dechifligne(List<String>lignes, List<String>lignesmodif, String cle)
    {
        String ligne, lignemodif;
        lignemodif="";
        int i=0;
        /*int k=0;
        int cpt=0;*/
        
        for (i = 0; i < lignes.size(); i ++)
        {
            ligne=lignes.get(i);
            lignemodif=dechiffcar(cle, ligne);
            lignesmodif.add(lignemodif);
        }
    }
    
    
    public static String dechiffcar(String cle, String ligne)
       {
           int k=0;
           int l=0;
           int cpt=0;
           String  lignemodif;
           lignemodif="";
           
           
            for(int j=0; j<(ligne.length()); j++ )
                {
                
                    //l++;
                
                    char caract = ligne.charAt(j);
                    int codeASCII = caract;
                    char caracle = cle.charAt(cpt);
                    int codeASCIIcle = caracle;
                    k = codeASCII - codeASCIIcle;
                    if(k<0)
                    {
                        k+=255;
                    }
                    caract=(char)k;
                    
                    lignemodif=lignemodif+caract;
                    
                    
                    if (cpt==(cle.length()-1))
                    {
                        cpt=(0-1);
                    }
                    cpt++;
                }
           
           
            return lignemodif;
       }
}

