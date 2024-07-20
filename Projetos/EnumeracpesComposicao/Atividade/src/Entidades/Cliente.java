package Entidades;

import java.util.Date;

public class Cliente {
    
    private String nome;
    private String email;
    private Date aniversarioData;

    public Cliente() {
    }

    public Cliente(String nome, String email, Date aniversarioData) {
        this.nome = nome;
        this.email = email;
        this.aniversarioData = aniversarioData;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAniversarioData() {
        return aniversarioData;
    }

    public void setAniversarioData(Date aniversarioData) {
        this.aniversarioData = aniversarioData;
    }
}
