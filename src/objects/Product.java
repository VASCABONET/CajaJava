
package objects;


public abstract class Product implements Cloneable{
    private String name;
    private int amount;
    private double price;
    
    
    //Constructor por defecto
    public Product(){}
    
    //Sobrecarga de costructor
    public Product(String n){this.name=n;}
    
    //Getter & Setter
    public String getName () {return name;}

    public void setName (String name) {this.name = name;}

    public int getAmount () {return amount;}

    public void setAmount (int amount) {
        if(amount<0){
            System.out.println("No se puede asignar cantidad negativa");
            return ;
        }
        this.amount = amount;
    }

    public double getPrice () {return price;}

    public void setPrice (double price) {
        if(price<0){
            System.out.println("No se puede asignar un precio negativo");
            return ;
        }
        this.price = price;
    }
    
    
    @Override
    public String toString(){
        return "Nombre: "+this.name +" Cantidad: "+this.amount+" Precio: "+this.price;
    }
    
    @Override
    public Product clone() throws CloneNotSupportedException{
        return (Product) super.clone();
    }
    
    

}
