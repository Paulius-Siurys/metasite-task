package metasite.dao.impl;

import metasite.dao.WordDao;
import metasite.dao.WordDaoCustom;
import metasite.entities.Word;
import metasite.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
	public List<Word> findByFirstLetter() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Word.class);
		Root<Word> root = criteriaQuery.from(Word.class);

//		List<Predicate> predicateList = new ArrayList<>();
//		List<Order> orderList = new ArrayList<>();
//
//		predicateList.add(criteriaBuilder.equal(root.get(DocumentVersion_.last), true));
//		predicateList.add(tagListJoin.get(Tag_.id).in(tagIdList));
//
//		if (orderByField) {
//			Join fieldListJoin = root.join(DocumentVersion_.fieldList, JoinType.LEFT);
//			Join structureFieldJoin = fieldListJoin.join(AbstractDocumentField_.structureField, JoinType.LEFT);
//
//			Order order = isInt ?
//					new OrderImpl(fieldListJoin.get(AbstractDocumentField_.value).as(Integer.class))
//					: new OrderImpl(fieldListJoin.get(AbstractDocumentField_.value));
//			orderList.add(order);
//
//			predicateList.add(criteriaBuilder.like(structureFieldJoin.get(StructureField_.name), orderField));
//		}
//
//		if (published) {
//			predicateList.add(criteriaBuilder.equal(documentJoin.get(Document_.status), ObjectStatusEnum.PUBLISHED));
//		}
//		criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
//
//		return CriteriaQueryUtils.getResultPage(criteriaQuery, criteriaBuilder, entityManager, root, pageable);
		return null;
	}
}
