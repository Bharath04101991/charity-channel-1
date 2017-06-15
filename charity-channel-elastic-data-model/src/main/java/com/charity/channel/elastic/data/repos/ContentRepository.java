package com.charity.channel.elastic.data.repos;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.charity.channel.elastic.data.model.Content;
import com.charity.channel.elastic.data.model.Professional;

@Repository
public interface ContentRepository extends ElasticsearchRepository<Content, String> {

    Page<Content> findByProfessional(String name, Pageable pageable);

    Content findByContentId(String contentId);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"player.name\": \"?0\"}}]}}")
    Page<Content> findByPlayerNameUsingCustomQuery(String name, Pageable pageable);

    Page<Content> findByTagsName(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"player.playerId\": \"?0\"}}]}}")
    List<Content> findByPlayerId(String playerId);

    //@Query("{\"bool\": {\"should\": [{\"match\": {\"text.title\": \"?0\"}}], \"should\": [{\"match\": {\"tags.name\": \"?0\"}}]}}")
    //@Query("{\"bool\": {\"should\": [{\"match\": {\"text.title\": \"?0\"}}]}}")
    //@Query("{\"bool\":{\"must\":[{\"term\":{\"deviceevent.location.id\": \"?0\"}},{\"term\":{\"deviceevent.deviceId\": \"?1\"}}]}},\"from\": 0,\"size\": 1,\"sort\":{\"timestamp\":{\"order\":\"desc\"}}")
    @Query("{\"bool\": "
    		+ "{\"should\": ["
    		+ "{\"match\": {\"tags.name\": \"?0\"}}, "
    		+ "{\"match\": {\"text.title\": \"?0\"}}"
    		+ "]}}")
    
    List<Content> findArticlesByKeywordQuery(String keyword);
    
    
    Page<Content> findByProfessional_ProfessionalIdAndProfessional_RoleOrderByCreatedAtDesc(String professionalId, String role, Pageable pageable);
    Page<Content> findByProfessional_RoleOrderByCreatedAtDesc(String role, Pageable pageable);
    Page<Content> findAllByOrderByCreatedAtDesc(Pageable pageable);    
    Page<Content> findByProfessional_ProfessionalIdAndProfessional_Role(String professionalId, String role, Pageable pageable);
    Page<Content> findByProfessional_Role(String role, Pageable pageable);
    Long countByProfessional_ProfessionalIdAndProfessional_Role(String professionalId, String role);

	Long countByProfessional_professionalId(String playerId);
	
	Page<Content> findByProfessional_professionalIdAndProfessional_RoleOrderByCreatedAtDesc(String professionalId, String role, Pageable pageable);
	List<Content> findByProfessional_professionalIdAndProfessional_RoleOrderByCreatedAtDesc(String professionalId, String role);
	
    Page<Content> findByProfessional_professionalIdNotAndProfessional_RoleNotOrderByCreatedAtDesc(String professionalId, String role, Pageable pageable);

	List<Content> findByProfessional(Professional professional);
	List<Content> findByProfessional_ProfessionalIdAndProfessional_Role(String professionalId, String role);
	Page<Content> findByContentIdIn(Set<String> contentIds ,Pageable page);
	Page<Content> findByContentIdInAndCreatedAtAfter(Set<String> contentIds,Long creationDate, Pageable page);

	Page<Content> findByProfessional_professionalIdAndProfessional_RoleAndContentSourceOrderByCreatedAtDesc(String professionalId,String professionalRole, String contentSource,Pageable pageable);

	
	 

}
