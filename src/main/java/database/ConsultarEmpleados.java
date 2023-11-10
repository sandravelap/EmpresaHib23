package database;

import entities.DepartamentosEntity;
import entities.EmpleadosEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
        //System.out.println("Departamento anterior: " );
        //recuperamos un objeto Departamento con el nuevo departamento
        //DepartamentosEntity nuevoDep = em.createQuery("from DepartamentosEntity where deptNo = 30", DepartamentosEntity.class).getSingleResult();
        //e.setDepartamentosByDeptNo(nuevoDep);
        //al hacer el commit los cambios se pasan a la base de datos
        transaction.commit();
    }
}
