import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.Arrays;  

/*
	Utilice esta clase para guardar la informacion de su
	AFD. NO DEBE CAMBIAR LOS NOMBRES DE LA CLASE NI DE LOS 
	METODOS que ya existen, sin embargo, usted es libre de 
	agregar los campos y metodos que desee.
*/
public class AFD{
	// Archivo - Stados - Estado final
	String path, states, final_state;
	String[] alphabet; // Lenguaje del AFD
	String[][] move_state; // Transiciones
	/*
		Implemente el constructor de la clase AFD
		que recibe como argumento un string que 
		representa el path del archivo que contiene
		la informacion del afd (i.e. "Documentos/archivo.afd").
		Puede utilizar la estructura de datos que desee
	*/
	public AFD(String path) throws FileNotFoundException {
		this.path = path;
		ReadFile();
		///
	}

	// Leer el file
	public void ReadFile() throws FileNotFoundException {
		File myObj = new File(this.path);
      	Scanner myReader = new Scanner(myObj);
		  int i = 1;
		  int x = 0;

		while (myReader.hasNextLine()) {
			//System.out.println(myReader.nextLine());
			if(i == 1){
				this.alphabet = myReader.nextLine().split(",");
				i++;
			} else if(i == 2){
				this.states = myReader.nextLine();
				i++;
			} else if (i == 3){
				this.final_state = myReader.nextLine();
				this.move_state = new String[this.alphabet.length][Integer.parseInt(this.states)];
				i++;
			} else {
				String[] b = myReader.nextLine().split(",");
	
				for (int y = 0; y < b.length; y++){
					this.move_state[x][y] = b[y];
				}

				i++;
				x++;
			}			
		}
		
		System.out.println(Arrays.toString(alphabet));
		System.out.printf("%s\n", states);
		System.out.printf("%s\n", final_state);
		System.out.println(Arrays.deepToString(move_state));
		
		myReader.close();      	
	}

	/*
		Implemente el metodo transition, que recibe de argumento
		un entero que representa el estado actual del AFD y un
		caracter que representa el simbolo a consumir, y devuelve 
		un entero que representa el siguiente estado
	*/
	public int getTransition(int currentState, char symbol){
		return 0;
	}

	/*
		Implemente el metodo accept, que recibe como argumento
		un String que representa la cuerda a evaluar, y devuelve
		un boolean dependiendo de si la cuerda es aceptada o no 
		por el afd
	*/
	public boolean accept(String string){
		return false;
	}

	/*
		El metodo main debe recibir como primer argumento el path
		donde se encuentra el archivo ".afd", como segundo argumento 
		una bandera ("-f" o "-i"). Si la bandera es "-f", debe recibir
		como tercer argumento el path del archivo con las cuerdas a 
		evaluar, y si es "-i", debe empezar a evaluar cuerdas ingresadas
		por el usuario una a una hasta leer una cuerda vacia (""), en cuyo
		caso debe terminar. Tiene la libertad de implementar este metodo
		de la forma que desee. 
	*/
	public static void main(String[] args) throws Exception{
		AFD afd = new AFD("/home/diegog/Documents/pj2_archivos/tests/afd/simple.afd");	
	}
}