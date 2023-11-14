package database;

import entities.DepartamentosEntity;
import entities.EmpleadosEntity;
import entitiesP.EmpleadosEntityP;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class ConsultarEmpleados {
    public static void leerEmpleados(EntityManager em) {
        EmpleadosEntity e = em.find(EmpleadosEntity.class,7499);
        System.out.println(e.getApellido() + " el " + e.getOficio());
        List<EmpleadosEntity> es = em.createQuery("from EmpleadosEntity where deptNo = 20",  EmpleadosEntity.class).getResultList();
        for (EmpleadosEntity elist : es){
            System.out.println(elist.getApellido());
        }
    }
    public static void modificarEmpleado(EntityManager em){
        EntityTransaction transaction = em.getTransaction();
        //comenzamos a crear el contexto de persistencia
        transaction.begin();
        EmpleadosEntity e = em.createQuery("from EmpleadosEntity where apellido like 'ARROYO'", EmpleadosEntity.class).getSingleResult();
        //a partir de aquí trabajamos sobre el objeto instanciado que representa un registro de la base de datos
        System.out.println("Salario anterior: "+ e.getSalario());
        e.setSalario(e.getSalario()+1000);
        System.out.println("Salario actual: " + e.getSalario());
        //al hacer el commit los cambios se pasan a la base de datos
        transaction.commit();
    }
    public static void crearEmpleado(EntityManager em){
        EntityTransaction transaction = em.getTransaction();
        //comenzamos a crear el contexto de persistencia
        transaction.begin();
        EmpleadosEntity e = new EmpleadosEntity();
        e.setApellido("VELAS");
        e.setOficio("PROFE");
        e.setDeptNo((byte) 10);
        //e.setEmpNo((short) 5);
        em.persist(e);
        transaction.commit();
    }
}
