/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescom.com.pe.lecturas.controller;

import gescom.com.pe.lecturas.model.Imagen;
import gescom.com.pe.lecturas.model.Usuario;
import gescom.com.pe.lecturas.servicie.ImagenService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImagenController {

    @Autowired
    private ImagenService service;
    String folderPhysical = "C:/files/img/";
    String folderLogic = "img/";

    @GetMapping("/imagen/nuevo")
    public ModelAndView showForm() {
        return new ModelAndView("imagen/nuevo");
    }

    @GetMapping(value = {"/imagen/", "/imagen/list", "/imagen/index"})
    @ResponseBody
    public ModelAndView listImagen(ModelAndView model) throws IOException {
        /**
         * List<Imagen> usuarios = service.imagenlist();
         * model.addObject("imagenList", usuarios);
         *
         */
        model.setViewName("imagen/index");
        return model;
    }
    //BindingResult --- si hay un error en el formulario entonces enviar un mensaje del error 
    //<form:errors path="nombre.*">

    @PostMapping(value = {"/imagen/uploadFile", "/imagen/#"})
    public ModelAndView agregarFoto(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req,
            ModelAndView model) throws IOException {
        if (!file.isEmpty()) {
            String nombreImagen = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Imagen imagen = new Imagen();
            imagen.setNombre(nombreImagen);
            imagen.setUrl(folderLogic + file.getOriginalFilename());
            //String base64 = DatatypeConverter.printBase64Binary(bytes);
            imagen.setDataimg(folderLogic + file.getOriginalFilename());
            service.addImagen(imagen);
            Path path = Paths.get(folderPhysical + nombreImagen);
            Files.write(path, bytes);

        }

        model.setViewName("redirect:/imagen/nuevo");
        return model;
    }
}
