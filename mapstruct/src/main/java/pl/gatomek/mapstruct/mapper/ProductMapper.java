package pl.gatomek.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;
import pl.gatomek.mapstruct.dto.AddressDto;
import pl.gatomek.mapstruct.dto.ProductDto;
import pl.gatomek.mapstruct.dto.Score;
import pl.gatomek.mapstruct.model.Address;
import pl.gatomek.mapstruct.model.NutriScore;
import pl.gatomek.mapstruct.model.Product;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "origin", target = "originId")
    @Mapping(source = "name", target = "label")
    @Mapping(source = "nutriScore", target = "score")
    ProductDto product2ProductDto(Product product);

    @ValueMapping(source = "A", target = "A0")
    @ValueMapping(source = "B", target = "A1")
    @ValueMapping(source = "C", target = "A2")
    @ValueMapping(source = "D", target = "A3")
    @ValueMapping(source = "E", target = "A4")
    Score nutriScore2Score(NutriScore nutriScore);

    @Mapping( source="streetNumber", target="strNumber")
    @Mapping( source="postalCode", target="code")
    AddressDto address2AddressDto(Address address);

    /**/

    @Mapping(target = "origin", source = "originId")
    @Mapping(target = "name", source = "label")
    @Mapping(target = "nutriScore", source = "score")
    Product productDto2Product(ProductDto productDto);

    @ValueMapping(target = "A", source = "A0")
    @ValueMapping(target = "B", source = "A1")
    @ValueMapping(target = "C", source = "A2")
    @ValueMapping(target = "D", source = "A3")
    @ValueMapping(target = "E", source = "A4")
    NutriScore score2NutriScore(Score score);

    @Mapping( target="streetNumber", source="strNumber")
    @Mapping( target="postalCode", source="code")
    Address addressDto2Address(AddressDto address);
}
