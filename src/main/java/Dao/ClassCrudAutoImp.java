package Dao;


import java.util.List;
import Interfaces.IAutoable;
import model.TblAuto;

public class ClassCrudAutoImp implements IAutoable{

	@Override
	public void RegistrarAuto(TblAuto tblauto) {
		// Establecemos conexion con la unidad de persistencia
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoMavenLPIIMartes");
		// Para gestionar los procesos
		EntityManager manager = factory.createEntityManager();
		// Iniciamos la transaccion
		manager.getTransaction().begin();
		// Registramos
		manager.persist(tblauto);
		// Confirmamos
		manager.getTransaction().commit();
		// Cerramos
		manager.close();
		
	}

	@Override
	public void ActualizarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TblAuto> ListadoAuto() {
		// Establecemos la unidad de persistencia
		EntityManagerFactory factory = Persistence.CreateEntityManagerFactory("ProyectoMavenLPIIMartes");
		EntityManager manager = factory.createEntityManager();
		// Iniciamos la transaccion
		manager.getTransaction().begin();
		List<TblAuto> ListaAuto = manager.createQuery("select a from TblAuto a", TblAuto.class).getResultList();
		// Confirmamos
		manager.getTransaction().commit();
		// Cerramos
		manager.close();
		// Retornamos el listado
		return ListaAuto;
		
	}

	@Override
	public TblAuto BuscarAuto() {
		// TODO Auto-generated method stub
		return null;
	}

}
