public interface Visitable {
  
  public double accept (Visitor visitor);
   
}

public class ProductoDescuento implements Visitable {
  
  private double precio;
  
  public double accept (Visitor visitor) {
    
    return visitor.visit(this);
    
  }
  
  public double getPrecio() {
    
    return precio;
    
  }
  
  public void setPrecio ( double precio ) {
    
    this.precio = precio;
    
  }
    
}

public class ProductoNormal implements Visitable {
  
  private double precio;
  
  public double accept (Visitor visitor) {
    
    return visitor.visit(this);
    
  }
  
  public double getPrecio() {
    
    return precio;
    
  }
  
  public void setPrecio ( double precio ) {
    
    this.precio = precio;
    
  }
    
}

public interface Visitor {
  
  public double visit ( ProductoNormal normal );
  
  public double visit ( ProductoDescuento reducido );
     
}

public class IVA implements Visitor {
  
  private final double impuestoNormal = 1.21;
  
  private final double impuestoReducido = 1.105;
  
  public double visit ( ProductoNormal normal ) {
    
    return normal.getPrecio() * impuestoNormal;
    
  }
  
  public double visit ( ProductoDescuento reducido ) {
    
    return reducido.getPrecio() * impuestoReducido;
    
  }
    
}

public static void main ( String[] args ) {
  
  ProductoDescuento producto1 = new ProductoDescuento();
  
  producto1.setPrecio( 100 );
  
  ProductoNormal producto2 = ProductoNormal();
  
  producto2.setPrecio( 100 );
  
  IVA iva = new IVA();
  
  double resultado1 = producto1.accept( iva );
  
  double resultado2 = producto2.accept( iva );
  
  System.out.println( resultado1 );
  
  System.out.println( resultado2 );
  
}
