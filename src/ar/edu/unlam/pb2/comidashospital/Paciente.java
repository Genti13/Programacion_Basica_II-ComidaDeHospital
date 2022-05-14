package ar.edu.unlam.pb2.comidashospital;

import java.util.ArrayList;

public class Paciente {
	private String enfermedad;
	private ArrayList<Ingrediente> veneno = new ArrayList<>();
	private Boolean medicacionDiaria;
	private Boolean puedeComidaCruda;

	public Paciente() {
		this.enfermedad = "Desconocida";
		this.medicacionDiaria = false;
	}

	public Paciente(String enfermedad) {

		if (enfermedad == "Oncologico") {
			this.puedeComidaCruda = false;
		} else {
			this.puedeComidaCruda = true;
		}

		this.medicacionDiaria = false;
		this.enfermedad = enfermedad;
		cargarVeneno(enfermedad);
	}

	private void cargarVeneno(String enfermedad) {
		Enfermedad laEnfermedad = new Enfermedad(enfermedad);
		this.veneno.addAll(laEnfermedad.getIngredientesProhibidos());
	}

	public String getEnfermedad() {
		return this.enfermedad;
	}

	public ArrayList<Ingrediente> getVeneno() {
		return this.veneno;
	}

	public void medicar() {
		this.medicacionDiaria = true;
	}

	public Boolean getMedDiaria() {
		return this.medicacionDiaria;
	}

	public Boolean getPuedeCrudo() {
		return puedeComidaCruda;
	}
}