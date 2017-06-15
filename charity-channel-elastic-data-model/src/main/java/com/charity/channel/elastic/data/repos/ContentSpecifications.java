package com.charity.channel.elastic.data.repos;

public class ContentSpecifications {

	/*public static Specification<Content> findOrdersByStatusAndDateRange(final String status, final Long orderId,
			final String orderCode, final String externalCustomerCode, final Date dateRangeStart,
			final Date dateRangeEnd, final String externalResellerCode) {

		return new Specification<Content>() {

			public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {

				Predicate predicate = criteriaBuilder.conjunction();
				// List<Order> orderByList = new ArrayList<Order>();

				if (!StringUtils.isEmpty(status)) {
					Expression<String> rootStatus = root.get("status");
					predicate = criteriaBuilder.and(predicate,
							criteriaBuilder.like(criteriaBuilder.lower(rootStatus), "%" + status.toLowerCase() + "%"));
				}
				
				if (!StringUtils.isEmpty(orderCode)) {
					Expression<String> rootOrderCode = root.get("orderCode");
					predicate = criteriaBuilder.and(predicate, criteriaBuilder
							.like(criteriaBuilder.lower(rootOrderCode), "%" + orderCode.toLowerCase() + "%"));

				}
				
				
				return predicate;
			}
		};
	}*/

}
