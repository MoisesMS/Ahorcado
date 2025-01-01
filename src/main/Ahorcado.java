package main;

public class Ahorcado {
	public final int INTENTOS = 10;
	public final int ERRORES = 5;

	private int intentos;
	private boolean acertado;
	private String palabraCensurada;
	private String palabra;
	private int errores;

	public Ahorcado() {
		this.palabra = generarPalabra();
		this.intentos = INTENTOS;
		this.errores = ERRORES;
		this.acertado = false;
		this.palabraCensurada = censurarPalabra(this.palabra);
	}

	private String generarPalabra() {
		String palabras[] = {"ALTAVOCES", "ORDENADOR", "TECLADO", "RATON", "MONITOR", "PORTATIL", "IMPRESORA", "ESCANER", "MOVIL", "TELEFONO"};

		return palabras[(int) (Math.random() * palabras.length)];
	}

	private String censurarPalabra(String palabra) {
		String palabraCensurada = "";
		for(int i = 0; i < palabra.length(); i++) {
			palabraCensurada += "*";
		}

		return palabraCensurada;
	}
	
	public int getERRORES() {
		return this.ERRORES;
	}
	
	public int getINTENTOS() {
		return this.INTENTOS;
	}
	
	public int getErrores() {
		return this.errores;
	}

	public int getIntentos() {
		return this.intentos;
	}
	
	public boolean palabraAcertada() {
		return acertado;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public String getPalabraCensurada() {
		return palabraCensurada;
	}
	
	public int getNumLetras() {
		return this.palabra.length();
	}
	
	public boolean resolver(String palabra) {
		intentos--;
		
		if(this.palabra.equals(palabra)) {
			this.acertado = true;
		} else {
			this.errores--;
		}
		
		return this.acertado;
	}
	
	public boolean intento(char letra) {
		boolean acertada = false;
		intentos--;
		
		if(this.palabra.indexOf(letra) != -1) {
			for(int i = 0; i < this.palabra.length(); i++) {
				if(this.palabra.charAt(i) == letra) {
					this.palabraCensurada = this.palabraCensurada.substring(0, i) + letra + this.palabraCensurada.substring(i + 1);
				}
			}
			
			if(this.palabra.equals(this.palabraCensurada)) {
				acertada = true;
			}
		} else {
			this.errores--;
		}

		return acertada;
	}
}
