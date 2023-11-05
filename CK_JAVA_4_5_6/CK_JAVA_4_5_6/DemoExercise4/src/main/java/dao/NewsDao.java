package dao;

import entity.News;

public class NewsDao extends AbstractDao<News> {
	public NewsDao () {
		super(News.class);
	}
}
