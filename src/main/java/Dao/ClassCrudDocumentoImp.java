package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IDocumentoable;
import model.TblDocumento;

public class ClassCrudDocumentoImp implements IDocumentoable{

	@Override
	public void RegistrarDocumento(TblDocumento tbdocum) {
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
		EntityManager eman = fabri.createEntityManager();
		eman.getTransaction().begin();
		eman.persist(tbdocum);
		eman.getTransaction().commit();
		eman.close();
	}
	
	@Override
	public void ActualizarDocumento(TblDocumento tbldocum) {
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
		EntityManager eman = fabri.createEntityManager();
		eman.getTransaction().begin();
		eman.persist(tbdocum);
		eman.getTransaction().commit();
		eman.close();
	}
	
	@Override
	public void EliminarDocumento(TblDocumento tbldocum) {
		
	}
	
	@Override
	public List<TblDocumento> listadoCoumentos() {
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
		EntityManager eman = fabri.createEntityManager();
		eman.getTransaction().begin();
		List<TblDocumento> listado = eman.createQuery("select docu from TblDocumento docu", TblDocumento.class).getResultList();
		// Retornamos el listado
		return listado;
		
	}
	
	@Override
	public TblDocumento BuscarDocumento(TblDocumento tbldocum) {
		ntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
		EntityManager eman = fabri.createEntityManager();
		eman.getTransaction().begin();
		TblDocumento buscadoc = eman.find(TblDocumento.class, tbldocum.getIddocument());
		// Retornamos el documento buscado por codigo
		return buscadoc;
	}
}
