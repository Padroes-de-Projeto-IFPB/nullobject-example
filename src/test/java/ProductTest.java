import br.edu.ifpb.domain.Product;
import br.edu.ifpb.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {

    private Product product;
    private ProductRepository repository = new ProductRepository();

    @BeforeEach
    public void init() {
        product = new Product();
        product.setPrice(BigDecimal.valueOf(2300L));
        product.setDesc("desc");
        product.setTitle("Hamburguer");
        product.setProductType(Product.ProductType.FOOD);

        repository.save(product);
    }

    @Test
    public void createProduct() {
        assertNotNull(product.getId());
    }

    @Test
    public void findProduct() {
        Product existingProduct = repository.find(product.getId());
        assertNotNull(existingProduct);
        assertEquals(existingProduct.getTitle(), "Hamburguer");
        assertEquals(existingProduct.getPrice(), BigDecimal.valueOf(2300L));
        assertEquals(existingProduct.getDesc(), "desc");
        assertEquals(existingProduct.getProductType(), Product.ProductType.FOOD);
    }

    @Test
    public void findNullObjectProduct() {
        Product nullProduct = repository.find(15L);
        assertEquals(nullProduct.getTitle(), "empty");
        assertEquals(nullProduct.getPrice(), BigDecimal.valueOf(0L));
        assertEquals(nullProduct.getDesc(), "Lorem Ipsum");
        assertEquals(nullProduct.getProductType(), Product.ProductType.GENERIC);
    }

}
