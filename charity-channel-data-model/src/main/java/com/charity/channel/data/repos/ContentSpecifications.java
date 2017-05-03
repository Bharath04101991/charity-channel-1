package com.charity.channel.data.repos;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ContentSpecifications 
{
	public static Sort sortByIdAsc() 
	{
	    return new Sort(Sort.Direction.ASC, "id");
	}

	  /**
	   * Returns a new object which specifies the the wanted result page.
	   *
	   * @param pageIndex The index of the wanted result page
	   * @return
	   */
	  public static Pageable constructPageSpecification(int pageIndex, int pageSize) 
	  {
	    Pageable pageSpecification = new PageRequest(pageIndex, pageSize);
	    return pageSpecification;
	  }

	 
}
