
package e2p1_kelvinmelgar;

import java.util.ArrayList;

/**
 *
 * @author kelvi
 */
public final class MaquinaEstados {
    
    private ArrayList<String> estados;
    private ArrayList<String> estados_aceptacion;
    private ArrayList<String> aristas;
    private String estado_actual;
    
    MaquinaEstados(String estados, String aristas){
        
        this.estados = this.splitStr(estados, ';');
        this.aristas = this.splitStr(aristas, ';');
        
        estado_actual = this.estados.get(0);
        
        estados_aceptacion = new ArrayList<>();
        this.extractAcceptNodes();
       
    }
    
    public ArrayList<String> getEstados(){
        return estados;
    }
    
    public ArrayList<String> getEstados_aceptacion(){
        return estados_aceptacion;
    }
    
    public ArrayList<String> getArista(){
        return aristas;
    }
    
    public String getEstado_actual(){
        return estado_actual;
    }
    
    public  void setEstados(ArrayList<String> a){
        this.estados = a;
    }
    
    public void setEstados_aceptacion(ArrayList<String> a){
        this.estados_aceptacion = a;
    }
    
    public void setArista(ArrayList<String> a){
        this.aristas = a;
    }
    
    public void setEstado_actual(String a){
        this.estado_actual = a;
    }
    
    
    public ArrayList<String> splitStr(String str, char delim){
        
        ArrayList<String> temp = new ArrayList<>();
        
        String sub_str = "";
        //recorre el string
        for (int i = 0; i < str.length(); i++) {
            
            //si no es el delimitador lo agrega al sub String
            if(str.charAt(i) != delim){
                
                sub_str += str.charAt(i);
                
                //si es la ultima iteracion la agrega a la lista el sub string
                if(str.length() - i == 1){
                    temp.add(sub_str);
                }
            }else{
                //agrega lo que tiene el sub string y lo resetea
                temp.add(sub_str);
                sub_str = "";
            }
        }
        
        
        
        return temp;
    }
    
    
    public void extractAcceptNodes(){
        
        //recorre los estados
        for (int i = 0; i < estados.size(); i++) {
            
            String est = estados.get(i);
            
            //si tiene un punto lo agrega a la lista de aceptacion y lo modifica en los estados
            if(est.charAt(0) == '.'){
                est = est.substring(1);
                
                estados_aceptacion.add(est);
                
                estados.set(i, est);
                
            }
            
            
        }
        
        
    }
    
    
    public String computeStr(String str){
        this.setEstado_actual(estados.get(0));
        
        String cadena = "";
        
        boolean paso = false;
        String[] arist = new String[3];
        
        //recorre el string para evaluar
        for (int i = 0; i < str.length(); i++) {
            
            //recorre la lista de arista para comprobar si puede seguir
            for (int j = 0; j < aristas.size(); j++) {
                arist = aristas.get(j).split(",");
                
                //condicion mira si estado actual actual esta en  la arista y si tiene un valor para moverse a otra posicion
                if(this.getEstado_actual().equals(arist[0]) && str.charAt(i) == arist[1].charAt(0)){
                    paso = true;
                    break;
                }
                
            }
            
            
            if(paso){
                //aniade a la cadena
                cadena += arist[0] + ": " + arist[1] + " -> " + arist[2];
                
                //setea el estado actual
                this.setEstado_actual(arist[2]);
                
            }else{
                
                
                return cadena + "\nRECHAZADO";
                
            }
            
            cadena += "\n";
            
        }
        
        //Condicion para ver si es aceptada
        if(this.getEstados_aceptacion().contains(this.getEstado_actual())){
            
            cadena += "\nACEPTADO";
            
        }else
            cadena += "\nRECHAZADO";
        
        
        return cadena;    
    }
    
}
