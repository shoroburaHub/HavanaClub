package com.HavanaClub.editors;

import com.HavanaClub.entity.Country;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 5/24/2017.
 */
public class CountryEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String idCountryFromJSP) throws IllegalArgumentException {

        Country country = new Country();
        country.setId(Integer.valueOf(idCountryFromJSP));

        setValue(country);

    }
}
