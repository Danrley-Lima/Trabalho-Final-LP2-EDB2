public class ConjuntoDisjunto<E> {
    E valor;
    int ordem;
    ConjuntoDisjunto<?> representante;

    ConjuntoDisjunto<E> makeSet(E valor) {
        this.valor = valor;
        representante = this;
        return this;
    }

    ConjuntoDisjunto<?> union(ConjuntoDisjunto<?> outro) {
        ConjuntoDisjunto<?> representante = this.find();
        ConjuntoDisjunto<?> outroRepresentante = outro.find();

        if (outroRepresentante.ordem < representante.ordem) {
            outroRepresentante.representante = representante;

            return representante;
        } else if (outroRepresentante.ordem == representante.ordem) {
            representante.representante = outroRepresentante;
            outroRepresentante.ordem++;

            return outroRepresentante;
        } else {
            representante.representante = outroRepresentante;
            return outroRepresentante;
        }
    }

    public ConjuntoDisjunto<?> find() {
        if (this.representante == this) {
            return this;
        } else {
            return this.representante.find();
        }
    }

    public void resetaRepresentante() {
        this.representante = this;
    }

    @Override
    public String toString() {
        return "" + valor;
    }
}
