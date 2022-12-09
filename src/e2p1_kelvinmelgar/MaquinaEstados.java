
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
        for (int i = 0; i < str.length(); i++) {
            
            if(str.charAt(i) != delim){
                
                sub_str += str.charAt(i);
                
                if(str.length() - i == 1){
                    temp.add(sub_str);
                }
            }else{
                
                temp.add(sub_str);
                sub_str = "";
            }
        }
        
        
        
        return temp;
    }
    
    
    public void extractAcceptNodes(){
        
        for (int i = 0; i < estados.size(); i++) {
            
            String est = estados.get(i);
            
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
        
        for (int i = 0; i < str.length(); i++) {
            
            for (int j = 0; j < aristas.size(); j++) {
                arist = aristas.get(j).split(",");
                
                if(this.getEstado_actual().equals(arist[0]) && str.charAt(i) == arist[1].charAt(0)){
                    paso = true;
                    break;
                }
                
            }
            
            if(paso){
                cadena += arist[0] + ": " + arist[1] + " -> " + arist[2];
                
                this.setEstado_actual(arist[2]);
                
            }else{
                
                
                return cadena + "\n\nRECHAZADO";
                
            }
            
            cadena += "\n";
            
        }
        
        if(this.getEstados_aceptacion().contains(this.getEstado_actual())){
            
            cadena += "\n\nACEPTADA";
            
        }else
            cadena += "\n\nACEPTADA";
        
        
        return cadena;    
    }
    
}
