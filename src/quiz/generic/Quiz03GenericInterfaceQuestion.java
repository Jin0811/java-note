package quiz.generic;

public class Quiz03GenericInterfaceQuestion {
    public static void main(String[] args) {
        Finder<Product> finder = new ProductFinder();
        Product product = finder.findById(1L);

        System.out.println(product.getName());

        /*
         * 问题：
         * 1. Finder<Product> 中的 T 被绑定成什么？
         * 2. finder.findById(1L) 为什么能直接赋给 Product？
         * 3. 后端 Repository/DAO 为什么常用泛型接口？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * Keyboard
         *
         * 问题 1：T 被绑定成 Product。
         *
         * 问题 2：因为 finder 的声明类型是 Finder<Product>，
         *     所以 findById 的返回值 T 就是 Product，不需要强转。
         *
         * 问题 3：因为增删改查方法形态很像，但实体类型不同。
         *     泛型接口可以复用方法契约，同时保留具体实体类型。
         */
    }
}

interface Finder<T> {
    T findById(Long id);
}

class ProductFinder implements Finder<Product> {
    public Product findById(Long id) {
        return new Product(id, "Keyboard");
    }
}

class Product {
    private Long id;
    private String name;

    Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
