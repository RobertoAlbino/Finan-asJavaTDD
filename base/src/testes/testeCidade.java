
package testes;

import Controller.daoCidade;
import Model.Cidade;
import java.sql.SQLException;
import tipos.tipoSigla;

public class testeCidade {
    public static void main(String[] args) {
        Cidade c1 = new Cidade(0, "criciuma", tipoSigla.SC);
        Cidade c2 = new Cidade(0, "sao paulo", tipoSigla.SP);
        Cidade c3 = new Cidade(0, "salvador", tipoSigla.BA);
        Cidade c4 = new Cidade(0, "belo horizonte", tipoSigla.MG);
        
        daoCidade dao = new daoCidade();
        
        try {
/*            
            System.out.println(dao.addCidade(c1) > 0 ? "Inserido" : "Não Inserido");
            System.out.println(dao.addCidade(c2) > 0 ? "Inserido" : "Não Inserido");
            System.out.println(dao.addCidade(c3) > 0 ? "Inserido" : "Não Inserido");
            System.out.println(dao.addCidade(c4) > 0 ? "Inserido" : "Não Inserido");
            
            c1 = dao.getCidade(3);
            if (c1 == null){
                System.out.println("Não achou");
            }else{
                c1.setNome("curitiba");
                c1.setSigla(tipoSigla.PR);
                dao.updateCidade(c1);
            }
            System.out.println(dao.deleteCidade(c1) > 0?"Removido":"Não Localizado");
*/
            for (Cidade cidade : dao.getCidadeList("m")) {
                System.out.println(cidade.getId()+"\t"+
                        cidade.getNome()+"\t"+
                        cidade.getSigla());
            }
        } catch (SQLException e) {
        }
    }
    
}
