/*

  ____          _____               _ _           _       
 |  _ \        |  __ \             (_) |         | |      
 | |_) |_   _  | |__) |_ _ _ __ _____| |__  _   _| |_ ___ 
 |  _ <| | | | |  ___/ _` | '__|_  / | '_ \| | | | __/ _ \
 | |_) | |_| | | |  | (_| | |   / /| | |_) | |_| | ||  __/
 |____/ \__, | |_|   \__,_|_|  /___|_|_.__/ \__, |\__\___|
         __/ |                               __/ |        
        |___/                               |___/         
    
____________________________________
/ Si necesitas ayuda, contáctame en \
\ https://parzibyte.me               /
 ------------------------------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||
Creado por Parzibyte (https://parzibyte.me). Este encabezado debe mantenerse intacto,
excepto si este es un proyecto de un estudiante.
*/
package me.parzibyte.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/alumnos")
@CrossOrigin(origins = "http://localhost")
public class AlumnosController {
    @Autowired
    private AlumnosRepository alumnosRepository;

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnosRepository.save(alumno);
    }

    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    public Iterable<Alumno> obtenerTodos() {
        return alumnosRepository.findAll();
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable() Long id) {
        alumnosRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public Alumno editar(@RequestBody Alumno alumno) {
        return alumnosRepository.save(alumno);
    }
}
