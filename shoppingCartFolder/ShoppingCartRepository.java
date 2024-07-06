package shoppingcartfolder;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import com.group_3.restful_group_3_project.shoppingCartFolder.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
    Optional<ShoppingCart> findByUserID(String userID);
}
