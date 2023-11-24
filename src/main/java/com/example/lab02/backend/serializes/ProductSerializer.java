package com.example.lab02.backend.serializes;

import com.example.lab02.backend.models.Product;
import com.example.lab02.backend.models.ProductPrice;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class ProductSerializer  extends StdSerializer<Product> {
    protected ProductSerializer(Class<Product> t) {
        super(t);
    }

    public ProductSerializer(){
        this(null);
    }

    @Override
    public void serialize(Product value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("product_id", value.getId());
        gen.writeStringField("product_name", value.getProductName());
        gen.writeStringField("description",value.getDescription());
        gen.writeStringField("unit", value.getUnit());
        gen.writeStringField("manufacturer", value.getManufacturerName());
        double price = 0;
        LocalDateTime dateLastest = LocalDateTime.now();
        for (ProductPrice p:
             value.getProductPrices()) {

            if (p.getId().isAfter(dateLastest)){
                dateLastest = p.getId();
                price = p.getPrice();
            }
        }
        gen.writeNumberField("product_price",price );
        gen.writeEndObject();
    }
}
