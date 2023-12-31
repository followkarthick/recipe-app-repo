package com.mydemo.recipe.unit.search.filter;

import org.junit.Test;

import com.mydemo.recipe.search.SearchOperation;
import com.mydemo.recipe.search.filter.SearchFilterNotEqual;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SearchFilterNotEqualTest {

    @Test
    public void couldBeAppliedReturnsTrueWhenOperationIsNotEqual() {
        SearchFilterNotEqual filterNotEqual  = new SearchFilterNotEqual();
        boolean b = filterNotEqual.couldBeApplied(SearchOperation.NOT_EQUAL);
        assertTrue(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsEqual() {
        SearchFilterNotEqual filterNotEqual  = new SearchFilterNotEqual();
        boolean b = filterNotEqual.couldBeApplied(SearchOperation.EQUAL);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsDoesNotContain() {
        SearchFilterNotEqual filterNotEqual  = new SearchFilterNotEqual();
        boolean b = filterNotEqual.couldBeApplied(SearchOperation.DOES_NOT_CONTAIN);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsContain() {
        SearchFilterNotEqual filterNotEqual  = new SearchFilterNotEqual();
        boolean b = filterNotEqual.couldBeApplied(SearchOperation.CONTAINS);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsNull() {
        SearchFilterNotEqual filterNotEqual  = new SearchFilterNotEqual();
        boolean b = filterNotEqual.couldBeApplied(null);
        assertFalse(b);
    }

    @Test
    public void apply() {
    }
}