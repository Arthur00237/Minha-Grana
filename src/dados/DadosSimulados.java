
package dados;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import minhagrana.*;

public class DadosSimulados {
    
    private static List<Lancamento> lancamentos = new ArrayList<>();
    private static List<Categoria> categorias = new ArrayList<>();
    private static int nextId = 1;
    
    static {
        categorias.add(new Categoria(1, "Alimentacao"));
        categorias.add(new Categoria(2, "Transporte"));
        categorias.add(new Categoria(3, "Moradia"));
        categorias.add(new Categoria(4, "Saude"));
        categorias.add(new Categoria(5, "Lazer"));
        
        Receita r1 = new Receita(2500.0, LocalDate.now(), "Salario", "Empresa XYZ");
        r1.setId(nextId++);
        lancamentos.add(r1);
        
        Despesa d1 = new Despesa(35.0, LocalDate.now(), "Almoco", categorias.get(0));
        d1.setId(nextId++);
        lancamentos.add(d1);
    }
    
    public static List<Lancamento> getLancamentos() {
        return lancamentos; 
    }
    public static List<Categoria> getCategorias() {
        return categorias; 
    }
    
    public static void adicionar(Lancamento l) {
        l.setId(nextId++);
        lancamentos.add(l);
    }
    public static void adicionarCategoria(minhagrana.Categoria c){
        c.setId(nextId++);
        categorias.add(c);
    }
    
    public static double getSaldo() {
        double total = 0;
        for (Lancamento l : lancamentos) {
            if (l instanceof Receita) total += l.getValor();
            else total -= l.getValor();
        }
        return total;
    }
    
    public static double getTotalReceitas() {
        double total = 0;
        for (Lancamento l : lancamentos)
            if (l instanceof Receita) total += l.getValor();
        return total;
    }
    
    public static double getTotalDespesas() {
        double total = 0;
        for (Lancamento l : lancamentos)
            if (l instanceof Despesa) total += l.getValor();
        return total;
    }
}
