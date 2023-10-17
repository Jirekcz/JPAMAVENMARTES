package TestEntidades;

import javax.persistence.EntityManager;

import model.TblTipodocumento;
import model.TblDocumento;

public class TestDocumento {

	public static void main(String[] args) {
		// Establecemos la conexion con la unidad de persistencia
		EntitymanagerFactory fabri = Persistence.createEntityFactory("BDAutoJPA");
		// Permite gestionar entidades
		EntityManager eman = fabri.createEntityManager();
		// Iniciar transaccion
		eman.getTransaction().begin();
		// Instanciar las respectivas entidades
		TblTipodocumento tipodocu = new TblTipodocumento();
		TblDocumento docum = new TblDocumento();
		// Ingresamos nuevos valores
		tipodocu.setNomdocum("boleta");
		tipodocu.setDescipdocum("comprobante de pago");
		eman.persist(tipodocu);
		docum.setNrodocument("827838");
		docum.setProvedocument("farma clin e.i.r.l");
		docum.setRucdocumen("8394726391");
		Date fecha = new Date();
		Date fechasql = new Date();
		docum.setFecha(fechasql);
		docum.setDescridocument("recolectar IGV para la sunat");
		eman.persist(docum);
		// Emitimos un mensaje por consola
		System.out.println("Dato(s) registrado(s)");
		// Configuramos
		eman.getTransaction().commit();
		// Cerramos
		eman.close();

		// Actualizar
		tipodocu.setIdtipodocum(1);
		tipodocu.setnomdocum("ticket");
		tipodocu.setDescripdocum("para llevar control interno");
		eman.merge(tipodocu);
		docum.setIddocument(1);
		docum.setNrodocument("777666");
		docum.setProvedocumnt("policlinico lima");
		docum.setRucdocument("1732389929");
		Date fecha = new Date();
		Date fechaact = new Date(fecha.getTime());
		docum.setFecha(fechaact);
		docum.setDescridocument("comprobante de pago");
		docum.setTblTipodocumento(tipodocu);
		eman.merge(docum);
		// Emitimos mensaje por pantalla
		System.out.println("Dato(s) actualizado(s)");
		// Confirmamos
		eman.getTransaction().commit();
		// Cerramos
		eman.close();

		// Listado
		List<TblDocumento> listado = eman.createQuery("select  docu from TblDocumento docu", TblDocumento.class)
				.getResultList();

		// Aplicamos un bucle for
		for (TblDocumento lis : listado) {
			System.out.println("codigo " + lis.getIddocument() + " nro de documento " + lis.getNrodocument()
					+ " nombre proveedor " + lis.getProvedocument() + " ruc de documento " + lis.Rucdocumen()
					+ " fecha " + lis.getFecha + " descrip document " + lis.getDescridocument()
					+ " codigo tipo documento " +

					lis.getTblTipodocumento().getIdtipodocum() + " nombre documento "
					+ lis.getTblTipodocumento().getNomdocum()

					+ "descrip tipo documento " + lis.getTblTipodocumento().getDescripdocum());

			// Buscar por codigo
			TblDocumento buscarcodigo = eman.find(TblDocumento.class, 3);
			// Imprimimos mensaje por consola
			System.out.println("codigo documento " + buscarcodigo.getIddocument() +

					" nro de documento " + buscarcodigo.getNrodocument() + " nombre proveedor "

					+ buscarcodigo.getProvedocument() + " ruc de documento " + buscarcodigo.getRucdocumen() +

					" fecha documento " + buscarcodigo.getFecha() + " descrip.. documento "

					+ buscarcodigo.getDescridocument() + " codigo tipo documento "

					+ buscarcodigo.getTblTipodocumento().getIdtipodocum() + " nombre tipo de documento "

					+ buscarcodigo.getTblTipodocumento().getNomdocum() + " descripcion tipo de documento "

					+ buscarcodigo.getTblTipodocumento().getDescripdocum());

		}
	}

}
