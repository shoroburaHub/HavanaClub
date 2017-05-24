

package com.HavanaClub.editors;

import com.HavanaClub.entity.Country;
import com.HavanaClub.service.CountryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 5/24/2017.
 */
public class CountryEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String idFromJSP) throws IllegalArgumentException {

        Country country = new Country();

        country.setId(Integer.parseInt(idFromJSP));

        setValue(country);


    }
}
