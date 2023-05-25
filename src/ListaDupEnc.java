public class ListaDupEnc<T extends Comparable<T>> extends Lista<T> {

    private NoDuplo<T> inicio;
    private int tamanho;

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public NoDuplo<T> getInicio() {
        return inicio;
    }

    public void setInicio(NoDuplo<T> inicio) {
        this.inicio = inicio;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        NoDuplo<T> novoDado= new NoDuplo<>(elemento);

        if (this.inicio==null){
            this.inicio=novoDado;
            this.tamanho++;
        }else{

            NoDuplo<T> aux= this.inicio;
            for (int i = 0; i <this.tamanho-1 ; i++) {
                aux=aux.prox;
            }
            aux.prox=novoDado;
            novoDado.ant=aux;

            this.tamanho++;
        }
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {

        NoDuplo<T> novoElemento = new NoDuplo<>(elemento);
        NoDuplo aux = inicio;
        NoDuplo anterior = null;

        if (posicao == 0){
            if (tamanho != 0){
                novoElemento.prox = aux;
                aux.ant = novoElemento;
                inicio = novoElemento;
                novoElemento.ant = null;
                tamanho++;
            }else {
                inicio = novoElemento;
                tamanho++;
            }
        }else if (posicao >= tamanho || posicao < 0){
            throw new Exception("A posicao e maior ou menor que o tamanho da lista, nao existindo valor nessa posicao");
        } else {
            for (int i = 0; i < posicao-1; i++) {
                aux = aux.prox;
            }
            anterior = aux;
            aux = aux.prox;
            anterior.prox = novoElemento;
            novoElemento.ant = anterior;
            novoElemento.prox = aux;
            aux.ant = novoElemento;
            tamanho++;
        }
    }

    @Override
    public T get(int posicao) throws Exception {
        return null;
    }

    @Override
    public int get(T elemnto) throws Exception {
        return 0;
    }

    @Override
    public void remover(int posicao) throws Exception {
    }

    @Override
    public void limpar() {
    }

    @Override
    public int getTamanho() {
        return 0;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        return false;
    }

    @Override
    public Lista<T> subLista(int posInicial, int posFinal) throws Exception {

        if (posInicial>= tamanho || posFinal>= tamanho){
            throw new Exception("Tamanho das posicoes maiores que a lista!");
        }

        if (posInicial < 0 || posFinal < 0){
            throw new Exception("Posicao tem que ser maior que 0!");
        }

        ListaDupEnc listaSub = new ListaDupEnc();
        NoDuplo<T> aux = inicio;
        int cont = 0;

        while (posInicial != cont){
            aux = aux.prox;
            cont++;
        }

        if (posInicial > posFinal){

            for (int i = posInicial; i >= posFinal ; i--) {

                listaSub.incluir(aux.dado);
                aux = aux.ant;

            }
        }
        for (int i = posInicial; i <= posFinal ; i++) {

            listaSub.incluir(aux.dado);
            aux=aux.prox;
            
        }

        return listaSub;
    }

}


































































































