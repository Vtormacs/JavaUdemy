package Entidades;

import Entidades.enums.NivelDoTrabalho;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {

    private String nome;
    private NivelDoTrabalho nivel;
    private Double salarioBase;

    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, NivelDoTrabalho nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelDoTrabalho getNivel() {
        return nivel;
    }

    public void setNivel(NivelDoTrabalho nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }

    public void adicionarContrato(ContratoPorHora contrato) {
        contratos.add(contrato);
    }

    ;
    
    public void removerContrato(ContratoPorHora contrato) {
        contratos.remove(contrato);
    };
    
    public double renda(int ano, int mes) {

        double soma = salarioBase;
        Calendar calendario = Calendar.getInstance();
        for (ContratoPorHora c : contratos) {
            calendario.setTime(c.getData());
            int c_ano = calendario.get(Calendar.YEAR);
            int c_mes = 1 + calendario.get(Calendar.MONTH);
            if (ano == c_ano && mes == c_mes) {
                soma += c.valorTotal();
            }
        }
        return soma;
    };
}
