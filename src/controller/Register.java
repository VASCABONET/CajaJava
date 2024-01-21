
package controller;

import Storage.Database;
import java.util.List;
import objects.Meat;
import objects.Potato;
import objects.Product;
import objects.Rice;


public class Register {
    //Para que mantenga los estados a este si lo vamos a instanciar es decir
    //Que no vamos a utilizar metodos estaticos
    
    private Database database; 
    
    
    public Register(){
       database= new Database();
    }
    
    //Metodo inicia el proceso de la registradora 
    public void register(){
       
     //   views.Views.showItemsMenu();
        int option;
        do{
            views.Views.showHeaderPrincipal();
            views.Views.showMenuPrincipal();
            views.Views.showGetOption();
            option= views.Views.getOption(); 
            switch(option){
                case 1:
                    buy();
                    break;
                case 2:
                    sale();
                    //views.Views.showSaleHeader();
                    break;
                case 3:
                    showStock();
                    break;
                case 4:
                    showPrchasese();
                    //views.Views.shotBuyListHeader();
                    break;
                case 5:
                    showSales();
                    //views.Views.showSaleHeader();
                    break;
                case 6:
                    views.Views. showThanks();
                    System.exit(0);
                    break;
                default:
                   views.Views.showInvalidOption();
            }
        }while(option>=1 && option<=6);
    }
    
    
    //Muestra el menu de compra y captura la opcion elegida del usuario
    private void buy(){
        views.Views.showBuyHeader();
        int option;
        do{
            views.Views.showGetOption();
            option=views.Views.getOption();
            if(option>=1 && option<=3){
                buyProduct(option);

            }else if(option ==4){
                views.Views.showGetBack("Compras");
                return;
            }else{
                views.Views.showInvalidOption();
            }
   
        } while(option<1 || option>4);
    }
    
    //REGISTRA EN LA BASE DE DATOS EL PRODUCTO COMPRADO
    //Creamos metodo que se va  a encargar de la compra, con la base de datos
    //Este metodo va a recibir la opcion que digito el usuario
    private void buyProduct(int option){
        //Mostramos cual de los productos es el que puedo vender
        Product product=null;
        switch (option)
        {
            case 1:
                product=new Potato("Sabanera");                
                break;
            case 2:
                product=new Rice("Arroz");
                break;
            case 3:
                product=new Meat("Lomo");
                break;
            
            default:
               views.Views.showInvalidOption();
        }
        //Preguntamos la cantidad que desea comprar
        views.Views.showGetAmount();
        //Capturamos la cantidad 
        int amount= views.Views.getAmount();  
        //Solicitamos el precio
        views.Views.showGetPrice();
        //Capturamos el precio
        double price = views.Views.getPrice();
        
        //Teniendo el amount & price asiganamos el valor al producto
        product.setAmount(amount);
        product.setPrice(price);
        database.buy(product);
    }
    
    private void showStock(){
        views.Views.showStockHeader();
        views.Views.showItemStock(database.getAll());
        views.Views.showAnykey();
        views.Views.getOption();
    }
    
    //********
        //Muestra el menu de VENTAS y captura la opcion elegida del usuario
    private void sale(){
        views.Views.showSaleHeader();
        int option;
        do{
            views.Views.showGetOption();
            option=views.Views.getOption();
            if(option>=1 && option<=3){
                saleProduct(option);

            }else if(option ==4){
                views.Views.showGetBack("Ventas");
                return;
            }else{
                views.Views.showInvalidOption();
            }
   
        } while(option<1 || option>4);
    }
    
    //***
    
    
    //METODO SALEPRODUCRT
      private void saleProduct(int option){
        //Mostramos cual de los productos es el que puedo vender, 
        //vemos si este producto tiene el stock sufuciente para venderlo
        //esto lo verificamos en la base de datos
        Product product=null;
        //Validamos si lo que recibimos es una opcion valida
        if(option<1|| option>3){
            views.Views.showInvalidOption();
            return;
        }
        //Aca obtenemos el producto de la base de datos
        product= database.getbyIndex(option-1);
  
        //Preguntamos la cantidad que desea comprar
        views.Views.showGetAmount();
        //Capturamos la cantidad 
        int amount= views.Views.getAmount();  
        
        //Validamos que la cantidad que no supere el stock que tenemos
        if(product.getAmount()<amount){
            views.Views.showInvalidAmount();
            return;
        }
        product.setAmount(amount);
        database.sale(product);
    }
    
    
    private void showPrchasese(){
        List<Product> listado = database.getPurchases();
        views.Views.shotBuyListHeader();
        views.Views.showPurchases(listado);
        views.Views.showAnykey();
        views.Views.getOption();
    }
    
    private void showSales(){
        List<Product> listado = database.getSales();
        views.Views.showSaleListHeader();
        views.Views.showSales(listado);
        views.Views.showAnykey();
        views.Views.getOption();
    }
    
}
