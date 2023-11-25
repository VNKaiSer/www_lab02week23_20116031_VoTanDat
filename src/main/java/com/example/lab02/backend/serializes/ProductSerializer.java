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
        double price = getPrice(value);
        System.out.println(price);
        gen.writeNumberField("product_price",price );
        gen.writeStringField("product_image", value.getProductImages().get(0).getPath());
        gen.writeEndObject();
    }

    private double getPrice(Product value) {
        double price = 0;
        if (value.getProductPrices().size() < 0) {
            price = 0;
        }
        else {
            LocalDateTime dateLastest = value.getProductPrices().get(0).getId();
            price = value.getProductPrices().get(0).getPrice();
            for (ProductPrice p:
                    value.getProductPrices()) {
                if (p.getId().isAfter(dateLastest)){
                    dateLastest = p.getId();
                    price = p.getPrice();
                }
            }
        }
        return price;
    }
}
