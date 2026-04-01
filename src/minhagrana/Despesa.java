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
public class Despesa extends Lancamento {
        
        private Categoria categoria;
    
    public Despesa(double valor, LocalDate data, String descricao, Categoria categoria) {
        super(valor, data, descricao);
        this.categoria = categoria;
    }

    

    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
