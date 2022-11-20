public class ConjuntoDisjunto<E> {
        E valor;
        int ordem;
        ConjuntoDisjunto<?> representante;

    ConjuntoDisjunto<E> MakeSet(E valor) {
        this.valor = valor;
        representante = this;
        return this;
    }

    ConjuntoDisjunto<?> Union(ConjuntoDisjunto<?> outro){
        ConjuntoDisjunto<?> representante = this.Find();
        ConjuntoDisjunto<?> outroRepresentante = outro.Find();//outroRepresetante
        
        System.out.println(representante);
        if(outroRepresentante.ordem < representante.ordem){//se a ordem do outro representante for menor que o representante da casa atual
            outroRepresentante.representante = representante;//"representante? o representante do outro conjunto passa a ser o representante do atual
            return representante;
        }
        else if (outroRepresentante.ordem == representante.ordem){///se a ordem dos conjuntos forem iguais
            representante.representante = outroRepresentante;//o representante do outro conjunto se torna o representante do atual
            outroRepresentante.ordem++;//Ordem do representante do outro conjunto cresce. (não deveria ser outroRepresentante.ordem += representante.ordem?
            return outroRepresentante;
        }
        else{//se a ordem do representante atual for menor que o representante do outro conjunto
            representante.representante = outroRepresentante;//representante do outro conjunto se torna representante do conjunto atual
            return outroRepresentante;
        }
    }

    ConjuntoDisjunto<?> Find(){
        if(this.representante == this){
            return this;
        }
        else{
            return this.representante.Find();
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
    	 return "" + valor;
     }
}
