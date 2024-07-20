package Aplicacao;

import Entidades.Comentario;
import Entidades.Postagem;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Aplicativo {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Comentario c1 = new Comentario("Tenha uma boa viagem!");
        Comentario c2 = new Comentario("Volte logo!");
        Postagem p1 = new Postagem(sdf.parse("21/06/2024 13:05:44"), "Teste", "Descrição teste", 12);
        
        p1.addComentario(c1);
        p1.addComentario(c2);
        
        System.out.println(p1); 
    }
    
}
