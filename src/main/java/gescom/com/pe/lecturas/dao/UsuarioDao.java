/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescom.com.pe.lecturas.dao;

import gescom.com.pe.lecturas.model.Usuario;
import java.util.List;

/**
 *
 * @author GescomWeb
 */
public interface UsuarioDao {

    public void addUsuario(Usuario usuario);

    public List<Usuario> usuarioslist();

    public void deleteUsuario(Integer usuariioId);

    public Usuario updateUsuario(Usuario usuario);

    public Usuario getUsuario(int usuario_id);
}
