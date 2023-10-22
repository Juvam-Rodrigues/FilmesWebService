
package br.edu.ifrn.pds.dominio;

public class Filme {
    private int id;
    private String titulo;
    private double duracao;
    private int anoLancamento;
    private double avaliacao;

    public Filme() {
    }

    public Filme(int id, String titulo, double duracao, int anoLancamento, double avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return " Filme:" + " id = " + id + ",\n título = " + titulo + ",\n duração = " + duracao + ",\n ano de lançamento = " + anoLancamento + ",\n avaliação dos críticos = " + avaliacao + '.' + '\n';
    }
   
}
