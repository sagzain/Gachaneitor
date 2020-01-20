package analizador;

import aplicacion.presentacion.VentanaPrincipal;
import aplicacion.dominio.Menu;
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
			VentanaPrincipal ventana = new VentanaPrincipal(menus);
			ventana.frame.setVisible(true);
		}
        }

}
