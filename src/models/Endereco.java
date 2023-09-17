package models;

public class Endereco {
    private String nomeDeRua;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    //Professora pediu para ser String
    private String numero;
    private String complemente;

    public Endereco(String nomeDeRua, String cidade, String estado, String pais, String cep, String numero, String complemente) {
        this.nomeDeRua = nomeDeRua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.numero = numero;
        this.complemente = complemente;
    }

    public String getNomeDeRua() {
        return nomeDeRua;
    }

    public void setNomeDeRua(String nomeDeRua) {
        this.nomeDeRua = nomeDeRua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemente() {
        return complemente;
    }

    public void setComplemente(String complemente) {
        this.complemente = complemente;
    }

    @Override
    public String toString() {
        return
                "\n Rua: " + nomeDeRua +
                "\n Cidade: " + cidade +
                "\n Estado: " + estado +
                "\n País: " + pais +
                "\n CEP: " + cep +
                "\n Número: " + numero +
                "\n Complemento: " + complemente;
    }

}
