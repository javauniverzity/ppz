package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.LinkedPerson;

@Repository(value = "linkedPersonRepository")
public class LinkedPersonRepositoryImpl extends AbstractRepository<LinkedPerson> implements LinkedPersonRepository {

	@Override
	public List<LinkedPerson> getLinkedPersonListByAvatar(Avatar avatar, Long round) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("avatar", avatar);
		filter.put("roundNo", round);

		List<LinkedPerson> results = loadByFilter(filter, LinkedPerson.class);
		if (results.size() != 0) {
			return results;
		} else {
			return null;
		}
	}

}
