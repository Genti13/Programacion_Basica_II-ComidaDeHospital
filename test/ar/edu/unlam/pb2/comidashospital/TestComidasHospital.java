package ar.edu.unlam.pb2.comidashospital;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestComidasHospital {

	// DiabeteS_T1 - Diabetes_T2 - Oncologicos - Celiacos - Hipertenso - General

	@Test
	public void pacienteNuevo() {
		Paciente paciente = dadoQueEsUnPacienteNuevo();

		suCondicionSeDesconoce(paciente);
	}

	@Test
	public void pacienteConDiabetesT1() {
		Paciente paciente = dadoQueElPacienteTiene("Diabetes_T1");

		Comida comida = cuandoSeLeDaraComida("Tomate", "NoAzucar", "Papa");

		entoncesElPacienteDeberiaVivir(paciente, comida);
	}

	@Test
	public void pacienteDiabetesT2() {
		Paciente paciente = dadoQueElPacienteTiene("Diabetes_T2");

		cuandoLeSuministraInsulinaDiaria(paciente);

		entoncesElPacienteDeberiaEstarEstable(paciente);
	}

	@Test
	public void pacienteOncolicos() {
		Paciente paciente = dadoQueElPacienteTiene("Oncologico");

		Comida comida = cuandoSeLeDaraComida("Tomate", "Lechuga", "Sal");
		cuandoLaComidaEstaCocinada(comida);

		entoncesElPacienteDeberiaNoMorir(paciente, comida);
	}

	@Test
	public void pacienteCeliaco() {
		Paciente paciente = dadoQueElPacienteTiene("Celiaco");

		Comida comida = cuandoSeLeDaraComida("Tomate", "NoTrigo", "Papa");

		entoncesElPacienteDeberiaVivir(paciente, comida);
	}

	@Test
	public void pacienteHiperTenso() {
		Paciente paciente = dadoQueElPacienteTiene("Hipertenso");

		Comida comida = cuandoSeLeDaraComida("Tomate", "NoSal", "Papa");

		entoncesElPacienteDeberiaVivir(paciente, comida);
	}

	@Test
	public void pacienteGeneral() {
		Paciente paciente = dadoQueElPacientePuedeComerCualquierCosa();

		Comida comida = cuandoSeLeDeCualquierComida("Trigo", "Sal", "Azucar");

		entoncesElPacienteDeberiaVivir(paciente, comida);
	}

	/***********************************************/
	/*****************Contrastacion*****************/
	/***********************************************/
	
	private void entoncesElPacienteDeberiaNoMorir(Paciente paciente, Comida comida) {
		Assert.assertFalse(paciente.getPuedeCrudo().equals(false) && comida.getCrudo().equals(true));
	}

	private void entoncesElPacienteDeberiaEstarEstable(Paciente paciente) {
		Assert.assertTrue(paciente.getMedDiaria());
	}

	private void entoncesElPacienteDeberiaVivir(Paciente paciente, Comida comida) {
		Boolean todoOK = true;

		for (Ingrediente ingrediente : comida.getIngredientes()) {
			for (Ingrediente lPaciente : paciente.getVeneno()) {
				if (ingrediente.getIngrediente().equals(lPaciente.getIngrediente())) {
					todoOK = false;
				}
			}
		}

		Assert.assertTrue(todoOK);
	}

	private void suCondicionSeDesconoce(Paciente paciente) {
		Assert.assertEquals(paciente.getEnfermedad(), "Desconocida");
	}
	
	/***********************************************/
	/*******************Ejecucion*******************/
	/***********************************************/
	
	private Comida cuandoSeLeDaraComida(String ingre1, String ingre2, String ingre3) {
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();

		ingredientes.add(new Ingrediente(ingre1));
		ingredientes.add(new Ingrediente(ingre2));
		ingredientes.add(new Ingrediente(ingre3));

		return new Comida(ingredientes);
	}

	private void cuandoLeSuministraInsulinaDiaria(Paciente paciente) {
		paciente.medicar();
	}

	private void cuandoLaComidaEstaCocinada(Comida comida) {
		comida.cocinar();
	}

	private Comida cuandoSeLeDeCualquierComida(String ing1, String ing2, String ing3) {
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();

		ingredientes.add(new Ingrediente(ing1));
		ingredientes.add(new Ingrediente(ing2));
		ingredientes.add(new Ingrediente(ing3));

		return new Comida(ingredientes);
	}

	/***********************************************/
	/******************Preparacion******************/
	/***********************************************/
	private Paciente dadoQueEsUnPacienteNuevo() {
		return new Paciente();
	}

	private Paciente dadoQueElPacienteTiene(String enfermedad) {
		return new Paciente(enfermedad);
	}

	private Paciente dadoQueElPacientePuedeComerCualquierCosa() {
		return new Paciente();
	}

}
