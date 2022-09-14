package com.example.buysell.models;
import com.example.buysell.models.enums.SystemItemType;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "system_item_import",schema = "public")

public class SystemItemImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private String id;

    @Column(name = "url",nullable = true)
    private String url;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="system_item", nullable=false)
    private SystemItem parentId;


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SystemItemType type;

    @Column(name = "size",nullable = true)
    private int size;




}
