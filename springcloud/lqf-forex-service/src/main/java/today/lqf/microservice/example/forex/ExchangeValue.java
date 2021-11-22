package today.lqf.microservice.example.forex;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class ExchangeValue {

    @Id
    @Getter
    private Long id;

    @Column(name = "currency_from")
    @Getter
    private String from;

    @Column(name = "currency_to")
    @Getter
    private String to;

    @Getter
    private BigDecimal conversionMultiple;

    @Getter
    @Setter
    private int port;

    public ExchangeValue() {

    }

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

}
