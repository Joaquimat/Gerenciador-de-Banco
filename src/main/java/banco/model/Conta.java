package banco.model;

import java.math.BigInteger;

public class Conta {

    private int numero;
    private String Cliente;
    private String cpf;
    private String email;
    private Long saldo;

    public Conta(int numero, String cliente, String cpf, String email, Long saldo) {
        this.numero = numero;
        Cliente = cliente;
        this.saldo = saldo;
        this.cpf = cpf;
        this.email = email;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
