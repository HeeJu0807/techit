package org.example.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private int idx;
    private String name;
    private double price;
}
