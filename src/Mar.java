public class Mar {


    private double forcaDoVento ;
    String nomeDoMar;

    public Mar(String nomeDoMar,double forcaDoVento){
        this.forcaDoVento = forcaDoVento;
        this.nomeDoMar = nomeDoMar;

    }

    public double getForcaDoVento() {
        return forcaDoVento;
    }



    public void mudarForçaDoVento(double novaForca){
       forcaDoVento = novaForca;
    }


}
