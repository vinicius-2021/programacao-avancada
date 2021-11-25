/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jdhein
 */
public class Usuario {
     private int id;
    private String nome;
    private String cpf;
    
    private String nascimento;
    private String genero;

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getVacinasFazer() {
        return VacinasFazer;
    }

    public void setVacinasFazer(String VacinasFazer) {
        this.VacinasFazer = VacinasFazer;
    }

    public String getDataRealizada() {
        return DataRealizada;
    }

    public void setDataRealizada(String DataRealizada) {
        this.DataRealizada = DataRealizada;
    }

    public String getDataMarcada() {
        return DataMarcada;
    }

    public void setDataMarcada(String DataMarcada) {
        this.DataMarcada = DataMarcada;
    }

    public String getProximaVacina() {
        return ProximaVacina;
    }

    public void setProximaVacina(String ProximaVacina) {
        this.ProximaVacina = ProximaVacina;
    }
    
    private String Nome;
    private String Sigla;
    private String Cidade;
        private String    Cep;
          private String  Endereco;
         private String   VacinasFazer;
         private String   DataRealizada;
         private String   DataMarcada;
         private String   ProximaVacina;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLogin(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSenha(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}