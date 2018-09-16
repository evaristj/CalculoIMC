package com.java.exercise.poojava.actividad2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcularIMC {

	public static void main(String[] args) throws InputMismatchException {

		// iniciamos variable que utilizaremos al imprimir por consola
		String imc = "";

		// capturamos posibles errores
		try {

			System.out.println("Introduce un nombre:");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();

			System.out.println("Introduce la edad:");
			int edad = sc.nextInt();

			System.out.println("Introduce el sexo (H o F):");
			String sexo2 = sc.next();
			char sexo = sexo2.charAt(0);

			System.out.println("Introduce el peso:");
			double peso = sc.nextDouble();

			System.out.println("Introduce la altura:");
			double altura = sc.nextDouble();

			// generamos un dni aleatorio para la persona introducida
			String dni = Persona.generarDni();

			// creamos el obejeto person pasando como parametros los que nos pide el
			// constructor
			Persona person = new Persona(name, edad, dni, sexo, peso, altura);

			// el metodo peso ideal nos devuelve un string que después imprimimos por
			// consola
			imc = pesoIdeal(person);

			// esto es lo que va a imprimir por consola, va llamar al metodo toString de la
			// clase Persona, y después nosotros le añadimos más datos como el name y el
			// resultado de IMC
			System.out.println(person.toString(person) + "\n" + person.getName() + imc);

		} catch (Exception e) {
			// si no introducimos caracteres correctamente, seltará este error
			System.out.println("Error al introducir caracteres: " + e.getMessage());
		}

	}

	// este llama a calacularIMC de la clase Persona, y nos devuelve el string segun el resultado
	public static String pesoIdeal(Persona person) {

		String peso = "";

		if (person.calcularIMC() <= 18.5) {
			peso = " está por debajo de su peso Ideal. IMC = " + person.calcularIMC();
		} else if (person.calcularIMC() > 18.5 && person.calcularIMC() <= 25) {
			peso = " está en su peso Ideal.IMC = " + person.calcularIMC();
		} else if (person.calcularIMC() > 25 && person.calcularIMC() <= 30) {
			peso = " está por encima de su peso Ideal. IMC = " + person.calcularIMC();
		} else if (person.calcularIMC() > 30) {
			peso = " sufre obesidad. IMC = " + person.calcularIMC();
		}

		return peso;

	}

	// comprobamos el resultado de checkEdad
	public static String esMayordeEdad(Persona person) {

		String edad = "";
		if (person.checkEdad()) {
			edad = " es mayor de edad.";
		} else {
			edad = " es menor de edad.";
		}

		return edad;
	}

}
