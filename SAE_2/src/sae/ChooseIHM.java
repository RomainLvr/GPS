package sae;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import java.util.PriorityQueue;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChooseIHM {

	private static String parent;

	public static String choisirVilleDepart(Collection<String> villes) {
        PriorityQueue<String> optionsToChoose = new PriorityQueue<String>();
        
        for(String ville : villes) {
        	optionsToChoose.add(ville);
        }
        
        
        String getVille = (String) JOptionPane.showInputDialog(
                null,
                "Quelle est votre ville de départ ?",
                "Choisir une ville : ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose.toArray(), optionsToChoose);
        
        return getVille;
    }
	
	public static String choisirVilleArrivee(Collection<String> villes) {
        PriorityQueue<String> optionsToChoose = new PriorityQueue<String>();
        
        for(String ville : villes) {
        	optionsToChoose.add(ville);
        }
        
        
        String getVille = (String) JOptionPane.showInputDialog(
                null,
                "Quelle est votre ville de d'arrivée ?",
                "Choisir une ville : ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose.toArray(), optionsToChoose);
        
        return getVille;
    }
	
	public static String dotFileChooser(Component parent)  {
		
		JFileChooser choix = new JFileChooser();
		FileNameExtensionFilter dotFilter = new FileNameExtensionFilter("Dot files","dot");
		choix.setFileFilter(dotFilter);
		choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int retour=choix.showOpenDialog(parent);
		if(retour==JFileChooser.APPROVE_OPTION){
		   choix.getSelectedFile().getName();
		   choix.getSelectedFile().getAbsolutePath();
		}
		System.out.println(choix.getSelectedFile().getAbsolutePath());
		return choix.getSelectedFile().getAbsolutePath();
	}
	
	public static int seeChemin() {
		
		int input = JOptionPane.showConfirmDialog(null, "Voulez-vous consulter le chemin ?");
        // 0=yes, 1=no, 2=cancel
        return input;
	    }
	
}
