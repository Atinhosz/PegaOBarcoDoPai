import java.util.Random;

public class Barco {

    private String nomeDoBarco;
    private String nomeDoCapitao;
    //String timão;
    private int totalDeVelas;
    private int velasAbaixadas;
    private boolean isVelaAbaixada = false;
    private double velocidade;
    private boolean ancoraLevantada;
    private int marinheiros;
    private double marForcaDoVento;

    public Barco(String nomeDoBarco, String nomeDoCapitao, int velas, int marinheiros, double marForcaDoVento) {
        this.totalDeVelas = velas;
        this.marinheiros = marinheiros;
        this.nomeDoBarco = nomeDoBarco;
        this.nomeDoCapitao = nomeDoCapitao;
        this.marForcaDoVento = marForcaDoVento;
    }

    //-----------ANCORA--------------//

    void levantarAncora() {
        if (ancoraLevantada == true) {
            throw new RuntimeException("Ocorreu um problema: Ancora ja está levantada");
        }  else{
            ancoraLevantada = true;
            System.out.println("MARUJOS LEVANTEM A ANCORA!! ESTA NA HORA DE ZARPAR");
        }
        atualizandoVelocidade();

    }

    void abaixarAncora() {
        if (ancoraLevantada == false) {
            throw new RuntimeException("Ocorreu um problema: Aconcora ja está abaixada");
        }else{
            ancoraLevantada = false;
            System.out.println("VAMOS FICAR POR AQUI, ABAIXEM ESSA ANCORA");
        }
        atualizandoVelocidade();
    }

    //------------VELAS--------------//

    public void abaixarVelas(int velasAAbaixar){
        if(velasAbaixadas - velasAAbaixar  > 0 ||  totalDeVelas < velasAAbaixar || velasAAbaixar + velasAbaixadas > totalDeVelas || velasAAbaixar <= 0){
            throw new IllegalArgumentException("Ocorreu um problema : O numero de velas à abaixar é muito alto ou muito baixo");
        } else {
                isVelaAbaixada = true;
                this.velasAbaixadas = velasAAbaixar + velasAbaixadas;
                System.out.println(this.nomeDoBarco + " ABAIXEM AS VELAS!!!");
        }
     atualizandoVelocidade();
    }





    public void levantarVelas(int velasLevantadas) {
        if(isVelaAbaixada == false || velasLevantadas < velasLevantadas || velasLevantadas <= 0){
            throw new IllegalArgumentException("Ocorreu um problema : O numero de velas a levantar é muito alto ou muito baixo");
        } else {
            this.velasAbaixadas = velasAbaixadas - velasLevantadas;
            System.out.println(this.nomeDoBarco + " LEVANTEM AS VELAS!!!");
             if(velasAbaixadas == 0){
                isVelaAbaixada = false;
             }
        }
        atualizandoVelocidade();
    }

    int getVelasAbaixadas(){
        return velasAbaixadas;
    }

    //---------------------------------//


    double getVelocidade() {
        return velocidade;
    }


    void atualizandoVelocidade() {
        velocidade = velasAbaixadas * marForcaDoVento;
        if (ancoraLevantada == false) {
            velocidade = 0;
        }
    }


    //-------------COISASNADAVER------------------//

    Random random = new Random();


    private int galpaoDePeixes = 0;
    int numero = random.nextInt(15);

    public int pescar() {
        galpaoDePeixes = galpaoDePeixes + numero;
        System.out.println("Você pescou " + numero);
        return galpaoDePeixes;
    }

    public int getGalpaoDePeixes() {
        return galpaoDePeixes;
    }

    public void comer(int peixesComidos) {
        if (peixesComidos <= galpaoDePeixes && galpaoDePeixes > 0) {
            this.galpaoDePeixes = galpaoDePeixes - peixesComidos;
            System.out.println("Esse peixe tava bom demais!!!!");
        }else {
            System.out.println("Não tem peixe para comer ;-;");
        }
        verSeAcabouOpeixe();
    }

    public void verSeAcabouOpeixe(){
        if(galpaoDePeixes == 0){
            System.out.println("Cabo o peixe ;-;");
        }else {
             System.out.println("de peixes ainda temos " + galpaoDePeixes);
        }
    }


    /////////////////////////////////////////////////////////////











}
