package com.HavanaClub.editors;

import com.HavanaClub.dto.CountryDto;
import com.HavanaClub.entity.Country;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 5/24/2017.
 */
public class CountryEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String idCountryFromJSP) throws IllegalArgumentException {

        CountryDto countryDto = new CountryDto();
        countryDto.setId(Integer.valueOf(idCountryFromJSP));

        setValue(countryDto);

    }
}
