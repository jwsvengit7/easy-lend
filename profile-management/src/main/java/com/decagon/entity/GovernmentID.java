package com.decagon.entity;

import com.decagon.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "government_issued_ids")
public class GovernmentID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "document_url")
    private String documentUrl;
}