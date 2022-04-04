public class ProblematicTenantException extends Exception{
    public String message;

     public ProblematicTenantException(String message){
         super(message);
     }
}
