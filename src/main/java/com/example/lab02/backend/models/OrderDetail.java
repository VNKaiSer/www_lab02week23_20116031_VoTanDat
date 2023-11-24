package com.example.lab02.backend.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@IdClass(OrderDetailPK.class)
@Table(name = "order_detail")
@NamedQueries({
        @NamedQuery(name = "OrderDetail.getListOrderDetail", query = "SELECT o FROM OrderDetail o WHERE o.order.id = :id")
})
public class OrderDetail {
    @Column(name = "order_id", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quantity", nullable = false, length = 10)
    private int quantity;
    @Column(name = "price", nullable = false, length = 10)
    private double price;
    @Column(name = "node", nullable = true, length = 100)
    private String node;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@EqualsAndHashCode
class OrderDetailPK implements Serializable {
    private long order;
    private long product;

}
