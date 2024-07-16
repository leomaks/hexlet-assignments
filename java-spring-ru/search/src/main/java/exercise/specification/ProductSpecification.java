package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN

@Component 
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO params) {
        return withPriceGt(params.getPriceGt())
                .and(withPriceLt(params.getPriceLt()))
                .and(withRatingGt(params.getRatingGt()))
                .and(withCategoryId(params.getCategoryId()))
                .and(withTitleCont(params.getTitleCont()));
    }


    private Specification<Product> withPriceGt(Integer min) {
        return (root, query, cb) -> min == null ? cb.conjunction() : cb.greaterThan(root.get("price"), min);
    }

    private Specification<Product> withPriceLt(Integer max) {
        return (root, query, cb) -> max == null ? cb.conjunction() : cb.lessThan(root.get("price"), max);
    }

    private Specification<Product> withRatingGt(Double min) {
        return (root, query, cb) -> min == null ? cb.conjunction() : cb.greaterThan(root.get("rating"), min);
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"), categoryId);
    }

    private Specification<Product> withTitleCont(String text) {
        return (root, query, cb) -> text == null ? cb.conjunction() : cb.like(root.get("category").get("name"), text);
    }

}


// END
