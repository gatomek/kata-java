package pl.gatomek.mapstruct;

import pl.gatomek.mapstruct.dto.ProductDto;
import pl.gatomek.mapstruct.mapper.ProductMapper;
import pl.gatomek.mapstruct.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("MapStruct Kata");

        Address address = Address.of("Main", 13, "91-495", "Lodz");
        Producer producer = Producer.of("Gatomek Lmt.", address);
        Product preProduct = Product.of("Paprica Chips", 125.80, "15-446", Status.HIGH, Country.FRANCE, NutriScore.C, producer);
        ProductDto productDto = ProductMapper.INSTANCE.product2ProductDto(preProduct);
        Product postProduct = ProductMapper.INSTANCE.productDto2Product(productDto);
    }
}
