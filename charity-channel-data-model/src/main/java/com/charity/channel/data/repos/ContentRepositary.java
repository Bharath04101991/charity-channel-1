package com.charity.channel.data.repos;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.charity.channel.data.model.Content;

public interface ContentRepositary extends TableRepository<Content, Long>,JpaSpecificationExecutor<Content>
{

}
