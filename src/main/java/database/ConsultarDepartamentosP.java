package database;

import entities.DepartamentosEntity;
import entitiesP.DepartamentosEntityP;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ConsultarDepartamentosP {
    public static void leerDepartamentosP(EntityManager em) {
        Query query = em.createQuery("from DepartamentosEntityP");
        List<DepartamentosEntityP> deps = query.getResultList();
        for (DepartamentosEntityP d : deps){
            System.out.println(d.getDnombre());
        }
    }
}
