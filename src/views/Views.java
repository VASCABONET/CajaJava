
package views;

import java.util.List;
import java.util.Scanner;
import objects.Product;


public class Views {
    
    public static void showHeaderPrincipal(){
        
        System.out.println("\t\t*************************************");
        System.out.println("\t\t* BIENVENIDO A LA CAJA REGISTRADORA *");
        System.out.println("\t\t*************************************");
        }
    
    public static void showMenuPrincipal(){
        System.out.println("\t\t\t1. Comprar");
        System.out.println("\t\t\t2. Vender");
        System.out.println("\t\t\t3. Inventario");
        System.out.println("\t\t\t4. Compras");
        System.out.println("\t\t\t5. Ventas");
        System.out.println("\t\t\t6. Salir");
        
    }
    
    public static void showGetOption(){
        System.out.print("\t\tDigite la opcion: ");
    }
    
    public static  void showGetAmount(){
        System.out.print("\t\tDigite la cantidad: ");
    }
    
    
    public static void showGetPrice(){
        System.out.print("\t\tDigite el precio: ");
    }
    
    
    public static int getOption(){
        Scanner tecaldo = new Scanner(System.in);
        return tecaldo.nextInt();
    }
     
    //Metodo para cantidad en enteros y otro en duoble
    public static int getAmount(){
        Scanner tecaldo = new Scanner(System.in);
        return tecaldo.nextInt();
    }
    
    public static double getPrice(){
        Scanner tecaldo = new Scanner(System.in);
        return tecaldo.nextDouble();
    }
    
    //Menu de compra
    public static void showBuyHeader(){
                System.out.println("\t\t************************************");
                System.out.println("\t\t*         MENU DE COMPRAS          *");                
                System.out.println("\t\t************************************");
                showItemsMenu();
    }
    
    //Menu de ventas
    public static void showSaleHeader(){
                System.out.println("\t\t************************************");
                System.out.println("\t\t*         MENU DE VENTAS           *");                
                System.out.println("\t\t************************************");
                showItemsMenu();
    
}
    
    //Menu de inventario
    public static void showStockHeader(){
               System.out.println("\t\t****************************************************");
               System.out.println("\t\t*                I N V E N T A R I O               *");              
               System.out.println("\t\t****************************************************");
               showItemsHeader();
               
    }
    
    public static void showItemsHeader(){
               System.out.println("\t\t----------------------------------------------------");
               System.out.println("\t\t* PRODUCTO\t| Cantidad\t| Vr Unitario\t| Vr Total\t*");
               System.out.println("\t\t----------------------------------------------------");
        
    }
    
    public static void shotBuyListHeader(){
               System.out.println("\t\t****************************************************");
               System.out.println("\t\t*                  C O M P R A S                   *");
               System.out.println("\t\t****************************************************");        
    }
    
    public static void showSaleListHeader(){
               System.out.println("\t\t****************************************************");
               System.out.println("\t\t*                  V E N T A S                     *");
               System.out.println("\t\t****************************************************");
               showItemsHeader();
    }
    
    public static void showItemsMenu(){
               System.out.println("\t\t\t1. Papas");
               System.out.println("\t\t\t2. Arroz");
               System.out.println("\t\t\t3. Carne");
               System.out.println("\t\t\t4. Volver");
    }
    
    public static void showThanks(){
        System.out.println("Gracias por utilizar nustra pimera APP");
    }
    public static void showInvalidOption(){
         System.out.println("Opcion no valida!!!");
    }
    public static void showGetBack(String name){
            System.out.println("\t\t\tSaliendo del modulo..."+name);
    }
    
    public static void showAnykey(){
        System.out.print("Digite cualquier numero para continuar:   ");
    }
            
    
    public static void showItemStock(Product[] products){
      for (Product v : products) {
            System.out.println("\t\t*"+v.getName()+"\t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+v.getAmount()*v.getPrice()+"\t\t*");
        }
    }
    
    public static void showInvalidAmount(){
        System.out.println("La cantidad no es valida!!");
    }
    
    public static void showPurchases(List<Product> listado){
        for(Product v : listado){
            System.out.println("\t\t*"+v.getName()+" \t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+v.getAmount()*v.getPrice()+"\t\t*");            
        }
    }
    
    public static void showSales(List<Product> listado){
        for(Product v : listado){
           System.out.println("\t\t*"+v.getName()+"\t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+v.getAmount()*v.getPrice()*1.25+"\t\t*");
        }
    }
    
}
