
package Storage;

import java.util.ArrayList;
import java.util.List;
import objects.Meat;
import objects.Potato;
import objects.Product;
import objects.Rice;


//Metodos para compra y para vender para esto vamos a utilizar unas listas



public class Database {
    //Lista de productos
    private Product [] products;
    //Lista de compras
    private List<Product> purchases;
    //Lista de ventas
    private List<Product> sales;
    
    //Elementos a vender
    public Database(){
        products =new Product[3];
        Product potato = new Potato("Sabanera");
        Product rice = new Rice("Arroz  ");
        Product meat = new Meat("Lomo   ");
        
        products[0]=potato;
        products[1]=rice;
        products[2]=meat;
        
        //Instanciamos compras y ventas
        purchases=new ArrayList<>();
        sales=new ArrayList<>() ; 
    }
    
    
    //Obtener un valor especifico del array
    public Product getbyIndex(int i){
        if(i<0 || i>2){
            System.out.println("Indice no valido!!");
            return null;            
        }
        
        //Si el indice es valido lo clonamos atrapamos la excepcion
        Product result =null;
        try{
            result = products[i].clone();
        }catch(CloneNotSupportedException cnse){
            System.out.println(cnse);           
        }
        
        return result;
    }
    
    
    
    //Metodo para obtener todo el array
    public Product[]getAll(){        
        Product[] result = new Product[3];
        try{
            result[0]=products[0].clone();
            result[1]=products[1].clone();
            result[2]=products[2].clone();        
        }catch(CloneNotSupportedException cnse){
            System.out.println("ERROR DE CLONACION!!"+cnse);            
        }
        return result;
    }
    
    //Metodos de comprar
    public void buy(Product product){
        //con temp obtengo el producto que se encuentra en el array
        Product temp;
        //Todas las clases tatno meat,rice & potato heredan de OBJECT el cual
        //ya viene pre construido con un metodo getClass. como se llamna
        //ed.team.objects.meat ed.team.objects.Potato ed.team.objects.Rice
        //usamos getSimpleName para objeter solo MEAT,RICE,POTATO
        switch(product.getClass().getSimpleName()){
            case "Potato":
                temp=products[0];
                break;
            case "Rice":
                temp=products[1];                     
                break;
            case "Meat":
                temp=products[2]; 
                break;
            default:
                    System.out.println("No valido");
                    return;
        }
        
        //Metodo para Modificar la cantidad del objeto seleccionado
        //Aumento la cantidad en 1 o 2 depende cuanto compre
        temp.setAmount(temp.getAmount()+product.getAmount());
        
        //Modificamos el precio segun la cantidad que estamos comprando
        temp.setPrice(product.getPrice());
        
        //Registramos la compra que hacemos en PURCHASES
        purchases.add(product);
        }
        
        //VENTAS
        
        public void sale(Product product){
        
        Product temp;
        
        switch(product.getClass().getSimpleName()){
            case "Potato":
                temp=products[0];
                break;
            case "Rice":
                temp=products[1];                     
                break;
            case "Meat":
                temp=products[2]; 
                break;
            default:
                    System.out.println("No valido");
                    return;
        }
        
        
        //Aca si se disminuye la cantidad ya que vendimos y tenemos menos stock
        temp.setAmount(temp.getAmount()-product.getAmount());
        
        //Aumentamos el precio del producto, al producto que compro le aumento un 25%
        product.setPrice(temp.getPrice()*1.25);
                
        sales.add(product);     
    }
         //Listamos las ventas y compras
        public List <Product> getPurchases(){ return purchases;}
        
        public List<Product>getSales(){return sales;}
}
