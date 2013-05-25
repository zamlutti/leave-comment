package br.com.zamlutti.comente.repositories;

import br.com.zamlutti.comente.entities.Entry;

public interface EntryRepository {
    public Entry find(String url);

    public void save(Entry entry);
}
