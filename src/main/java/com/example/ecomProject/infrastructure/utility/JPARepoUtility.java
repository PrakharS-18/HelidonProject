package com.example.ecomProject.infrastructure.utility;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class JPARepoUtility {

    @PersistenceContext(unitName = "ecom")
    private EntityManager em;

    public<T> List<T> getElementByFields(Class<T> daoClass, Map<String, String> fields) {
        CriteriaBuilder criteriaBuilder =em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(daoClass);
        Root<T> root = criteriaQuery.from(daoClass);
        criteriaQuery.select(root);

        List<Predicate> predicates = fields.entrySet()
                .stream()
                .map(entry -> createPredicate(entry, criteriaBuilder, root))
                .toList();

        if (!predicates.isEmpty()) {
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
        }

        TypedQuery<T> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Transactional
    public<T> T create(T entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Transactional
    public <T> T remove(T entity) {
        em.remove(entity);
        return entity;
    }

    @Transactional
    public <T> T update(T entity) {
        em.merge(entity);
        return entity;
    }

    private static<T> Predicate createPredicate(Map.Entry<String, String> entry, CriteriaBuilder criteriaBuilder, Root<T> root) {
        return criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue());
    }
}
