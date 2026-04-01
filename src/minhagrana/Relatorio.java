/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhagrana;

import java.util.List;

/**
 *
 * @author arthur
 */
public class Relatorio {
    
    private List<Lancamento> lancamentos;

    public Relatorio(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public double calcularSaldo() {
        double total = 0;

        for (Lancamento l : lancamentos) {
            if (l instanceof Receita) {
                total += l.getValor();
            } else if (l instanceof Despesa) {
                total -= l.getValor();
            }
        }

        return total;
    }
}

