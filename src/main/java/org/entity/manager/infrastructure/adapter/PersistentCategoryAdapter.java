package org.entity.manager.infrastructure.adapter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.entity.manager.infrastructure.entity.CategoryInfo;
import org.entity.manager.infrastructure.port.PersistentCategoryPort;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PersistentCategoryAdapter implements PersistentCategoryPort {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public CategoryInfo finCategoryInfo(Integer categoryId){
        CategoryInfo categoryInfo;
        try{

            Query query = entityManager.createNativeQuery("""
                    SELECT C.CategoryID,C.CategoryName FROM CATEGORIES C
                    WHERE C.CATEGORYID = :code
                    """);
            query.setParameter("code", categoryId);
            Object[] result = (Object[]) query.getSingleResult();
            categoryInfo = CategoryInfo.builder()
                    .id(Integer.valueOf(result[0].toString()))
                    .nombre(result[1].toString()).build();
        }
        catch (Exception e)
        {
            log.error("{}",e.getMessage());
            categoryInfo = CategoryInfo.builder().build();
        }
        return categoryInfo;
    }

}
