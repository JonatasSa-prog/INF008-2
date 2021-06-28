import java.util.ArrayList;

public class CompararMapaCor {

    ArrayList<MapaRGB> mapasAux = new ArrayList<MapaRGB> ();

    public ArrayList<MapaRGB> getImagemPorLuminosidade(MapasRGB mapas,int red, int green, int blue, double pctMinimo, double limiarSimilaridade){
        

        int max,min,aux;
        CorRGB cor = new CorRGB(red,green,blue);
        aux = (int) Math.round(cor.getLuminosidade() * (pctMinimo/100) );
        max = (int) (cor.getLuminosidade() + aux);
        min = (int) (cor.getLuminosidade() - aux);
        
        int vet[] = mapas.comparar(max,min);
        
        for(int i = 0; i < vet.length; i++){
            double tamanho = mapas.getMapaRGB(i).getAltura() * mapas.getMapaRGB(i).getLargura();
            int pctAux = (int) ((tamanho - vet[i]) / tamanho * 100);
            if((100 - pctAux) >= pctMinimo / 100)
                mapasAux.add((MapaRGB) mapas.getMapaRGB(i));        
            }

        return mapasAux;
        /*for(int i = 0; i < mapasAux.size(); i++){
            System.out.println("Mapa Araaylist " + i + ":");
            mapasAux.get(i).status();
        }*/
    }

    public void addMapasAux(MapaRGB mapa){
        mapasAux.add(mapa);
    }

    public void getMapasAux(int num){
        mapasAux.get(num);
    }

    public void statusMapaAux(){
        for(int i = 0; i < mapasAux.size(); i++){
            System.out.println("Mapa " + i + ":");
            mapasAux.get(i);
        }
    }

}
