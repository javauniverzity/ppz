package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.LinkedPerson;

/**
 * Repository specifickych metod objektu pro entitu LinkedPerson 
 * @author David
 */
public interface LinkedPersonRepository extends GenericRepository<LinkedPerson> {

	List<LinkedPerson> getLinkedPersonListByAvatar(Avatar avatar, Long round);

}
