package com.luwei.bbs.dao;


import com.luwei.bbs.po.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IArticleDAO extends CrudRepository<Article,Integer >{


    @Query("select a from Article a where a.rootid=:rid")
    Page<Article> findAll(Pageable pb, @Param("rid")Integer rid);


    @Modifying
    @Query("DELETE from Article where id=:id or rootid =:id ")
    int deleteZT(@Param("id")Integer id);

    @Modifying
    @Query("DELETE from Article where id=:id ")
    int deleteCT(@Param("id")Integer id);//从贴

    @Override
    Article save(Article article);
}
