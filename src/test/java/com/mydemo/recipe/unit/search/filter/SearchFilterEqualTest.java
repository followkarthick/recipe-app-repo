package com.mydemo.recipe.unit.search.filter;

import org.junit.Test;

import com.mydemo.recipe.search.SearchOperation;
import com.mydemo.recipe.search.filter.SearchFilterEqual;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SearchFilterEqualTest {

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsNotEqual() {
        SearchFilterEqual filterEqual  = new SearchFilterEqual();
        boolean b = filterEqual.couldBeApplied(SearchOperation.NOT_EQUAL);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsTrueWhenOperationIsEqual() {
        SearchFilterEqual filterEqual  = new SearchFilterEqual();
        boolean b = filterEqual.couldBeApplied(SearchOperation.EQUAL);
        assertTrue(b);

    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsDoesNotContain() {
        SearchFilterEqual filterEqual  = new SearchFilterEqual();
        boolean b = filterEqual.couldBeApplied(SearchOperation.DOES_NOT_CONTAIN);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsContain() {
        SearchFilterEqual filterEqual  = new SearchFilterEqual();
        boolean b = filterEqual.couldBeApplied(SearchOperation.CONTAINS);
        assertFalse(b);
    }

    @Test
    public void couldBeAppliedReturnsFalseWhenOperationIsNull() {
        SearchFilterEqual filterEqual  = new SearchFilterEqual();
        boolean b = filterEqual.couldBeApplied(null);
        assertFalse(b);
    }

    @Test
    public void apply() {
    }
}