package cz.itnetwork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import cz.itnetwork.constant.Countries;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceDTO {

    @JsonProperty("_id")
    private Long id;

    @NotNull
    private int invoiceNumber;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate issued;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    private String product;

    private double price;

    private int vat;

    private String note;

    private PersonDTO seller;

    private PersonDTO buyer;

}
