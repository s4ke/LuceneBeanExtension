package com.github.hotware.lucene.extension.hsearch.jpa.test.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

@Indexed
@Entity
public class Place {

	private Integer id;
	private String name;
	private Set<Sorcerer> sorcerers = new HashSet<>();

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Field(store = Store.NO, index = Index.YES)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@IndexedEmbedded
	@OneToMany
	public Set<Sorcerer> getSorcerers() {
		return sorcerers;
	}

	public void setSorcerers(Set<Sorcerer> sorcerers) {
		this.sorcerers = sorcerers;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", sorcerers="
				+ sorcerers + "]";
	}

}