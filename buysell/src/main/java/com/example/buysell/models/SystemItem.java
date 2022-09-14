package com.example.buysell.models;

import com.example.buysell.models.enums.SystemItemType;
import lombok.Data;
import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "system_item",schema = "public")
public class SystemItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private String id;

    @Column(name = "url",nullable = true)
    private String url;

    @Column(name = "date",nullable = false)
    private ZonedDateTime date=ZonedDateTime.now();

    @Column(name = "parentId",nullable = true)
    private String parentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SystemItemType type;

    @Column(name = "size",nullable = true)
    private int size;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="systemItem")
    private List<SystemItem> children;

    @ManyToOne
    @JoinColumn(name = "system_item_id")
    private SystemItem systemItem;

    public SystemItem getSystemItem() {
        return systemItem;
    }

    public void setSystemItem(SystemItem systemItem) {
        this.systemItem = systemItem;
    }

    public void addChild(final SystemItem child) {
        if (children == null) {
            children = new ArrayList<SystemItem>();
        }

        children.add(child);

        child.setId(String.valueOf(this));
    }

}
