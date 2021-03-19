package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAlienText;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	dizionario  = new AlienDictionary();
    	
    	if(this.txtAlienText.getText().contains(" ")){
    		String[] testo = this.txtAlienText.getText().split(" ");
        	
    		for(int i = 0; i < testo.length; i++)
        		if (!Pattern.matches("[a-zA-Z]+", testo[i])) {
        			txtResult.setText("ERRORE: Impossibile inserire caratteri speciali o numeri");
        			return;
        	}
    		
    		dizionario.addWord(testo[0], testo[1]);
    		this.txtResult.setText("NUOVA PAROLA AGGIUNTA: "+testo[0]+" ("+testo[1]+")");
    		this.txtAlienText.clear();
    		return;
    	}
    
    	String testo = this.txtResult.getText();
    	
    	try {
    		this.txtResult.setText("Traduzione :"+ dizionario.transalteWord(testo));
    	}catch(NullPointerException e){
    		this.txtResult.setText("Traduzione non trovata :( ");
    		this.txtAlienText.clear();
    	}
    	
    	return;
    }

    @FXML
    void initialize() {
        assert txtAlienText != null : "fx:id=\"txtAlienText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
