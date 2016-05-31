package actions;

import java.util.ArrayList;
import models.Coordonnees;

public enum DeplacementType {
	CROIX("croix"),
	DIAGONALE("diagonale");
	
	private String type;
		
	DeplacementType(String typeDeDeplacement){
		this.type=typeDeDeplacement;
	}
	/**
	 * retourne le type de d�placement
	 * @return croix || diagonale
	 */
	public String getType(){
		return this.type;
	}
	public ArrayList<Coordonnees>getChoix(Coordonnees c){
		return null;
	}
	public boolean equals(DeplacementType deplacement){
		return this.type==deplacement.getType();
	}
}
