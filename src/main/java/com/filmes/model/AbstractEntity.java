package com.filmes.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public abstract class AbstractEntity extends AbstractPersistable<Long> {

	@Version
	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
