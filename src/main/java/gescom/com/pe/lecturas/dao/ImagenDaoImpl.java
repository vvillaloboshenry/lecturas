/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescom.com.pe.lecturas.dao;

import gescom.com.pe.lecturas.model.Imagen;
import gescom.com.pe.lecturas.model.Usuario;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ImagenDaoImpl extends AbstractDao<Integer, Imagen> implements ImagenDao {

    public void addImagen(Imagen imagen) {
        getSession().saveOrUpdate(imagen);
    }

    public List<Imagen> imagenlist() {
        return getSession().createQuery("from Imagen").list();
    }

    public void deleteImagen(Integer usuariioId) {
        Imagen employee = (Imagen) getSession().load(
                Imagen.class, usuariioId);
        if (null != employee) {
            this.getSession().delete(employee);
        }
    }

    public Imagen updateImagen(Imagen imagen) {
        getSession().update(imagen);
        return imagen;
    }

    public Imagen getImagen(int imagen_id) {
        return (Imagen) getSession().get(Imagen.class, imagen_id);
    }

}
