/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhagrana;

import java.time.LocalDate;

/**
 *
 * @author arthur
 */
public class Receita extends Lancamento {
        
        private String origem;
        
    public Receita(double valor, LocalDate data, String descricao, String origem) {
        super(valor, data, descricao);
        this.origem = origem;
    }

    

   

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
}
