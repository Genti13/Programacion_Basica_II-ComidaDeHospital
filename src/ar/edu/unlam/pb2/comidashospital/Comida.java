package ar.edu.unlam.pb2.comidashospital;

import java.util.ArrayList;

public class Comida {
	private ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	private Boolean crudo;

	public Comida() {
		this.crudo = true;
	}

	public Comida(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes.addAll(ingredientes);
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void cocinar() {
		this.crudo = false;
	}

	public Boolean getCrudo() {
		return this.crudo;
	}

}
