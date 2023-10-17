package Interfaces;

import model.TblDocumento;

public interface IDocumentoable {
	// Declaramos sus metodos
	public void RegistrarDocumento(TblDocumento tbdocum);
	public void ActualizarDocumento(TblDocumento tbldocum);
	public void EliminarDocumento(TblDocumento tbldocum);
	public List<TblDocumento> ListadoDocumentos();
	public TblDocumento BuscarDocumento(TblDocumento tbldocum);
}
