package unitec;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by campitos on 29/07/15.
 */

@Configuration
public class ServicioProfesor {
    @Inject
    MongoTemplate mongoTemplate;

    public void agregarProfesor(Profesor u){
        if(!mongoTemplate.collectionExists(Profesor.class)){
            mongoTemplate.createCollection(Profesor.class);
        }
        System.out.println("bien");
        mongoTemplate.insert(u);
    }

    public void borrarColeccion(){
        mongoTemplate.dropCollection(Profesor.class);
    }

    public List<Profesor> getTodos(){
        List<Profesor> registros=new ArrayList<Profesor>();
        registros=mongoTemplate.findAll(Profesor.class);
        return registros;
    }

    public Profesor getPorId(Integer id){
        Profesor Profesor =mongoTemplate.findById(id, Profesor.class);
        return Profesor;
    }
}
