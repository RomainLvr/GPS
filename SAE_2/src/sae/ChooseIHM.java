package sae;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ChooseIHM {


	public static String choisirVilleDepart(Collection<String> villes) {
        List<String> optionsToChoose = new ArrayList<String>();
        
        for(String ville : villes) {
        	optionsToChoose.add(ville);
        }
        
        Collections.sort(optionsToChoose);
        
        
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
        List<String> optionsToChoose = new ArrayList<String>();
        
        for(String ville : villes) {
        	optionsToChoose.add(ville);
        }
        
        Collections.sort(optionsToChoose);
        
        String getVille = (String) JOptionPane.showInputDialog(
                null,
                "Quelle est votre ville de d'arrivée ?",
                "Choisir une ville : ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose.toArray(), optionsToChoose);
        
        return getVille;
    }
	@SuppressWarnings("exports")
	
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
	
	public static int boxChooser(String message) {
		
		int input = JOptionPane.showConfirmDialog(null, message);
        // 0=yes, 1=no, 2=cancel
        return input;
	}
	
	public static void displayMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
    }
	
}
