package gescom.com.pe.lecturas.controller;

import gescom.com.pe.lecturas.model.Imagen;
import gescom.com.pe.lecturas.model.Usuario;
import gescom.com.pe.lecturas.servicie.ImagenService;
import gescom.com.pe.lecturas.servicie.UsuarioService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    @Autowired
    private ImagenService service1;
    String folderPhysical = "C:/files/img/";
    String folderLogic = "img/";

    @GetMapping("/usuario/nuevo")
    public ModelAndView showform() {
        return new ModelAndView("usuario/nuevo", "command", new Usuario());
    }

    @PostMapping(value = "usuario/uploadFile")
    public String AgregarUsuario(@RequestParam("nombreuser") String name, @RequestParam("direccion") String direccion,
            @RequestParam("telefono") String telefono, @RequestParam("file") CommonsMultipartFile file,
            HttpServletRequest req) throws IOException {
        new File("C:/files").mkdir();
        new File("C:/files/img").mkdir();
        String nombreImagen = "";
        if (!file.isEmpty()) {
            nombreImagen = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Imagen imagen = new Imagen();
            imagen.setNombre(nombreImagen);
            imagen.setUrl(folderLogic + nombreImagen);
            String base64 = DatatypeConverter.printBase64Binary(bytes);
            imagen.setDataimg(base64);
            service1.addImagen(imagen);

            Usuario usuario = new Usuario();
            usuario.setIdimagen(imagen);
            usuario.setNombre(name);
            usuario.setTelefono(telefono);
            usuario.setDireccion(direccion);
            service.addUsuario(usuario);

            Path path = Paths.get(folderPhysical + nombreImagen);
            Files.write(path, bytes);
        }
        return "redirect:/usuario/";
    }

    @GetMapping(value = {"/usuario/", "/usuario/list", "/usuario/index"})
    @ResponseBody
    public ModelAndView listUsuario(ModelAndView model) throws IOException {
        List<Usuario> usuarios = service.usuarioslist();
        model.addObject("usuarioList", usuarios);
        model.setViewName("usuario/index");
        return model;
    }

    @GetMapping(value = {"/usuario/U/{id}"})
    @ResponseBody
    public ModelAndView UpdateUser(@PathVariable int id, ModelAndView model) {
        Usuario usuario = service.getUsuario(id);
        model.addObject("usuario", usuario);
        model.setViewName("usuario/edit");
        return model;
    }

    @GetMapping(value = {"/usuario/D/{id}"})
    @ResponseBody
    public ModelAndView DeleteUser(@PathVariable int id, ModelAndView model) {
        service.deleteUsuario(id);
        model.addObject("message", "Ususario Eliminado");
        model.setViewName("usuario/index");
        return model;
    }
}
