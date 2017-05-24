package com.HavanaClub.editors;

import com.HavanaClub.entity.Ingredient;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 5/24/2017.
 */
public class IngredientEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        Ingredient ingredient = new Ingredient();
        ingredient.setId(Integer.parseInt(text));

        setValue(ingredient);

    }
}
