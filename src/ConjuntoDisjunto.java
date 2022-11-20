/*
 * TEMOS QUE DISCUTIR UMAS COISAS
 * 1 - NOME DAS VARIÁVEIS DESSE CÓDIGO
 * 2 - DAR UMA MODELADA NO PROBLEMA, DEFINIR CLASSES E INTERFACES
 * 3 - DISCUTIR POSSÍVEIS SOLUÇÕES, JÁ TENHO UMA PENSADA PRAS ÁRVORES MÍNIMAS GERADAS
 * 4 - como isso afeta o grêmio
 * */

public class ConjuntoDisjunto<E> {
        E value;
        int ordem;
        ConjuntoDisjunto<?> eu;

    ConjuntoDisjunto<E> MakeSet(E valor) {
        this.value = valor;
        eu = this;//adicionei isso pq o "eu" é o representante e não estava sendo inicializado
        return this;
    }

    ConjuntoDisjunto<?> Union(ConjuntoDisjunto<?> outro){
        ConjuntoDisjunto<?> representante = this.Find();
        ConjuntoDisjunto<?> guardar = outro.Find();//outroRepresetante
        System.out.println(representante);
        if(guardar.ordem < representante.ordem){//se a ordem do outro representante for menor que o representante da casa atual
            guardar.eu = representante;//"eu? o representante do outro conjunto passa a ser o representante do atual
            return representante;
        }
        else if (guardar.ordem == representante.ordem){///se a ordem dos conjuntos forem iguais
            representante.eu = guardar;//o representante do outro conjunto se torna o representante do atual
            guardar.ordem++;//Ordem do representante do outro conjunto cresce. (não deveria ser guardar.ordem += representante.ordem?
            return guardar;
        }
        else{//se a ordem do representante atual for menor que o representante do outro conjunto
            representante.eu = guardar;//representante do outro conjunto se torna representante do conjunto atual
            return guardar;
        }
    }

    ConjuntoDisjunto<?> Find(){
        if(this.eu == this){
            return this;
        }
        else{
            return this.eu.Find();
        }
    }

     static boolean areMerged(ConjuntoDisjunto<?>c1, ConjuntoDisjunto<?> c2){
        if(c1.Find() == c2.Find()){
            return true;
        }
        else{
            return false;
        }
    }
     
     @Override
     public String toString(){
    	 return "" + value;
     }
}