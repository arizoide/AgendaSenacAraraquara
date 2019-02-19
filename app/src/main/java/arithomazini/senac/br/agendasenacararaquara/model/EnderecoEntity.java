package arithomazini.senac.br.agendasenacararaquara.model;

public class EnderecoEntity {

    private Integer id;
    private String rua;
    private String numero;
    private String cidadeEstado;

    public EnderecoEntity(String rua, String numero, String cidadeEstado) {
        this.rua = rua;
        this.numero = numero;
        this.cidadeEstado = cidadeEstado;
    }

    public EnderecoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidadeEstado() {
        return cidadeEstado;
    }

    public void setCidadeEstado(String cidadeEstado) {
        this.cidadeEstado = cidadeEstado;
    }
}
