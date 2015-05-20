package com.ppz.web.repository;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Avatar;

@Repository(value = "avatarRepository")
public class AvatarRepositoryImpl extends AbstractRepository<Avatar> implements AvatarRepository {

	public Class<Avatar> getType() {
		return Avatar.class;
	}


}