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
