package database;

import entities.EmpleadosEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ConsultarEmpleadosClase {
    public static void leerEmps(EntityManager em) {
        EmpleadosEntity e = em.find(EmpleadosEntity.class, 7499);
        //System.out.println(e.getApellido()+ e.getDepartamentosByDeptNo().getDnombre());
        String jpql = "from EmpleadosEntity where deptNo = 20";
        List<EmpleadosEntity> es = em.createQuery(jpql,  EmpleadosEntity.class).getResultList();
        EmpleadosEntity e2 = em.createQuery("from EmpleadosEntity where empNo=7369", EmpleadosEntity.class).getSingleResult();
    }
}

