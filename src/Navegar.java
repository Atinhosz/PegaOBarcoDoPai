public class Navegar {


    public static void main(String[]args){



    Mar marNegro = new Mar("marNegro",41.5);
    Mar marMediterraneo = new Mar("marMediterraneo",100.0);
    Mar marOceanoAtlantico = new Mar("OceanoAtlantico",78.3);

    Barco x = new Barco("x","x",6,97,marMediterraneo.getForcaDoVento());

    System.out.println("PROBLEMA COM USO DA ANCORA");
    try {
        x.abaixarAncora();
    }catch (RuntimeException e){
        System.out.println(e.getMessage());
    }

        System.out.println("PROBLEMA COM O USO DO AbaixarVelas");
    try {
            x.abaixarVelas(5);
    }catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
    }

        try {
            x.abaixarVelas(2);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("PROBLEMA COM O USO DO LevantarVelas");



    try {
        x.levantarVelas(2);
        x.levantarVelas(0);
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }




    }
}
