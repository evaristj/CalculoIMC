package com.java.exercise.poojava.actividad2;

public class Persona {

	// constantes de sexo
	static final char HOMBRE = 'H';
	static final char MUJER = 'F';

	// atributos de la clase persona
	private String name;
	private int edad;
	private static String dni;
	private char sexo;
	private double peso;
	private double altura;

	// creamos 2 constructores
	// el primero por defecto
	public Persona() {
	}

	// el segundo con 5 atribbutos
	public Persona(String name, int edad, String dni, char sexo, double peso, double altura) {
		this.name = name;
		this.edad = edad;
		Persona.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	// metodo para calcular el IMC
	public double calcularIMC() {

		double pesoIdeal = this.peso / (this.altura * this.altura);

		double result = 0;
		if (pesoIdeal <= 18.5) {
			result = pesoIdeal;
		} else if (pesoIdeal > 18.5 && pesoIdeal <= 25) {
			result = pesoIdeal;
		} else if (pesoIdeal > 25 && pesoIdeal <= 29.9) {
			result = pesoIdeal;
		} else if (pesoIdeal > 30) {
			result = pesoIdeal;
		}

		return result;

	}

	// metodo que nos dirá si es mayor de edad o no
	public boolean checkEdad() {

		boolean adulto = false;

		if (edad >= 18) {
			adulto = true;
		}
		return adulto;
	}

	// metodo que comprueba el sexo, y si no tiene se le pone hombre por defecto
	public char comprobarSexo() {

		char genero = this.sexo;
		if (this.sexo != HOMBRE && this.sexo != MUJER) {
			genero = HOMBRE;
		}

		return genero;
	}

	// metodo que genera DNI aleatorio con letra
	public static String generarDni() {

		// calculamos el numero DNI aleatoriamente
		int numDni = (int) (Math.random() * 100000000);

		// la letra será el resultado del resto del numero generado aleatoriamente entre
		// 23
		int letra = (numDni % 23);

		// creamos un array de caracteres donde introducimos las posibles letras del DNI
		char letras[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		// la variable iniciada al principio de la clase llamada dni, una vez iniciado
		// este metodo, tendra el siguiente valor
		return dni = Integer.toString(numDni) + "-" + letras[letra];

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *          the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *          the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *          the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *          the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * @param altura
	 *          the altura to set
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() toString imprimira por consola lo indicado
	 */
	public String toString(Persona person) {
		
		// aquí tenemos dos formas de introducir en el toString lo que queramos que se imprima
		// una es llamando al metodo esMayorEdad de la clase PersonaEjecutable, y pasando como 
		// parametro el person que tiene toString,
		// y la otra es llamando al metodo de la clase persona para imprimir el sexo por defecto
		return name + " tiene " + edad + " años," + CalcularIMC.esMayordeEdad(person) + " Con dni " + dni + ", sexo "
				+ person.comprobarSexo() + ", con un peso de " + peso + "kg y una altura de " + altura + "metros.";
	}

}
