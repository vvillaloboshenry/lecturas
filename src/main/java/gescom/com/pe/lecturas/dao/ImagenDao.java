/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescom.com.pe.lecturas.dao;

import gescom.com.pe.lecturas.model.Imagen;
import java.util.List;

/**
 *
 * @author GescomWeb
 */
public interface ImagenDao {

    public void addImagen(Imagen usuario);

    public List<Imagen> imagenlist();

    public void deleteImagen(Integer usuariioId);

    public Imagen updateImagen(Imagen usuario);

    public Imagen getImagen(int usuario_id);
}
