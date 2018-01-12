
package gescom.com.pe.lecturas.servicie;

import gescom.com.pe.lecturas.model.Usuario;
import java.util.List;

public interface UsuarioService {

    public void addUsuario(Usuario usuario);

    public List<Usuario> usuarioslist();

    public void deleteUsuario(Integer usuariioId);

    public Usuario updateUsuario(Usuario usuario);

    public Usuario getUsuario(int usuario_id);
}
