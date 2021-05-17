import com.oobd.oobd_spring.lab16.OneMoreThread;
import com.oobd.oobd_spring.lab16.OneMoreThread2;
import com.oobd.oobd_spring.models.Product;
import com.oobd.oobd_spring.service.DbWork;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                DbWork db = DbWork.getInstance();

                Product product = new Product("Sweater", "Brand", 2200);
                Product product2 = new Product("Sweater", "Brand", 2200);
                Product product3 = new Product("Sweater", "Brand", 2200);

                Product[] products = new Product[]{product, product2, product3};

                EntityManager entityManager = db.getEmManager();

                for (int i = 0; i < 3; i++) {
                    entityManager.getTransaction().begin();
                    entityManager.persist(products[i]);
                    entityManager.getTransaction().commit();

                    entityManager.getTransaction().begin();
                    Product product1 = entityManager.find(Product.class, 2);
                    entityManager.getTransaction().commit();

                    product1.setProductBrand("Some another brand");

                    entityManager.getTransaction().begin();
                    entityManager.merge(product1);
                    entityManager.getTransaction().commit();

                }

                db.closeEntityManager();

                DbWork.clear();

            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                DbWork db = DbWork.getInstance();

                Product product = new Product("Skirt", "Brand", 2200);
                Product product2 = new Product("Skirt", "Brand", 2200);
                Product product3 = new Product("Skirt", "Brand", 2200);

                Product[] products = new Product[]{product, product2, product3};

                EntityManager entityManager = db.getEmManager();

                for (int i = 0; i < 3; i++) {
                    entityManager.getTransaction().begin();
                    entityManager.persist(products[i]);
                    entityManager.getTransaction().commit();

                    entityManager.getTransaction().begin();
                    Product product1 = entityManager.find(Product.class, 2);
                    entityManager.getTransaction().commit();

                    product1.setProductBrand("Some another brand 2");
                    entityManager.getTransaction().begin();
                    entityManager.merge(product1);
                    entityManager.getTransaction().commit();
                }

            }
        };

        OneMoreThread thread1 = new OneMoreThread(task1);
        OneMoreThread2 thread2 = new OneMoreThread2(task2);

        thread1.start();
        thread2.start();


    }
}
