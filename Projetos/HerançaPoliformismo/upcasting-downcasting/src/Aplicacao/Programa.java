package Aplicacao;

import Entidades.Conta;
import Entidades.ContaEmpresarial;
import Entidades.ContaPoupanca;

public class Programa {

    public static void main(String[] args) {

        Conta conta = new Conta(1001, "Vitor", 0.0);
        ContaEmpresarial contaEmpresarial = new ContaEmpresarial(1002,"Jaqueline", 0.0, 500.00);

        //UPCASTING é eu pegar um subClasse e atribuilo para uma superClasse
        Conta conta1 = contaEmpresarial;
        Conta c2 = new ContaEmpresarial(1003,"Gustavo", 0.0, 200.00);
        Conta c3 = new ContaPoupanca(1004,"Anna", 0.0, 0.01);

        //DOWNCASTING converter um obj da superClasse para a subClasse
        ContaEmpresarial contaEmpresarial2 = (ContaEmpresarial) c2;
        contaEmpresarial2.emprestimo(100.00);

       //ContaEmpresarial contaEmpresarial3 = (ContaEmpresarial) c3;
        if(c3 instanceof ContaEmpresarial){

            ContaEmpresarial contaEmpresarial3 = (ContaEmpresarial) c3;
            contaEmpresarial3.emprestimo(200.00);
            System.out.println("Emprestimo!");

        }

        if(c3 instanceof ContaPoupanca){

            ContaPoupanca contaEmpresarial3 = (ContaPoupanca) c3;
            contaEmpresarial3.atualizarSaldo();
            System.out.println("Atualizado!");

        }
    }
}
