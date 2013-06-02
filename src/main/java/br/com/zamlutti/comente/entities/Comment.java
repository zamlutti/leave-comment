package br.com.zamlutti.comente.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = "Email inválido")
	private String email;
	@NotEmpty(message = "Comentário não pode ser vazio")
	@Length(min = 3, max = 255, message = "Comentário deve ter entre 3 e 255 caracteres")
	private String text;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(nullable = false)
	private Entry entry;

	public int getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Entry getEntry() {
		return this.entry;
	}

	public void setEntry(Entry entry) {
		entry.addComment(this);
		this.entry = entry;
	}
}
