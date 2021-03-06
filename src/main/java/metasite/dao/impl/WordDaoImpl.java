package metasite.dao.impl;

import metasite.dao.WordDaoCustom;
import metasite.entities.Word;
import metasite.entities.Word_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulius on 10/10/2015.
 */
@Repository("WordDao")
public class WordDaoImpl implements WordDaoCustom {

	@PersistenceContext
	private EntityManager entityManager;
	private Expression<?> Word;

	@Override
	public Page<Word> findByFirstLetter(char[] firstLetterArray, Integer firstResult, Integer maxResults) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Word.class);
		Root<Word> root = criteriaQuery.from(Word.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();
		for (char firstLetter : firstLetterArray) {
			predicateList.add(criteriaBuilder.like(root.get(Word_.value), firstLetter + "%"));
		}

		criteriaQuery.where(criteriaBuilder.or(predicateList.toArray(new Predicate[]{})));

		long totalElements = getTotalElements(criteriaQuery, criteriaBuilder, root);
		criteriaQuery.select(root);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get(Word_.value)));

		TypedQuery typedQuery = entityManager.createQuery(criteriaQuery);
		if (firstResult != null && maxResults != null) {
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResults);
		}
		return new PageImpl<Word>(typedQuery.getResultList(), null, totalElements);
	}

	public Long getTotalElements(CriteriaQuery criteriaQuery, CriteriaBuilder builder, Root root) {
		criteriaQuery.select(builder.count(root));
		return (Long) entityManager.createQuery(criteriaQuery).getSingleResult();
	}
}
