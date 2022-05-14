package ar.edu.unlam.pb2.comidashospital;

import java.util.ArrayList;

public class Enfermedad {
	private ArrayList<Ingrediente> ingredientesProhibidos = new ArrayList<>();

	public Enfermedad(String enfermedad) {
		switch (enfermedad) {
		case "Diabetes_T1":
			ingredientesProhibidos.add(new Ingrediente("Azucar"));
			break;
		case "Diabetes_T2":
			ingredientesProhibidos.add(new Ingrediente("Azucar"));
			break;
		case "Celiaco":
			ingredientesProhibidos.add(new Ingrediente("Trigo"));
			ingredientesProhibidos.add(new Ingrediente("Avena"));
			ingredientesProhibidos.add(new Ingrediente("Cebada"));
			ingredientesProhibidos.add(new Ingrediente("Centeno"));
			break;
		case "Hipertenso":
			ingredientesProhibidos.add(new Ingrediente("Sal"));
			break;
		default:
			break;
		}
	}

	public ArrayList<Ingrediente> getIngredientesProhibidos() {
		return this.ingredientesProhibidos;
	}

}
