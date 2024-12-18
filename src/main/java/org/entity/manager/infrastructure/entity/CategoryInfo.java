package org.entity.manager.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryInfo {
    private Integer id;
    private String nombre;
}
