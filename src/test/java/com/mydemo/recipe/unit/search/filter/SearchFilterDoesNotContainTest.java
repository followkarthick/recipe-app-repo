package com.mydemo.recipe.unit.search.filter;

import org.junit.Test;

import com.mydemo.recipe.search.SearchOperation;
import com.mydemo.recipe.search.filter.SearchFilterDoesNotContain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchFilterDoesNotContainTest {

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsNotEqual() {
        SearchFilterDoesNotContain filter  = new SearchFilterDoesNotContain();
        boolean b = filter.couldBeApplied(SearchOperation.NOT_EQUAL);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsEqual() {
        SearchFilterDoesNotContain filter  = new SearchFilterDoesNotContain();
        boolean b = filter.couldBeApplied(SearchOperation.EQUAL);
        assertFalse(b);

    }

    @Test
    public void couldBeAppliedReturnsTrueWhenOperationIsDoesNotContain() {
        SearchFilterDoesNotContain filter  = new SearchFilterDoesNotContain();
        boolean b = filter.couldBeApplied(SearchOperation.DOES_NOT_CONTAIN);
        assertTrue(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsContain() {
        SearchFilterDoesNotContain filter  = new SearchFilterDoesNotContain();
        boolean b = filter.couldBeApplied(SearchOperation.CONTAINS);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsNull() {
        SearchFilterDoesNotContain filter  = new SearchFilterDoesNotContain();
        boolean b = filter.couldBeApplied(null);
        assertFalse(b);
    }

}