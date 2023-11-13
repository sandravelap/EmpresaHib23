import database.EmfSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


import static database.ConsultarEmpleados.*;
import static database.ConsultarEmpleadosClase.leerEmps;

public class Main {
    //Contexto de persistencia haciendo uso del singleton
    static EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        leerEmps(em);
        modificarEmpleado(em);
        insertarEmpleado(em);
        desconectar();
    }

    private static void desconectar() {
        em.close();
        emf.close();
    }


}
