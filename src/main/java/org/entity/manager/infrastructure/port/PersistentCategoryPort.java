package org.entity.manager.infrastructure.port;

import org.entity.manager.infrastructure.entity.CategoryInfo;

public interface PersistentCategoryPort {
    CategoryInfo finCategoryInfo(Integer categoryId);
}
