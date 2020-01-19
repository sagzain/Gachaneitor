package analizador;

import aplicacion.presentacion.VentanaPrincipal;
import aplicacion.dominio.Menu;
//import aplicacion.dominio.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

        public static void main(String [] args) throws Exception {
		ArrayList<Menu> menus = new ArrayList<Menu>();
		for(int i = 1; i < args.length; i++) {
			System.out.println(args[i]);
			File fichero=new File(args[i]);
			FileReader entrada =new FileReader(fichero);
			try{
				parser p = new parser(new scanner(entrada));
				p.parse();
				for(Menu m : p.getMenus()) {
					for(Menu m2 : menus) {
						if(m.getID().equals(m2.getID())) {
		   					System.out.println("ERROR: id de menu ya existente");
							throw new Exception();
						}
					}
				}
				menus.addAll(p.getMenus());
		   		System.out.println("Compilacion completada");
			} catch ( Exception e) {
				System.out.println("Error en la compilacion");
			}
		}
		if(!args[0].equals("ngui")) {
			System.out.println("Iniciando interfaz");
			/*for(Menu m : menus) {
				System.out.print("Menu:");
				System.out.print(" ID: "+m.getID());
				System.out.print(" Nombre: "+m.getNombre());
				System.out.println(" Autor: "+m.getNickname());
				System.out.println();
				System.out.println("\tIngredientes globales");
				for(Ingrediente i : m.getIngredientesGlobales()) {
					System.out.print("\t\tIngrediente global:");
					System.out.print(" ID: "+i.getID());
					System.out.print(" Nombre: "+i.getNombre());
					System.out.print(" Cantidad: "+i.getCantidad());
					System.out.println(" Medida: "+i.getMedida());
					System.out.println();
				}
				System.out.println("\tPlatos");
				System.out.println();
				for(Plato p : m.getPlatos()) {
					System.out.print("\t\tPlato:");
					System.out.print(" ID: "+p.getID());
					System.out.print(" Nombre: "+p.getNombre());
					System.out.print(" Tipo: "+p.getTipo());
					System.out.print(" Comensales: "+p.getComensales());
					System.out.print(" TCocinado: "+p.getTiempos().getTCocinado());
					System.out.print(" MCocinado: "+p.getTiempos().getMCocinado());
					System.out.print(" TPreparacion: "+p.getTiempos().getTPreparacion());
					System.out.print(" MPreparacion: "+p.getTiempos().getMPreparacion());
					System.out.print(" TTotal: "+p.getTiempos().getTTotal());
					System.out.println(" MTotal: "+p.getTiempos().getMTotal());
					System.out.println("\t\tIngredientes");
					for(Ingrediente i : p.getIngredientes()) {
						System.out.print("\t\t\tIngrediente:");
						System.out.print(" ID: "+i.getID());
						System.out.print(" Nombre: "+i.getNombre());
						System.out.print(" Cantidad: "+i.getCantidad());
						System.out.println(" Medida: "+i.getMedida());
					}
					System.out.println("\t\tPasos");
					for(Paso pa : p.getPasos()) {
						System.out.println("\t\t\tDescripcion: "+pa.getDescripcion());
					}
					System.out.println();
				}
				System.out.println();
				System.out.println();
				System.out.println();
			}*/
			VentanaPrincipal ventana = new VentanaPrincipal(menus);
			ventana.frame.setVisible(true);
		}
        }

}
