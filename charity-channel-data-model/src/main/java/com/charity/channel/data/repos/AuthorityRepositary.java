package com.charity.channel.data.repos;

import com.charity.channel.data.model.Authority;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AuthorityRepositary extends TableRepository<Authority, Long>, JpaSpecificationExecutor<Authority>
{

}
