package br.com.zamlutti.comente.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "entries", uniqueConstraints = { @UniqueConstraint(columnNames = { "url" }) })
public class Entry {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String url;

	@OneToMany(mappedBy = "entry")
	private final List<Comment> comments;

	public Entry() {
		this.comments = new ArrayList<Comment>();
	}

	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
}
