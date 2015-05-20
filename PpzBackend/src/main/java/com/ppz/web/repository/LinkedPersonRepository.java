package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.LinkedPerson;

/**
 * REPOSITORY object for entity LinkedPerson specific methods.
 * 
 * @author Petr Hirs
 * 
 */
public interface LinkedPersonRepository extends GenericRepository<LinkedPerson> {

	List<LinkedPerson> getLinkedPersonListByAvatar(Avatar avatar, Long round);

}
