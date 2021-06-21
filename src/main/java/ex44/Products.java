package ex44;

public class Products {
    private Product[] products;

    public Products(Product[] productArray) {
        this.products = productArray;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
