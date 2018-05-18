package testes;

import Controller.daoMarca;
import Model.Marca;
import java.sql.SQLException;

public class testeMarca {
    public static void main(String[] args) {
        Marca m1 = new Marca(0, "hp");
        Marca m2 = new Marca(0, "dell");
        Marca m3 = new Marca(0, "lg");
        Marca m4 = new Marca(0, "asus");
        
        daoMarca dao = new daoMarca();
        
        try{
//            dao.addMarca(m1);
//            dao.addMarca(m2);
//            dao.addMarca(m3);
//            dao.addMarca(m4);
//            System.out.println("INSERIDOS");
            m1 = dao.getMarca(3);
            if (m1 != null){
                System.out.println(m1.getId()+
                        "\t"+m1.getNome());
                m1.setNome("samsung");
                dao.updateMarca(m1);
                dao.deleteMarca(m1);
            }else{
                System.out.println("Não AChou");
            }
            for (Marca arg : dao.getMarcaLista("h")) {
                System.out.println(arg.getId()+"\t"+
                        arg.getNome());
            }
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }                
    }
}
