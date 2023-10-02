package com.mydemo.recipe.search.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mydemo.recipe.models.Recipe;
import com.mydemo.recipe.search.SearchOperation;

public interface SearchFilter  {
    boolean couldBeApplied(SearchOperation opt);
    Predicate apply(CriteriaBuilder cb, String filterKey, String filterValue, Root<Recipe> root, Join<Object, Object> subRoot);
}