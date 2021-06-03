package ar.edu.unju.edm;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.service.IClienteService;

@SpringBootApplication
public class Tp04GimenezEdm2021Application implements CommandLineRunner{
	
	@Autowired
	@Qualifier("implementacionMYSQL")
	IClienteService clienteService;
	
	@Autowired
	Cliente unCliente;
	
	public static void main(String[] args) {
		SpringApplication.run(Tp04GimenezEdm2021Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
		//inicializo un cliente para pruebas
//		unCliente.setNroDocumento(1000000);
//		unCliente.setNombreApellido("user");
//		unCliente.setTipoDocumento("DNI");
//		unCliente.setEmail("nicole@gmail.com");
//		unCliente.setPassword("123456");
//		unCliente.setFechaNacimiento(LocalDate.now ());
//		unCliente.setFechaUltimaCompra(LocalDate.now ());
//		clienteService.guardarCliente(unCliente);
		
	}

	
}
