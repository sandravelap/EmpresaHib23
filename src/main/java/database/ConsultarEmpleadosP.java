package database;

import entities.EmpleadosEntity;
import entitiesP.DepartamentosEntityP;
import entitiesP.EmpleadosEntityP;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import libs.Leer;

import java.util.List;

public class ConsultarEmpleadosP {
    public static void leerEmpleados(EntityManager em) {
        EmpleadosEntityP e = em.find(EmpleadosEntityP.class,7499);
        System.out.println(e.getApellido() + " el " + e.getOficio());
        List<EmpleadosEntityP> es = em.createQuery("from EmpleadosEntityP where deptNo = 20",  EmpleadosEntityP.class).getResultList();
        for (EmpleadosEntityP elist : es){
            System.out.println(elist.getApellido());
        }
    }
    public static void modificarEmpleado(EntityManager em){
        EntityTransaction transaction = em.getTransaction();
        //comenzamos a crear el contexto de persistencia
        transaction.begin();
        EmpleadosEntityP e = em.createQuery("from EmpleadosEntityP where apellido like 'ARROYO'", EmpleadosEntityP.class).getSingleResult();
        //a partir de aquí trabajamos sobre el objeto instanciado que representa un registro de la base de datos
        System.out.println("Salario anterior: "+ e.getSalario());
        e.setSalario(e.getSalario()+100);
        System.out.println("Salario actual: " + e.getSalario());
        System.out.println("Departamento anterior: " +e.getDepartamentosByDeptNo().getDnombre());
        //recuperamos un objeto Departamento con el nuevo departamento
        String nombreNuevoDep = Leer.pedirCadena("Introduce el nombre del nuevo departamento: ").toUpperCase();
        Query queryDep = em.createQuery("from DepartamentosEntityP where dnombre = :nombreDep");
        queryDep.setParameter("nombreDep", nombreNuevoDep);
        DepartamentosEntityP nuevoDep = (DepartamentosEntityP) queryDep.getSingleResult();
        e.setDepartamentosByDeptNo(nuevoDep);
        //al hacer el commit los cambios se pasan a la base de datos
        transaction.commit();
    }
    public static void crearEmpleadoP(EntityManager em){
        EntityTransaction transaction = em.getTransaction();
        //comenzamos a crear el contexto de persistencia
        transaction.begin();
        EmpleadosEntityP e = new EmpleadosEntityP();
        e.setApellido("VELAS");
        e.setOficio("PROFE");
        Query queryDep = em.createQuery("from DepartamentosEntityP where dnombre = 'VENTAS'");
        DepartamentosEntityP nuevoDep = (DepartamentosEntityP) queryDep.getSingleResult();
        e.setDepartamentosByDeptNo(nuevoDep);
        //e.setEmpNo((short)7000);
        em.persist(e);
        transaction.commit();
    }
}
