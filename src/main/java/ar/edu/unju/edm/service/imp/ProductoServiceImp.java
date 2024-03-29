package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
	//como se hace la solucion del problema
	//guardar en Array
	//guardar en una BD MySQL
	//guardar en una DB Oracle
	
	private static final Log NICOLE = LogFactory.getLog(ProductoServiceImp.class);
	
	@Autowired
	Producto unProducto;
	
	//creando una estructura que guardará todos los productos
	ArrayList<Producto> listaDeProductos = new ArrayList<Producto>();
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub

		System.out.println(unProducto.getNombre());
		listaDeProductos.add(unProducto);

		System.out.println(listaDeProductos.size());
		
		NICOLE.info("METHOD: ingresando a Guardar Producto");
		NICOLE.info("RESULT: guardado " + listaDeProductos.get(listaDeProductos.size()-1).getNombre());
	}

	@Override
	public Producto obtenerUnProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		int i = listaDeProductos.size() - 1;
		return listaDeProductos.get(i);
	}

	@Override
	public Producto encontrarUnProducto(int cod) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == cod) {
		    	unProducto = listaDeProductos.get(i);
		    }
		}
		return unProducto;
	}

	@Override
	public Object crearProducto() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public void modificarProducto(Producto productoModificado) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == productoModificado.getCodProducto()) {
		    	listaDeProductos.set(i, productoModificado);
		    }
		}
	}

	@Override
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == id) {
		    	listaDeProductos.remove(i);
		    }
		}
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return listaDeProductos;
	}


	@Override
	public Producto obtenerProductoCodigo(int cod) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
