package br.unifor.so.escalonador.fifo;

public class fifoMain {

	public static void main(String[] args) {

		Fifo<String> cola = new Fifo<String>();
		String nombre = new String("jaime");
		String nombre2 = new String("Fabita");
		String nombre3 = new String("T�masito");
		Object elNombre = new Object();

		Fifo<Articulo> listaArticulos = new Fifo<Articulo>();

		cola.push(nombre);
		cola.push(nombre2);
		cola.push(nombre3);

		Articulo jabon = new Articulo("Jabon coltex", 2000, 2);
		Articulo leche = new Articulo("Leche Nido", 1200, 3);
		Articulo pan = new Articulo("Pan Ayuya", 1650, 4);

		listaArticulos.push(pan);
		listaArticulos.push(leche);
		listaArticulos.push(jabon);

		System.out.println("Cantidad de personas en la cola ahora : " + cola.size());

		elNombre = cola.pull();
		System.out.println("Ha salido de la cola : " + elNombre);

		System.out.println("Cantidad de personas en la cola ahora : " + cola.size());

		elNombre = null;
		elNombre = cola.pull();
		System.out.println("Ha salido de la cola : " + elNombre);

		System.out.println("Cantidad de personas en la cola ahora : " + cola.size());

		cola.push(new String("Lunita"));
		System.out.println("ha ingresado Lunita a la cola!");

		System.out.println("Cantidad de personas en la cola ahora : " + cola.size());

		elNombre = null;
		elNombre = cola.pull();
		System.out.println("Ha salido de la cola : " + elNombre);

		elNombre = null;
		elNombre = cola.pull();
		System.out.println("Ha salido de la cola : " + elNombre);

		System.out.println("Cantidad de personas en la cola ahora : " + cola.size());

		Articulo unArticulo;
		unArticulo = listaArticulos.pull();

		System.out.println("Articulo sacado de la lista : " + unArticulo.getNombre());

	}

}
