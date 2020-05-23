package model.dal_pedidos;

public class Pedidos {

    private String protocolo;
    private String quantidade;

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    private String preco;
    private String dataAberturaDoPedido;
    private String dataFechamentoDoPedido;

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDataAberturaDoPedido() {
        return dataAberturaDoPedido;
    }

    public void setDataAberturaDoPedido(String dataAberturaDoPedido) {
        this.dataAberturaDoPedido = dataAberturaDoPedido;
    }

    public String getDataFechamentoDoPedido() {
        return dataFechamentoDoPedido;
    }

    public void setDataFechamentoDoPedido(String dataFechamentoDoPedido) {
        this.dataFechamentoDoPedido = dataFechamentoDoPedido;
    }
}