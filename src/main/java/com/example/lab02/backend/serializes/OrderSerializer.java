package com.example.lab02.backend.serializes;

import com.example.lab02.backend.models.Order;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class OrderSerializer extends StdSerializer<Order> {
    protected OrderSerializer(Class<Order> t) {
        super(t);
    }

    public OrderSerializer() {
        this(null);
    }

    @Override
    public void serialize(Order value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("order_id", value.getId());
        gen.writeStringField("order_date", value.getOrderDate().toString());
        gen.writeNumberField("customer_id", value.getCustomer().getId());
        gen.writeNumberField("employee_id", value.getEmployee().getId());
        gen.writeEndObject();
    }
}
